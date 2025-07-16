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
	
	private boolean getNumberLength(String str) {
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)>='0' && str.charAt(i)<='9') {			
				
				return true;
			}			
			
		}
		return false;
		
	}
	
	public boolean isCountAvailable(List<WebElement> ls) {
		int cnt=0;
		
		for(WebElement element: ls) {
			if(getNumberLength(element.getText())) cnt++;
		}
		System.out.println("siz"+ls.size());
		System.out.println("count"+cnt);
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
