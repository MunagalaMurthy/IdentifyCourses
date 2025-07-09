package com.cognizant.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognizant.base.Base_Page;

public class HomePage extends Base_Page{
	
//	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="search-autocomplete-input")
	WebElement searchBox;
	
	@FindBy(xpath="//button[contains(@class,'search-button')]/div")
	WebElement searchButton;
	
	public void enterTextIntoSearchBox(String inputSearch) {
		searchBox.sendKeys(inputSearch);
	}
	
	public String searchTextCheck() {
		return searchBox.getAttribute("value");
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
}
