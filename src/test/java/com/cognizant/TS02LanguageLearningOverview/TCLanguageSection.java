package com.cognizant.TS02LanguageLearningOverview;

import org.testng.annotations.Test;
import org.apache.commons.codec.language.bm.Rule.RPattern;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.cognizant.base.Base_Test;
import com.cognizant.elementRepository.ResultPage;

public class TCLanguageSection extends Base_Test{
	
	
	
	@Test(groups="sanity")
	public void tc02ToVerifyLanguageSectionAccessible() {
		Assert.assertTrue(rp.isAccessible("language"));
	}
	
	@Test(groups = "smoke")
	public void tc03ToVerifyVisibilityOfShowMoreLink() {
		Assert.assertTrue(rp.isAccessible("showmore"));
	}
	
	@Test(groups = "smoke")
	public void tc04ToVerifyEnglishOptionIsAvailable() {
		try {
			for(String lang:rp.getList("language")) {
				if(lang.contains("English")) {
					Assert.assertTrue(true);
					return;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		Assert.assertFalse(true);
	}
	
	@Test(groups = "sanity")
	public void tc05ToVeriftCountOfCoursesVisibleForEachLanguage() {
		try {
			Assert.assertTrue(rp.isCountDisplayed("language"));
			for(String lang: rp.getList("languages")) {
				Reporter.log(lang+"\n");
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test(groups = "sanity")
	public void tc08ToVerifyCountOfLanguages() {
		String text = rp.ShowMoreText();
		int numberInText = Integer.parseInt(text.substring(text.indexOf("Show")+5,text.indexOf("more")-1));
		int TotalCount = numberInText+4; 
		Assert.assertEquals(TotalCount,rp.getTotalNumberOfElementsInList("language"));
	}
	
	@Test(groups="smoke")
	public void tc11ToVerifyEnglishLanguageCheckboxChecked() {
		
		try {
			rp.applyEnglishFilter();
			Assert.assertTrue(rp.isEnglishChecked());
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}


}
