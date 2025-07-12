package com.cognizant.TS01CourseSearchAndFiltering;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cognizant.base.Base_Test;

public class TC01 extends Base_Test{
	
	public Logger logger;
	int i=4;
	
	@BeforeClass
	public void loggerInitiation() {
		logger=LogManager.getLogger(this.getClass());
	}
	
	//Test 1: testing whether search box accepts any text input
	@Test(priority=1,groups= {"Smoke"})
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
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	
	//Test 2: testing whether search button triggers the search on clicking
	@Test(priority=2,dependsOnMethods={"testSearchInputAcceptsText"},groups= {"Smoke"})
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
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	//Test 3: testing whether search results shown on the results page are valid and related to the search key
	@Test(priority=3,dependsOnMethods= {"testSearchButtonTrigger"},groups= {"Sanity"})
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
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
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
			Assert.assertTrue(rp.checkAppliedFilter(filterName));
			logger.info("\tCS-TC-0"+i+": Successfully Passed");
			i++;
		} catch (AssertionError ae) {
			logger.error(ae.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
