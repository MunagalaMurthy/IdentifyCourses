package com.cognizant.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognizant.base.Base_Page;

public class HomePage extends Base_Page{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	
	//Locator to find the search box in the homepage
	@FindBy(id="search-autocomplete-input")
	public WebElement searchBox;
	
	//Locator to find the search button in the search bar
	@FindBy(xpath="//button[contains(@class,'search-button')]/div")
	WebElement searchButton;
	
	//Action methods
	
	//Method to pass the given input search key into the search box
	public void enterTextIntoSearchBox(String inputSearch) {
		searchBox.sendKeys(inputSearch);
	}
	
	//Method to check whether the search box contains the passed search key
	public String searchTextCheck() {
		return searchBox.getAttribute("value");
	}
	
	//Method to click the search button to trigger search
	public void clickSearchButton() {
		searchButton.click();
	}
	
}
