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
	
//	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="search-autocomplete-input")
	public WebElement searchBox;
	
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
	
	public void searchForCourse(String courseName) {
        searchBox.sendKeys(courseName);
        searchButton.click();
    }
	
	public void selectSuggestionFromSearch(String inputText, String targetSuggestion) throws InterruptedException {
        Actions actions = new Actions(driver);

        actions.moveToElement(searchBox).click().perform();

        for (char ch : inputText.toCharArray()) {
            actions.sendKeys(String.valueOf(ch)).perform();
            Thread.sleep(300); // Simulate typing delay
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
            By.xpath("//span[contains(@class, 'item-name') and contains(@class, 'body-1-text') and contains(translate(text(), 'WEB', 'web'), 'web')]")
        ));

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
