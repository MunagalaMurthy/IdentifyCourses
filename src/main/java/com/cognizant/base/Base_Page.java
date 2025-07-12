package com.cognizant.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base_Page {
	protected WebDriver driver;

	//Inititalising the PageFactory class to use in all page object classes
	public Base_Page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
	}
}
