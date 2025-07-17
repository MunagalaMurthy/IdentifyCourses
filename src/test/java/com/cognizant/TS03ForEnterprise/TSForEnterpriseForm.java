package com.cognizant.TS03ForEnterprise;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cognizant.base.Base_Test;
import com.cognizant.elementRepository.ForEnterprisePage;
import com.cognizant.utilities.ExtentReportManager;

// This class contains test cases for various "For Enterprise" forms.
public class TSForEnterpriseForm extends Base_Test{	
	
	// Page object for interacting with the "For Enterprise" page elements.
	ForEnterprisePage fep;
	
	/**
	 * Test case to verify successful submission of the Business Sales form.
	 * This test is categorized as "high" priority.
	 * @throws IOException If there's an issue with I/O operations (e.g., reading test data or capturing screenshots).
	 */
	@Test(groups="high")
	public void tc01tofillBusinessSalesForm() throws IOException {		
		logger.info("EF-TC-01: Started");
		logger.info("EF-TC-01: To Verify that college details is successfully submitted.");
		// Create an ExtentTest entry for detailed reporting.
		ExtentTest test = ExtentReportManager.extent.createTest("EF-TC-01: To Verify that college details is successfully submitted.");
		test.assignCategory("TS-ForEnterprisesForm");
		try { 
			test.log(Status.INFO,"EF-TC-01: Started");
			// Initialize the ForEnterprisePage object, passing the WebDriver instance.
			fep = new ForEnterprisePage(driver);
			// Fill the Business Sales form using test data retrieved from 'testData' list.
			String message = fep.fillFormForBusinessSales(testData.get(1).get(0), testData.get(1).get(1), testData.get(1).get(2), testData.get(1).get(3), testData.get(1).get(4), testData.get(1).get(5),testData.get(1).get(6),testData.get(1).get(7), testData.get(1).get(8), testData.get(1).get(12), testData.get(1).get(9), testData.get(1).get(10));
			// Assert that the confirmation message contains "Thank", indicating successful submission.
			Assert.assertTrue(message.contains("Thank"));
			test.log(Status.PASS, "EF-TC-01: Successfully Passed");
			logger.info("EF-TC-01: Successfully Passed");
			// Capture a screenshot and add it to the Extent Report.
			String captureScreen = captureScreen("TestSearchInputAcceptsText");
			test.addScreenCaptureFromPath(captureScreen);
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae; // Re-throw the assertion error to mark the test as failed.
		}
	}

	/**
	 * Test case to verify successful submission of the College Support form.
	 * This test is categorized as "high" priority.
	 * @throws IOException If there's an issue with I/O operations.
	 */
	@Test(groups="high")
	public void tc02tofillCollegeSupportForm() throws IOException {
		logger.info("EF-TC-02: Started");
		logger.info("EF-TC-02: To Verify the company details is successfully submitted.");
		// Create an ExtentTest entry for detailed reporting.
		ExtentTest test = ExtentReportManager.extent.createTest("EF-TC-02: To Verify the company details is successfully submitted.");
		test.assignCategory("TS-ForEnterprisesForm");
		try {
			test.log(Status.INFO, "EF-TC-02: Started");
			// Fill the College Support form using test data.
			String message = fep.fillFormForCollege(testData.get(2).get(0), testData.get(2).get(1), testData.get(2).get(2), testData.get(2).get(3), testData.get(2).get(4), testData.get(2).get(15),testData.get(2).get(13),testData.get(2).get(14),testData.get(2).get(6),testData.get(2).get(7),testData.get(2).get(8),testData.get(2).get(9),testData.get(2).get(10));
			// Assert that the confirmation message contains "Thank".
			Assert.assertTrue(message.contains("Thank"));
			test.log(Status.PASS, "EF-TC-02: Successfully Passed");
			logger.info("EF-TC-02: Successfully Passed");
			// Capture a screenshot and add it to the report.
			String captureScreen = captureScreen("TestSearchInputAcceptsText");
			test.addScreenCaptureFromPath(captureScreen);
			
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;			
		}
	}

