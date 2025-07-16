package com.cognizant.TS01CourseSearchAndFiltering;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cognizant.base.Base_Test;

public class TSCourseSearch extends Base_Test{
	
	
int i=4;
	
	//Test 1: testing whether search box accepts any text input
	@Test(priority=0,groups= {"Smoke"})
	public void testSearchInputAcceptsText() {
		logger.info("CS-TC-01: To Verify That Search Input Field Accepts Text");
		try {
			logger.info("\tCS-TC-01: Started");
			//Gathering the input term/search key from the properties file
			logger.info("\tCS-TC-01: Entering Search Key into Search Box");
			String searchInput = prop.getProperty("SEARCH_KEY");
			hp.enterTextIntoSearchBox(searchInput);
			//clicking outside the text box at a random point to check if text still stays in search box
			logger.info("\tCS-TC-01: Checking if input stays in Search Box");
			Actions action = new Actions(driver);
			action.moveByOffset(847, 75).click().perform(); //random point on the page where no element is present
			//Assertion check by checking if the text stays in the input box after clicking outside
			Assert.assertEquals(hp.searchBox.getAttribute("value"), searchInput);
			logger.info("\tCS-TC-01: Successfully Passed");
		} catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Exception Occurred");
		}
		
	}
	
	//Test 2: testing whether search button triggers the search on clicking
	@Test(priority=1,dependsOnMethods={"testSearchInputAcceptsText"},groups= {"Smoke"})
	public void testSearchButtonTrigger() {
		logger.info("CS-TC-02: To Verify That Search Button Click Triggers Search");
		try {
			logger.info("\tCS-TC-02: Started");
			logger.info("\tCS-TC-02: Triggering Search");
			hp.clickSearchButton();
			//Assertion check by checking the url of the page loaded after clicking the search button
			Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("RESULTS_URL"));
			logger.info("\tCS-TC-02: Successfully Passed");
		} catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Exception Occurred");
		}
	}
	
	//Test 3: testing whether search results shown on the results page are valid and related to the search key
	@Test(priority=2, dependsOnMethods= {"testSearchButtonTrigger"},groups= {"Sanity"})
	public void testValidSearchResults() throws IOException {
		logger.info("CS-TC-03: To Verify That Search Results Are Displayed Correctly");
		try {
			logger.info("\tCS-TC-03: Started");
			logger.info("\tCS-TC-03: Checking the result page");
			//Assertion check by checking whether atleast one result card is displayed
			Assert.assertTrue(rp.checkCourseCardsDisplay());
			logger.info("\tCS-TC-03: Results Displayed");
			logger.info("\tCS-TC-03: Checking Relevancy of Results");
			//Assertion check by checking whether shown result cards have relevance to the search key
			Assert.assertTrue(rp.CourseCardsRelevanceCheck());
			logger.info("\tCS-TC-03: Successfully Passed");
		} catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Exception Occurred");
		}
	}
	
	//Data provider method for the checkbox filters
	@DataProvider(name="filtersData")
	public String[][] passFiltersData(){
		//Array with one element for one filter
		return new String[][] {{"English"},{"Beginner"}};
	}
	
	//CS-TC-08: Verifies that 'Beginner' and 'English' filters are unselected by default.
	@Test(priority = 3,dataProvider="filtersData",dependsOnMethods= {"testSearchButtonTrigger"})
	public void testDefaultStateOfFilters(String filterName) {
	    logger.info("CS-TC-08: Starting default filter state verification for "+filterName);

	    try {
	        // Perform course search
	    	/*
	        String searchKey = prop.getProperty("SEARCH_KEY");
	        hp.searchForCourse(searchKey);
	        logger.info("   CS-TC-08: Search performed with keyword: " + searchKey);
	        */

	        // Checking the default filter states
	        boolean selected = rp.filterSelectStatus(filterName);
	        //boolean englishSelected = rp.englishFilterSelectStatus();

	        // Logging filter states 
	        logger.info("   CS-TC-08: "+filterName+" filter selected: " + selected);
//			        logger.info("   CS-TC-08: English filter selected: " + englishSelected);

	        // Asserting the default states
	        Assert.assertFalse(selected, filterName+" filter should be unselected by default");
//			        Assert.assertFalse(englishSelected, "English filter should be unselected by default");

	        logger.info("   CS-TC-08: Default filter state verified successfully");

	    } 
	    catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
		}
	    catch (Exception e) {
	        logger.error("CS-TC-08: Error during default filter state verification", e);
	        Assert.fail("Exception Occurred");
	        
	    }
	}
	
	//Test 4: testing whether checkboxes function as required individually
	@Test(priority=4,dataProvider="filtersData",dependsOnMethods="testValidSearchResults",groups= {"Sanity"})
	public void testRespectiveCheckboxes(String filterName) {
		logger.info("CS-TC-0"+i+": Test "+filterName+" Checkbox is Clickable");
		try {
			logger.info("\tCS-TC-0"+i+": Started");
			logger.info("\tCS-TC-0"+i+": Checking presence and state of checkbox");
			//Assertion checks to check if the checkbox is displayed and not selected at the start
			Assert.assertTrue(rp.filterDisplayStatus(filterName));
			Assert.assertFalse(rp.filterSelectStatus(filterName));
			logger.info("\tCS-TC-0"+i+": Successfully Passed");
			i++;
			logger.info("CS-TC-0"+i+": To Verify That "+filterName+" Filter Gets Applied");
			logger.info("\tCS-TC-0"+i+": Started");
			logger.info("\tCS-TC-0"+i+": Applying the "+filterName+" filter");
			//Clicking to apply the required filter
			rp.applyFilter(filterName);
			logger.info("\tCS-TC-0"+i+": "+filterName+" filter applied successfully");
			//Applying explicit wait to wait until the selected filter is applied and results are loaded
			logger.info("\tCS-TC-0"+i+": Loading filtered results");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElements(rp.appliedFilters));
			logger.info("\tCS-TC-0"+i+": Checking status of filter after applying");
			//Assertion check to check if the checkbox is actually selected and filter is applied 
			Assert.assertTrue(rp.filterSelectStatus(filterName));
			Assert.assertNotEquals(rp.getAppliedFilters().size(), 0);
			logger.info("\tCS-TC-0"+i+": Successfully Passed");
			i++;
			//Clearing the current applied filter
			rp.clearAllAppliedFilters();
		} catch (AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.fail("Exception Occurred");
		}
	}

		
		//CS-TC-09: Verifies that multiple filters (English and Beginner) are applied correctly
		@Test(priority = 6, dependsOnMethods = {"testValidSearchResults"})
		public void testMultipleFiltersApplicable() {
		    logger.info("CS-TC-09: Verifying multiple filter application");

		    try {		    	
		    	//Applying the filters required
		        rp.applyFilter("English");
		        rp.applyFilter("Beginner");

		        //Printing the Applied Filters
		        ArrayList<String> filtersApplied = rp.getAppliedFilters();
		        logger.info("   CS-TC-09: Applied filters: " + filtersApplied);

		        //Asserting the applied filters
		        Assert.assertTrue(filtersApplied.contains("Language: English"), "English filter not applied");
		        Assert.assertTrue(filtersApplied.contains("Beginner"), "Beginner filter not applied");
		        
		        logger.info("   CS-TC-09: Applying multiple filters verified successfully");

		    } 
		    catch (AssertionError ae) {
				logger.error(ae.getMessage());
				Assert.fail("Assertion Failed");
			}
		    catch (Exception e) {
		        logger.error("CS-TC-09: Error applying multiple filters", e);
		        Assert.fail("Exception occurred: " + e.getMessage());
		    }
		}
		
		//CS-TC-10: Verifies that all required fields (e.g., title, rating, duration) are present in each course result after filters are applied.
		@Test(priority = 7, dependsOnMethods = {"testMultipleFiltersApplicable"})
		public void testPresenceOfAllRequiredFields() {
		    logger.info("CS-TC-10: Starting verification of required fields in course results");

		    try {
		        // Check if all required fields are present in the filtered course results
		        boolean fieldsPresent = rp.areCourseFieldsPresent();
		        logger.info("   CS-TC-10: Required fields present: " + fieldsPresent);

		        Assert.assertTrue(fieldsPresent, "Required course fields are missing in the results");
		        logger.info("   CS-TC-10: Required fields verified successfully");

		    }
		    catch (AssertionError ae) {
				logger.error(ae.getMessage());
				Assert.fail("Assertion Failed");
			}
		    catch (Exception e) {
		        logger.error("  CS-TC-10: Exception while verifying course fields", e);
		        Assert.fail("Exception occurred during field verification: " + e.getMessage());
		    }
		}
	    
		/**
		 * Main Test Case: Extracts and prints details of the top 2 filtered courses.
		 */
		@Test(priority = 8, dependsOnMethods= {"testPresenceOfAllRequiredFields"})
		public void testCourseDetailsExtraction() {
		    logger.info("Main Test Case: Extracting top 2 filtered course details");

		    try {
		    	//Printing top 2 courses details
		    	logger.info("   Main Test Case: Top 2 Courses Fetched are:");
		        rp.printTopCourseDetails();
		        logger.info("Main Test Case: Top course details printed successfully");
		        
		    }
		    catch (AssertionError ae) {
				logger.error(ae.getMessage());
				Assert.fail("Assertion Failed");
			}
		    catch (Exception e) {
		        logger.error("Main Test Case: Error while extracting top course details", e);
		        Assert.fail("Exception occurred during course detail extraction: " + e.getMessage());
		    }
		}

		//CS-TC-11: Verifies that all retrieved course ratings are within the valid range (1 to 5).
		@Test(priority = 9, dependsOnMethods = {"testPresenceOfAllRequiredFields"})
		public void testRangeOfRatingField() {
		    logger.info("CS-TC-11: Starting rating range validation");

		    try {
		    	//Retrieve top 2 ratings
		        ArrayList<Float> retrievedRatings = rp.ratingValuesCheck();
		        logger.info("  CS-TC-11: Retrieved ratings: " + retrievedRatings);

		        //Check the range 1-5
		        for (float rating : retrievedRatings) {
		            Assert.assertTrue(rating >= 1 && rating <= 5, "Rating " + rating + " is out of valid range (1-5)");
		        }

		        logger.info("CS-TC-11: All ratings are within the valid range");

		    }
		    catch (AssertionError ae) {
				logger.error(ae.getMessage());
				Assert.fail("Assertion Failed");
			}
		    catch (Exception e) {
		        logger.error("CS-TC-11: Error while validating rating values", e);
		        Assert.fail("Exception occurred during rating validation: " + e.getMessage());
		    }
		}
		
		//CS-TC-13: Verifies that the 'Clear Filters' button removes all applied filters.
		@Test(priority = 10)
		public void testClearFiltersButtonFunctionality() {
		    logger.info("CS-TC-13: Starting test for 'Clear Filters' functionality");

		    try {
		    	
		    	//Clearing Applied Filters
		        rp.clearAllAppliedFilters();
		        ArrayList<String> filtersApplied = rp.getAppliedFilters();
		        logger.info("   CS-TC-13: Filters after clearing: " + filtersApplied);

		        //Validation whether filters cleared or not
		        Assert.assertTrue(filtersApplied.isEmpty(), "Filters not cleared properly");

		        logger.info("CS-TC-13: 'Clear Filters' functionality verified successfully");

		    }
		    catch (AssertionError ae) {
				logger.error(ae.getMessage());
				Assert.fail("Assertion Failed");
			}
		    catch (Exception e) {
		        logger.error("CS-TC-13: Exception while testing 'Clear Filters' functionality", e);
		        Assert.fail("Exception occurred during filter clearing: " + e.getMessage());
		    }
		}
		
		//CS-TC-12: Verifies behavior of the search field when no input is provided. Ensures that the system handles empty search queries gracefully.
		@Test(priority = 11)
		public void testEmptySearchFieldBehaviour() {
		    logger.info("CS-TC-12: Starting test for empty search field behavior");

		    try {
		    	//Navigating back to search page
		        driver.navigate().to(prop.getProperty("URL"));
		        hp.searchForCourse("");

		        //Get current url for empty search key
		        String currentUrl = driver.getCurrentUrl();
		        logger.info("   CS-TC-12: Current URL after empty search: " + currentUrl);

		        //Validation
		        Assert.assertTrue(currentUrl.endsWith("query=&"), "Unexpected behavior for empty search field");

		        logger.info("CS-TC-12: Empty search field handled correctly");

		    }
		    catch (AssertionError ae) {
				logger.error(ae.getMessage());
				Assert.fail("Assertion Failed");
			}
		    catch (Exception e) {
		        logger.error("CS-TC-12: Exception during empty search field test", e);
		        Assert.fail("Exception occurred: " + e.getMessage());
		    }
		}

		//CS-TC-14: Verifies that the search box auto-suggestion selects the correct course. Ensures that selecting a suggestion updates the URL with relevant keywords.
		@Test(priority = 12)
		public void testAutoSuggestionOfSearch() throws InterruptedException {
		    logger.info("CS-TC-14: Starting test for search box auto-suggestion");

		    try {
		    	//Navigating back to Search page
		        driver.navigate().to(prop.getProperty("URL"));
		        
		        //Performing required functionality
		        hp.selectSuggestionFromSearch("Web De", "Web Development");

		        //Validations and assertions
		        String currentUrl = driver.getCurrentUrl();
		        logger.info("   CS-TC-14: URL after selecting suggestion: " + currentUrl);

		        Assert.assertTrue(currentUrl.toLowerCase().contains("web") && currentUrl.toLowerCase().contains("development"),
		                "Irrelevant auto suggestions generated or incorrect URL");

		        logger.info("CS-TC-14: Auto-suggestion functionality verified successfully");

		    }
		    catch (AssertionError ae) {
				logger.error(ae.getMessage());
				Assert.fail("Assertion Failed");
			}
		    catch (Exception e) {
		        logger.error("CS-TC-14: Exception during auto-suggestion test", e);
		        Assert.fail("Exception occurred during auto-suggestion verification: " + e.getMessage());
		    }
		}
	
	
}

