package com.cognizant.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Utility class to encapsulate common Selenium WebDriver operations for dropdown (SELECT) elements.
 * This class provides methods to select options from a dropdown using visible text, value, or index.
 */
public class SelectUtils {

    // The WebElement representing the dropdown (HTML <select> tag).
    private WebElement dropDown;

    // The Selenium Select object, used to interact with the dropdown.
    // It's initialized in the constructor to ensure the WebElement is available.
    private Select select;

    /**
     * Constructor for SelectUtils.
     * Initializes the WebElement representing the dropdown.
     * @param dropDown The WebElement that is an HTML <select> tag.
     * It is crucial that this WebElement is indeed a dropdown element.
     */
    public SelectUtils(WebElement dropDown) {
        this.dropDown = dropDown;
        // IMPORTANT: Initialize the Select object here, AFTER the 'dropDown' WebElement is set.
        // If initialized outside the constructor as "Select select = new Select(dropDown);",
        // 'dropDown' might be null at that point, leading to a NullPointerException.
        this.select = new Select(this.dropDown);
    }
    
    /**
     * Selects an option from the dropdown by its visible text.
     * This method will select the option whose displayed text matches the given string.
     * @param searchTxt The visible text of the option to be selected.
     */
    public void selectFromVisibleText(String searchTxt) {
        select.selectByVisibleText(searchTxt);
    }
    
    /**
     * Selects an option from the dropdown by its 'value' attribute.
     * This method will select the option whose 'value' attribute matches the given string.
     * For example, for `<option value="apple">Apple Fruit</option>`, the value is "apple".
     * @param valueTxt The 'value' attribute of the option to be selected.
     */
    public void selectFromValue(String valueTxt) {
        select.selectByValue(valueTxt);
    }
    
    /**
     * Selects an option from the dropdown by its index.
     * The index is 0-based, meaning the first option has an index of 0, the second 1, and so on.
     * @param index The 0-based index of the option to be selected.
     */
    public void selectFromIndex(int index) {
        select.selectByIndex(index);
    }
}