package com.cognizant.TS02LanguageLearningOverview;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.cognizant.base.Base_Test;

public class TCLanguageSection extends Base_Test{
	
	
	// Test Case: LL-TC-02
	// Description: To verify that the Language section is accessible on the result page.
	@Test(groups="sanity")
	public void tc02ToVerifyLanguageSectionAccessible() throws IOException {
		
		//Gathering the input term/search key from the properties file
		logger.info("\tLL-TC-01: Entering Search Key into Search Box");
		String searchInput = prop.getProperty("SEARCH_KEY");
		hp.enterTextIntoSearchBox(searchInput);
		//clicking outside the text box at a random point to check if text still stays in search box
		logger.info("\tLL-TC-01: Checking if input stays in Search Box");
		hp.clickSearchButton();
		// Logging the start of the test case
		logger.info("LL-TC-02: To verify that Language section is accessible");
		
		// Creating a test entry in the Extent Report
		ExtentTest test = extent.createTest("LL-TC-02: To verify that Language section is accessible");
		
		try {
			
			// Logging the steps being performed
			logger.info("\tLL-TC-02: Started");
	        logger.info("\tLL-TC-02: Checking if Language section is visible in Filter By section or not");
	        test.log(Status.INFO, "Checking if Language section is accessible");
	        
	        // Assertion to verify if the language section is accessible
	        Assert.assertTrue(rp.isAccessible("language"));
	        
	        // Taking screenshot on successful verification
	        screenshotPath = su.takeScreenshot("LL_TC02_pass");
	        test.log(Status.PASS, "Successfully Passed");
	        
	        // Logging success in Extent Report and console
	        logger.info("\tLL-TC-02: Successfully Passed");

		}catch (AssertionError ae) {
			
			// Logging assertion failure and capturing screenshot
	        logger.error("\tLL-TC-02: Assertion failed - " + ae.getMessage());
	        screenshotPath = su.takeScreenshot("LL_TC02_fail");
	        
	        // Attaching screenshot to Extent Report with failure status
	        test.fail("Assertion Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		}catch (Exception e) {
			
			// Logging unexpected exception and capturing screenshot
			logger.error("\tLL-TC-02: Exception occurred - " + e.getMessage());
			screenshotPath = su.takeScreenshot("LL_TC02_fail");
			
			// Attaching screenshot to Extent Report with failure status
			test.fail("Exception Occurred", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		}
		finally {
			
			// Adding screenshot to the test report regardless of pass/fail
	        test.addScreenCaptureFromPath(screenshotPath);
	    }
	}
	
	
	// Test Case: LL-TC-03
	// Description: To verify that the "Show More" link is visible in the language section.
	@Test(groups = "smoke")
	public void tc03ToVerifyVisibilityOfShowMoreLink() throws IOException {
		

		// Logging the start of the test case
	    logger.info("LL-TC-03: To verify that 'Show More' link is visible in the Language section");
	    

		 // Creating a test entry in the Extent Report
	     ExtentTest test = extent.createTest("LL-TC-03: To verify that 'Show More' link is visible in the Language section");
	     
	     try {
	    	 
	    	 // Logging the steps being performed
	         logger.info("\tLL-TC-03: Started");
	         logger.info("\tLL-TC-03: Checking if 'Show More' link is accessible");
	         test.log(Status.INFO, "Checking if 'Show More' link is accessible");
	        
	         // Assertion to verify if the 'showmore' element is accessible
	         Assert.assertTrue(rp.isAccessible("showmore"));

	         // Taking screenshot on successful verification
             screenshotPath = su.takeScreenshot("LL_TC03_pass");

             // Logging success in Extent Report and console
             test.log(Status.PASS, "Successfully Passed");
             logger.info("\tLL-TC-03: Successfully Passed");

	     } catch(AssertionError ae) {
	    	 
	    	 // Logging assertion failure and capturing screenshot
	    	 logger.error("\tLL-TC-03: Assertion failed - " + ae.getMessage());
	    	 screenshotPath = su.takeScreenshot("LL_TC03_fail");
	    	 
	    	 // Attaching screenshot to Extent Report with failure status
             test.fail("Assertion Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
             
	     } catch (Exception e) {
	    	 
	    	 // Logging unexpected exception and capturing screenshot
	    	 
	    	 logger.error("\tLL-TC-03: Exception occurred - " + e.getMessage());
	         screenshotPath = su.takeScreenshot("LL_TC03_fail");

	         // Attaching screenshot to Extent Report with failure status
	         test.fail("Exception Occurred", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
	         
	     } finally {
	    	 
	    	 // Adding screenshot to the test report regardless of pass/fail
	         test.addScreenCaptureFromPath(screenshotPath);

		}
	}
	
	//Test Case: LL-TC-04
	//Description: To verify that "English" is one of the available language options.
	@Test(groups = "smoke")
	public void tc04ToVerifyEnglishOptionIsAvailable() throws IOException {
		

		// Logging the start of the test case
	    logger.info("LL-TC-04: To verify that 'English' option is available in the language list");

	    // Creating a test entry in the Extent Report
	    ExtentTest test = extent.createTest("LL-TC-04: To verify that 'English' option is available in the language list");

		try {
			
			logger.info("\tLL-TC-04: Started");
			logger.info("\tLL-TC-04: Fetching list of available languages");
			test.log(Status.INFO, "Fetching list of available languages");
			
			// Loop through the list of languages to check for "English"
			for(String lang:rp.getList("language")) {
				if(lang.contains("English")) {
					
					logger.info("\tLL-TC-04: 'English' option found in the list");
					test.log(Status.PASS, "'English' option is available");
					
					// Capture screenshot on success
	                screenshotPath = su.takeScreenshot("LL_TC04_pass");
	                test.addScreenCaptureFromPath(screenshotPath);
	                
					// English found
					Assert.assertTrue(true);  
					return;
				}
			}
			
		} catch (AssertionError ae) {
			
	        // Log assertion failure and capture screenshot
	        logger.error("\tLL-TC-04: Assertion failed - " + ae.getMessage());
	        screenshotPath = su.takeScreenshot("LL_TC04_fail");
	        test.fail("\tLL-TC-04: 'English' option not found in the list", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

	    } catch (Exception e) {
	    	
			// Log any unexpected exception and capture screenshot
	    	logger.error("\tLL-TC-04: Exception occurred - " + e.getMessage());
	        screenshotPath = su.takeScreenshot("LL_TC04_fail");
	        test.fail("\tLL-TC-04: 'English' option not found in the list", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        
		} finally {
	        // Attach screenshot to the report regardless of outcome
	        if (screenshotPath != null) {
	            test.addScreenCaptureFromPath(screenshotPath);
	        }
	    }

		

		// English not found
		Assert.assertFalse(true);
	}
	
	
	// Test Case: LL-TC-05
	// Description: To verify that the count of courses is displayed for each language
	@Test(groups = "sanity")
	public void tc05ToVerifyCountOfCoursesVisibleForEachLanguage() throws IOException {
		

		// Logging the start of the test case
	    logger.info("LL-TC-05: To verify that the count of courses is visible for each language in the list");

	    // Creating a test entry in the Extent Report
	    ExtentTest test = extent.createTest("LL-TC-05: To verify that the count of courses is visible for each language in the list");
		
		try {
			logger.info("\tLL-TC-05: Started");
	        logger.info("\tLL-TC-05: Checking if course count is displayed for each language");
	        test.log(Status.INFO, "Checking if course count is displayed for each language");

	        // Assertion to verify if the count is displayed for the language section
			Assert.assertTrue(rp.isCountDisplayed("language"));
			
			// Capture screenshot on success
	        screenshotPath = su.takeScreenshot("LL_TC05_pass");

	        // Logging and reporting each language and its course count
	        Reporter.log("Available languages and count of courses:");
	        
//
	        System.out.println("calling getList loop");
			for(String lang:rp.getList("language")) {
				System.out.println(lang);
				Reporter.log(lang+"\n");
				test.info(lang + "\n");
			}
			
			logger.info("\tLL-TC-05: Successfully Passed");
			test.log(Status.PASS, "Successfully Passed");

		} catch (AssertionError ae) {
			// Log assertion failure and capture screenshot
	        logger.error("\tLL-TC-05: Assertion failed - " + ae.getMessage());
	        screenshotPath = su.takeScreenshot("LL_TC05_fail");
	        test.fail("Assertion Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} catch (Exception e) {
			// Log unexpected exception and capture screenshot
	        logger.error("\tLL-TC-05: Exception occurred - " + e.getMessage());
	        screenshotPath = su.takeScreenshot("LL_TC05_fail");
	        test.fail("Exception Occurred", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} finally {

			// Attach screenshot to the report
			test.addScreenCaptureFromPath(screenshotPath);

		}
	}
	
	
	
	// Test Case: LL-TC-08
    // Description: To verify that the count of languages displayed matches the expected count.
	@Test(groups = "sanity")
	public void tc08ToVerifyCountOfLanguages() throws IOException {
		
		// Logging the start of the test case
	    logger.info("LL-TC-08: To verify that the count of languages is same as the total languages displayed");

	    // Creating a test entry in the Extent Report
	    ExtentTest test = extent.createTest("LL-TC-08: To verify that the count of languages is same as the total languages displayed");
	    
	    try {
	    	logger.info("\tLL-TC-08: Started");
			logger.info("\tLL-TC-08: Fetching 'Show More' text to calculate expected language count");
			test.log(Status.INFO, "Fetching 'Show More' text to calculate expected language count");

			// Extracting number from "Show More" text
			String text = rp.ShowMoreText();
			
			//It calculates the expected count using the "Show More" text.
			int langCount = Integer.parseInt(text.substring(text.indexOf("Show")+5,text.indexOf("more")-1));
			
			// 4 languages are shown by default
			int totalLangCount = langCount+4;
			

			logger.info("\tLL-TC-08: Calculated expected language count: " + totalLangCount);
	        logger.info("\tLL-TC-08: Fetching actual language count from UI");
	
	        // Assertion to verify if expected and actual counts match
	        Assert.assertEquals(totalLangCount,rp.getTotalNumberOfElementsInList("language"));
			
	    } catch (AssertionError ae) {
	    	// Log assertion failure and capture screenshot
	        logger.error("\tLL-TC-08: Assertion failed - " + ae.getMessage());
	        screenshotPath = su.takeScreenshot("LL_TC08_fail");
	        test.fail("Assertion Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

	    } catch (Exception e) {
	    	// Log unexpected exception and capture screenshot
	        logger.error("\tLL-TC-08: Exception occurred - " + e.getMessage());
	        screenshotPath = su.takeScreenshot("LL_TC08_fail");
	        test.fail("Exception Occurred", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

	    }finally {
	    	//Attach screenshot to the report
	    	test.addScreenCaptureFromPath(screenshotPath);

		}
	}
	
	//Test Case: LL-TC-10
	//Description: To verify that the English language checkbox is checked after applying the filter.
	@Test(groups="smoke")
	public void tc10ToVerifyEnglishLanguageCheckboxChecked() throws IOException {
		

		// Logging the start of the test case
	    logger.info("LL-TC-10: To verify that English language checkbox is checked after applying the filter");

	    // Creating a test entry in the Extent Report
	    ExtentTest test = extent.createTest("LL-TC-10: To verify that English language checkbox is checked after applying the filter");

		try {
			logger.info("\tLL-TC-10: Started");
	        logger.info("\tLL-TC-10: Applying English language filter");
	        test.log(Status.INFO, "Applying English language filter");
	        
	        // Apply the English filter
			rp.applyEnglishFilter();
			
			// Verify if the English checkbox is checked
			Assert.assertTrue(rp.isEnglishChecked());
			

			// Capture screenshot on success
	        screenshotPath = su.takeScreenshot("LL_TC10_pass");
	        test.log(Status.PASS, "Successfully Passed");
	        logger.info("\tLL-TC-10: Successfully Passed");
			
		} catch (AssertionError ae) {
			// Log assertion failure and capture screenshot
	        logger.error("\tLL-TC-10: Assertion failed - " + ae.getMessage());
	        screenshotPath = su.takeScreenshot("LL_TC10_fail");
	        test.fail("Assertion Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

			 
		} catch (Exception e) {

			// Log unexpected exception and capture screenshot
	        logger.error("\tLL-TC-10: Exception occurred - " + e.getMessage());
	        screenshotPath = su.takeScreenshot("LL_TC10_fail");
	        test.fail("Exception Occurred", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} finally {
			
			//Attach screenshot to the report
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}


}
