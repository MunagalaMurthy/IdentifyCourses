package com.cognizant.elementRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognizant.base.Base_Page;
import com.cognizant.utilities.ExcelUtils;
import com.cognizant.utilities.MiscUtils;

public class ResultPage extends Base_Page{

	// Locator For The Entire Filters Section 
	@FindBy(xpath="//div[@aria-label=\"Filters\"]")
	private WebElement filtersSection;
	
	// Locator For The Language Filter Section
	@FindBy(xpath = "//div[@data-testid=\"search-filter-group-Language\"]")
	private WebElement languageSection;

	// Locator For The Level Filter Section
	@FindBy(xpath="//div[@data-testid=\"search-filter-group-Level\"]")
	private WebElement levelSection;

	// Locator For The List Of All Level Filter Options
	@FindBy(xpath="//div[contains(@data-testid,\"productDifficultyLevel\")]")
	private List<WebElement> levelsList;

	//Locator For The List Of All Language Filter Options
	@FindBy(xpath ="//div[contains(@data-testid,\"language\")]")
	private List<WebElement> languageList;	

	// Locator For The 'Show More' Button In Language Filter Section
	@FindBy(xpath="//button[@data-testid=\"expand-filter-items-button\" and @aria-label=\"Show more Language options\"]")
	private WebElement showMoreLink;

	// Locator For The 'Show Less' Button In Language Filter Section
	@FindBy(xpath = "//button[@aria-label='Show less Language options']")
	private WebElement showLessLink;

	// Locator For The English Filter Selector When Checked
	@FindBy(xpath = "//div[@data-testid='language:English-true']")
	private WebElement englishFilterChecked;

	//Locator For The Beginner Level Tag
	@FindBy(xpath="//button[contains(normalize-space(),\"Beginner\")]")
	private WebElement beginnerTag;
	
	// Locator For The English Language Tag
	@FindBy(xpath="//button[contains(normalize-space(),\"English\")]")
	private WebElement englishTag;
	
	// Locator For The English Filter Selector
	@FindBy(xpath = "//div[contains(@data-testid,'English') and contains(@data-testid,'language')]")
	private WebElement englishFilterCheckBox;
	
	// Locator For The Checked Begineer Filter
	@FindBy(xpath="//div[@data-testid=\"productDifficultyLevel:Beginner-true\"]")
	private WebElement beginnerFilterChecked;
	
	// Locator for The English filter selector
	@FindBy(xpath="//div[contains(@data-testid,'Beginner') and contains(@data-testid,'Level')]")
	private WebElement beginnerFilterCheckBox;
	
	// Locator for applied filters list
	@FindBy(xpath="//span[@class='cds-Chip-label']")
	public List<WebElement> appliedFilters;
	
	// Locator for Filters Chips
	@FindBy(className="cds-Chip-label")
	private List<WebElement> filtersApplied;
	
	// Locator for Course Cards
	@FindBy(className = "css-1whl2ol")
	private List<WebElement> courseCards;
	
	// Locator For Course Names
	@FindBy(className = "cds-CommonCard-title")
	private List<WebElement> courseCardTitles;
	
	// Locator For Course Ratings
	@FindBy(xpath = "//div[contains(@class,'RatingStat')]//descendant::span[1]")
	private List<WebElement> courseCardRatings;
	
	// Locator For Course Durations
	@FindBy(xpath = "//div[contains(@class,'metadata')]//descendant::p")
	private List<WebElement> courseCardDurations;
	
	// Locator for Clear All
	@FindBy(xpath="//span[normalize-space()='Clear all']")
	private WebElement clearAllFiltersButton;
	
	// Creating Utility Class Instance 
	MiscUtils mu = new MiscUtils();
	

	// Flag To Track Visibility State Of 'Show More' Link
	boolean isShowMoreVisible = true;
	
	// Constructor For Initializing WebDriver
	public ResultPage(WebDriver driver) {
		super(driver);
	}
	
	// Method To Get Text Of 'Show More' Button
	public String ShowMoreText() throws InterruptedException {
	  
		  // Ensures show More button is Visible First
			if(isShowMoreVisible==false) {
				
				showLessLink.click();
				isShowMoreVisible = true;
			}
			
			// Return Text Of 'Show More' Button
			return showMoreLink.getText();
		}
	 
	 // Check the Display status of Show More
	 public void clickShowMoreLink() {
			
			if (isShowMoreVisible) {
				// Click 'Show More'
				showMoreLink.click();
				isShowMoreVisible = false;
			} else {
				// Click 'Show Less'
				showLessLink.click();
				isShowMoreVisible = true;
				
				// Recursively Ensure 'Show More' Is Clicked
				clickShowMoreLink();
			}
	
		}
	 
	// Method To Check Visibility Of Specific  Sections
	public boolean isAccessible(String value) {
		value = value.toLowerCase();
		switch (value) {
		case "filter":
			return filtersSection.isDisplayed();
		case "level":
			return levelSection.isDisplayed();
		case "language":
			return languageSection.isDisplayed();
		case "showmore":
			return showMoreLink.isDisplayed();

		}
		return false;

	}

