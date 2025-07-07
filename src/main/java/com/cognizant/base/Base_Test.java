package com.cognizant.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;

public class Base_Test {
	
	private WebDriver driver;
	private Properties prop;
	
//	@BeforeSuite
//	public void setup() throws Exception {
//		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/IdentifyCourses/src/main/resources/config.properties");
//		prop = new Properties();
//		prop.load(file);
//		if(prop.getProperty("BROWSER").equalsIgnoreCase("Chrome")) {
//			driver = new ChromeDriver();
//		}
//		else {
//			driver = new EdgeDriver();
//		}
//		driver.get(prop.getProperty("URL"));
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
	}
}
