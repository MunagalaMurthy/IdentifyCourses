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

//    public static String takeScreenshot(String screenshotName) {
//        // Define the directory where screenshots will be saved
//        String screenshotDir = System.getProperty("user.dir") + "/screenshots/";
//        File dir = new File(screenshotDir);
//        if (!dir.exists()) {
//            dir.mkdirs(); // Create directory if it doesn't exist
//        }
//
//        // Generate a unique file name using timestamp
//        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        String filePath = screenshotDir + screenshotName + "_" + timestamp + ".png";
//
//        try {
//            TakesScreenshot ts = (TakesScreenshot) driver;
//            File source = ts.getScreenshotAs(OutputType.FILE);
//            File destination = new File(filePath);
//            FileHandler.copy(source, destination);
//            System.out.println("Screenshot captured: " + filePath); // For debugging
//            return filePath; // Return the absolute path
//        } catch (IOException e) {
//            System.err.println("Failed to capture screenshot: " + e.getMessage());
//            e.printStackTrace();
//            return null;
//        }
//    }
    public String takeScreenshot(String tname) {
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	String targetFilepath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+".png";
    	File target = new File(targetFilepath);
		src.renameTo(target);
		return targetFilepath;
	}
	
}
