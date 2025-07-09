package com.cognizant.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognizant.base.Base_Page;
import com.cognizant.utilities.SelectUtils;

public class ForEnterprisePage extends Base_Page{
	//Locators & Variables
	private SelectUtils select;
	@FindBy(id="FirstName") private WebElement firstNameElem;
	@FindBy(id="LastName") private WebElement lastNameElem;
	@FindBy(id="Email") private WebElement emailElem;
	@FindBy(id="Phone") private WebElement phoneNumberElem;
	@FindBy(id="rentalField9") private WebElement orgTypeElem;
	@FindBy(id="Title") private WebElement titleElem;
	@FindBy(id="What_the_lead_asked_for_on_the_website__c") private WebElement needDiscribeElem;
	@FindBy(id="Self_reported_employees_to_buy_for__c") private WebElement noOfLearnersElem;
	@FindBy(id="Country") private WebElement countryElem;
	@FindBy(id="State") private WebElement stateElem;
	
	//Constructors
	public ForEnterprisePage(WebDriver driver) {
		super(driver);
	}
	
	public void fillFormForBusinessSales(String firstName,
									String lastName,
									String email,
									String phoneNumber, 
									String orgType,
									String jobTitle,
									String businessNeeds,
									String noOfLearners,
									String country,
									String state) {
		 firstNameElem.sendKeys(firstName);
		 lastNameElem.sendKeys(lastName);
		 emailElem.sendKeys(email);
		 phoneNumberElem.sendKeys(phoneNumber);
		 titleElem.sendKeys(jobTitle);
	}
}