	/**
	 * Test case to verify successful submission of the Government Upskilling form.
	 * This test is categorized as "high" priority.
	 * @throws IOException If there's an issue with I/O operations.
	 */
	@Test(groups="high")
	public void tc03toFillGovernmentUpskillingForm() throws IOException {
		logger.info("EF-TC-03: Started");
		logger.info("EF-TC-03: To Verify the government details is successfully submitted.");
		// Create an ExtentTest entry.
		ExtentTest test = ExtentReportManager.extent.createTest("EF-TC-03: To Verify the government details is successfully submitted.");
		test.assignCategory("TS-ForEnterprisesForm"); 
		try { 
			test.log(Status.INFO,"EF-TC-03: Started");
			// Fill the Government Upskilling form using test data.
			String message = fep.fillFormForGovernmentUpskilling(testData.get(3).get(0), testData.get(3).get(1), testData.get(3).get(2), testData.get(3).get(3), testData.get(3).get(4), testData.get(3).get(5),testData.get(3).get(6), testData.get(3).get(7),testData.get(3).get(8), testData.get(3).get(12),testData.get(3).get(9),testData.get(3).get(10));
			// Assert that the confirmation message contains "Thank".
			Assert.assertTrue(message.contains("Thank")); 
			test.log(Status.PASS, "EF-TC-03: Successfully Passed");
			logger.info("EF-TC-03: Successfully Passed");
			// Capture a screenshot.
			String captureScreen = captureScreen("TestSearchInputAcceptsText");
			test.addScreenCaptureFromPath(captureScreen);
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		} 
	}

	/**
	 * Test case to verify successful submission of the Non-Profit form.
	 * This test is categorized as "high" priority.
	 * @throws IOException If there's an issue with I/O operations.
	 */
	@Test(groups="high")
	public void tc04toFillNonProfitForm() throws IOException {

		logger.info("EF-TC-04: Started");
		logger.info("EF-TC-04: To Verify the non-profit organization details is successfully submitted.");
		// Create an ExtentTest entry.
		ExtentTest test = ExtentReportManager.extent.createTest("EF-TC-04: To Verify the non-profit organization details is successfully submitted.");
		test.assignCategory("TS-ForEnterprisesForm"); 
		try { 
			test.log(Status.INFO,"EF-TC-04: Started");
			// Fill the Non-Profit form using test data.
			String message = fep.fillFormForNonProfit(testData.get(4).get(0), testData.get(4).get(1), testData.get(4).get(2), testData.get(4).get(3), testData.get(4).get(4), testData.get(4).get(5),testData.get(4).get(6), testData.get(4).get(7),testData.get(4).get(8),testData.get(4).get(9),testData.get(4).get(10));
			// Assert that the confirmation message contains "Thank".
			Assert.assertTrue(message.contains("Thank")); 
			test.log(Status.PASS, "EF-TC-04: Successfully Passed");
			logger.info("EF-TC-04: Successfully Passed");
			// Capture a screenshot.
			String captureScreen = captureScreen("TestSearchInputAcceptsText");
			test.addScreenCaptureFromPath(captureScreen);
		}catch(AssertionError ae) {
			logger.error(ae.getMessage()); 
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		} 
	}

	/**
	 * Test case to verify successful submission of the Business Others form.
	 * @throws IOException If there's an issue with I/O operations.
	 */
	@Test
	public void tc05toFillBusinessOthersForm() throws IOException {
		logger.info("EF-TC-05: Started");
		logger.info("EF-TC-05: To Verify that business details is successfully submitted.");
		// Create an ExtentTest entry.
		ExtentTest test = ExtentReportManager.extent.createTest("EF-TC-05: To Verify that business details is successfully submitted.");
		test.assignCategory("TS-ForEnterprisesForm"); 
		try { 
			test.log(Status.INFO,"EF-TC-05: Started");
			// Fill the Business Others form using test data.
			String message = fep.fillFormForBusinessOthers(testData.get(5).get(0), testData.get(5).get(1), testData.get(5).get(2), testData.get(5).get(3), testData.get(5).get(4),testData.get(5).get(5),testData.get(5).get(6),testData.get(5).get(7),testData.get(5).get(8), testData.get(5).get(9), testData.get(5).get(10), testData.get(5).get(11));
			// Assert that the confirmation message contains "Thank".
			Assert.assertTrue(message.contains("Thank")); 
			test.log(Status.PASS, "EF-TC-05: Successfully Passed");
			logger.info("EF-TC-05: Successfully Passed");
			// Capture a screenshot.
			String captureScreen = captureScreen("TestSearchInputAcceptsText");
			test.addScreenCaptureFromPath(captureScreen);
		}catch(AssertionError ae) {
			logger.error(ae.getMessage()); 
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		} 
	}

