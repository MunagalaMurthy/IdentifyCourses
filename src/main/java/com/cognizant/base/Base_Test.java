package com.cognizant.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cognizant.elementRepository.ForEnterprisePage;
import com.cognizant.elementRepository.HomePage;
import com.cognizant.elementRepository.ResultPage;
import com.cognizant.utilities.ScreenshotUtils;

public class Base_Test {
	
	protected static WebDriver driver;
	protected Properties prop;
	protected HomePage hp;
	protected ForEnterprisePage fep;
	protected ResultPage rp;
	protected Logger logger;
	protected String url;
//	protected ExtentSparkReporter htmlReporter;
//	protected ExtentReports extent;
//    protected ExtentTest test;
//	protected String screenshotPath = null;
//	protected ScreenshotUtils su;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String browser) throws Exception {
		//Loading the config.properties file into the project to use for inputs
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Creating the required class objects to use in the test cases
		hp = new HomePage(driver);
		rp = new ResultPage(driver);
		fep = new ForEnterprisePage(driver);
//		su = new ScreenshotUtils(driver);
	}
	
	@AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Quits the browser opened for the current <test> tag
        }
//        if (extent != null) {
//            extent.flush(); // Flushes the report for the current <test> tag
//        }
    }
	
	public String captureScreen(String tname) throws IOException {
		 
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
 
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
 
	}
}
