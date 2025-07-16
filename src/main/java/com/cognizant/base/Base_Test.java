package com.cognizant.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cognizant.elementRepository.ForEnterprisePage;
import com.cognizant.elementRepository.HomePage;
import com.cognizant.elementRepository.ResultPage;
import com.cognizant.utilities.ExcelUtils;
import com.cognizant.utilities.ScreenshotUtils;

public class Base_Test {
	
	protected WebDriver driver;
	protected Properties prop;
	protected HomePage hp;
	protected ForEnterprisePage fep;
	protected ResultPage rp;
	protected Logger logger;
	protected String url;
	protected ExtentHtmlReporter htmlReporter;
	protected ExtentReports extent;
    protected ExtentTest test;
	protected String screenshotPath = null;
	protected ScreenshotUtils su;
	protected List<List<String>> testData = new ArrayList<>();
	ExcelUtils eu = new ExcelUtils(System.getProperty("user.dir") + "\\src\\test\\testdata\\FormTestData.xlsx");
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(@Optional("chrome") String browser) throws Exception {
		
		//Loading the config.properties file into the project to use for inputs
		ThreadContext.put("browser", browser);
		logger = LogManager.getLogger(this.getClass());
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		prop = new Properties();
		prop.load(file);
		//Cross-Browser compatibility: checking for browser from the properties file
		if(browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		//Navigating to the required URL (from the properties file)
		url = prop.getProperty("URL");
		driver.get(url);
		driver.manage().window().maximize();
		//Adding a general common implicit wait to the driver
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/reports/extentReport.html");
	    // create ExtentReports and attach reporter(s)
	    extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
		//Creating the required class objects to use in the test cases
		hp = new HomePage(driver);
		su = new ScreenshotUtils(driver);
		readTestData();
	}
	
	public void readTestData() {
		int rows;
		try {
			rows = eu.getRowCount("FormTestData");
			for(int i = 0;i<rows;i++) {
				List<String> row = new ArrayList<String>();
				int cols = eu.getCellCount("FormTestData", i);
				for(int j = 0;j<cols;j++) {
					row.add(eu.getCellData("FormTestData", i, j));
				}
				testData.add(row);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Quits the browser opened for the current <test> tag
        }
        if (extent != null) {
            extent.flush(); // Flushes the report for the current <test> tag
        }
    }
}