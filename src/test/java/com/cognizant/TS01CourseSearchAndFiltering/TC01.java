package com.cognizant.TS01CourseSearchAndFiltering;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cognizant.base.Base_Test;

public class TC01 extends Base_Test{
	
	@Test(priority=1,groups= {"Smoke"})
	public void testSearchInputAcceptsText() {
		String searchInput = prop.getProperty("SEARCH_KEY");
		hp.enterTextIntoSearchBox(searchInput);
		Actions action = new Actions(driver);
		action.moveByOffset(847, 75).click().perform();
		Assert.assertEquals(hp.searchBox.getAttribute("value"), searchInput);
	}
	
	@Test(priority=2,dependsOnMethods={"testSearchInputAcceptsText"},groups= {"Smoke"})
	public void testSearchButtonTrigger() {
		hp.clickSearchButton();
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("RESULTS_URL"));
	}
	
	@Test(priority=3,dependsOnMethods= {"testSearchButtonTrigger"},groups= {"Sanity"})
	public void testValidSearchResults() throws IOException {
		Assert.assertTrue(rp.checkCourseCardsDisplay());
		Assert.assertTrue(rp.CourseCardsRelevanceCheck());
	}
	
	@DataProvider(name="filtersData")
	public String[][] passFiltersData(){
		return new String[][] {{"language","English"},{"level","Beginner"}};
	}
	
	@Test(priority=4,dataProvider="filtersData",dependsOnMethods="testValidSearchResults",groups= {"Sanity"})
	public void testRespectiveCheckboxes(String filterType, String filterName) {
		Assert.assertTrue(rp.filterDisplayStatus(filterName));
		Assert.assertFalse(rp.filterSelectStatus(filterName));
		rp.applyFilter(filterName);
//		Assert.assertTrue(rp.englishFilterSelectStatus());
		Assert.assertTrue(rp.checkAppliedFilter(filterName));
	}
	
	/*
	@Test(dependsOnMethods= {"testValidSearchResults"})
	public void testEnglishLanguageFilter() throws InterruptedException {
		Assert.assertTrue(rp.englishFilterDisplayStatus());
		Assert.assertFalse(rp.englishFilterSelectStatus());
		rp.applyEnglishFilter();
		Thread.sleep(3000);
//		Assert.assertTrue(rp.englishFilterSelectStatus());
		Assert.assertTrue(rp.checkAppliedEnglishFilter());
	}
	
	@Test(dependsOnMethods= {"testValidSearchResults"})
	public void testBeginnerLevelFilterApplied() throws InterruptedException{
//		Assert.assertTrue(rp.beginnerFilterDisplayStatus());
		Assert.assertFalse(rp.beginnerFilterSelectStatus());
		rp.applyBeginnerFilter();
		Thread.sleep(3000);
//		Assert.assertTrue(rp.beginnerFilterSelectStatus());
		Assert.assertTrue(rp.checkAppliedBeginnerFilter());
	}
	*/
}