	// Method To Get Total Number Of Elements In the List
	  public String getTotalNumberOfElementsInList(String value) {
			value = value.toLowerCase();
			switch (value) {
			case "level":
				return mu.getElementsCount(levelsList);
			case "language":
				clickShowMoreLink();
				return mu.getElementsCount(languageList);
	
			}
			return "0";
		}
	  
	// Method To Check If Count Is Displayed For the List
	 public boolean isCountDisplayed(String value) {
			value = value.toLowerCase();
			switch (value) {
			case "level":
				return mu.isCountAvailable(levelsList);
			case "language":
				return mu.isCountAvailable(languageList);
			}
			return false;
		}
	
	//Method To Check If A Specific Filter Is Selected
	public boolean isChecked(String value) {
		value = value.toLowerCase();
		switch(value) {
		case "beginner":
			return beginnerFilterChecked.isDisplayed();
		case "english":
			return englishFilterChecked.isDisplayed();
		}
		return false;
	}
	

	//Method To Get the elements List
	public List<String> getList(String value) {
		value = value.toLowerCase();
		switch (value) {
		case "level":
			return mu.getNameList(levelsList);
		case "language":
			clickShowMoreLink();
			return mu.getNameList(languageList);

		}
		return null;

	}


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
		ExcelUtils excel = new ExcelUtils(System.getProperty("user.dir")+"/src/main/resources/Checkwords.xlsx");
		int count = excel.getRowCount("Sheet1");
		
		//Creating an array to store the checking key words
		String[] checkWords = new String[count-1];
		
		for(int i=1;i<count;i++)
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
		
		//Conditional checking if all the courses consist of atleast 75% of the truly relevant courses
		if(trueCount>=(0.6*courseCardTitles.size()))
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
			//checks if the filter's attribute ends with 'true'- meaning checkbox is selected
			if(englishFilterCheckBox.getAttribute("data-testid").endsWith("true"))
				returnValue = true;
			break;
		case "Beginner":
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
	
	//Method for Clearing Filters
	public void clearAllAppliedFilters() {
		clearAllFiltersButton.click();
	}
	
	//Method for printing top 2 Courses Name, Rating and Duration
	public void printTopCourseDetails() {
		int count = Math.min(2, Math.min(courseCardTitles.size(),
				Math.min(courseCardRatings.size(), courseCardDurations.size())));

		for (int i = 0; i < count; i++) {
			
			//Get Course Title
			String title = courseCardTitles.get(i).getText().trim();
			//Get Course Rating
			String rating = courseCardRatings.get(i).getText().trim();
			//Get Course Metadata
			String metadata = courseCardDurations.get(i).getText();
			String[] parts = metadata.split("·");
			//Extract Duration
			String duration = parts.length > 2 ? parts[2].trim() : "N/A";

			System.out.println("Course " + (i + 1) + ":");
			System.out.println("  Title   : " + title);
			System.out.println("  Rating  : " + rating);
			System.out.println("  Duration: " + duration);
			System.out.println("-----------------------------------");
		}
	}
	
	//Method For Checking If A Specific Filter Is Applied
	public boolean isFilterApplied(String filterName) {
		for (WebElement filter : filtersApplied) {
			if (filter.getText().trim().equalsIgnoreCase(filterName)) {
				return true;
			}
		}
		return false;
	}
	

	//Method For Printing All Applied Filters
	public void printAppliedFilters() {
		for(WebElement filter:filtersApplied) {
			
			//Print Each Applied Filter
			System.out.println(filter.getText());
		}
	}


	//Method For Getting List Of Applied Filters
	public ArrayList<String> getAppliedFilters() {
		ArrayList<String> filtersAppliedOnResults=new ArrayList<String>();
		for(WebElement filter:filtersApplied) {
			String fil=filter.getText();
			filtersAppliedOnResults.add(fil);
		}
		return filtersAppliedOnResults;
	}


	//Method For Checking If Course Title, Rating, and Duration Are Present
	public boolean areCourseFieldsPresent() {
		if (courseCardTitles.isEmpty() || courseCardRatings.isEmpty() || courseCardDurations.isEmpty()) {
			return false;
		}
		//Get First Course Title
		String title = courseCardTitles.get(0).getText().trim();
		//Get First Course Rating
		String rating = courseCardRatings.get(0).getText().trim();
		//Get First Course Metadata
		String metadata = courseCardDurations.get(0).getText();
		
		String[] parts = metadata.split("·");
		//Extract Duration
		String duration = parts.length > 2 ? parts[2].trim() : "";
		//Check If All Fields Are Non-Empty
		return !title.isEmpty() && !rating.isEmpty() && !duration.isEmpty();
	}
	

	//Method For Extracting Rating Values Of Top 2 Courses
	public ArrayList<Float> ratingValuesCheck(){
		ArrayList<Float> ratings=new ArrayList<Float>();
		int i=1;
		for(WebElement elem:courseCardRatings) {
			if(i>2)
				break;
			//Get Rating Text
			String data=elem.getText();
			Float rating=Float.parseFloat(data);
			//Add To List
			ratings.add(rating);
			i++;
		}
		return ratings;

	}
	

	//Method For Printing Titles Of Top 10 Search Results
	public void printSearchResults() {
		int i=1;
		for(WebElement elem:courseCardTitles) {
			if(i>10)
				break;
			//Print Course Title
			System.out.println(elem.getText());
			i++;
		}

	}
}
