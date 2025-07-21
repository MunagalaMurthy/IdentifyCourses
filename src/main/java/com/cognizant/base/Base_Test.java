package com.cognizant.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;
import com.cognizant.elementRepository.ForEnterprisePage;
import com.cognizant.elementRepository.HomePage;
import com.cognizant.elementRepository.ResultPage;
import com.cognizant.utilities.ExcelUtils;

// Base_Test class provides foundational setup and teardown for all test classes.
public class Base_Test {

	protected WebDriver driver; // WebDriver instance for browser interaction
	protected Properties prop; // Properties object to load configuration from config.properties
	protected HomePage hp; // Page object for the Home Page
	protected ForEnterprisePage fep; // Page object for the For Enterprise Page
	protected ResultPage rp; // Page object for the Result Page
	protected Logger logger; // Logger for logging test execution information
	protected String url; // Stores the base URL from the properties file
	protected ExtentTest test; // ExtentTest object for reporting test status
	protected String screenshotPath = null; // Path to store screenshots
	protected List<List<String>> testData = new ArrayList<>(); // List to store test data from Excel
	// ExcelUtils instance to read data from the specified Excel file
	ExcelUtils eu = new ExcelUtils(System.getProperty("user.dir") + "\\src\\test\\testdata\\FormTestData.xlsx");

	/**
	 * Sets up the WebDriver based on the execution environment (local/remote) and browser.
	 * Loads configuration from `config.properties` and test data from Excel.
	 * @param browser The browser to use for testing (e.g., "Chrome", "Edge"). Default is "chrome".
	 * @throws Exception If there's an issue with file loading, URI, or URL conversion.
	 */
	@BeforeClass
	@Parameters({"browser"})
	public void setup(@Optional("chrome") String browser) throws Exception {

		// Set browser name in Log4j2 ThreadContext for logging differentiation.
		ThreadContext.put("browser", browser);
		// Initialize logger for the current class.
		logger = LogManager.getLogger(this.getClass());

		// Load configuration properties from config.properties file.
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		prop = new Properties();
		prop.load(file);

		// Determine execution environment: Selenium Grid (remote) or local.
		if(prop.getProperty("EXECUTION_ENV").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			// Set platform capabilities based on OS property.
			if(prop.getProperty("OS").equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(prop.getProperty("OS").equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No Matching OS found for remote execution. Please check 'OS' property in config.properties.");
				return; // Exit setup if OS is not supported for remote execution.
			}

			// Set browser capabilities.
			if(browser.equalsIgnoreCase("Chrome")) {
				capabilities.setBrowserName("chrome");
			}
			else if(browser.equalsIgnoreCase("Edge")) {
				capabilities.setBrowserName("MicrosoftEdge");
			} else {
				System.out.println("Unsupported browser for remote execution: " + browser);
				return; // Exit setup if browser is not supported for remote execution.
			}

			// Construct URL for Selenium Grid Hub.
			URI uri = new URI(prop.getProperty("GRID_LINK"));
			URL seleniumHubUrl = uri.toURL();

			// Initialize RemoteWebDriver for remote execution.
			driver = new RemoteWebDriver(seleniumHubUrl, capabilities);

		} else if(prop.getProperty("EXECUTION_ENV").equalsIgnoreCase("local")) {
			// Initialize WebDriver for local execution based on browser parameter.
			if(browser.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			} else {
				System.out.println("Unsupported browser for local execution: " + browser);
				return; // Exit setup if browser is not supported for local execution.
			}
		} else {
			System.out.println("Invalid EXECUTION_ENV property. Please use 'local' or 'remote'.");
			return; // Exit setup if EXECUTION_ENV is invalid.
		}

		// Navigate to the application URL.
		url = prop.getProperty("URL");
		driver.get(url);

		// Maximize browser window.
		driver.manage().window().maximize();

		// Delete all cookies to ensure a clean session.
		driver.manage().deleteAllCookies();

		// Set implicit wait for element visibility.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Initialize Page Object Model (POM) classes.
		// Note: fep and rp are initialized only if needed in specific tests,
		// but hp is universally useful for navigating to the main page.
		hp = new HomePage(driver);

		// Read test data from Excel.
		readTestData();
	}

	/**
	 * Reads test data from the "FormTestData" sheet in the Excel file
	 * and stores it in the `testData` list.
	 */
	public void readTestData() {
		int rows;
		try {
			rows = eu.getRowCount("FormTestData"); // Get total row count from the sheet.
			for(int i = 0; i < rows; i++) {
				List<String> row = new ArrayList<>(); // Create a new list for each row.
				int cols = eu.getCellCount("FormTestData", i); // Get total column count for the current row.
				for(int j = 0; j < cols; j++) {
					row.add(eu.getCellData("FormTestData", i, j)); // Add cell data to the row list.
				}
				testData.add(row); // Add the complete row to the testData list.
			}
		} catch (IOException e) {
			logger.error("Error reading test data from Excel: " + e.getMessage());
			e.printStackTrace(); // Print stack trace for debugging.
		}
	}

	/**
	 * Captures a screenshot of the current browser window and saves it to a specified path.
	 * The screenshot file name includes the test name and a timestamp for uniqueness.
	 * @param tname The name of the test case for which the screenshot is being captured.
	 * @return The absolute path to the saved screenshot file.
	 * @throws IOException If there is an error during file operations (e.g., copying the file).
	 */
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); // Generate timestamp.
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver; // Cast WebDriver to TakesScreenshot.
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE); // Get screenshot as a File.
		// Define destination path for the screenshot.
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination)); // Copy screenshot to destination.
		} catch (Exception e) {
			logger.error("Error capturing screenshot: " + e.getMessage());
			e.getMessage();
		}
		return destination; // Return the path of the saved screenshot.

	}

	/**
	 * Tears down the WebDriver by quitting the browser after all tests in the class have run.
	 */
	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit(); // Quits the browser opened for the current test class.
		}
	}
}