	/**
	 * Test case to verify successful submission of the generic Business form.
	 * @throws IOException If there's an issue with I/O operations.
	 */
	@Test
	public void tc06toFillBussinessForm() throws IOException {
		logger.info("EF-TC-06: Started");
		logger.info("EF-TC-06: To Verify that business details is successfully submitted.");
		// Create an ExtentTest entry.
		ExtentTest test = ExtentReportManager.extent.createTest("EF-TC-06: To Verify that business details is successfully submitted.");
		test.assignCategory("TS-ForEnterprisesForm"); 
		try { 
			test.log(Status.INFO,"EF-TC-06: Started");
			// Fill the Business form using test data.
			String message = fep.fillFormForBusiness(testData.get(6).get(0), testData.get(6).get(1), testData.get(6).get(2), testData.get(6).get(3), testData.get(6).get(4),testData.get(6).get(5),testData.get(6).get(6),testData.get(6).get(7),testData.get(6).get(8), testData.get(6).get(9), testData.get(6).get(10));
			// Assert that the confirmation message contains "Thank".
			Assert.assertTrue(message.contains("Thank")); 
			test.log(Status.PASS, "EF-TC-06: Successfully Passed");
			logger.info("EF-TC-06: Successfully Passed");
			// Capture a screenshot.
			String captureScreen = captureScreen("TestSearchInputAcceptsText");
			test.addScreenCaptureFromPath(captureScreen);
		}catch(AssertionError ae) {
			logger.error(ae.getMessage()); 
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		} 
	}

	/**
	 * Test case to verify successful submission of the College form.
	 * @throws IOException If there's an issue with I/O operations.
	 */
	@Test
	public void tc07toFillCollegeForm() throws IOException {
		logger.info("EF-TC-07: Started");
		logger.info("EF-TC-07: To Verify that college details is successfully submitted.");
		// Create an ExtentTest entry.
		ExtentTest test = ExtentReportManager.extent.createTest("EF-TC-07: To Verify that college details is successfully submitted.");
		test.assignCategory("TS-ForEnterprisesForm"); 
		try { 
			test.log(Status.INFO,"EF-TC-07: Started");
			// Fill the College form using test data.
			String message = fep.fillFormForCollege(testData.get(7).get(0), testData.get(7).get(1), testData.get(7).get(2), testData.get(7).get(3), testData.get(7).get(4),testData.get(7).get(15),testData.get(7).get(13),testData.get(7).get(14),testData.get(7).get(6),testData.get(7).get(7), testData.get(7).get(8), testData.get(5).get(9), testData.get(5).get(10));
			// Assert that the confirmation message contains "Thank".
			Assert.assertTrue(message.contains("Thank")); 
			test.log(Status.PASS, "EF-TC-07: Successfully Passed");
			logger.info("EF-TC-07: Successfully Passed");
			// Capture a screenshot.
			String captureScreen = captureScreen("TestSearchInputAcceptsText");
			test.addScreenCaptureFromPath(captureScreen);
		}catch(AssertionError ae) {
			logger.error(ae.getMessage()); 
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		} 
	}

