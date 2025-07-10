package com.cognizant.elementRepository;

import java.util.ArrayList;
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
	
	@FindBy(xpath="//button[contains(normalize-space(),\"Beginner\")]")
	private WebElement beginnerTag;
	
	@FindBy(xpath="//button[contains(normalize-space(),\"English\")]")
	private WebElement englishTag;
	
	//Locator For The English Filter
	@FindBy(xpath = "//div[contains(text(),\"Language\")]/../../../../../div[2]/div/div")
	private WebElement englishFilterCheckBox;

	//Locator For The Beginner Filter
	@FindBy(xpath="//span[text()='Beginner']//ancestor::div[2]//descendant::input")
	private WebElement beginnerFilterCheckBox;
		
	//Locator For Course Names
	@FindBy(className = "cds-CommonCard-title")
	private List<WebElement> courseCardTitles;
		
	//Locator For Course Ratings
	@FindBy(xpath = "//div[contains(@class,'RatingStat')]//descendant::span[1]")
	private List<WebElement> courseCardRatings;

	//Locator For Course Durations
	@FindBy(xpath = "//div[contains(@class,'metadata')]//descendant::p")
	private List<WebElement> courseCardDurations;
	
	//Locator for Filters Chips
	@FindBy(className="cds-Chip-label")
	private List<WebElement> filtersApplied;
	
	//Locator for Clear All
	@FindBy(xpath="//span[normalize-space()='Clear all']")
	private WebElement clearAllFiltersButton;
	
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
	
	public boolean isBeginnerLevelFilterDisplayed() {
		return beginnerTag.isDisplayed();
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
	
	//Method for checking the beginnerFilterClickable
	public boolean beginnerFilterDisplayStatus() {
		return beginnerFilterCheckBox.isDisplayed();
	}
		
	//Method for checking the englishFilterClickable
	public boolean englishFilterDisplayStatus() {
		return englishFilterCheckBox.isDisplayed();
	}
		
	//Method for checking beginnerFilterStatus
	public boolean beginnerFilterSelectStatus() {
		return beginnerFilterCheckBox.isSelected();
	}
		
	//Method for checking englishFilterStatus
	public boolean englishFilterSelectStatus() {
		return englishFilterCheckBox.isSelected();
	}
		
	//Method for applying English filter
	public void applyEnglishFilter() {
		englishFilterCheckBox.click();
	}
		
	//Method for applying Beginner filter
	public void applyBeginnerFilter() {
		beginnerFilterCheckBox.click();
	}
		
	//Method for Clearing Filters
	public void clearAllAppliedFilters() {
		clearAllFiltersButton.click();
	}
	
	//Method for printing top 2 Courses Name, Rating and Duration
	public void printTopCourseDetails() {
	    int count = Math.min(2, Math.min(courseCardTitles.size(),
	                        Math.min(courseCardRatings.size(), courseCardDurations.size())));

	    for (int i = 0; i < count; i++) {
	        String title = courseCardTitles.get(i).getText().trim();
	        String rating = courseCardRatings.get(i).getText().trim();

	        String metadata = courseCardDurations.get(i).getText();
	        String[] parts = metadata.split("·");
	        String duration = parts.length > 2 ? parts[2].trim() : "N/A";

	        System.out.println("Course " + (i + 1) + ":");
	        System.out.println("  Title   : " + title);
	        System.out.println("  Rating  : " + rating);
	        System.out.println("  Duration: " + duration);
	        System.out.println("-----------------------------------");
	    }
	}
	
	public boolean isFilterApplied(String filterName) {
		for (WebElement filter : filtersApplied) {
			if (filter.getText().trim().equalsIgnoreCase(filterName)) {
				return true;
			}
		}
		return false;
	}

	public void printAppliedFilters() {
		for(WebElement filter:filtersApplied) {
			System.out.println(filter.getText());
		}
	}
	
	public ArrayList<String> getAppliedFilters() {
		ArrayList<String> filtersAppliedOnResults=new ArrayList<String>();
		for(WebElement filter:filtersApplied) {
			String fil=filter.getText();
			filtersAppliedOnResults.add(fil);
		}
		return filtersAppliedOnResults;
	}
	
	public boolean areCourseFieldsPresent() {
	    if (courseCardTitles.isEmpty() || courseCardRatings.isEmpty() || courseCardDurations.isEmpty()) {
	        return false;
	    }

	    String title = courseCardTitles.get(0).getText().trim();
	    String rating = courseCardRatings.get(0).getText().trim();
	    String metadata = courseCardDurations.get(0).getText();
	    String[] parts = metadata.split("·");
	    String duration = parts.length > 2 ? parts[2].trim() : "";

	    return !title.isEmpty() && !rating.isEmpty() && !duration.isEmpty();
	}
	
	public ArrayList<Float> ratingValuesCheck(){
		ArrayList<Float> ratings=new ArrayList<Float>();
		int i=1;
		for(WebElement elem:courseCardRatings) {
			if(i>2)
				break;
			String data=elem.getText();
			Float rating=Float.parseFloat(data);
			ratings.add(rating);
			i++;
		}
		return ratings;
		
	}
	
	public void printSearchResults() {
		int i=1;
		for(WebElement elem:courseCardTitles) {
			if(i>10)
				break;
			System.out.println(elem.getText());
			i++;
		}

	}
	
	
}
