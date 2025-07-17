package com.cognizant.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Base_Page is the foundational class for all Page Object Model (POM) classes
 * in this Selenium automation framework. It provides a WebDriver instance
 * and initializes the PageFactory elements for web elements defined in subclasses.
 */
public class Base_Page {

	/**
	 * The WebDriver instance used to interact with the web browser.
	 * This WebDriver object will be inherited by all page object classes
	 * that extend Base_Page.
	 */
	protected WebDriver driver;

	/**
	 * Constructor for the Base_Page class.
	 * It takes a WebDriver instance as a parameter and initializes the
	 * PageFactory.
	 *
	 * @param driver The WebDriver instance to be used by the page objects.
	 */
	public Base_Page(WebDriver driver){
		// Assign the passed WebDriver instance to the 'driver' field of this class.
		this.driver = driver;
		
		// Initialize the web elements defined with @FindBy annotations
		// in this class and its subclasses. PageFactory.initElements
		// is crucial for automating the population of WebElement fields.
		PageFactory.initElements(this.driver, this);
	}
}