package com.cognizant.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Utility class to encapsulate common Selenium WebDriver Actions.
 * This class provides methods for performing complex user interactions
 * like mouse hovers, clicks, and scrolling using the Actions API.
 */
public class ActionUtils {

    // WebDriver instance to perform actions on.
    private WebDriver driver;

    // Actions object for performing complex user gestures.
    // It's initialized in the constructor to ensure the WebDriver is available.
    private Actions action;

    /**
     * Constructor for ActionUtils.
     * Initializes the WebDriver and the Actions object.
     * @param driver The WebDriver instance to be used for performing actions.
     */
    public ActionUtils(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver); // IMPORTANT: Initialize 'action' here after 'driver' is set.
    }

    /**
     * Performs a mouse hover action over a specified WebElement.
     * This moves the mouse cursor to the center of the target element.
     * @param target The WebElement to hover over.
     */
    public void mouseHoverToElement(WebElement target) {
        action.moveToElement(target).perform();
    }

    /**
     * Performs a mouse hover action over a specified WebElement and then clicks it.
     * This combines moving the mouse to the element and then performing a click.
     * @param target The WebElement to hover over and then click.
     */
    public void mouseHoverToElementAndClick(WebElement target) {
        action.moveToElement(target).click().perform();
    }

    /**
     * Scrolls the web page to bring the specified WebElement into the viewable area.
     * @param target The WebElement to scroll to.
     */
    public void scrollToElement(WebElement target) {
        action.scrollToElement(target).perform();
    }
    
    /**
     * Scrolls the web page to bring the specified WebElement into the viewable area and
     * clicks on the target element.
     */
    public void scrollToElementAndClick(WebElement section, WebElement target) {
    	action.scrollToElement(section).click(target).perform();
    }
}