package com.cognizant.TS02LanguageLearningOverview;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.cognizant.base.Base_Test;

public class TCLevelSection extends Base_Test {

	@Test(groups="sanity")
	public void tc01ToVerifyFilterSectionAccessible() throws IOException {
		logger.info("LL-TC-01: To verify that \"Filter by\" section is  accessible");
		ExtentTest test = extent.createTest("LL-TC-01: To verify that \"Filter by\" section is  accessible");
		try {
			logger.info("\tLL-TC-01: Started");
			logger.info("\tLL-TC-01: Checking if Filter section is visible or not");
			//Gathering the input term/search key from the properties file
			logger.info("\tLL-TC-01: Entering Search Key into Search Box");
			String searchInput = prop.getProperty("SEARCH_KEY");
			hp.enterTextIntoSearchBox(searchInput);
			//clicking outside the text box at a random point to check if text still stays in search box
			logger.info("\tLL-TC-01: Checking if input stays in Search Box");
			hp.clickSearchButton();
			
			Assert.assertTrue(rp.isFilterSectionAccessible());
			
			screenshotPath = su.takeScreenshot("LL_TC01_pass");
			test.log(Status.PASS,"Successfully Passed");
			logger.info("\tLL-TC-01: Successfully Passed");
		}catch (AssertionError ae) {
			logger.error(ae.getMessage());
			test.fail("Details: ",MediaEntityBuilder.createScreenCaptureFromPath("LL_TC01_fail.png").build());
			screenshotPath = su.takeScreenshot("LL_TC01_fail");
		}catch(Exception e) {
			logger.error(e.getMessage());
			screenshotPath = su.takeScreenshot("LL_TC01_fail");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
		
	}
	
	@Test(groups="sanity")
	public void tc06ToVerifyLevelSectionAccessible() throws IOException {
		logger.info("LL-TC-06: To verify that course level section is accessible");
		ExtentTest test = extent.createTest("LL-TC-06: To verify that course level section is accessible");
		try {
			logger.info("\tLL-TC-06: Started");
			logger.info("\tLL-TC-06: Checking if Course level section is visible in Filter By section or not");
			test.log(Status.INFO, "Checking if Filter section is visible or not");
			Assert.assertTrue(rp.isLevelSectionAccessible());
			screenshotPath = su.takeScreenshot("LL_TC06_pass");
			test.log(Status.PASS,"Successfully Passed");
			logger.info("\tLL-TC-06: Successfully Passed");
		}catch (AssertionError ae) {
			logger.error(ae.getMessage());
			test.fail("Details: ",MediaEntityBuilder.createScreenCaptureFromPath("LL_TC06_fail.png").build());
			screenshotPath = su.takeScreenshot("LL_TC06_fail");
		}catch(Exception e) {
			logger.error(e.getMessage());
			screenshotPath = su.takeScreenshot("LL_TC06_fail");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
		
	}
	@Test(groups="sanity")
	public void tc08ToVerifyCountOfLevels() throws IOException {
		logger.info("LL-TC-08: To verify the count of languages is same as the total languages displayed");
		ExtentTest test = extent.createTest("LL-TC-08: To verify the count of languages is same as the total languages displayed");
		try {
			logger.info("\tLL-TC-08: Started");
			logger.info("\tLL-TC-08: Checking Whether the count of languages is same as the total language displayed");
			test.log(Status.INFO, "Checking Whether the count of languages is same as the total language displayed");
			Assert.assertEquals(rp.getNumberOfLevels(), 4);
			screenshotPath = su.takeScreenshot("LL_TC08_pass");
			test.log(Status.PASS,"Successfully Passed");
			logger.info("\tLL-TC-08: Successfully Passed");
		}catch (AssertionError ae) {
			logger.error(ae.getMessage());
			test.fail("Details: ",MediaEntityBuilder.createScreenCaptureFromPath("LL_TC08_fail.png").build());
			screenshotPath = su.takeScreenshot("LL_TC08_fail");
		}catch(Exception e) {
			logger.error(e.getMessage());
			screenshotPath = su.takeScreenshot("LL_TC08_fail");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
		
	}
	@Test(groups="sanity")
	public void tc07ToVerifyCountOfCoursesVisibleForEachLevels() throws IOException {
		logger.info("LL-TC-07: To verify that the count of courses is visible for each level in the list");
		ExtentTest test = extent.createTest("LL-TC-07: To verify that the count of courses is visible for each level in the list");
		try {
			logger.info("\tLL-TC-07: Started");
			logger.info("\tLL-TC-07: Checking if Course level section is visible in Filter By section or not");
			test.log(Status.INFO, "Checking if Course level section is visible in Filter By section or not");
			Assert.assertTrue(rp.isCountDisplayed("level"));
			screenshotPath = su.takeScreenshot("LL_TC07_pass");
			Reporter.log("Available levels and Count of courses:");
			for(String lvl: rp.getListOfLevels()) {
				Reporter.log(lvl+"\n");
				test.info(lvl+"\n");
			}
			logger.info("\tLL-TC-07: Successfully Passed");
			test.log(Status.PASS,"Successfully Passed");
		}catch (AssertionError ae) {
			logger.error(ae.getMessage());
			test.fail("Details: ",MediaEntityBuilder.createScreenCaptureFromPath("LL_TC07_fail.png").build());
			screenshotPath = su.takeScreenshot("LL_TC07_fail");
		}catch(Exception e) {
			logger.error(e.getMessage());
			screenshotPath = su.takeScreenshot("LL_TC07_fail");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	// Needs to be run only after the level checkbox is checked
	@Test(groups="smoke")
	public void tc11ToVerifyBeginnerLevelCheckboxChecked() throws IOException {
		logger.info("LL-TC-11: To verify course level filter is applied successfully after appling the course level filter");
		ExtentTest test = extent.createTest("LL-TC-11: To verify that the count of courses is visible for each level in the list");
		try {
			logger.info("\tLL-TC-11: Started");
			logger.info("\tLL-TC-11: Checking Whether the Beginner level checkbox is checked or not");
			test.log(Status.INFO, "Checking Whether the Beginner level checkbox is checked or not");
			rp.applyBeginnerFilter();
			Assert.assertTrue(rp.isBeginnerChkd());
			screenshotPath = su.takeScreenshot("LL_TC11_pass");
			logger.info("\tLL-TC-11: Successfully Passed");
			test.log(Status.PASS,"Successfully Passed");
		}catch (AssertionError ae) {
			logger.error(ae.getMessage());
			test.fail("Details: ",MediaEntityBuilder.createScreenCaptureFromPath("LL_TC11_fail.png").build());
			screenshotPath = su.takeScreenshot("LL_TC11_fail");
		}catch(Exception e) {
			logger.error(e.getMessage());
			screenshotPath = su.takeScreenshot("LL_TC11_fail");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}
	
	@Test(groups="smoke")
	public void tc09ToVerifyBeginnerOptionIsAvailable() throws IOException {
		logger.info("LL-TC-09: To verify that \"Beginner\" option is available in levels section");
		ExtentTest test = extent.createTest("LL-TC-09: To verify that \"Beginner\" option is available in levels section");
		try {
			logger.info("\tLL-TC-09: Started");
			logger.info("\tLL-TC-09:Checking Whether the Beginner level is present in list or not");
			test.log(Status.INFO, "Checking Whether the Beginner level is present in list or not");
			for(String lvl: rp.getListOfLevels()) {
				if(lvl.contains("Beginner")) {
					Assert.assertTrue(true);
					screenshotPath = su.takeScreenshot("LL_TC09_pass");
					return;
				}
			}
			logger.info("\tLL-TC-09: Successfully Passed");
			test.log(Status.PASS,"Successfully Passed");
		}catch (AssertionError ae) {
			logger.error(ae.getMessage());
			test.fail("Details: ",MediaEntityBuilder.createScreenCaptureFromPath("LL_TC09_fail.png").build());
		}catch(Exception e) {
			logger.error(e.getMessage());
			screenshotPath = su.takeScreenshot("LL_TC09_fail");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
		Assert.assertFalse(true);
	}
}
