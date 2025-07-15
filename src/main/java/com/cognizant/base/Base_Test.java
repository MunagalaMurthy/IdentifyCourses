package com.cognizant.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.cognizant.elementRepository.HomePage;
import com.cognizant.elementRepository.ResultPage;
import com.cognizant.elementRepository.ForEnterprisePage;

public class Base_Test {
	
	protected WebDriver driver;
	protected Properties prop;
	protected HomePage hp;
	protected ForEnterprisePage fep;
	protected ResultPage rp;
	protected Logger logger;
	protected String url;
	
	@BeforeClass
	public void setup() throws Exception {
		//Loading the config.properties file into the project to use for inputs
		logger = LogManager.getLogger(this.getClass());
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		prop = new Properties();
		prop.load(file);
		//Cross-Browser compatibility: checking for browser from the properties file
		if(prop.getProperty("BROWSER").equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("BROWSER").equalsIgnoreCase("Edge")) {
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
		logger=LogManager.getLogger(this.getClass());
		fep = new ForEnterprisePage(driver);
	}
	
	@AfterClass
	public void  tearDown() {
		driver.quit();
	}
		
}
