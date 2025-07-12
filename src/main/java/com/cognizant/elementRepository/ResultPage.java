package com.cognizant.elementRepository;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognizant.base.Base_Page;
import com.cognizant.utilities.ExcelUtils;
import com.cognizant.utilities.MiscUtils;

public class ResultPage extends Base_Page{
	
	/*
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
	*/
	
	//Locator for The English filter selector
	@FindBy(xpath="//div[contains(@data-testid,'English') and contains(@data-testid,'language')]")
	private WebElement englishFilterCheckBox;
	
	//Locator for The English filter selector
	@FindBy(xpath="//div[contains(@data-testid,'Beginner') and contains(@data-testid,'Level')]")
	private WebElement beginnerFilterCheckBox;
	
	//Locator for applied filters list
	@FindBy(xpath="//span[@class='cds-Chip-label']")
	public List<WebElement> appliedFilters;
	
	//Locator for Course Cards
	@FindBy(className = "css-1whl2ol")
	private List<WebElement> courseCards;
	
	//Locator For Course Names
	@FindBy(className = "cds-CommonCard-title")
	private List<WebElement> courseCardTitles;
	
	/*
	//Locator For Course Ratings
	@FindBy(xpath = "//div[contains(@class,'RatingStat')]//descendant::span[1]")
	private List<WebElement> courseCardRatings;

	//Locator For Course Durations
	@FindBy(xpath = "//div[contains(@class,'metadata')]//descendant::p")
	private List<WebElement> courseCardDurations;
	
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
	
	//Locator to find the clear all filters button
	@FindBy(xpath="//span[normalize-space()='Clear all']")
	private WebElement clearAllFiltersButton; 
	*/
	
	//Locator to find the applied filters
	@FindBy(className="cds-Chip-label")
	private List<WebElement> filtersApplied;
	
	MiscUtils mu = new MiscUtils();
	
	public ResultPage(WebDriver driver) {
		super(driver);
	}
	
	/*
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
	*/
	
	//Method to check if atleast one course card is displayed or not
	public boolean checkCourseCardsDisplay() {
		if(courseCards.size()>0)
			return true;
		else
			return false;
	}
	
	//Method to check whether the course cards displayed on the search results page are relevant to the search key
	public boolean CourseCardsRelevanceCheck() throws IOException {
		//Using checkWords excel file, which contains key words used to compare with the titles of the courses to check relevance
		ExcelUtils excel = new ExcelUtils("C:\\Users\\2407200\\eclipse-workspace\\AutomationSamples\\src\\main\\resources\\Checkwords.xlsx");
		int count = excel.getRowCount("Sheet1");
		//Creating an array to store the checking key words
		String[] checkWords = new String[count];
		for(int i=1;i<=count;i++)
			checkWords[i-1] = excel.getCellData("Sheet1", i, 0);
		//Checking whether the course titles contain atleast one of the key words from the array
		int trueCount = 0;
		for(WebElement title:courseCardTitles) {
			for(String checkWord:checkWords) {
				if(title.getText().toLowerCase().contains(checkWord)) {
					trueCount++;
					break;
				}
			}
		}
		
		//Debug print statements to check how many course are relevant out of all
		/*
		System.out.println("Total Count:"+courseCardTitles.size());
		System.out.println("Relevant Count:"+trueCount);
		*/
		//Conditional checking if all the courses consist of atleast 75% of the truly relevant courses
		if(trueCount>=(0.75*courseCardTitles.size()))
			return true;
		else
			return false;
	}
	
	//Method for checking whether the given filter is displayed or not
	public boolean filterDisplayStatus(String filterName) {
		boolean returnValue = false;
		//Using the name of the filter provided to check if the respective check box is displayed
		switch (filterName) {
			case "English":
				returnValue = englishFilterCheckBox.isDisplayed();
				break;
			case "Beginner":
				returnValue = beginnerFilterCheckBox.isDisplayed();
				break;
		}
		return returnValue;
	}
		
	//Method for checking whether the given filter is selected or not
	public boolean filterSelectStatus(String filterName) {
		boolean returnValue = false;
		//Using the name of the filter provided to check if the respective check box is selected
		switch (filterName) {
			case "English":
				//System.out.println(englishFilterCheckBox.getAttribute("data-testid"));
				//checks if the filter's attribute ends with 'true'- meaning checkbox is selected
				if(englishFilterCheckBox.getAttribute("data-testid").endsWith("true"))
					returnValue = true;
				break;
			case "Beginner":
				//System.out.println(beginnerFilterCheckBox.getAttribute("data-testid"));
				//checks if the filter's attribute ends with 'true'- meaning checkbox is selected
				if(beginnerFilterCheckBox.getAttribute("data-testid").endsWith("true"))
					returnValue = true;
				break;
		}
		return returnValue;
	}
	
	//Method for applying the given filter
	public void applyFilter(String filterName) {
		//Using the name of the filter provided to click the respective checkbox
		switch (filterName) {
			case "English":
				englishFilterCheckBox.click();
				break;
			case "Beginner":
				beginnerFilterCheckBox.click();
				break;
		}
	}
	
	//Method to check if the selected filter is applied properly
	public boolean checkAppliedFilter(String filterName) {
		boolean check = false;
		//Using the name of the filter provided to check if the selected filter is applied as required
		for(WebElement filter:appliedFilters) {
			if(filter.getText().contains(filterName))
				check = true;
		}
		return check;
	}

	/*
	//Method for checking the beginnerFilterClickable
	public boolean beginnerFilterDisplayStatus() {
		Actions action = new Actions(driver);
		action.scrollToElement(beginnerFilterCheckBox).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(beginnerFilterCheckBox.isDisplayed());
		return beginnerFilterCheckBox.isDisplayed();
	}
		
	public boolean beginnerFilterSelectStatus() {
		return beginnerFilterCheckBox.isSelected();
	}
		
	//Method for applying Beginner filter
	public void applyBeginnerFilter() {
		beginnerFilterCheckBox.click();
	}
	
	public boolean checkAppliedBeginnerFilter() {
		boolean check = false;
		for(WebElement filter:appliedFilters) {
			if(filter.getText().contains("Beginner"))
				check = true;
		}
		return check;
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
	*/
}
