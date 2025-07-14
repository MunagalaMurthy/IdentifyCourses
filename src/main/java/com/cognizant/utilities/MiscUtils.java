package com.cognizant.utilities;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class MiscUtils {
	
	public int getElementsCount(List<WebElement> elements_list) {
		return elements_list.size();
	}
	
	public boolean isItDisplayed(WebElement item) {
		return item.isDisplayed();
	}
	
	public boolean isItSelected(WebElement element) {
		return element.isSelected();
	}
	
	public void ClickOnElement(WebElement element) {
		element.click();
	}
	
	private int getNumberLength(String str) {
		int cnt=0;
		String num = str.substring( str.indexOf("(")+1, str.indexOf(")"));
		for(int i=0;i<num.length();i++) {
			if(num.charAt(i)>='0' && num.charAt(i)<='9') {
				cnt++;
			}
		}
		return cnt;
		
	}
	
	public boolean isCountAvailable(List<WebElement> ls) {
		int cnt=0;
		for(WebElement element: ls) {
			if(getNumberLength(element.getText())>0) cnt++;
		}
		if(cnt == ls.size()) return true;
		return false;
	}
	
	
	
	public List<String> getNameList(List<WebElement> elementNames) {
		List<String> elementNamesList = new ArrayList<>();
		for(WebElement ele:elementNames ) {
			elementNamesList.add(ele.getText());
		}
		
		return elementNamesList;
	}
}
