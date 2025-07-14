package com.cognizant.TS02LanguageLearningOverview;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.cognizant.base.Base_Test;

public class TCLevelSection extends Base_Test {

	@Test(groups="sanity")
	public void tc01ToVerifyFilterSectionAccessible() {
		logger.info("LL-TC-01: To verify that \"Filter by\" section is  accessible");
		try {
			logger.info("\tLL-TC-01: Started");
			logger.info("\tLL-TC-01: Checking if Filter section is visible or not");
			Assert.assertTrue(rp.isFilterSectionAccessible());
			logger.info("\tLL-TC-01: Successfully Passed");
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	
	@Test(groups="sanity")
	public void tc06ToVerifyLevelSectionAccessible() {
		logger.info("LL-TC-06: To verify that course level section is accessible");
		try {
			logger.info("\tLL-TC-06: Started");
			logger.info("\tLL-TC-06: Checking if Course level section is visible in Filter By section or not");
			Assert.assertTrue(rp.isLevelSectionAccessible());
			logger.info("\tLL-TC-06: Successfully Passed");
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	@Test(groups="sanity")
	public void tc08ToVerifyCountOfLevels() {
		logger.info("LL-TC-08: To verify the count of languages is same as the total languages displayed");
		try {
			logger.info("\tLL-TC-08: Started");
			logger.info("\tLL-TC-08: Checking Whether the count of languages is same as the total language displayed");
			Assert.assertEquals(rp.getNumberOfLevels(), 4);
			logger.info("\tLL-TC-08: Successfully Passed");
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	@Test(groups="sanity")
	public void tc07ToVerifyCountOfCoursesVisibleForEachLevels() {
		logger.info("LL-TC-07: To verify that the count of courses is visible for each level in the list");
		try {
			logger.info("\tLL-TC-07: Started");
			logger.info("\tLL-TC-07: Checking if Course level section is visible in Filter By section or not");
			Assert.assertTrue(rp.isCountDisplayed("level"));
			Reporter.log("Available levels and Count of courses:");
			for(String lvl: rp.getListOfLevels()) {
				Reporter.log(lvl+"\n");
			}
			logger.info("\tLL-TC-06: Successfully Passed");
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	// Needs to be run only after the level checkbox is checked
	@Test(groups="smoke")
	public void tc11ToVerifyBeginnerLevelCheckboxChecked() {
		logger.info("LL-TC-11: To verify course level filter is applied successfully after appling the course level filter");
		try {
			logger.info("\tLL-TC-11: Started");
			logger.info("\tLL-TC-11: Checking Whether the Beginner level checkbox is checked or not");
			rp.applyBeginnerFilter();
			Assert.assertTrue(rp.isBeginnerChkd());
			logger.info("\tLL-TC-11: Successfully Passed");
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@Test(groups="smoke")
	public void tc09ToVerifyBeginnerOptionIsAvailable() {
		logger.info("LL-TC-09: To verify that \"Beginner\" option is available in levels section");
		try {
			logger.info("\tLL-TC-09: Started");
			logger.info("\tLL-TC-09:Checking Whether the Beginner level is present in list or not");
			for(String lvl: rp.getListOfLevels()) {
				if(lvl.contains("Beginner")) {
					Assert.assertTrue(true);
					return;
				}
			}
			logger.info("\tLL-TC-09: Successfully Passed");
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		Assert.assertFalse(true);
	}
}
