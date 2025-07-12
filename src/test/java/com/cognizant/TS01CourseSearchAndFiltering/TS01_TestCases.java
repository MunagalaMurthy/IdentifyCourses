package com.cognizant.TS01CourseSearchAndFiltering;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.*;

import com.cognizant.base.Base_Test;

public class TS01_TestCases extends Base_Test{

	//CS-TC-08: Verifies that 'Beginner' and 'English' filters are unselected by default.
	@Test(priority = 8)
	public void testDefaultStateOfFilters() {
	    logger.info("CS-TC-08: Starting default filter state verification");

	    try {
	        // Perform course search
	        String searchKey = prop.getProperty("SEARCH_KEY");
	        hp.searchForCourse(searchKey);
	        logger.info("   CS-TC-08: Search performed with keyword: " + searchKey);

	        // Checking the default filter states
	        boolean beginnerSelected = rp.beginnerFilterSelectStatus();
	        boolean englishSelected = rp.englishFilterSelectStatus();

	        // Logging filter states 
	        logger.info("   CS-TC-08: Beginner filter selected: " + beginnerSelected);
	        logger.info("   CS-TC-08: English filter selected: " + englishSelected);

	        // Asserting the default states
	        Assert.assertFalse(beginnerSelected, "Beginner filter should be unselected by default");
	        Assert.assertFalse(englishSelected, "English filter should be unselected by default");

	        logger.info("   CS-TC-08: Default filter state verified successfully");

	    } catch (Exception e) {
	        logger.error("CS-TC-08: Error during default filter state verification", e);
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }
	}


	
	//CS-TC-09: Verifies that multiple filters (English and Beginner) are applied correctly
	@Test(priority = 9, dependsOnMethods = {"testDefaultStateOfFilters"})
	public void testMultipleFiltersApplicable() {
	    logger.info("CS-TC-09: Verifying multiple filter application");

	    try {
	    	//Applying the filters required
	        rp.applyEnglishFilter();
	        rp.applyBeginnerFilter();

	        //Printing the Applied Filters
	        ArrayList<String> filtersApplied = rp.getAppliedFilters();
	        logger.info("   CS-TC-09: Applied filters: " + filtersApplied);

	        //Asserting the applied filters
	        Assert.assertTrue(filtersApplied.contains("Language: English"), "English filter not applied");
	        Assert.assertTrue(filtersApplied.contains("Beginner"), "Beginner filter not applied");
	        
	        logger.info("   CS-TC-09: Applying multiple filters verified successfully");

	    } catch (Exception e) {
	        logger.error("CS-TC-09: Error applying multiple filters", e);
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }
	}
	
	//CS-TC-10: Verifies that all required fields (e.g., title, rating, duration) are present in each course result after filters are applied.
	@Test(priority = 10, dependsOnMethods = {"testMultipleFiltersApplicable"})
	public void testPresenceOfAllRequiredFields() {
	    logger.info("CS-TC-10: Starting verification of required fields in course results");

	    try {
	        // Check if all required fields are present in the filtered course results
	        boolean fieldsPresent = rp.areCourseFieldsPresent();
	        logger.info("   CS-TC-10: Required fields present: " + fieldsPresent);

	        Assert.assertTrue(fieldsPresent, "Required course fields are missing in the results");
	        logger.info("   CS-TC-10: Required fields verified successfully");

	    } catch (Exception e) {
	        logger.error("  CS-TC-10: Exception while verifying course fields", e);
	        Assert.fail("Exception occurred during field verification: " + e.getMessage());
	    }
	}
    
	/**
	 * Main Test Case: Extracts and prints details of the top 2 filtered courses.
	 */
	@Test(priority = 11)
	public void testCourseDetailsExtraction() {
	    logger.info("Main Test Case: Extracting top 2 filtered course details");

	    try {
	    	//Printing top 2 courses details
	    	logger.info("   Main Test Case: Top 2 Courses Fetched are:");
	        rp.printTopCourseDetails();
	        logger.info("Main Test Case: Top course details printed successfully");
	        
	    } catch (Exception e) {
	        logger.error("Main Test Case: Error while extracting top course details", e);
	        Assert.fail("Exception occurred during course detail extraction: " + e.getMessage());
	    }
	}

	//CS-TC-11: Verifies that all retrieved course ratings are within the valid range (1 to 5).
	@Test(priority = 12, dependsOnMethods = {"testPresenceOfAllRequiredFields"})
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

	    } catch (Exception e) {
	        logger.error("CS-TC-11: Error while validating rating values", e);
	        Assert.fail("Exception occurred during rating validation: " + e.getMessage());
	    }
	}
	
	//CS-TC-12: Verifies behavior of the search field when no input is provided. Ensures that the system handles empty search queries gracefully.
	@Test(priority = 14)
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

	    } catch (Exception e) {
	        logger.error("CS-TC-12: Exception during empty search field test", e);
	        Assert.fail("Exception occurred: " + e.getMessage());
	    }
	}

	//CS-TC-13: Verifies that the 'Clear Filters' button removes all applied filters.
	@Test(priority = 13)
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

	    } catch (Exception e) {
	        logger.error("CS-TC-13: Exception while testing 'Clear Filters' functionality", e);
	        Assert.fail("Exception occurred during filter clearing: " + e.getMessage());
	    }
	}

	//CS-TC-14: Verifies that the search box auto-suggestion selects the correct course. Ensures that selecting a suggestion updates the URL with relevant keywords.
	@Test(priority = 15)
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

	    } catch (Exception e) {
	        logger.error("CS-TC-14: Exception during auto-suggestion test", e);
	        Assert.fail("Exception occurred during auto-suggestion verification: " + e.getMessage());
	    }
	}

}
