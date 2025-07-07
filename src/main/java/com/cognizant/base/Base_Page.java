package com.cognizant.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base_Page {
	private WebDriver driver;

	public Base_Page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
	}
}
