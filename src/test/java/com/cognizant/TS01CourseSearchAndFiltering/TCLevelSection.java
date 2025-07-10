package com.cognizant.TS01CourseSearchAndFiltering;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.cognizant.base.Base_Test;

public class TCLevelSection extends Base_Test {
	
	
	@Test(groups="sanity")
	public void toVerifyFilterSectionAccessible() {
		Assert.assertTrue(rp.isFilterSectionAccessible());
	}
	@Test(groups="sanity")
	public void toVerifyCountOfLevels() {
		Assert.assertEquals(rp.getNumberOfLevels(), 4);
	}
	@Test(groups="sanity")
	public void isCountOfCoursesVisibleForEachLevels() {
		Reporter.log("Available levels and Count of courses:");
		for(String lvl: rp.getListOfLevels()) {
			Reporter.log(lvl+"\n");
		}
		Assert.assertTrue(rp.isCountAvailableForLevels());
	}
	
	@Test(groups="smoke")
	public void isBeginnerLevelFilterApplied() {
		Assert.assertTrue(rp.isBeginnerLevelFilterDisplayed());
	}
}
