package com.cognizant.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtils {
	private WebElement dropDown;
	public SelectUtils(WebElement dropDown) {
		this.dropDown = dropDown;
	}
	
	Select select = new Select(dropDown);
	
	
	public void selectFromVisibleText(String searchTxt) {
		select.selectByVisibleText(searchTxt);
	}
	
	public void selectFromValue(String valueTxt) {
		select.selectByValue(valueTxt);
	}
	
	public void selectFromIndex(int index) {
		select.selectByIndex(index);
	}
}
