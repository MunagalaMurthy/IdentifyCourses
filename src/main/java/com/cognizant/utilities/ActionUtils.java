package com.cognizant.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtils {
	private WebDriver driver;
	public ActionUtils(WebDriver driver) {
		this.driver = driver;
	}
	Actions action = new Actions(driver);
	public void mouseHoverToElement(WebElement target) {
		action.moveToElement(target).perform();
	}
	
	public void mouseHoverToElementAndClick(WebElement target) {
		action.moveToElement(target).click().perform();
	}
	
	public void scrollToElement(WebElement target) {
		action.scrollToElement(target).perform();
	}
	
	
}
