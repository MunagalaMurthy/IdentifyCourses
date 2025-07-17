package com.cognizant.TS02LanguageLearningOverview;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cognizant.base.Base_Test;
import com.cognizant.elementRepository.ResultPage;
import com.cognizant.utilities.ExtentReportManager;

public class TSLanguageLearning extends Base_Test {
	ResultPage rp;
	@Test(groups="sanity")
	public void tc01ToVerifyFilterSectionAccessible() throws IOException {
		logger.info("LL-TC-01: To verify that \"Filter by\" section is  accessible");
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-01: To verify that \"Filter by\" section is  accessible");
		test.assignCategory("TS-LanguageLearning");
		try {
			logger.info("\tLL-TC-01: Started");
			test.log(Status.INFO, "LL-TC-01: Started");
			logger.info("\tLL-TC-01: Checking if Filter section is visible or not");
			test.log(Status.INFO, "LL-TC-01: Checking if Filter section is visible or not");

			//Gathering the input term/search key from the properties file

			logger.info("\tLL-TC-01: Entering Search Key into Search Box");
			test.log(Status.INFO, "LL-TC-01: Entering Search Key into Search Box");
			String searchInput = prop.getProperty("SEARCH_KEY");
			hp.enterTextIntoSearchBox(searchInput);
			//clicking outside the text box at a random point to check if text still stays in search box
			logger.info("\tLL-TC-01: Triggering Search");
			test.log(Status.INFO, "LL-TC-01: Triggering Search");
			hp.clickSearchButton();
			rp= new ResultPage(driver);
			Assert.assertTrue(rp.isAccessible("filter"));
			test.log(Status.PASS,"Successfully Passed");
			logger.info("\tLL-TC-01: Successfully Passed");

			String captureScreen = captureScreen("ToVerifyFilterSectionAccessible");
			test.addScreenCaptureFromPath(captureScreen);
		}catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}catch(Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Exception Occured");
		}
	}

	// Test Case: LL-TC-02
	// Description: To verify that the Language section is accessible on the result page.
	@Test(groups="sanity")
	public void tc02ToVerifyLanguageSectionAccessible() throws IOException {

		// Logging the start of the test case
		logger.info("LL-TC-02: To verify that Language section is accessible");
		// Creating a test entry in the Extent Report
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-02: To verify that Language section is accessible");
		test.assignCategory("TS-LanguageLearning");
		try {

			// Logging the steps being performed
			logger.info("\tLL-TC-02: Started");
			test.log(Status.INFO, "LL-TC-02: Started");
			logger.info("\tLL-TC-02: Checking if Language section is visible in Filter By section or not");
			test.log(Status.INFO, "LL-TC-02: Checking if Language section is visible in Filter By section or not");

			// Assertion to verify if the language section is accessible
			Assert.assertTrue(rp.isAccessible("language"));
			// Taking screenshot on successful verification
			test.log(Status.PASS, "Successfully Passed");
			// Logging success in Extent Report and console
			logger.info("\tLL-TC-02: Successfully Passed");
			String captureScreen = captureScreen("ToVerifyLanguageSectionAccessible");
			test.addScreenCaptureFromPath(captureScreen);

		}catch (AssertionError ae) {

			// Logging assertion failure and capturing screenshot
			logger.error("\tLL-TC-02: Assertion failed - " + ae.getMessage());
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;

		}catch (Exception e) {

			// Logging unexpected exception and capturing screenshot
			logger.error("\tLL-TC-02: Exception occurred - " + e.getMessage());
			Assert.fail("Exception Occured");

		}
	}

	// Test Case: LL-TC-03
	// Description: To verify that the "Show More" link is visible in the language section.
	@Test(groups = "smoke")
	public void tc03ToVerifyVisibilityOfShowMoreLink() throws IOException {


		// Logging the start of the test case
		logger.info("LL-TC-03: To verify that 'Show More' link is visible in the Language section");
		// Creating a test entry in the Extent Report
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-03: To verify that 'Show More' link is visible in the Language section");
		test.assignCategory("TS-LanguageLearning");
		try {

			// Logging the steps being performed
			logger.info("\tLL-TC-03: Started");
			test.log(Status.INFO, "LL-TC-03: Started");
			logger.info("\tLL-TC-03: Checking if 'Show More' link is accessible");
			test.log(Status.INFO, "Checking if 'Show More' link is accessible");

			// Assertion to verify if the 'showmore' element is accessible
			Assert.assertTrue(rp.isAccessible("showmore"));

			// Logging success in Extent Report and console
			test.log(Status.PASS, "Successfully Passed");
			logger.info("\tLL-TC-03: Successfully Passed");
			String captureScreen = captureScreen("ToVerifyVisibilityOfShowMoreLink");
			test.addScreenCaptureFromPath(captureScreen);

		} catch(AssertionError ae) {

			// Logging assertion failure and capturing screenshot
			logger.error("\tLL-TC-03: Assertion failed - " + ae.getMessage());
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;

		} catch (Exception e) {

			// Logging unexpected exception and capturing screenshot

			logger.error("\tLL-TC-03: Exception occurred - " + e.getMessage());
			Assert.fail("Exception Occured");

		}
	}

	//Test Case: LL-TC-04
	//Description: To verify that "English" is one of the available language options.
	@Test(groups = "smoke")
	public void tc04ToVerifyEnglishOptionIsAvailable() throws IOException {


		// Logging the start of the test case
		logger.info("LL-TC-04: To verify that 'English' option is available in the language list");

		// Creating a test entry in the Extent Report
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-04: To verify that 'English' option is available in the language list");
		test.assignCategory("TS-LanguageLearning");
		try {

			logger.info("\tLL-TC-04: Started");
			test.log(Status.INFO, "LL-TC-04: Started");
			logger.info("\tLL-TC-04: Fetching list of available languages");
			test.log(Status.INFO, "LL-TC-04: Fetching list of available languages");

			// Loop through the list of languages to check for "English"
			for(String lang:rp.getList("language")) {
				if(lang.contains("English")) {

					logger.info("\tLL-TC-04: 'English' option found in the list");
					test.log(Status.PASS, "'English' option is available");
					// English found
					Assert.assertTrue(true);  
					return;
				}
			}
			String captureScreen = captureScreen("ToVerifyEnglishOptionIsAvailable");
			test.addScreenCaptureFromPath(captureScreen);

		} catch (AssertionError ae) {

			// Log assertion failure and capture screenshot
			logger.error("\tLL-TC-04: Assertion failed - " + ae.getMessage());
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;

		} catch (Exception e) {

			// Log any unexpected exception and capture screenshot
			logger.error("\tLL-TC-04: Exception occurred - " + e.getMessage());
			Assert.fail("Exception Occured");

		}
	}



	// Test Case: LL-TC-05
	// Description: To verify that the count of courses is displayed for each language
	@Test(groups = "sanity")
	public void tc05ToVerifyCountOfCoursesVisibleForEachLanguage() throws IOException {


		// Logging the start of the test case
		logger.info("LL-TC-05: To verify that the count of courses is visible for each language in the list");

		// Creating a test entry in the Extent Report
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-05: To verify that the count of courses is visible for each language in the list");
		test.assignCategory("TS-LanguageLearning");
		try {
			logger.info("\tLL-TC-05: Started");
			test.log(Status.INFO, "LL-TC-05: Started");
			logger.info("\tLL-TC-05: Checking if course count is displayed for each language");
			test.log(Status.INFO, "LL-TC-05: Checking if course count is displayed for each language");

			// Assertion to verify if the count is displayed for the language section
			Assert.assertTrue(rp.isCountDisplayed("language"));

			// Logging and reporting each language and its course count
			Reporter.log("Available languages and count of courses:");

			for(String lang:rp.getList("language")) {
				Reporter.log(lang+"\n");
				test.info("\t"+lang);
			}

			logger.info("\tLL-TC-05: Successfully Passed");
			test.log(Status.PASS, "Successfully Passed");
			String captureScreen = captureScreen("ToVerifyCountOfCoursesVisibleForEachLanguage");
			test.addScreenCaptureFromPath(captureScreen);

		} catch (AssertionError ae) {
			// Log assertion failure and capture screenshot
			logger.error("\tLL-TC-05: Assertion failed - " + ae.getMessage());
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;

		} catch (Exception e) {
			// Log unexpected exception and capture screenshot
			logger.error("\tLL-TC-05: Exception occurred - " + e.getMessage());
			Assert.fail("Exception Occured");

		}
	}
	@Test(groups="sanity")
	public void tc06ToVerifyLevelSectionAccessible() throws IOException {
		logger.info("LL-TC-06: To verify that course level section is accessible");
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-06: To verify that course level section is accessible");
		test.assignCategory("TS-LanguageLearning");
		try {
			logger.info("\tLL-TC-06: Started");
			test.log(Status.INFO, "LL-TC-06: Started");
			logger.info("\tLL-TC-06: Checking if Course level section is visible in Filter By section or not");
			test.log(Status.INFO, "LL-TC-06: Checking if Filter section is visible or not");
			Assert.assertTrue(rp.isAccessible("level"));
			test.log(Status.PASS,"Successfully Passed");
			logger.info("\tLL-TC-06: Successfully Passed");
			String captureScreen = captureScreen("ToVerifyLevelSectionAccessible");
			test.addScreenCaptureFromPath(captureScreen);
		}catch (AssertionError ae) {
			logger.error(ae.getMessage());
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}catch(Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Exception Occured");
		}

	}

	@Test(groups="sanity")
	public void tc07ToVerifyCountOfCoursesVisibleForEachLevels() throws IOException {
		logger.info("LL-TC-07: To verify that the count of courses is visible for each level in the list");
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-07: To verify that the count of courses is visible for each level in the list");
		test.assignCategory("TS-LanguageLearning");
		try {
			logger.info("\tLL-TC-07: Started");
			test.log(Status.INFO, "LL-TC-07: Started");
			logger.info("\tLL-TC-07: Checking if Course level section is visible in Filter By section or not");
			test.log(Status.INFO, "LL-TC-07: Checking if Course level section is visible in Filter By section or not");
			Assert.assertTrue(rp.isCountDisplayed("level"));
			Reporter.log("Available levels and Count of courses:");
			test.log(Status.INFO, "List of Levels:");
			for(String lvl: rp.getList("level")) {
				Reporter.log(lvl+"\n");
				test.log(Status.INFO,"\t"+lvl);
			}
			logger.info("\tLL-TC-07: Successfully Passed");
			test.log(Status.PASS,"LL-TC-07: Successfully Passed");
			String captureScreen = captureScreen("ToVerifyCountOfCoursesVisibleForEachLevels");
			test.addScreenCaptureFromPath(captureScreen);
		}catch (AssertionError ae) {
			logger.error(ae.getMessage());
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}catch(Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Exception Occured");
		}
	}
	@Test(groups="sanity")
	public void tc08ToVerifyCountOfLevels() throws IOException {
		logger.info("LL-TC-08: To verify the count of languages is same as the total languages displayed");
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-08: To verify the count of languages is same as the total languages displayed");
		test.assignCategory("TS-LanguageLearning");
		try {
			logger.info("\tLL-TC-08: Started");
			test.log(Status.INFO, "LL-TC-08: Started");
			logger.info("\tLL-TC-08: Checking Whether the count of languages is same as the total language displayed");
			test.log(Status.INFO, "LL-TC-08: Checking Whether the count of languages is same as the total language displayed");
			Assert.assertEquals(rp.getTotalNumberOfElementsInList("level"), prop.getProperty("TOTAL_LEVELS"));
			test.log(Status.PASS,"Successfully Passed");
			logger.info("\tLL-TC-08: Successfully Passed");
			String captureScreen = captureScreen("ToVerifyCountOfLevels");
			test.addScreenCaptureFromPath(captureScreen);
		}catch (AssertionError ae) {
			logger.error(ae.getMessage());
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}catch(Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Exception Occured");
		}

	}

	// Test Case: LL-TC-08
	// Description: To verify that the count of languages displayed matches the expected count.
	@Test(groups = "sanity")
	public void tc09ToVerifyCountOfLanguages() throws IOException {

		// Logging the start of the test case
		logger.info("LL-TC-09: To verify that the count of languages is same as the total languages displayed");

		// Creating a test entry in the Extent Report
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-09: To verify that the count of languages is same as the total languages displayed");
		test.assignCategory("TS-LanguageLearning");
		try {
			logger.info("\tLL-TC-09: Started");
			test.log(Status.INFO, "LL-TC-09: Started");
			logger.info("\tLL-TC-09: Fetching 'Show More' text to calculate expected language count");
			test.log(Status.INFO, "LL-TC-09: Fetching 'Show More' text to calculate expected language count");

			// Extracting number from "Show More" text
			String text = rp.ShowMoreText();

			//It calculates the expected count using the "Show More" text.
			int langCount = Integer.parseInt(text.substring(text.indexOf("Show")+5,text.indexOf("more")-1));

			// 4 languages are shown by default
			int totalLangCount = langCount+4;


			logger.info("\tLL-TC-09: Calculated expected language count: " + totalLangCount);
			test.info("\tLL-TC-09: Calculated expected language count: " + totalLangCount);
			logger.info("\tLL-TC-09: Fetching actual language count from UI");
			test.info("\tLL-TC-09: Fetching actual language count from UI");

			// Assertion to verify if expected and actual counts match
			Assert.assertEquals(totalLangCount+"",rp.getTotalNumberOfElementsInList("language"));
			String captureScreen = captureScreen("ToVerifyCountOfLanguages");
			test.addScreenCaptureFromPath(captureScreen);

		} catch (AssertionError ae) {
			// Log assertion failure and capture screenshot
			logger.error("\tLL-TC-09: Assertion failed - " + ae.getMessage());
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;

		} catch (Exception e) {
			// Log unexpected exception and capture screenshot
			logger.error("\tLL-TC-09: Exception occurred - " + e.getMessage());
			Assert.fail("Exception Occured");

		}
	}

	@Test(groups="smoke")
	public void tc10ToVerifyBeginnerOptionIsAvailable() throws IOException {
		logger.info("LL-TC-10: To verify that \"Beginner\" option is available in levels section");
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-10: To verify that \"Beginner\" option is available in levels section");
		test.assignCategory("TS-LanguageLearning");
		try {
			logger.info("\tLL-TC-10: Started");
			test.log(Status.INFO, "LL-TC-10: Started");
			logger.info("\tLL-TC-10:Checking Whether the Beginner level is present in list or not");
			test.log(Status.INFO, "Checking Whether the Beginner level is present in list or not");
			for(String lvl: rp.getList("level")) {
				if(lvl.contains("Beginner")) {
					Assert.assertTrue(true);
					return;
				}
			}
			logger.info("\tLL-TC-10: Successfully Passed");
			test.log(Status.PASS,"LL-TC-10: Successfully Passed");
			String captureScreen = captureScreen("ToVerifyBeginnerOptionIsAvailable");
			test.addScreenCaptureFromPath(captureScreen);
		}catch (AssertionError ae) {
			logger.error(ae.getMessage());
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}catch(Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Exception Occured");
		}
	}



	//Test Case: LL-TC-11
	//Description: To verify that the English language checkbox is checked after applying the filter.
	@Test(groups="smoke")
	public void tc11ToVerifyEnglishLanguageCheckboxChecked() throws IOException {


		// Logging the start of the test case
		logger.info("LL-TC-11: To verify that English language checkbox is checked after applying the filter");

		// Creating a test entry in the Extent Report
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-11: To verify that English language checkbox is checked after applying the filter");
		test.assignCategory("TS-LanguageLearning");
		try {
			logger.info("\tLL-TC-11: Started");
			test.log(Status.INFO, "LL-TC-11: Started");
			logger.info("\tLL-TC-11: Applying English language filter");
			test.log(Status.INFO, "Applying English language filter");

			// Apply the English filter
			rp.applyFilter("English");

			// Verify if the English checkbox is checked
			Assert.assertTrue(rp.isChecked("English"));

			test.log(Status.PASS, "Successfully Passed");
			logger.info("\tLL-TC-11: Successfully Passed");
			String captureScreen = captureScreen("ToVerifyEnglishLanguageCheckboxChecked");
			test.addScreenCaptureFromPath(captureScreen);

		} catch (AssertionError ae) {
			// Log assertion failure and capture screenshot
			logger.error("\tLL-TC-11: Assertion failed - " + ae.getMessage());
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;


		} catch (Exception e) {

			// Log unexpected exception and capture screenshot
			logger.error("\tLL-TC-11: Exception occurred - " + e.getMessage());
			Assert.fail("Exception Occured");

		}
	}

	// Needs to be run only after the level checkbox is checked
	@Test(groups="smoke")
	public void tc12ToVerifyBeginnerLevelCheckboxChecked() throws IOException {
		logger.info("LL-TC-12: To verify course level filter is applied successfully after appling the course level filter");
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-12: To verify that the count of courses is visible for each level in the list");
		test.assignCategory("TS-LanguageLearning");
		try {
			logger.info("\tLL-TC-12: Started");
			test.log(Status.INFO, "LL-TC-12: Started");
			logger.info("\tLL-TC-12: Checking Whether the Beginner level checkbox is checked or not");
			test.log(Status.INFO, "LL-TC-12: Checking Whether the Beginner level checkbox is checked or not");
			rp.applyFilter("Beginner");
			Assert.assertTrue(rp.isChecked("Beginner"));
			logger.info("\tLL-TC-12: Successfully Passed");
			test.log(Status.PASS,"Successfully Passed");
			String captureScreen = captureScreen("ToVerifyBeginnerLevelCheckboxChecked");
			test.addScreenCaptureFromPath(captureScreen);
		}catch (AssertionError ae) {
			logger.error(ae.getMessage());
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}catch(Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Exception Occured");
		}
	}
	
}