	/**
	 * Test case to verify successful submission of the College Others form.
	 * @throws IOException If there's an issue with I/O operations.
	 */
	@Test
	public void tc08toFillCollegeOthersForm() throws IOException {
		logger.info("EF-TC-08: Started");
		logger.info("EF-TC-08: To Verify that college details is successfully submitted.");
		// Create an ExtentTest entry.
		ExtentTest test = ExtentReportManager.extent.createTest("EF-TC-08: To Verify that college details is successfully submitted.");
		test.assignCategory("TS-ForEnterprisesForm"); 
		try { 
			test.log(Status.INFO,"EF-TC-08: Started");
			// Fill the College Others form using test data.
			String message = fep.fillFormForCollege(testData.get(8).get(0), testData.get(8).get(1), testData.get(8).get(2), testData.get(8).get(3), testData.get(8).get(4),testData.get(8).get(15),testData.get(8).get(13),testData.get(8).get(6),testData.get(8).get(7), testData.get(8).get(8), testData.get(8).get(9), testData.get(8).get(10));
			// Assert that the confirmation message contains "Thank".
			Assert.assertTrue(message.contains("Thank")); 
			test.log(Status.PASS, "EF-TC-08: Successfully Passed");
			logger.info("EF-TC-08: Successfully Passed");
			// Capture a screenshot.
			String captureScreen = captureScreen("TestSearchInputAcceptsText");
			test.addScreenCaptureFromPath(captureScreen);
		}catch(AssertionError ae) {
			logger.error(ae.getMessage()); 
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		} 
	}

	/**
	 * Test case to verify successful submission of the Government Learner form.
	 * @throws IOException If there's an issue with I/O operations.
	 */
	@Test
	public void tc09toFillGovernmentLearnerForm() throws IOException {
		logger.info("EF-TC-09: Started");
		logger.info("EF-TC-09: To Verify that government details is successfully submitted.");
		// Create an ExtentTest entry.
		ExtentTest test = ExtentReportManager.extent.createTest("EF-TC-09: To Verify that government details is successfully submitted.");
		test.assignCategory("TS-ForEnterprisesForm"); 
		try { 
			test.log(Status.INFO,"EF-TC-09: Started");
			// Fill the Government Learner form using test data.
			String message = fep.fillFormForGovernmentLearner(testData.get(9).get(0), testData.get(9).get(1), testData.get(9).get(2), testData.get(9).get(3), testData.get(9).get(4),testData.get(9).get(5),testData.get(9).get(6), testData.get(9).get(7), testData.get(9).get(8), testData.get(9).get(9), testData.get(9).get(10));
			// Assert that the confirmation message contains "Thank".
			Assert.assertTrue(message.contains("Thank")); 
			test.log(Status.PASS, "EF-TC-09: Successfully Passed");     
			logger.info("EF-TC-09: Successfully Passed");
			// Capture a screenshot.
			String captureScreen = captureScreen("TestSearchInputAcceptsText");
			test.addScreenCaptureFromPath(captureScreen);
		}catch(AssertionError ae) {
			logger.error(ae.getMessage()); 
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		} 
	}

	/**
	 * Test case to verify successful submission of the Government Others form.
	 * @throws IOException If there's an issue with I/O operations.
	 */
	@Test
	public void tc10toFillGovernmentForm() throws IOException {
		logger.info("EF-TC-10: Started");
		logger.info("EF-TC-10: To Verify that government details is successfully submitted.");
		// Create an ExtentTest entry.
		ExtentTest test = ExtentReportManager.extent.createTest("EF-TC-10: To Verify that government details is successfully submitted.");
		test.assignCategory("TS-ForEnterprisesForm"); 
		try { 
			test.log(Status.INFO,"EF-TC-10: Started");
			// Fill the Government Others form using test data.
			String message = fep.fillFormForGovernmentOthers(testData.get(10).get(0),testData.get(10).get(1), testData.get(10).get(2), testData.get(10).get(3), testData.get(10).get(4), testData.get(10).get(5), testData.get(10).get(6), testData.get(10).get(7), testData.get(10).get(8), testData.get(10).get(9), testData.get(10).get(10), testData.get(10).get(11));
			// Assert that the confirmation message contains "Thank".
			Assert.assertTrue(message.contains("Thank")); 
			test.log(Status.PASS, "EF-TC-10: Successfully Passed");
			logger.info("EF-TC-10: Successfully Passed");
			// Capture a screenshot.
			String captureScreen = captureScreen("TestSearchInputAcceptsText");
			test.addScreenCaptureFromPath(captureScreen);
		}catch(AssertionError ae) {
			logger.error(ae.getMessage()); 
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		} 
	}

