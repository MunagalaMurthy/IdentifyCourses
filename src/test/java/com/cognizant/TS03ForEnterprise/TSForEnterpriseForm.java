package com.cognizant.TS03ForEnterprise;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.cognizant.base.Base_Test;
import com.cognizant.elementRepository.ForEnterprisePage;

public class TSForEnterpriseForm extends Base_Test{	
	
	ForEnterprisePage fep;
	
	@Test(groups="sanity")
	public void tc01tofillBusinessSalesForm() throws IOException {
		
		logger.info("EF-TC-01: Started");
		logger.info("EF-TC-01: To Verify that college details is successfully submitted.");
		ExtentTest test = extent.createTest("EF-TC-01: To Verify that college details is successfully submitted.");
		try {
			fep = new ForEnterprisePage(driver);
			String title = fep.fillFormForBusinessSales(testData.get(1).get(0), testData.get(1).get(1), testData.get(1).get(2), testData.get(1).get(3), testData.get(1).get(4), testData.get(1).get(5),testData.get(1).get(6),testData.get(1).get(7), testData.get(1).get(8), testData.get(1).get(12), testData.get(1).get(9), testData.get(1).get(10));
			Assert.assertTrue(title.contains("Thank"));
			screenshotPath = su.takeScreenshot("EF-TC-01");
			logger.info("EF-TC-01: Successfully Passed");
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			screenshotPath = su.takeScreenshot("EF-TC-01");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	@Test(groups="sanity")
	public void tc02tofillCollegeSupportForm() throws IOException {
		logger.info("EF-TC-02: Started");
		logger.info("EF-TC-02: To Verify the company details is successfully submitted.");
		ExtentTest test = extent.createTest("EF-TC-02: To Verify the company details is successfully submitted.");
		try {
			fep = new ForEnterprisePage(driver);
			String title = fep.fillFormForCollege(testData.get(2).get(0), testData.get(2).get(1), testData.get(2).get(2), testData.get(2).get(3), testData.get(2).get(4), testData.get(2).get(15),testData.get(2).get(13),testData.get(2).get(14),testData.get(2).get(6),testData.get(2).get(7),testData.get(2).get(8),testData.get(2).get(9),testData.get(2).get(10));
			Assert.assertTrue(title.contains("Thank"));
			screenshotPath = su.takeScreenshot("EF-TC-02");
			logger.info("EF-TC-02: Successfully Passed");
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			screenshotPath = su.takeScreenshot("EF-TC-02");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	@Test(groups="sanity")
	public void tc03toFillGovernmentUpskillingForm() throws IOException {
		logger.info("EF-TC-03: Started");
		logger.info("EF-TC-03: To Verify the government details is successfully submitted.");
		ExtentTest test = extent.createTest("EF-TC-03: To Verify the government details is successfully submitted.");
		try {
			fep = new ForEnterprisePage(driver);
			String title = fep.fillFormForGovernmentUpskilling(testData.get(3).get(0), testData.get(3).get(1), testData.get(3).get(2), testData.get(3).get(3), testData.get(3).get(4), testData.get(3).get(5),testData.get(3).get(6), testData.get(3).get(7),testData.get(3).get(8), testData.get(3).get(12),testData.get(3).get(9),testData.get(3).get(10));
			Assert.assertTrue(title.contains("Thank"));
			screenshotPath = su.takeScreenshot("EF-TC-03");
			logger.info("EF-TC-03: Successfully Passed");
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			screenshotPath = su.takeScreenshot("EF-TC-03");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	@Test(groups="sanity")
	public void tc04toFillNonProfitForm() throws IOException {

		logger.info("EF-TC-04: Started");
		logger.info("EF-TC-04: To Verify the non-profit organization details is successfully submitted.");
		ExtentTest test = extent.createTest("EF-TC-04: To Verify the non-profit organization details is successfully submitted.");
		try {
			fep = new ForEnterprisePage(driver);
			String title = fep.fillFormForNonProfit(testData.get(4).get(0), testData.get(4).get(1), testData.get(4).get(2), testData.get(4).get(3), testData.get(4).get(4), testData.get(4).get(5),testData.get(4).get(6), testData.get(4).get(7),testData.get(4).get(8),testData.get(4).get(9),testData.get(4).get(10));
			Assert.assertTrue(title.contains("Thank"));
			screenshotPath = su.takeScreenshot("EF-TC-04");
			logger.info("EF-TC-04: Successfully Passed");
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			screenshotPath = su.takeScreenshot("EF-TC-04");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	@Test(groups="smoke")
	public void tc05toFillBusinessOthersForm() throws IOException {
		logger.info("EF-TC-05: Started");
		logger.info("EF-TC-05: To Verify that business details is successfully submitted.");
		ExtentTest test = extent.createTest("EF-TC-05: To Verify that business details is successfully submitted.");
		try {
			fep = new ForEnterprisePage(driver);
			String title = fep.fillFormForBusinessOthers(testData.get(5).get(0), testData.get(5).get(1), testData.get(5).get(2), testData.get(5).get(3), testData.get(5).get(4),testData.get(5).get(5),testData.get(5).get(6),testData.get(5).get(7),testData.get(5).get(8), testData.get(5).get(9), testData.get(5).get(10), testData.get(5).get(11));
			Assert.assertTrue(title.contains("Thank"));
			screenshotPath = su.takeScreenshot("EF-TC-05");
			logger.info("EF-TC-05: Successfully Passed");
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			screenshotPath = su.takeScreenshot("EF-TC-05");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}


	@Test(groups="smoke")
	public void tc06toFillBussinessForm() throws IOException {
		logger.info("EF-TC-06: Started");
		logger.info("EF-TC-06: To Verify that business details is successfully submitted.");
		ExtentTest test = extent.createTest("EF-TC-06: To Verify that business details is successfully submitted.");
		try {
			fep = new ForEnterprisePage(driver);
			String title = fep.fillFormForBusiness(testData.get(6).get(0), testData.get(6).get(1), testData.get(6).get(2), testData.get(6).get(3), testData.get(6).get(4),testData.get(6).get(5),testData.get(6).get(6),testData.get(6).get(7),testData.get(6).get(8), testData.get(6).get(9), testData.get(6).get(10));
			Assert.assertTrue(title.contains("Thank"));
			screenshotPath = su.takeScreenshot("EF-TC-06");
			logger.info("EF-TC-06: Successfully Passed");
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			screenshotPath = su.takeScreenshot("EF-TC-06");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}


	@Test(groups="smoke")
	public void tc07toFillCollegeForm() throws IOException {
		logger.info("EF-TC-07: Started");
		logger.info("EF-TC-07: To Verify that college details is successfully submitted.");
		ExtentTest test = extent.createTest("EF-TC-07: To Verify that college details is successfully submitted.");
		try {
			fep = new ForEnterprisePage(driver);
			String title = fep.fillFormForCollege(testData.get(7).get(0), testData.get(7).get(1), testData.get(7).get(2), testData.get(7).get(3), testData.get(7).get(4),testData.get(7).get(15),testData.get(7).get(13),testData.get(7).get(14),testData.get(7).get(6),testData.get(7).get(7), testData.get(7).get(8), testData.get(5).get(9), testData.get(5).get(10));
			Assert.assertTrue(title.contains("Thank"));
			screenshotPath = su.takeScreenshot("EF-TC-07");
			logger.info("EF-TC-07: Successfully Passed");
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			screenshotPath = su.takeScreenshot("EF-TC-07");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	@Test(groups="smoke")
	public void tc08toFillCollegeOthersForm() throws IOException {
		logger.info("EF-TC-08: Started");
		logger.info("EF-TC-08: To Verify that college details is successfully submitted.");
		ExtentTest test = extent.createTest("EF-TC-08: To Verify that college details is successfully submitted.");
		try {
			fep = new ForEnterprisePage(driver);
			String title = fep.fillFormForCollege(testData.get(8).get(0), testData.get(8).get(1), testData.get(8).get(2), testData.get(8).get(3), testData.get(8).get(4),testData.get(8).get(15),testData.get(8).get(13),testData.get(8).get(6),testData.get(8).get(7), testData.get(8).get(8), testData.get(8).get(9), testData.get(8).get(10));
			Assert.assertTrue(title.contains("Thank"));
			screenshotPath = su.takeScreenshot("EF-TC-08");
			logger.info("EF-TC-08: Successfully Passed");
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			screenshotPath = su.takeScreenshot("EF-TC-08");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	@Test(groups="smoke")
	public void tc09toFillGovernmentLearnerForm() throws IOException {
		logger.info("EF-TC-09: Started");
		logger.info("EF-TC-09: To Verify that government details is successfully submitted.");
		ExtentTest test = extent.createTest("EF-TC-09: To Verify that government details is successfully submitted.");
		try {
			fep = new ForEnterprisePage(driver);
			String title = fep.fillFormForGovernmentLearner(testData.get(9).get(0), testData.get(9).get(1), testData.get(9).get(2), testData.get(9).get(3), testData.get(9).get(4),testData.get(9).get(5),testData.get(9).get(6), testData.get(9).get(7), testData.get(9).get(8), testData.get(9).get(9), testData.get(9).get(10));
			Assert.assertTrue(title.contains("Thank"));        
			screenshotPath = su.takeScreenshot("EF-TC-09");
			logger.info("EF-TC-09: Successfully Passed");
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			screenshotPath = su.takeScreenshot("EF-TC-09");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	@Test(groups="smoke")
	public void tc10toFillGovernmentForm() throws IOException {
		logger.info("EF-TC-10: Started");
		logger.info("EF-TC-10: To Verify that government details is successfully submitted.");
		ExtentTest test = extent.createTest("EF-TC-10: To Verify that government details is successfully submitted.");
		try {
			fep = new ForEnterprisePage(driver);
			String title = fep.fillFormForGovernmentOthers(testData.get(10).get(0),testData.get(10).get(1), testData.get(10).get(2), testData.get(10).get(3), testData.get(10).get(4), testData.get(10).get(5), testData.get(10).get(6), testData.get(10).get(7), testData.get(10).get(8), testData.get(10).get(9), testData.get(10).get(10), testData.get(10).get(11));
			Assert.assertTrue(title.contains("Thank"));
			screenshotPath = su.takeScreenshot("EF-TC-10");
			logger.info("EF-TC-10: Successfully Passed");
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			screenshotPath = su.takeScreenshot("EF-TC-10");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	@Test(groups="smoke")
	public void tc11toFillNonProfitOthersForm() throws IOException {
		logger.info("EF-TC-11: Started");
		logger.info("EF-TC-11: To Verify the non-profit organization details is successfully submitted.");
		ExtentTest test = extent.createTest("EF-TC-11: To Verify the non-profit organization details is successfully submitted.");
		try {
			fep = new ForEnterprisePage(driver);
			String title = fep.fillFormForNonProfitOthers(testData.get(11).get(0),testData.get(11).get(1), testData.get(11).get(2), testData.get(11).get(3), testData.get(11).get(4), testData.get(11).get(5), testData.get(11).get(6), testData.get(11).get(7), testData.get(11).get(8), testData.get(11).get(9), testData.get(11).get(10), testData.get(11).get(11));
			Assert.assertTrue(title.contains("Thank"));
			screenshotPath = su.takeScreenshot("EF-TC-11");
			logger.info("EF-TC-11: Successfully Passed");
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			screenshotPath = su.takeScreenshot("EF-TC-11");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	@Test(groups="smoke")
	public void tc12toFillNonProfitOthersForm() throws IOException {
		logger.info("EF-TC-12: Started");
		logger.info("EF-TC-12: To Verify the non-profit organization details is successfully submitted.");
		ExtentTest test = extent.createTest("EF-TC-12: To Verify the non-profit organization details is successfully submitted.");
		try {
			fep = new ForEnterprisePage(driver);
			String title = fep.fillFormForNonProfitSales(testData.get(12).get(0),testData.get(12).get(1), testData.get(12).get(2), testData.get(12).get(3), testData.get(12).get(4), testData.get(12).get(5), testData.get(12).get(6), testData.get(12).get(7), testData.get(12).get(8), testData.get(12).get(12), testData.get(12).get(9), testData.get(12).get(10));
			Assert.assertTrue(title.contains("Thank"));
			screenshotPath = su.takeScreenshot("EF-TC-12");
			logger.info("EF-TC-12: Successfully Passed");
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			screenshotPath = su.takeScreenshot("EF-TC-12");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	@Test
	public void tc13toFillBusinessForm() throws IOException {
		logger.info("EF-TC-13: Started");
		logger.info("EF-TC-13: To Verify the company details is declined.");
		ExtentTest test = extent.createTest("EF-TC-13: To Verify the company details is declined.");
		try {
			fep = new ForEnterprisePage(driver);
			String title = fep.fillFormForBusiness(testData.get(13).get(0),testData.get(13).get(1), testData.get(13).get(2), testData.get(13).get(3), testData.get(13).get(4), testData.get(13).get(5),testData.get(13).get(6),testData.get(13).get(7), testData.get(13).get(8),testData.get(13).get(9),testData.get(13).get(10));
			Assert.assertTrue(title.contains("Must be"));
			screenshotPath = su.takeScreenshot("EF-TC-13");
			logger.info("EF-TC-13: Successfully Passed");
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			screenshotPath = su.takeScreenshot("EF-TC-13");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	@Test
	public void tc14toFillCollegeForm() throws IOException {
		logger.info("EF-TC-14: Started");
		logger.info("EF-TC-14: To Verify the non-profit organization details is declined.");
		ExtentTest test = extent.createTest("EF-TC-14: To Verify the non-profit organization details is declined.");
		try {
			fep = new ForEnterprisePage(driver);
			String title = fep.fillFormForCollege(testData.get(14).get(0),testData.get(14).get(1), testData.get(14).get(2), testData.get(14).get(3), testData.get(14).get(4), testData.get(14).get(15), testData.get(14).get(13), testData.get(14).get(14),testData.get(14).get(6),testData.get(14).get(7), testData.get(14).get(8), testData.get(14).get(9),testData.get(14).get(10));
			Assert.assertTrue(title.contains("Must be"));
			screenshotPath = su.takeScreenshot("EF-TC-14");
			logger.info("EF-TC-14: Successfully Passed");
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			screenshotPath = su.takeScreenshot("EF-TC-14");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	@Test
	public void tc15toFillNonProfitForm() throws IOException {
		logger.info("EF-TC-15: Started");
		logger.info("EF-TC-15: To Verify that non-profit organization details is declined.");
		ExtentTest test = extent.createTest("EF-TC-15: To Verify that non-profit organization details is declined.");
		try {
			fep = new ForEnterprisePage(driver);
			String title = fep.fillFormForNonProfit(testData.get(15).get(0),testData.get(15).get(1), testData.get(15).get(2), testData.get(15).get(3), testData.get(15).get(4), testData.get(15).get(5), testData.get(14).get(6), testData.get(14).get(7), testData.get(14).get(8), testData.get(14).get(9),testData.get(14).get(10));
			Assert.assertTrue(title.contains("Thank"));
			screenshotPath = su.takeScreenshot("EF-TC-15");
			logger.info("EF-TC-15: Successfully Passed");
		}catch(AssertionError ae) {
			logger.error(ae.getMessage());
			screenshotPath = su.takeScreenshot("EF-TC-15");
		}
		finally {
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}


}
