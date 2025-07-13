package com.cognizant.utilities;

import org.openqa.selenium.WebElement;

public class MiscUtils {
	
	public int getElementsCount(List<WebElement> elements_list) {
		return elements_list.size();
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
	
	public boolean isSectionDisplayed(WebElement Section) {
		return Section.isDisplayed();
	}
	
	public List<String> getNameList(List<WebElement> elementNames) {
		List<String> elementNamesList = new ArrayList<>();
		for(WebElement ele:elementNames ) {
			elementNamesList.add(ele.getText());
		}
		
		return elementNamesList;
	}
	
	public void sendValues(WebElement element, String value) {
		element.sendKeys(value);
	}
}
