package com.cognizant.testscripts;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cognizant.base.Base_Test;
import com.cognizant.elementRepository.ResultPage;
import com.cognizant.utilities.ExtentReportManager;

public class TSCourseSearch extends Base_Test{

	ResultPage rp;

	int i=4;

	//Test 1: testing whether search box accepts any text input
	@Test(priority=-4)
	public void tc01testSearchInputAcceptsText() {
		logger.info("CS-TC-01: To Verify That Search Input Field Accepts Text");

		// Creating a test entry in the Extent Report
		ExtentTest test = ExtentReportManager.extent.createTest("CS-TC-01: To Verify That Search Input Field Accepts Text");
		test.assignCategory("TS-CourseSearch");
		try {
			logger.info("\tCS-TC-01: Started");
			test.log(Status.INFO, "CS-TC-01: Started");
			//Gathering the input term/search key from the properties file
			logger.info("\tCS-TC-01: Entering Search Key into Search Box");
			test.log(Status.INFO, "CS-TC-01: Entering Search Key into Search Box");

			String searchInput = prop.getProperty("SEARCH_KEY");
			hp.enterTextIntoSearchBox(searchInput);

			//clicking outside the text box at a random point to check if text still stays in search box
			logger.info("\tCS-TC-01: Checking if input stays in Search Box");
			test.log(Status.INFO, "CS-TC-01: Checking if input stays in Search Box");

			Actions action = new Actions(driver);
			action.moveByOffset(847, 75).click().perform(); //random point on the page where no element is present

			//Assertion check by checking if the text stays in the input box after clicking outside
			Assert.assertEquals(hp.searchBox.getAttribute("value"), searchInput);
			logger.info("\tCS-TC-01: Successfully Passed");
			test.log(Status.PASS, "CS-TC-01: Successfully Passed");

			String captureScreen = captureScreen("tc01testSearchInputAcceptsText");
			test.addScreenCaptureFromPath(captureScreen);

		} catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Exception Occurred");
			test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
		}

	}

	//Test 2: testing whether search button triggers the search on clicking
	@Test(priority=-3,dependsOnMethods={"tc01testSearchInputAcceptsText"})
	public void testSearchButtonTrigger() {
		logger.info("CS-TC-02: To Verify That Search Button Click Triggers Search");
		ExtentTest test = ExtentReportManager.extent.createTest("CS-TC-02: To Verify That Search Button Click Triggers Search");
		test.assignCategory("TS-CourseSearch");
		try {
			logger.info("\tCS-TC-02: Started");
			test.log(Status.INFO, "CS-TC-02: Started");
			logger.info("\tCS-TC-02: Triggering Search");
			test.log(Status.INFO, "CS-TC-02: Triggering Search");
			hp.clickSearchButton();
			rp = new ResultPage(driver);
			//Assertion check by checking the url of the page loaded after clicking the search button
			Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("RESULTS_URL"));
			logger.info("\tCS-TC-02: Successfully Passed");
			test.log(Status.PASS, "CS-TC-02: Successfully Passed");

			String captureScreen = captureScreen("testSearchButtonTrigger");
			test.addScreenCaptureFromPath(captureScreen);

		} catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Exception Occurred");
			test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
		}
	}

	//Test 3: testing whether search results shown on the results page are valid and related to the search key
	@Test(priority=-2, dependsOnMethods= {"testSearchButtonTrigger"})
	public void testValidSearchResults() throws IOException {
		logger.info("CS-TC-03: To Verify That Search Results Are Displayed Correctly");
		ExtentTest test = ExtentReportManager.extent.createTest("CS-TC-03: To Verify That Search Results Are Displayed Correctly");
		test.assignCategory("TS-CourseSearch");
		try {
			logger.info("\tCS-TC-03: Started");
			test.log(Status.INFO, "CS-TC-03: Started");
			logger.info("\tCS-TC-03: Checking the result page");
			test.log(Status.INFO, "CS-TC-03: Checking the result page");
			//Assertion check by checking whether atleast one result card is displayed
			Assert.assertTrue(rp.checkCourseCardsDisplay());
			logger.info("\tCS-TC-03: Results Displayed");
			test.log(Status.INFO, "CS-TC-03: Results Displayed");
			logger.info("\tCS-TC-03: Checking Relevancy of Results");
			test.log(Status.INFO, "CS-TC-03: Checking Relevancy of Results");
			//Assertion check by checking whether shown result cards have relevance to the search key
			Assert.assertTrue(rp.CourseCardsRelevanceCheck());
			logger.info("\tCS-TC-03: Successfully Passed");
			test.log(Status.PASS, "CS-TC-03: Successfully Passed");

			String captureScreen = captureScreen("testValidSearchResults");
			test.addScreenCaptureFromPath(captureScreen);

		} catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Exception Occurred");
			test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
		}
	}

	//Data provider method for the checkbox filters
	@DataProvider(name="filtersData")
	public String[][] passFiltersData(){
		//Array with one element for one filter
		return new String[][] {{"English"},{"Beginner"}};
	}

	//CS-TC-08: Verifies that 'Beginner' and 'English' filters are unselected by default.
	@Test(priority = -1,dataProvider="filtersData",dependsOnMethods= {"testSearchButtonTrigger"})
	public void testDefaultStateOfFilters(String filterName) {
		logger.info("CS-TC-08: Starting default filter state verification for "+filterName);
		ExtentTest test = ExtentReportManager.extent.createTest("CS-TC-08: Starting default filter state verification for "+filterName);
		test.assignCategory("TS-CourseSearch");

		try {
			// Checking the default filter states
			boolean selected = rp.filterSelectStatus(filterName);

			// Logging filter states 
			logger.info("\tCS-TC-08: "+filterName+" filter selected: " + selected);
			test.log(Status.INFO, "CS-TC-08: "+filterName+" filter selected: "+selected);

			// Asserting the default states
			Assert.assertFalse(selected, filterName+" filter should be unselected by default");

			logger.info("\tCS-TC-08: Default filter state verified successfully");
			test.log(Status.PASS, "CS-TC-08: Default filter state verified successfully");

			String captureScreen = captureScreen("testDefaultStateOfFilters");
			test.addScreenCaptureFromPath(captureScreen);

		} 
		catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}
		catch (Exception e) {
			logger.error("CS-TC-08: Error during default filter state verification", e);
			Assert.fail("Exception Occurred: "+e.getMessage());

		}
	}

	//Test 4: testing whether checkboxes function as required individually
	@Test(priority=0,dataProvider="filtersData",dependsOnMethods="testValidSearchResults")
	public void testRespectiveCheckboxes(String filterName) {
		logger.info("CS-TC-0"+i+": Test "+filterName+" Checkbox is Clickable");
		ExtentTest test = ExtentReportManager.extent.createTest("CS-TC-0"+i+": Test "+filterName+" Checkbox is Clickable");
		test.assignCategory("TS-CourseSearch");
		try {
			logger.info("\tCS-TC-0"+i+": Started");
			test.log(Status.INFO, "CS-TC-0"+i+": Started");
			logger.info("\tCS-TC-0"+i+": Checking presence and state of checkbox");
			test.log(Status.INFO, "CS-TC-0"+i+": Checking presence and state of checkbox");
			//Assertion checks to check if the checkbox is displayed and not selected at the start
			Assert.assertTrue(rp.isAccessible(filterName));
			Assert.assertFalse(rp.filterSelectStatus(filterName));
			logger.info("\tCS-TC-0"+i+": Successfully Passed");
			test.log(Status.PASS, "CS-TC-0"+i+": Successfully Passed");
			i++;
			logger.info("CS-TC-0"+i+": To Verify That "+filterName+" Filter Gets Applied");
			test.log(Status.INFO, "CS-TC-0"+i+": To Verify That "+filterName+" Filter Gets Applied");
			logger.info("\tCS-TC-0"+i+": Started");
			test.log(Status.INFO, "CS-TC-0"+i+": Started");
			logger.info("\tCS-TC-0"+i+": Applying the "+filterName+" filter");
			test.log(Status.INFO, "CS-TC-0"+i+": Applying the "+filterName+" filter");
			//Clicking to apply the required filter
			rp.applyFilter(filterName);
			logger.info("\tCS-TC-0"+i+": "+filterName+" filter applied successfully");
			test.log(Status.INFO, "CS-TC-0"+i+": "+filterName+" filter applied successfully");
			//Applying explicit wait to wait until the selected filter is applied and results are loaded
			logger.info("\tCS-TC-0"+i+": Loading filtered results");
			test.log(Status.INFO, "CS-TC-0"+i+": Loading filtered results");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElements(rp.appliedFilters));
			logger.info("\tCS-TC-0"+i+": Checking status of filter after applying");
			test.log(Status.INFO, "CS-TC-0"+i+": Checking status of filter after applying");
			//Assertion check to check if the checkbox is actually selected and filter is applied 
			Assert.assertTrue(rp.filterSelectStatus(filterName));
			Assert.assertNotEquals(rp.getAppliedFilters().size(), 0);
			logger.info("\tCS-TC-0"+i+": Successfully Passed");
			test.log(Status.PASS, "CS-TC-0"+i+": Successfully Passed");
			i++;

			String captureScreen = captureScreen("testRespectiveCheckboxes");
			test.addScreenCaptureFromPath(captureScreen);

			//Clearing the current applied filter
			rp.clearAllAppliedFilters();

		} catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Exception Occurred");
			test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
		}
	}


	//CS-TC-09: Verifies that multiple filters (English and Beginner) are applied correctly
	@Test(priority = 1, dependsOnMethods = {"testValidSearchResults"})
	public void testMultipleFiltersApplicable() {
		logger.info("CS-TC-09: Verifying multiple filter application");
		ExtentTest test = ExtentReportManager.extent.createTest("CS-TC-09: Verifying multiple filter application");
		test.assignCategory("TS-CourseSearch");

		try {		
			//Applying the filters required
			rp.applyFilter("English");
			rp.applyFilter("Beginner");

			//Printing the Applied Filters
			ArrayList<String> filtersApplied = rp.getAppliedFilters();
			logger.info("\tCS-TC-09: Applied filters: " + filtersApplied);
			test.log(Status.INFO, "CS-TC-09: Applied filters: " + filtersApplied);

			//Asserting the applied filters
			Assert.assertTrue(filtersApplied.contains("Language: English"), "English filter not applied");
			Assert.assertTrue(filtersApplied.contains("Beginner"), "Beginner filter not applied");

			logger.info("\tCS-TC-09: Applying multiple filters verified successfully");
			test.log(Status.PASS, "CS-TC-09: Applying multiple filters verified successfully");

			String captureScreen = captureScreen("testMultipleFiltersApplicable");
			test.addScreenCaptureFromPath(captureScreen);

		} 
		catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}
		catch (Exception e) {
			logger.error("CS-TC-09: Error applying multiple filters", e);
			Assert.fail("Exception occurred: " + e.getMessage());
		}
	}

	//CS-TC-10: Verifies that all required fields (e.g., title, rating, duration) are present in each course result after filters are applied.
	@Test(priority = 2, dependsOnMethods = {"testMultipleFiltersApplicable"})
	public void testPresenceOfAllRequiredFields() {
		logger.info("CS-TC-10: Starting verification of required fields in course results");
		ExtentTest test = ExtentReportManager.extent.createTest("CS-TC-10: Starting verification of required fields in course results");
		test.assignCategory("TS-CourseSearch");

		try {
			// Check if all required fields are present in the filtered course results
			boolean fieldsPresent = rp.areCourseFieldsPresent();
			logger.info("\tCS-TC-10: Required fields present: " + fieldsPresent);
			test.log(Status.INFO, "CS-TC-10: Required fields present: " + fieldsPresent);

			Assert.assertTrue(fieldsPresent, "Required course fields are missing in the results");
			logger.info("\tCS-TC-10: Required fields verified successfully");
			test.log(Status.PASS, "CS-TC-10: Required fields verified successfully");

			String captureScreen = captureScreen("testPresenceOfAllRequiredFields");
			test.addScreenCaptureFromPath(captureScreen);

		}
		catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}
		catch (Exception e) {
			logger.error("\tCS-TC-10: Exception while verifying course fields", e);
			Assert.fail("Exception occurred during field verification: " + e.getMessage());
		}
	}

	/**
	 * Main Test Case: Extracts and prints details of the top 2 filtered courses.
	 */
	@Test(priority = 3, dependsOnMethods= {"testPresenceOfAllRequiredFields"})
	public void testCourseDetailsExtraction() {
		logger.info("Main Test Case: Extracting top 2 filtered course details");
		ExtentTest test = ExtentReportManager.extent.createTest("Main Test Case: Extracting top 2 filtered course details");
		test.assignCategory("TS-CourseSearch");

		try {
			//Printing top 2 courses details
			logger.info("\tMain Test Case: Top 2 Courses Fetched are:");
			//test.log(Status.INFO, "Main Test Case: Top 2 Courses Fetched are:");
			rp.printTopCourseDetails();
			logger.info("Main Test Case: Top course details printed successfully");
			test.log(Status.PASS, "Main Test Case: Top course details printed successfully");

			String captureScreen = captureScreen("testCourseDetailsExtraction");
			test.addScreenCaptureFromPath(captureScreen);

		}
		catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}
		catch (Exception e) {
			logger.error("Main Test Case: Error while extracting top course details", e);
			Assert.fail("Exception occurred during course detail extraction: " + e.getMessage());
		}
	}

	//CS-TC-11: Verifies that all retrieved course ratings are within the valid range (1 to 5).
	@Test(priority = 4, dependsOnMethods = {"testPresenceOfAllRequiredFields"})
	public void testRangeOfRatingField() {
		logger.info("CS-TC-11: Starting rating range validation");
		ExtentTest test = ExtentReportManager.extent.createTest("CS-TC-11: Starting rating range validation");
		test.assignCategory("TS-CourseSearch");
		try {
			//Retrieve top 2 ratings
			ArrayList<Float> retrievedRatings = rp.ratingValuesCheck();
			logger.info("\tCS-TC-11: Retrieved ratings: " + retrievedRatings);
			test.log(Status.INFO, "CS-TC-11: Retrieved ratings: " + retrievedRatings);

			//Check the range 1-5
			for (float rating : retrievedRatings) {
				Assert.assertTrue(rating >= 1 && rating <= 5, "Rating " + rating + " is out of valid range (1-5)");
			}

			logger.info("CS-TC-11: All ratings are within the valid range");
			test.log(Status.PASS, "CS-TC-11: All ratings are within the valid range");

			String captureScreen = captureScreen("testRangeOfRatingField");
			test.addScreenCaptureFromPath(captureScreen);

		}
		catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}
		catch (Exception e) {
			logger.error("CS-TC-11: Error while validating rating values", e);
			Assert.fail("Exception occurred during rating validation: " + e.getMessage());
		}
	}

	//CS-TC-13: Verifies that the 'Clear Filters' button removes all applied filters.
	@Test(priority = 5, dependsOnMethods= {"testMultipleFiltersApplicable"})
	public void testClearFiltersButtonFunctionality() {
		logger.info("CS-TC-12: Starting test for 'Clear Filters' functionality");
		ExtentTest test = ExtentReportManager.extent.createTest("CS-TC-12: Starting test for 'Clear Filters' functionality");
		test.assignCategory("TS-CourseSearch");
		try {
			//Clearing Applied Filters
			rp.clearAllAppliedFilters();
			ArrayList<String> filtersApplied = rp.getAppliedFilters();
			logger.info("\tCS-TC-12: Filters after clearing: " + filtersApplied);
			test.log(Status.INFO, "CS-TC-12: Filters after clearing: " + filtersApplied);

			//Validation whether filters cleared or not
			Assert.assertTrue(filtersApplied.isEmpty(), "Filters not cleared properly");

			logger.info("\tCS-TC-12: 'Clear Filters' functionality verified successfully");
			test.log(Status.PASS, "CS-TC-12: 'Clear Filters' functionality verified successfully");

			String captureScreen = captureScreen("testClearFiltersButtonFunctionality");
			test.addScreenCaptureFromPath(captureScreen);

		}
		catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}
		catch (Exception e) {
			logger.error("CS-TC-12: Exception while testing 'Clear Filters' functionality", e);
			Assert.fail("Exception occurred during filter clearing: " + e.getMessage());
		}
	}

	//CS-TC-12: Verifies behavior of the search field when no input is provided. Ensures that the system handles empty search queries gracefully.
	@Test(priority = 6)
	public void testEmptySearchFieldBehaviour() {
		logger.info("CS-TC-13: Starting test for empty search field behavior");
		ExtentTest test = ExtentReportManager.extent.createTest("CS-TC-13: Starting test for empty search field behavior");
		test.assignCategory("TS-CourseSearch");
		try {
			//Navigating back to search page
			driver.navigate().to(prop.getProperty("URL"));
			hp.searchForCourse("");

			//Get current url for empty search key
			String currentUrl = driver.getCurrentUrl();
			logger.info("\tCS-TC-13: Current URL after empty search: " + currentUrl);
			test.log(Status.INFO, "CS-TC-13: Current URL after empty search: " + currentUrl);

			//Validation
			Assert.assertTrue(currentUrl.endsWith("query=&"), "Unexpected behavior for empty search field");

			logger.info("CS-TC-13: Empty search field handled correctly");
			test.log(Status.PASS, "CS-TC-13: Empty search field handled correctly");

			String captureScreen = captureScreen("testEmptySearchFieldBehaviour");
			test.addScreenCaptureFromPath(captureScreen);

		}
		catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}
		catch (Exception e) {
			logger.error("CS-TC-13: Exception during empty search field test", e);
			Assert.fail("Exception occurred: " + e.getMessage());
		}
	}

	//CS-TC-14: Verifies that the search box auto-suggestion selects the correct course. Ensures that selecting a suggestion updates the URL with relevant keywords.
	@Test(priority = 7)
	public void testAutoSuggestionOfSearch() throws InterruptedException {
		logger.info("CS-TC-14: Starting test for search box auto-suggestion");
		ExtentTest test = ExtentReportManager.extent.createTest("CS-TC-14: Starting test for search box auto-suggestion");
		test.assignCategory("TS-CourseSearch");
		try {
			//Navigating back to Search page
			driver.navigate().to(prop.getProperty("URL"));

			//Performing required functionality
			hp.selectSuggestionFromSearch("Web De", "Web Development");

			//Validations and assertions
			String currentUrl = driver.getCurrentUrl();
			logger.info("\tCS-TC-14: URL after selecting suggestion: " + currentUrl);
			test.log(Status.INFO, "CS-TC-14: URL after selecting suggestion: " + currentUrl);

			Assert.assertTrue(currentUrl.toLowerCase().contains("web") && currentUrl.toLowerCase().contains("development"),
					"Irrelevant auto suggestions generated or incorrect URL");

			logger.info("CS-TC-14: Auto-suggestion functionality verified successfully");
			test.log(Status.PASS, "CS-TC-14: Auto-suggestion functionality verified successfully");

			String captureScreen = captureScreen("testAutoSuggestionOfSearch");
			test.addScreenCaptureFromPath(captureScreen);

		}
		catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		}
		catch (Exception e) {
			logger.error("CS-TC-14: Exception during auto-suggestion test", e);
			Assert.fail("Exception occurred during auto-suggestion verification: " + e.getMessage());
		}
	}


}