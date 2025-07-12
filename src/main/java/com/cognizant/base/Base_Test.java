package com.cognizant.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j

import com.cognizant.elementRepository.HomePage;
import com.cognizant.elementRepository.ResultPage;

public class Base_Test {
	
	public WebDriver driver;
	protected Properties prop;
	protected ResultPage rp;
	protected HomePage hp;
	public Logger logger;
	
	
	@BeforeClass
	public void setup() throws Exception {
		logger=LogManager.getLogger(this.getClass());
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		prop = new Properties();
		prop.load(file);
		if(prop.getProperty("BROWSER").equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("BROWSER").equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp = new HomePage(driver);
		rp = new ResultPage(driver);
	}
	
	@AfterClass
	public void  tearDown() {
		driver.quit();
	}
		
}
