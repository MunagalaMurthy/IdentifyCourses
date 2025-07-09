package com.cognizant.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Utility class to encapsulate common Selenium WebDriver operations for dropdown (SELECT) elements.
 * This class provides methods to select options from a dropdown using visible text, value, or index.
 */
public class SelectUtils {

    // The WebElement representing the dropdown (HTML <select> tag).

    // The Selenium Select object, used to interact with the dropdown.
    // It's initialized in the constructor to ensure the WebElement is available.
    private static Select select;
    
    /**
     * Selects an option from the dropdown by its visible text.
     * This method will select the option whose displayed text matches the given string.
     * @param searchTxt The visible text of the option to be selected.
     */
    public static void selectFromVisibleText(WebElement elem,String searchTxt) {
    	select = new Select(elem);
        select.selectByVisibleText(searchTxt);
    }
    
    /**
     * Selects an option from the dropdown by its 'value' attribute.
     * This method will select the option whose 'value' attribute matches the given string.
     * For example, for `<option value="apple">Apple Fruit</option>`, the value is "apple".
     * @param valueTxt The 'value' attribute of the option to be selected.
     */
    public static void selectFromValue(WebElement elem,String valueTxt) {
    	select = new Select(elem);
        select.selectByValue(valueTxt);
    }
    
    /**
     * Selects an option from the dropdown by its index.
     * The index is 0-based, meaning the first option has an index of 0, the second 1, and so on.
     * @param index The 0-based index of the option to be selected.
     */
    public static void selectFromIndex(WebElement elem,int index) {
    	select = new Select(elem);
        select.selectByIndex(index);
    }
}