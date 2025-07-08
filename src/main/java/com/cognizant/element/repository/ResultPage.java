package com.cognizant.element.repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognizant.base.Base_Page;
import com.cognizant.utilities.MiscUtils;

public class ResultPage extends Base_Page{
	
	
	@FindBy(xpath="//div[@aria-label=\"Filters\"]")
	private WebElement filtersSection;
	
	@FindBy(xpath = "//div[contains(text(),\"Language\")]/../../../../../..")
	private WebElement languageSection;
	
	@FindBy(xpath="//div[contains(text(),\"Level\")]/../..")
	private WebElement levelSection;
	
	@FindBy(xpath="//div[contains(text(),\"Level\")]/../../div/div/div")
	private List<WebElement> levelsList;
	
	@FindBy(xpath ="//div[contains(text(),\"Language\")]/../../../../../div[2]/div/div")
	private List<WebElement> languageList;
	
	@FindBy(xpath="//span[normalize-space()='Show 24 more']")
	private WebElement showMoreLink;
	
	/*
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
	
	public List<String> getListOfLevels() {
		List<String> levelsList = new ArrayList<>();
		for(WebElement level: levels_list) {
			levelsList.add(level.getText());
		}
		
		return levelsList;
	}
	
	
	*/
	
	MiscUtils mu = new MiscUtils();
	
	public ResultPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isFilterSectionAccessible() {
		return mu.isSectionDisplayed(filtersSection);
	}
	
	public boolean isLevelSectionAccessible() {
		return mu.isSectionDisplayed(levelSection);
	}
	
	public boolean isLanguageSectionAccessible() {
		return mu.isSectionDisplayed(languageSection);
	}
	
	public int getNumberOfLevels() {
		return levelsList.size();
	}
	
	public int getNumberOfLanguages() {
		return languageList.size();
	}
	
	public boolean isCountAvailableForLevels() {
		
		return mu.isCountAvailable(levelsList);
	}
	
	public boolean isCountAvailableForLanguages() {
		
		return mu.isCountAvailable(languageList);
	}
	
	public List<String> getListOfLevels() {
		
		return mu.getNameList(levelsList);
	}
	
	public List<String> getListOfLanguages() {
		
		return mu.getNameList(languageList);
	}
}
