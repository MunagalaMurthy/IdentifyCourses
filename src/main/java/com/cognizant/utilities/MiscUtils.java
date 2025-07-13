package com.cognizant.utilities;

import org.openqa.selenium.WebElement;

public class MiscUtils {
	
	public void sendValues(WebElement element, String value) {
		element.sendKeys(value);
	}
}
