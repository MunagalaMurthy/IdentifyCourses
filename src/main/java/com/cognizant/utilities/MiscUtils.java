package com.cognizant.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class MiscUtils {
	
	//Method For Getting The Count Of Elements In A List As String
	public String getElementsCount(List<WebElement> elements_list) {
		return elements_list.size()+"";
	}
	
	//Utility Method For Checking String contains digits
	private boolean getNumberLength(String str) {
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)>='0' && str.charAt(i)<='9') {	
				return true;
			}			
		}
		return false;
	}
	
	//Method For Verifying If All Elements In The List Contain Count
	public boolean isCountAvailable(List<WebElement> ls) {
		int cnt=0;
		for(WebElement element: ls) {
			if(getNumberLength(element.getText())) cnt++;
		}
		if(cnt == ls.size()) return true;
		return false;
	}
	
	//Method For Extracting Text From A List Of WebElements And Returning As A List Of Strings
	public List<String> getNameList(List<WebElement> elementNames) {
		List<String> elementNamesList = new ArrayList<>();
		for(WebElement ele:elementNames ) {
			elementNamesList.add(ele.getText());
		}
		
		return elementNamesList;
	}
	

	//Method For Sending Input Text To A WebElement
	public void sendValues(WebElement element, String value) {
		element.sendKeys(value);
	}
}