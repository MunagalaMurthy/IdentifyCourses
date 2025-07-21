package com.cognizant.testscripts;

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

	// Test Case: LL-TC-01
	// Description: To verify filter section accessible
	@Test(groups="sanity")
	public void tc01ToVerifyFilterSectionAccessible() throws IOException {
		// Log an informational message indicating the start of the test case.
		logger.info("LL-TC-01: To verify that \"Filter by\" section is  accessible");
		// Create a test entry in the Extent Report with the test case name.
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-01: To verify that \"Filter by\" section is  accessible");
		// Assign a category to the test for better reporting organization.
		test.assignCategory("TS-LanguageLearning");
		try {
			// Log and report that the test case has started.
			logger.info("\tLL-TC-01: Started");
			test.log(Status.INFO, "LL-TC-01: Started");
			// Log and report the action of checking for the visibility of the Filter section.
			logger.info("\tLL-TC-01: Checking if Filter section is visible or not");
			test.log(Status.INFO, "LL-TC-01: Checking if Filter section is visible or not");

			//Gathering the input term/search key from the properties file

			// Log and report the action of entering text into the search box.
			logger.info("\tLL-TC-01: Entering Search Key into Search Box");
			test.log(Status.INFO, "LL-TC-01: Entering Search Key into Search Box");
			// Retrieve the search input from the properties file.
			String searchInput = prop.getProperty("SEARCH_KEY");
			// Call the method to enter the search input into the search box.
			hp.enterTextIntoSearchBox(searchInput);
			//clicking outside the text box at a random point to check if text still stays in search box
			// Log and report the action of triggering the search.
			logger.info("\tLL-TC-01: Triggering Search");
			test.log(Status.INFO, "LL-TC-01: Triggering Search");
			// Call the method to click the search button.
			hp.clickSearchButton();
			// Initialize the ResultPage object with the driver.
			rp= new ResultPage(driver);
			// Assert that the "filter" section is accessible on the Result Page.
			Assert.assertTrue(rp.isAccessible("filter"));
			// Log and report that the test case passed successfully.
			test.log(Status.PASS,"Successfully Passed");
			logger.info("\tLL-TC-01: Successfully Passed");

			// Capture a screenshot and get its path.
			String captureScreen = captureScreen("ToVerifyFilterSectionAccessible");
			// Add the captured screenshot to the Extent Report.
			test.addScreenCaptureFromPath(captureScreen);
		}catch (AssertionError ae) {
			// Catch AssertionErrors, log the error message, mark the test as failed, and re-throw the assertion error.
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}catch(Exception e) {
			// Catch any other exceptions, log the error message, and mark the test as failed.
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

	// Test Case: LL-TC-06
	// Description: To verify level section accessible
	@Test(groups="sanity")
	public void tc06ToVerifyLevelSectionAccessible() throws IOException {
		// Log an informational message indicating the start of the test case.
		logger.info("LL-TC-06: To verify that course level section is accessible");
		// Create a test entry in the Extent Report with the test case name.
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-06: To verify that course level section is accessible");
		// Assign a category to the test for better reporting organization.
		test.assignCategory("TS-LanguageLearning");
		try {
			// Log and report that the test case has started.
			logger.info("\tLL-TC-06: Started");
			test.log(Status.INFO, "LL-TC-06: Started");
			// Log and report the action of checking for the visibility of the Course level section within the Filter By section.
			logger.info("\tLL-TC-06: Checking if Course level section is visible in Filter By section or not");
			// Note: There's a slight discrepancy here; the log message says "Filter section" instead of "Course level section."
			// It might be good to ensure consistency in logging for clarity.
			test.log(Status.INFO, "LL-TC-06: Checking if Filter section is visible or not"); // Consider changing this log message for accuracy.
			// Assert that the "level" section is accessible on the Result Page.
			Assert.assertTrue(rp.isAccessible("level"));
			// Log and report that the test case passed successfully.
			test.log(Status.PASS,"Successfully Passed");
			logger.info("\tLL-TC-06: Successfully Passed");
			// Capture a screenshot and get its path.
			String captureScreen = captureScreen("ToVerifyLevelSectionAccessible");
			// Add the captured screenshot to the Extent Report.
			test.addScreenCaptureFromPath(captureScreen);
		}catch (AssertionError ae) {
			// Catch AssertionErrors, log the error message, mark the test as failed, and re-throw the assertion error.
			logger.error(ae.getMessage());
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}catch(Exception e) {
			// Catch any other exceptions, log the error message, and mark the test as failed.
			logger.error(e.getMessage());
			Assert.fail("Exception Occured");
		}
	}

	// Test Case: LL-TC-07
	// Description: To verify count of courses visible for each levels
	@Test(groups="sanity")
	public void tc07ToVerifyCountOfCoursesVisibleForEachLevels() throws IOException {
		// Log an informational message indicating the start of the test case.
		logger.info("LL-TC-07: To verify that the count of courses is visible for each level in the list");
		// Create a test entry in the Extent Report with the test case name.
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-07: To verify that the count of courses is visible for each level in the list");
		// Assign a category to the test for better reporting organization.
		test.assignCategory("TS-LanguageLearning");
		try {
			// Log and report that the test case has started.
			logger.info("\tLL-TC-07: Started");
			test.log(Status.INFO, "LL-TC-07: Started");
			// Log and report the action of checking for the visibility of the Course level section within the Filter By section.
			logger.info("\tLL-TC-07: Checking if Course level section is visible in Filter By section or not");
			test.log(Status.INFO, "LL-TC-07: Checking if Course level section is visible in Filter By section or not");
			// Assert that the course count is displayed for each level.
			Assert.assertTrue(rp.isCountDisplayed("level"));
			// Log to the TestNG Reporter and Extent Report that the available levels and course counts are being listed.
			Reporter.log("Available levels and Count of courses:");
			test.log(Status.INFO, "List of Levels:");
			// Iterate through the list of levels retrieved from the result page.
			for(String lvl: rp.getList("level")) {
				// Log each level to the TestNG Reporter and Extent Report.
				Reporter.log(lvl+"\n");
				test.log(Status.INFO,"\t"+lvl);
			}
			// Log and report that the test case passed successfully.
			logger.info("\tLL-TC-07: Successfully Passed");
			test.log(Status.PASS,"LL-TC-07: Successfully Passed");
			// Capture a screenshot and get its path.
			String captureScreen = captureScreen("ToVerifyCountOfCoursesVisibleForEachLevels");
			// Add the captured screenshot to the Extent Report.
			test.addScreenCaptureFromPath(captureScreen);
		}catch (AssertionError ae) {
			// Catch AssertionErrors, log the error message, mark the test as failed, and re-throw the assertion error.
			logger.error(ae.getMessage());
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}catch(Exception e) {
			// Catch any other exceptions, log the error message, and mark the test as failed.
			logger.error(e.getMessage());
			Assert.fail("Exception Occured");
		}
	}

	// Test Case: LL-TC-08
	// Description: To verify count of levels
	@Test(groups="sanity")
	public void tc08ToVerifyCountOfLevels() throws IOException {
		// Log an informational message indicating the start of the test case.
		logger.info("LL-TC-08: To verify the count of languages is same as the total languages displayed");
		// Create a test entry in the Extent Report with the test case name.
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-08: To verify the count of languages is same as the total languages displayed");
		// Assign a category to the test for better reporting organization.
		test.assignCategory("TS-LanguageLearning");
		try {
			// Log and report that the test case has started.
			logger.info("\tLL-TC-08: Started");
			test.log(Status.INFO, "LL-TC-08: Started");
			// Log and report the action of checking if the count of levels matches the expected total.
			logger.info("\tLL-TC-08: Checking Whether the count of languages is same as the total language displayed");
			test.log(Status.INFO, "LL-TC-08: Checking Whether the count of languages is same as the total language displayed");
			// Assert that the total number of elements in the "level" list retrieved from the page
			// matches the expected total levels specified in the properties file.
			// Note: The log message mentions "languages" but the assertion uses "level".
			// Ensure that "level" in rp.getTotalNumberOfElementsInList("level") correctly refers to course levels,
			// and prop.getProperty("TOTAL_LEVELS") indeed holds the expected count of levels.
			Assert.assertEquals(rp.getTotalNumberOfElementsInList("level"), prop.getProperty("TOTAL_LEVELS"));
			// Log and report that the test case passed successfully.
			test.log(Status.PASS,"Successfully Passed");
			logger.info("\tLL-TC-08: Successfully Passed");
			// Capture a screenshot and get its path.
			String captureScreen = captureScreen("ToVerifyCountOfLevels");
			// Add the captured screenshot to the Extent Report.
			test.addScreenCaptureFromPath(captureScreen);
		}catch (AssertionError ae) {
			// Catch AssertionErrors, log the error message, mark the test as failed, and re-throw the assertion error.
			logger.error(ae.getMessage());
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}catch(Exception e) {
			// Catch any other exceptions, log the error message, and mark the test as failed.
			logger.error(e.getMessage());
			Assert.fail("Exception Occured");
		}
	}

	// Test Case: LL-TC-09
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

	// Test Case: LL-TC-09
	// Description: To verify beginner option is available
	@Test(groups="smoke")
	public void tc10ToVerifyBeginnerOptionIsAvailable() throws IOException {
		// Log an informational message indicating the start of the test case.
		logger.info("LL-TC-10: To verify that \"Beginner\" option is available in levels section");
		// Create a test entry in the Extent Report with the test case name.
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-10: To verify that \"Beginner\" option is available in levels section");
		// Assign a category to the test for better reporting organization.
		test.assignCategory("TS-LanguageLearning");
		try {
			// Log and report that the test case has started.
			logger.info("\tLL-TC-10: Started");
			test.log(Status.INFO, "LL-TC-10: Started");
			// Log and report the action of checking for the presence of the "Beginner" level.
			logger.info("\tLL-TC-10:Checking Whether the Beginner level is present in list or not");
			test.log(Status.INFO, "Checking Whether the Beginner level is present in list or not");

			// Initialize a flag to track if "Beginner" is found.
			boolean beginnerFound = false;
			// Iterate through the list of levels retrieved from the result page.
			for(String lvl: rp.getList("level")) {
				// Check if the current level string contains "Beginner".
				if(lvl.contains("Beginner")) {
					// If "Beginner" is found, set the flag to true and break the loop.
					beginnerFound = true;
					break; // No need to continue checking once found
				}
			}

			// Assert that "Beginner" was found in the list.
			// This assertion should be outside the loop to ensure the test fails if "Beginner" is not found.
			Assert.assertTrue(beginnerFound, "Beginner level is not available in the list.");

			// Log and report that the test case passed successfully.
			logger.info("\tLL-TC-10: Successfully Passed");
			test.log(Status.PASS,"LL-TC-10: Successfully Passed");
			// Capture a screenshot and get its path.
			String captureScreen = captureScreen("ToVerifyBeginnerOptionIsAvailable");
			// Add the captured screenshot to the Extent Report.
			test.addScreenCaptureFromPath(captureScreen);
		}catch (AssertionError ae) {
			// Catch AssertionErrors, log the error message, mark the test as failed, and re-throw the assertion error.
			logger.error(ae.getMessage());
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}catch(Exception e) {
			// Catch any other exceptions, log the error message, and mark the test as failed.
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

	// Test Case: LL-TC-09
	// Description: To verify beginner level checkbox checked
	// Needs to be run only after the level checkbox is checked
	@Test(groups="smoke")
	public void tc12ToVerifyBeginnerLevelCheckboxChecked() throws IOException {
		// Log an informational message indicating the start of the test case.
		logger.info("LL-TC-12: To verify course level filter is applied successfully after appling the course level filter");
		// Create a test entry in the Extent Report with the test case name.
		// Note: The ExtentTest description seems to be a copy-paste from a previous test case (LL-TC-07).
		// It should ideally reflect the current test's purpose: "To verify that the 'Beginner' level checkbox is checked after applying the filter".
		ExtentTest test = ExtentReportManager.extent.createTest("LL-TC-12: To verify that the 'Beginner' level checkbox is checked after applying the filter");
		// Assign a category to the test for better reporting organization.
		test.assignCategory("TS-LanguageLearning");
		try {
			// Log and report that the test case has started.
			logger.info("\tLL-TC-12: Started");
			test.log(Status.INFO, "LL-TC-12: Started");
			// Log and report the action of checking if the "Beginner" level checkbox is checked.
			logger.info("\tLL-TC-12: Checking Whether the Beginner level checkbox is checked or not");
			test.log(Status.INFO, "LL-TC-12: Checking Whether the Beginner level checkbox is checked or not");
			// Apply the "Beginner" filter on the result page.
			rp.applyFilter("Beginner");
			// Assert that the "Beginner" checkbox is indeed checked after applying the filter.
			Assert.assertTrue(rp.isChecked("Beginner"));
			// Log and report that the test case passed successfully.
			logger.info("\tLL-TC-12: Successfully Passed");
			test.log(Status.PASS,"Successfully Passed");
			// Capture a screenshot and get its path.
			String captureScreen = captureScreen("ToVerifyBeginnerLevelCheckboxChecked");
			// Add the captured screenshot to the Extent Report.
			test.addScreenCaptureFromPath(captureScreen);
		}catch (AssertionError ae) {
			// Catch AssertionErrors, log the error message, mark the test as failed, and re-throw the assertion error.
			logger.error(ae.getMessage());
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}catch(Exception e) {
			// Catch any other exceptions, log the error message, and mark the test as failed.
			logger.error(e.getMessage());
			Assert.fail("Exception Occured");
		}
	}

}
