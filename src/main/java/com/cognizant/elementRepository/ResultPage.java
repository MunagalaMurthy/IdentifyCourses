package com.cognizant.elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognizant.base.Base_Page;
import com.cognizant.utilities.MiscUtils;

public class ResultPage extends Base_Page {

	@FindBy(xpath = "//div[@aria-label=\"Filters\"]")
	private WebElement filtersSection;

	@FindBy(xpath = "//div[contains(text(),\"Language\")]/../../../../../..")
	private WebElement languageSection;

	@FindBy(xpath = "//div[data-testid=\"search-filter-group-Level\"]")
	private WebElement levelSection;

	@FindBy(xpath = "//div[contains(@data-testid,\"productDifficultyLevel\")]")
	private List<WebElement> levelsList;

	@FindBy(xpath = "//button[@data-testid=\"expand-filter-items-button\" and @aria-label=\"Show more Language options\"]")
	private WebElement showMoreLink;

	@FindBy(xpath = "//div[contains(text(),\"Language\")]/../../../../../div[2]/div/div")
	private List<WebElement> languageList;

	@FindBy(xpath = "//button[@aria-label='Show less Language options']")
	private WebElement showLessLink;

	@FindBy(xpath = "//button[contains(normalize-space(),\"Beginner\")]")
	private WebElement beginnerTag;

	@FindBy(xpath = "//button[contains(normalize-space(),\"English\")]")
	private WebElement englishTag;

	// Locator For The English Filter
	@FindBy(xpath = "//div[contains(text(),\"Language\")]/../../../../../div[2]/div/div")
	private WebElement englishFilterCheckBox;

	@FindBy(xpath = "//div[@data-testid='language:English-true']")
	private WebElement englishFilterChecked;

	// Locator For The Checked Beginner Filter
	@FindBy(xpath = "//div[@data-testid=\"productDifficultyLevel:Beginner-true\"]")
	private WebElement beginnerFilterChecked;

	// Locator For The Unchecked Beginner Filter
	@FindBy(xpath = "//div[@data-testid=\"productDifficultyLevel:Beginner-false\"]")
	private WebElement beginnerFilterCheckBox;

	// Locator For Course Names
	@FindBy(className = "cds-CommonCard-title")
	private List<WebElement> courseCardTitles;

	// Locator For Course Ratings
	@FindBy(xpath = "//div[contains(@class,'RatingStat')]//descendant::span[1]")
	private List<WebElement> courseCardRatings;

	// Locator For Course Durations
	@FindBy(xpath = "//div[contains(@class,'metadata')]//descendant::p")
	private List<WebElement> courseCardDurations;

	MiscUtils mu = new MiscUtils();

	boolean isshowmorevisible = true;

	public ResultPage(WebDriver driver) {
		super(driver);
	}

	public String ShowMoreText() throws InterruptedException {
		if(isshowmorevisible==false) {
			mu.ClickOnElement(showLessLink);
			isshowmorevisible = true;
		}
		return showMoreLink.getText();
	}

	public void clickShowMoreLink() {
		System.out.println("bool status" + isshowmorevisible);
		if (isshowmorevisible) {
			mu.ClickOnElement(showMoreLink);
			isshowmorevisible = false;
		} else {
			mu.ClickOnElement(showLessLink);
			isshowmorevisible = true;
			clickShowMoreLink();
		}

	}

	public boolean isAccessible(String value) {
		value = value.toLowerCase();
		switch (value) {
		case "filter":
			return mu.isItDisplayed(filtersSection);
		case "level":
			return mu.isItDisplayed(levelSection);
		case "language":
			return mu.isItDisplayed(languageSection);
		case "showmore":
//
			System.out.println("inside isAccesible func - showmore");
			System.out.println("isDisplayed method " + mu.isItDisplayed(showMoreLink));
			return mu.isItDisplayed(showMoreLink);

		}
		return false;

	}

	public boolean isBeginnerChkd() {
		return mu.isItDisplayed(beginnerFilterChecked);
	}

	public boolean isEnglishChecked() {
		return mu.isItDisplayed(englishFilterChecked);
	}

	public boolean isBeginnerLevelFilterDisplayed() {
		return beginnerTag.isDisplayed();
	}

	// Method for checking the beginnerFilterClickable
	public boolean beginnerFilterDisplayStatus() {
		return beginnerFilterCheckBox.isDisplayed();
	}

	// Method for checking the beginnerFilterClickable
	public boolean englishFilterDisplayStatus() {
		return englishFilterCheckBox.isDisplayed();
	}

	public int getTotalNumberOfElementsInList(String value) {
		value = value.toLowerCase();
		switch (value) {
		case "level":
			return mu.getElementsCount(levelsList);
		case "language":
			clickShowMoreLink();
			return mu.getElementsCount(languageList);

		}
		return 0;
	}

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

	public List<String> getList(String value) {
		value = value.toLowerCase();
		switch (value) {
		case "level":
			return mu.getNameList(levelsList);
		case "language":
//			
			System.out.println("calling clickable method");
			clickShowMoreLink();
			return mu.getNameList(languageList);

		}
		return null;

	}

	public boolean beginnerFilterSelectStatus() {
		return beginnerFilterCheckBox.isSelected();
	}

	// Method for checking the beginnerFilterClickable
	public boolean englishFilterSelectStatus() {
		return englishFilterCheckBox.isSelected();
	}

	// Method for applying English filter
	public void applyEnglishFilter() {
		englishFilterCheckBox.click();
	}

	// Method for applying Beginner filter
	public void applyBeginnerFilter() {
		beginnerFilterCheckBox.click();
	}

	// Method for printing top 2 Courses Name, Rating and Duration
	public void printTopCourseDetails() {
		int count = Math.min(2,
				Math.min(courseCardTitles.size(), Math.min(courseCardRatings.size(), courseCardDurations.size())));

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
}