	/**
	 * Test case to verify successful submission of the Non-Profit Others form (first instance).
	 * @throws IOException If there's an issue with I/O operations.
	 */
	@Test
	public void tc11toFillNonProfitOthersForm() throws IOException {
		logger.info("EF-TC-11: Started");
		logger.info("EF-TC-11: To Verify the non-profit organization details is successfully submitted.");
		// Create an ExtentTest entry.
		ExtentTest test = ExtentReportManager.extent.createTest("EF-TC-11: To Verify the non-profit organization details is successfully submitted.");
		test.assignCategory("TS-ForEnterprisesForm"); 
		try { 
			test.log(Status.INFO,"EF-TC-11: Started");
			// Fill the Non-Profit Others form using test data.
			String message = fep.fillFormForNonProfitOthers(testData.get(11).get(0),testData.get(11).get(1), testData.get(11).get(2), testData.get(11).get(3), testData.get(11).get(4), testData.get(11).get(5), testData.get(11).get(6), testData.get(11).get(7), testData.get(11).get(8), testData.get(11).get(9), testData.get(11).get(10), testData.get(11).get(11));
			// Assert that the confirmation message contains "Thank".
			Assert.assertTrue(message.contains("Thank")); 
			test.log(Status.PASS, "EF-TC-11: Successfully Passed");
			logger.info("EF-TC-11: Successfully Passed");
			// Capture a screenshot.
			String captureScreen = captureScreen("TestSearchInputAcceptsText");
			test.addScreenCaptureFromPath(captureScreen);
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae; 
		} 
	}

	/**
	 * Test case to verify successful submission of the Non-Profit Sales form.
	 * @throws IOException If there's an issue with I/O operations.
	 */
	@Test
	public void tc12toFillNonProfitOthersForm() throws IOException {
		logger.info("EF-TC-12: Started");
		logger.info("EF-TC-12: To Verify the non-profit organization details is successfully submitted.");
		// Create an ExtentTest entry.
		ExtentTest test = ExtentReportManager.extent.createTest("EF-TC-12: To Verify the non-profit organization details is successfully submitted.");
		test.assignCategory("TS-ForEnterprisesForm"); 
		try { 
			test.log(Status.INFO,"EF-TC-12: Started");
			// Fill the Non-Profit Sales form using test data.
			String message = fep.fillFormForNonProfitSales(testData.get(12).get(0),testData.get(12).get(1), testData.get(12).get(2), testData.get(12).get(3), testData.get(12).get(4), testData.get(12).get(5), testData.get(12).get(6), testData.get(12).get(7), testData.get(12).get(8), testData.get(12).get(12), testData.get(12).get(9), testData.get(12).get(10));
			// Assert that the confirmation message contains "Thank".
			Assert.assertTrue(message.contains("Thank")); 
			test.log(Status.PASS, "EF-TC-12: Successfully Passed");
			logger.info("EF-TC-12: Successfully Passed");
			// Capture a screenshot.
			String captureScreen = captureScreen("TestSearchInputAcceptsText");
			test.addScreenCaptureFromPath(captureScreen);
		}catch(AssertionError ae) {
			logger.error(ae.getMessage()); 
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		} 
	}

	/**
	 * Test case to verify that the Business form submission is declined due to validation errors.
	 * This test is categorized as "high" priority.
	 * @throws IOException If there's an issue with I/O operations.
	 */
	@Test(groups="high")
	public void tc13toFillBusinessForm() throws IOException {
		logger.info("EF-TC-13: Started");
		logger.info("EF-TC-13: To Verify the company details is declined.");
		// Create an ExtentTest entry.
		ExtentTest test = ExtentReportManager.extent.createTest("EF-TC-13: To Verify the company details is declined.");
		test.assignCategory("TS-ForEnterprisesForm"); 
		try { 
			test.log(Status.INFO,"EF-TC-13: Started");
			// Fill the Business form with data expected to trigger validation errors.
			String message = fep.fillFormForBusiness(testData.get(13).get(0),testData.get(13).get(1), testData.get(13).get(2), testData.get(13).get(3), testData.get(13).get(4), testData.get(13).get(5),testData.get(13).get(6),testData.get(13).get(7), testData.get(13).get(8),testData.get(13).get(9),testData.get(13).get(10));
			// Assert that the error message contains "Must be", indicating a validation failure.
			Assert.assertTrue(message.contains("Must be")); 
			test.log(Status.PASS, "EF-TC-13: Successfully Passed"); // This log indicates the test *passed* because it successfully identified the decline.
			logger.info("EF-TC-13: Successfully Passed");
			// Capture a screenshot.
			String captureScreen = captureScreen("TestSearchInputAcceptsText");
			test.addScreenCaptureFromPath(captureScreen);
		}catch(AssertionError ae) {
			logger.error(ae.getMessage()); 
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		} 
	}

