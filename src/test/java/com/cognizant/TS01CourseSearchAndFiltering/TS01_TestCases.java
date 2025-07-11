package com.cognizant.TS01CourseSearchAndFiltering;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.*;

import com.cognizant.base.Base_Test;

public class TS01_TestCases extends Base_Test{
	
	@BeforeMethod
    public void beforeMethodSetup() {
        driver.get("https://www.coursera.org/");
    }

	//CS-TC-07: Verifying that the Beginners Level filter applies correctly.
    @Test(priority = 1)
    public void testBeginnerLevelFilterApplied() {
    	logger.info("CS-TC-07: Verifying that the Beginners Level filter applies correctly.");
        hp.searchForCourse("Web Development");
        rp.applyBeginnerFilter();
        Assert.assertTrue(rp.isFilterApplied("Beginner"));
    }

    //CS-TC-08: Testing default state of Language and Levels checkboxes.
    @Test(priority = 2)
    public void testDefaultStateOfFilters() {
    	logger.info("CS-TC-08: Testing default state of Language and Levels checkboxes.");
        hp.searchForCourse("Web Development");
        Assert.assertFalse(rp.beginnerFilterSelectStatus(), "Beginner filter should be unselected by default");
        Assert.assertFalse(rp.englishFilterSelectStatus(), "English filter should be unselected by default");
    }

    //CS-TC-09: Testing application of multiple filters together.
    @Test(priority = 3, dependsOnMethods = {"testBeginnerLevelFilterApplied"})
    public void testMultipleFiltersApplicable() {
    	logger.info("CS-TC-09: Testing application of multiple filters together.");
        hp.searchForCourse("Web Development");
        rp.applyEnglishFilter();
        rp.applyBeginnerFilter();
        ArrayList<String> filtersApplied = rp.getAppliedFilters();
        Assert.assertFalse(filtersApplied.isEmpty(), "Filters not applied, there is some error");
    }

    //CS-TC-10: Verifying presence of all required fields in the results.
    @Test(priority = 4, dependsOnMethods = {"testMultipleFiltersApplicable"})
    public void testPresenceOfAllRequiredFields() {
    	logger.info("CS-TC-10: Verifying presence of all required fields in the results.");
        hp.searchForCourse("Web Development");
        rp.applyBeginnerFilter();
        rp.applyEnglishFilter();
        Assert.assertTrue(rp.areCourseFieldsPresent(), "Results not present");
    }

    //CS-TC-11: Verifying that rating data is within the valid range.
    @Test(priority = 5)
    public void testRangeOfRatingField() {
    	logger.info("CS-TC-11: Verifying that rating data is within the valid range.");
        hp.searchForCourse("Web Development");
        rp.applyBeginnerFilter();
        rp.applyEnglishFilter();
        ArrayList<Float> retrievedRatings = rp.ratingValuesCheck();
        for (float f : retrievedRatings) {
            Assert.assertTrue(f >= 1 && f <= 5, "Rating " + f + " is out of valid range");
        }
    }

    //CS-TC-12: Testing behavior of search field when no input is provided.
    @Test(priority = 6)
    public void testEmptySearchFieldBehaviour() {
    	logger.info("CS-TC-12: Testing behavior of search field when no input is provided.");
        hp.searchForCourse("");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.endsWith("query=&"), "Unexpected behavior for empty search field");
    }

    //CS-TC-13: Testing functionality of Clear Filters option.
    @Test(priority = 7)
    public void testClearFiltersButtonFunctionality() {
    	logger.info("CS-TC-13: Testing functionality of Clear Filters option.");
        hp.searchForCourse("Web Development");
        rp.applyEnglishFilter();
        rp.applyBeginnerFilter();
        rp.clearAllAppliedFilters();
        ArrayList<String> filtersApplied = rp.getAppliedFilters();
        Assert.assertTrue(filtersApplied.isEmpty(), "Filters not cleared properly");
    }

    //Main-Test-Case For Retreiving Top 2 Filtered Courses
    @Test(priority = 8)
    public void testCourseDetailsExtraction() {
    	logger.info("Main-Test-Case For Retreiving Top 2 Filtered Courses");
        hp.searchForCourse("Web Development");
        rp.applyEnglishFilter();
        rp.applyBeginnerFilter();
        rp.printTopCourseDetails();
        rp.printAppliedFilters();
    }

    //CS-TC-14: Testing functionality of search box auto-suggestion.
    @Test(priority = 9)
    public void testAutoSuggestionOfSearch() throws InterruptedException {
    	logger.info("CS-TC-14: Testing functionality of search box auto-suggestion.");
        hp.selectSuggestionFromSearch("Web De", "Web Development");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("web") && currentUrl.contains("development"), "Irrelevant auto suggestions generated");
    }
    
    @AfterMethod
    public void afterMethodCleanup() {
        driver.manage().deleteAllCookies(); // Optional cleanup
    }
	

}
