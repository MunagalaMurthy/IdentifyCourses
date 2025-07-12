package com.cognizant.utilities;

import org.openqa.selenium.WebElement;

public class MiscUtils {
	
	public void sendValues(WebElement e, String value) {
		e.clear();
		e.sendKeys(value);
	}
}