	/**
	 * Test case to verify that the College form submission is declined due to validation errors.
	 * This test is categorized as "high" priority.
	 * @throws IOException If there's an issue with I/O operations.
	 */
	@Test(groups="high")
	public void tc14toFillCollegeForm() throws IOException {
		logger.info("EF-TC-14: Started");
		logger.info("EF-TC-14: To Verify the non-profit organization details is declined.");
		// Create an ExtentTest entry.
		ExtentTest test = ExtentReportManager.extent.createTest("EF-TC-14: To Verify the non-profit organization details is declined.");
		test.assignCategory("TS-ForEnterprisesForm"); 
		try { 
			test.log(Status.INFO,"EF-TC-14: Started");
			// Fill the College form with data expected to trigger validation errors.
			String message = fep.fillFormForCollege(testData.get(14).get(0),testData.get(14).get(1), testData.get(14).get(2), testData.get(14).get(3), testData.get(14).get(4), testData.get(14).get(15), testData.get(14).get(13), testData.get(14).get(14),testData.get(14).get(6),testData.get(14).get(7), testData.get(14).get(8), testData.get(14).get(9),testData.get(14).get(10));
			// Assert that the error message contains "Must be".
			Assert.assertTrue(message.contains("Must be")); 
			test.log(Status.PASS, "EF-TC-14: Successfully Passed"); // This log indicates the test *passed* because it successfully identified the decline.
			logger.info("EF-TC-14: Successfully Passed");
			// Capture a screenshot.
			String captureScreen = captureScreen("TestSearchInputAcceptsText");
			test.addScreenCaptureFromPath(captureScreen);
		}catch(AssertionError ae) {
			logger.error(ae.getMessage()); 
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		} 
	}

	/**
	 * Test case to verify that the Non-Profit form submission is declined due to validation errors.
	 * This test is categorized as "high" priority.
	 * Note: The assertion for this test case currently checks for "Thank", which contradicts the "declined" description.
	 * If the intent is to verify a decline, the assertion should be updated to check for an error message (e.g., "Must be").
	 * @throws IOException If there's an issue with I/O operations.
	 */
	@Test(groups="high")
	public void tc15toFillNonProfitForm() throws IOException {
		logger.info("EF-TC-15: Started");
		logger.info("EF-TC-15: To Verify that non-profit organization details is declined.");
		// Create an ExtentTest entry.
		ExtentTest test = ExtentReportManager.extent.createTest("EF-TC-15: To Verify that non-profit organization details is declined.");
		test.assignCategory("TS-ForEnterprisesForm"); 
		try { 
			test.log(Status.INFO,"EF-TC-15: Started");
			// Fill the Non-Profit form with data expected to trigger validation errors.
			String message = fep.fillFormForNonProfit(testData.get(15).get(0),testData.get(15).get(1), testData.get(15).get(2), testData.get(15).get(3), testData.get(15).get(4), testData.get(15).get(5), testData.get(14).get(6), testData.get(14).get(7), testData.get(14).get(8), testData.get(14).get(9),testData.get(14).get(10));
			// IMPORTANT: The current assertion checks for "Thank". If the test is truly meant to verify a "declined" scenario,
			// this assertion should be changed to check for an error message (e.g., `message.contains("Must be")`).
			Assert.assertTrue(message.contains("Thank")); 
			test.log(Status.PASS, "EF-TC-15: Successfully Passed"); // This log indicates the test *passed* based on the current "Thank" assertion.
			logger.info("EF-TC-15: Successfully Passed");
			// Capture a screenshot.
			String captureScreen = captureScreen("TestSearchInputAcceptsText");
			test.addScreenCaptureFromPath(captureScreen);
		}catch(AssertionError ae) {
			logger.error(ae.getMessage()); 
			Assert.fail("Assertion Failed");
			test.log(Status.FAIL, "Error message mismatch: " + ae.getMessage());
			throw ae;
		} 
	}
}