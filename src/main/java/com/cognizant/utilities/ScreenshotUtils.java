package com.cognizant.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
public class ScreenshotUtils {
	
	// Assuming you have a WebDriver instance accessible

    // You might pass it as a parameter or get it from a common base class

    private static WebDriver driver; // Initialize this appropriately, e.g., in a BaseTest class
 
    public ScreenshotUtils(WebDriver driver) {
        this.driver = driver;

    }
public String takeScreenshot(String tname) {

		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

    	String targetFilepath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+".png";

    	File target = new File(targetFilepath);

		src.renameTo(target);

		return targetFilepath;

	}
 
}
