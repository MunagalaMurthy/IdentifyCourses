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

    @Test(priority = 1)
    public void testBeginnerLevelFilterApplied() {
        hp.searchForCourse("Web Development");
        rp.applyBeginnerFilter();
        Assert.assertTrue(rp.isFilterApplied("Beginner"));
    }

    @Test(priority = 2)
    public void testDefaultStateOfFilters() {
        hp.searchForCourse("Web Development");
        Assert.assertFalse(rp.beginnerFilterSelectStatus(), "Beginner filter should be unselected by default");
        Assert.assertFalse(rp.englishFilterSelectStatus(), "English filter should be unselected by default");
    }

    @Test(priority = 3, dependsOnMethods = {"testBeginnerLevelFilterApplied"})
    public void testMultipleFiltersApplicable() {
        hp.searchForCourse("Web Development");
        rp.applyEnglishFilter();
        rp.applyBeginnerFilter();
        ArrayList<String> filtersApplied = rp.getAppliedFilters();
        Assert.assertFalse(filtersApplied.isEmpty(), "Filters not applied, there is some error");
    }

    @Test(priority = 4, dependsOnMethods = {"testMultipleFiltersApplicable"})
    public void testPresenceOfAllRequiredFields() {
        hp.searchForCourse("Web Development");
        rp.applyBeginnerFilter();
        rp.applyEnglishFilter();
        Assert.assertTrue(rp.areCourseFieldsPresent(), "Results not present");
    }

    @Test(priority = 5)
    public void testRangeOfRatingField() {
        hp.searchForCourse("Web Development");
        rp.applyBeginnerFilter();
        rp.applyEnglishFilter();
        ArrayList<Float> retrievedRatings = rp.ratingValuesCheck();
        for (float f : retrievedRatings) {
            Assert.assertTrue(f >= 1 && f <= 5, "Rating " + f + " is out of valid range");
        }
    }

    @Test(priority = 6)
    public void testEmptySearchFieldBehaviour() {
        hp.searchForCourse("");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.endsWith("query=&"), "Unexpected behavior for empty search field");
    }

    @Test(priority = 7)
    public void testClearFiltersButtonFunctionality() {
        hp.searchForCourse("Web Development");
        rp.applyEnglishFilter();
        rp.applyBeginnerFilter();
        rp.clearAllAppliedFilters();
        ArrayList<String> filtersApplied = rp.getAppliedFilters();
        Assert.assertTrue(filtersApplied.isEmpty(), "Filters not cleared properly");
    }

    @Test(priority = 8)
    public void testCourseDetailsExtraction() {
        hp.searchForCourse("Web Development");
        rp.applyEnglishFilter();
        rp.applyBeginnerFilter();
        rp.printTopCourseDetails();
        rp.printAppliedFilters();
    }

    @Test(priority = 9)
    public void testAutoSuggestionOfSearch() throws InterruptedException {
        hp.selectSuggestionFromSearch("Web De", "Web Development");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("web") && currentUrl.contains("development"), "Irrelevant auto suggestions generated");
    }
    

    @AfterMethod
    public void afterMethodCleanup() {
        driver.manage().deleteAllCookies(); // Optional cleanup
    }
	

}
