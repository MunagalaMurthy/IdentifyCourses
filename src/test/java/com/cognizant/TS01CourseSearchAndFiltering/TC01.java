package com.cognizant.TS01CourseSearchAndFiltering;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cognizant.base.Base_Test;

public class TC01 extends Base_Test{
	
	//Test 1: testing whether search box accepts any text input
	@Test(priority=1,groups= {"Smoke"})
	public void testSearchInputAcceptsText() {
		//Gathering the input term/search key from the properties file
		String searchInput = prop.getProperty("SEARCH_KEY");
		hp.enterTextIntoSearchBox(searchInput);
		//clicking outside the text box at a random point to check if text still stays in search box
		Actions action = new Actions(driver);
		action.moveByOffset(847, 75).click().perform(); //random point on the page where no element is present
		//Assertion check by checking if the text stays in the input box after clicking outside
		Assert.assertEquals(hp.searchBox.getAttribute("value"), searchInput);
	}
	
	//Test 2: testing whether search button triggers the search on clicking
	@Test(priority=2,dependsOnMethods={"testSearchInputAcceptsText"},groups= {"Smoke"})
	public void testSearchButtonTrigger() {
		hp.clickSearchButton();
		//Assertion check by checking the url of the page loaded after clicking the search button
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("RESULTS_URL"));
	}
	
	//Test 3: testing whether search results shown on the results page are valid and related to the search key
	@Test(priority=3,dependsOnMethods= {"testSearchButtonTrigger"},groups= {"Sanity"})
	public void testValidSearchResults() throws IOException {
		//Assertion check by checking whether atleast one result card is displayed
		Assert.assertTrue(rp.checkCourseCardsDisplay());
		//Assertion check by checking whether shown result cards have relevance to the search key
		Assert.assertTrue(rp.CourseCardsRelevanceCheck());
	}
	
	//Data provider method for the checkbox filters
	@DataProvider(name="filtersData")
	public String[][] passFiltersData(){
		//Array with one element for one filter
		return new String[][] {{"English"},{"Beginner"}};
	}
	
	//Test 4: testing whether checkboxes function as required
	@Test(priority=4,dataProvider="filtersData",dependsOnMethods="testValidSearchResults",groups= {"Sanity"})
	public void testRespectiveCheckboxes(String filterName) {
		//Assertion checks to check if the checkbox is displayed and not selected at the start
		Assert.assertTrue(rp.filterDisplayStatus(filterName));
		Assert.assertFalse(rp.filterSelectStatus(filterName));
		//Clicking to apply the required filter
		rp.applyFilter(filterName);
		//Applying explicit wait to wait until the selected filter is applied and results are loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(rp.appliedFilters));
		//Assertion check to check if the checkbox is actually selected and filter is applied 
		Assert.assertTrue(rp.filterSelectStatus(filterName));
		Assert.assertTrue(rp.checkAppliedFilter(filterName));
	}
}
