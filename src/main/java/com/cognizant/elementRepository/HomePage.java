package com.cognizant.elementRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognizant.base.Base_Page;

public class HomePage extends Base_Page{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	
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
	

	//Method For Searching A Course Using Search Box click on search Button
	public void searchForCourse(String courseName) {
		//Enter Course Name In Search Box
        searchBox.sendKeys(courseName);
      //Click On Search Button To Initiate Search
        searchButton.click();
    }
	

	//Method For Selecting A Specific Suggestion From Auto-Suggest Dropdown
	public void selectSuggestionFromSearch(String inputText, String targetSuggestion) throws InterruptedException {
		

		//Create Actions Instance For Simulating User Input
        Actions actions = new Actions(driver);

        //Focus And Click On Search Box
        actions.moveToElement(searchBox).click().perform();

      //Simulate Typing Each Character With Delay
        for (char ch : inputText.toCharArray()) {
            actions.sendKeys(String.valueOf(ch)).perform();
            Thread.sleep(300); // Simulate typing delay
        }

      //Wait Until Suggestions Are Visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
            By.xpath("//span[contains(@class, 'item-name') and contains(@class, 'body-1-text') and contains(translate(text(), 'WEB', 'web'), 'web')]")
        ));
      //Iterate Through Suggestions And Click On Matching Suggestion
        for (WebElement elem : suggestions) {
            String suggestion = elem.getText();
            System.out.println("Suggestion: " + suggestion);
            if (suggestion.equalsIgnoreCase(targetSuggestion)) {
                elem.click();
                break;
            }
        }
    }	
}
