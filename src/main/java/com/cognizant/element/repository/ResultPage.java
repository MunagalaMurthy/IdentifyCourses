package com.cognizant.element.repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognizant.base.Base_Page;
import com.cognizant.utilities.MiscUtils;

public class ResultPage extends Base_Page{
	
	
	@FindBy(xpath="//div[@aria-label=\"Filters\"]")
	private WebElement filters_section;
	@FindBy(xpath="//div[contains(text(),\"Level\")]/../..")
	private WebElement level_section;
	@FindBy(xpath="//div[contains(text(),\"Level\")]/../../div/div/div")
	private List<WebElement> levels_list;
	
	
	
	public ResultPage(WebDriver driver) {
		super(driver);
	}
	
	
	public boolean isFilterSectionAccessible() {
		return filters_section.isDisplayed();
	}
	
	public boolean isLevelSectionAccessible() {
		return level_section.isDisplayed();
	}
	public int getNumberOfLevels() {
		return levels_list.size();
	}
	
	public boolean isCountAvailableForLevels() {
		MiscUtils mu = new MiscUtils();
		return mu.isCountAvailable(levels_list);
	}
	
	
}
