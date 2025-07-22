package com.cognizant.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.net.URL;
import java.net.URL;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.cognizant.base.Base_Test;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public static  ExtentReports extent;
	public ExtentTest test;
	public Properties prop;

	String repName;

	public void onStart(ITestContext testContext) {
		
		/*SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt=new Date();
		String currentdatetimestamp=df.format(dt);
		*/
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		repName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// specify location of the report
		

		sparkReporter.config().setDocumentTitle("CourseEra Automation"); // Title of report
		sparkReporter.config().setReportName("CourseEra Automation Testing Report"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "CourseEra");
		extent.setSystemInfo("Module", "Searching for Courses");
		extent.setSystemInfo("Sub Module", "For Enterprise");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt", "QA");
		
		// Load configuration properties from config.properties file.
		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
			prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		extent.setSystemInfo("OS", prop.getProperty("OS"));
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
		extent.setSystemInfo("Groups", includedGroups.toString());
		}
	}

//	public void onTestSuccess(ITestResult result) {
//	
//		test = extent.createTest(result.getTestClass().getName());
//		test.assignCategory(result.getMethod().getGroups()); // to display groups in report
//		test.log(Status.PASS,result.getName()+" got successfully executed");
//		
//		try {
//			String imgPath = new BaseClass().captureScreen(result.getName());
//			test.addScreenCaptureFromPath(imgPath);
//			
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		
//	}

	public void onTestFailure(ITestResult result) {
	    test = extent.createTest(result.getTestClass().getName());
	    test.assignCategory(result.getMethod().getGroups());

	    test.log(Status.FAIL, result.getName() + " got failed");
	    test.log(Status.INFO, result.getThrowable().getMessage());

	    try {
	        Base_Test testInstance = (Base_Test) result.getInstance(); // Get the actual test instance
	        String imgPath = testInstance.captureScreen(result.getName()); // Use its initialized driver
	        test.addScreenCaptureFromPath(imgPath);
	    } catch (IOException e1) {
	        e1.printStackTrace();
	    } catch (Exception e2) {
	        System.out.println("Screenshot capture failed: " + e2.getMessage());
	    }
	}


	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+" got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext testContext) {
		
		extent.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		 
	}

}

