package com.cognizant.TS02LanguageLearningOverview;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cognizant.base.Base_Test;

public class TCLevelSection extends Base_Test {

	@Test(groups="sanity")
	public void tc01ToVerifyFilterSectionAccessible() {
		Assert.assertTrue(rp.isFilterSectionAccessible());
	}
	
	@Test(groups="sanity")
	public void tc06ToVerifyLevelSectionAccessible() {
		Assert.assertTrue(rp.isLevelSectionAccessible());
	}
	@Test(groups="sanity")
	public void tc08ToVerifyCountOfLevels() {
		Assert.assertEquals(rp.getNumberOfLevels(), 4);
	}
	@Test(groups="sanity")
	public void tc07ToVerifyCountOfCoursesVisibleForEachLevels() {
		Reporter.log("Available levels and Count of courses:");
		for(String lvl: rp.getListOfLevels()) {
			Reporter.log(lvl+"\n");
		}
		Assert.assertTrue(rp.isCountDisplayed("level"));
	}

	// Needs to be run only after the level checkbox is checked
	@Test(groups="smoke")
	public void tc10ToVerifyBeginnerLevelCheckboxChecked() {
		rp.applyBeginnerFilter();
		Assert.assertTrue(rp.isBeginnerChkd());
	}
	
	@Test(groups="smoke")
	public void tc09ToVerifyBeginnerOptionIsAvailable() {
		for(String lvl: rp.getListOfLevels()) {
			if(lvl.contains("Beginner")) {
				Assert.assertTrue(true);
				return;
			}
		}
		Assert.assertFalse(true);
	}
}
