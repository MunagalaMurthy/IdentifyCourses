package com.cognizant.element_repository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognizant.base.Base_Page;
import com.cognizant.utilities.SelectUtils;

public class ForEnterprisePage extends Base_Page{
	//Locators & Variables
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
	@FindBy(xpath="//*[@id=\"mktoForm_2666\"]/div[54]/span/button") private WebElement submitBtn; 
	@FindBy(id="rentalField5") private WebElement descriptionElem;
	@FindBy(linkText = "For Enterprise") private WebElement forEnterpriseElem;
	@FindBy(id="Institution_Type__c") private WebElement institutionElem;
	@FindBy(id="C4C_Job_Title__c") private WebElement jobRoleElem;
	@FindBy(id="Department") private WebElement departmentElem;
	@FindBy(id="Company") private WebElement companyElem;
	@FindBy(id="Employee_Range__c") private WebElement companySizeElem;
	
	//Constructors
	public ForEnterprisePage(WebDriver driver) {
		super(driver);
	}
	
	public void fillFormForBusinessSales(String firstName,
										 String email,
										 String phoneNumber, 
										 String lastName,
										 String orgType,
										 String jobTitle,
										 String businessNeeds,
										 String noOfLearners,
										 String country,
										 String state) {
		 forEnterpriseElem.click();
		 firstNameElem.sendKeys(firstName);
		 lastNameElem.sendKeys(lastName);
		 emailElem.sendKeys(email);
		 phoneNumberElem.sendKeys(phoneNumber);
		 SelectUtils.selectFromVisibleText(orgTypeElem, orgType);
		 titleElem.sendKeys(jobTitle);
		 SelectUtils.selectFromVisibleText(needDiscribeElem, businessNeeds);
		 SelectUtils.selectFromVisibleText(noOfLearnersElem, noOfLearners);
		 SelectUtils.selectFromVisibleText(countryElem, country);
		 SelectUtils.selectFromVisibleText(stateElem, state);
		 submitBtn.click();
	}
	
	public void fillFormForBusinessOther(String firstName,
										 String lastName,
										 String email,
										 String phoneNumber, 
										 String orgType,
										 String jobTitle,
										 String businessNeeds,
										 String country,
										 String state,
										 String description) {
		forEnterpriseElem.click();
		firstNameElem.sendKeys(firstName);
		lastNameElem.sendKeys(lastName);
		emailElem.sendKeys(email);
		phoneNumberElem.sendKeys(phoneNumber);
		SelectUtils.selectFromVisibleText(orgTypeElem, orgType);
		titleElem.sendKeys(jobTitle);
		SelectUtils.selectFromVisibleText(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		descriptionElem.sendKeys(description);
		submitBtn.click();
	}
	
//	public void fillFormForBusinessIndividual(String firstName,
//											  String lastName,
//											  String email,
//											  String phoneNumber, 
//											  String orgType,
//											  String jobTitle,
//											  String businessNeeds,
//											  String country,
//											  String state) {
//	    forEnterpriseElem.click();
//		firstNameElem.sendKeys(firstName);
//		lastNameElem.sendKeys(lastName);
//		emailElem.sendKeys(email);
//		phoneNumberElem.sendKeys(phoneNumber);
//		SelectUtils.selectFromVisibleText(orgTypeElem, orgType);
//		titleElem.sendKeys(jobTitle);
//		SelectUtils.selectFromVisibleText(needDiscribeElem, businessNeeds);
//		SelectUtils.selectFromVisibleText(countryElem, country);
//		SelectUtils.selectFromVisibleText(stateElem, state);
//		submitBtn.click();
//	}
//	
//	public void fillFormForBusinessLearnerSupport(String firstName,
//												  String lastName,
//												  String email,
//												  String phoneNumber, 
//												  String orgType,
//												  String jobTitle,
//												  String businessNeeds,
//												  String country,
//												  String state) {

//	    forEnterpriseElem.click();
//		firstNameElem.sendKeys(firstName);
//		lastNameElem.sendKeys(lastName);
//		emailElem.sendKeys(email);
//		phoneNumberElem.sendKeys(phoneNumber);
//		SelectUtils.selectFromVisibleText(orgTypeElem, orgType);
//		titleElem.sendKeys(jobTitle);
//		SelectUtils.selectFromVisibleText(needDiscribeElem, businessNeeds);
//		SelectUtils.selectFromVisibleText(countryElem, country);
//		SelectUtils.selectFromVisibleText(stateElem, state);
//		submitBtn.click();
//	}
	
	public void fillFormForBusiness(String firstName,
									String lastName,
									String email,
									String phoneNumber, 
									String orgType,
									String jobTitle,
									String businessNeeds,
									String country,
									String state) {
		forEnterpriseElem.click();
		firstNameElem.sendKeys(firstName);
		lastNameElem.sendKeys(lastName);
		emailElem.sendKeys(email);
		phoneNumberElem.sendKeys(phoneNumber);
		SelectUtils.selectFromVisibleText(orgTypeElem, orgType);
		titleElem.sendKeys(jobTitle);
		SelectUtils.selectFromVisibleText(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
	}
	
	public void fillFormForGovernmentUpskilling(String firstName,
											    String lastName,
											    String email,
									 		    String phoneNumber, 
									            String orgType,
											    String jobTitle,
											    String company,
											    String companySize,
											    String businessNeeds,
											    String noOfLearners,
											    String country,
											    String state) {
		forEnterpriseElem.click();
		firstNameElem.sendKeys(firstName);
		lastNameElem.sendKeys(lastName);
		emailElem.sendKeys(email);
		phoneNumberElem.sendKeys(phoneNumber);
		SelectUtils.selectFromVisibleText(orgTypeElem, orgType);
		titleElem.sendKeys(jobTitle);
		companyElem.sendKeys(company);
		SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		SelectUtils.selectFromVisibleText(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(noOfLearnersElem, noOfLearners);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
	}
	
	public void fillFormForGovernmentLearner(String firstName,
											   String lastName,
											   String email,
											   String phoneNumber, 
											   String orgType,
											   String jobTitle,
											   String company,
											   String companySize,
											   String businessNeeds,
											   String country,
											   String state) {
		forEnterpriseElem.click(); 
		firstNameElem.sendKeys(firstName);
		lastNameElem.sendKeys(lastName);
		emailElem.sendKeys(email);
		phoneNumberElem.sendKeys(phoneNumber);
		SelectUtils.selectFromVisibleText(orgTypeElem, orgType);
		titleElem.sendKeys(jobTitle);
		companyElem.sendKeys(company);
		SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		SelectUtils.selectFromVisibleText(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
	}
	
	public void fillFormForGovernmentOthers(String firstName,
										    String lastName,
										    String email,
										    String phoneNumber, 
										    String orgType,
										    String jobTitle,
										    String company,
										    String companySize,
										    String businessNeeds,
										    String country,
										    String state,
										    String description) {
		forEnterpriseElem.click();  
		firstNameElem.sendKeys(firstName);
		lastNameElem.sendKeys(lastName);
		emailElem.sendKeys(email);
		phoneNumberElem.sendKeys(phoneNumber);
		SelectUtils.selectFromVisibleText(orgTypeElem, orgType);
		titleElem.sendKeys(jobTitle);
		companyElem.sendKeys(company);
		SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		SelectUtils.selectFromVisibleText(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		descriptionElem.sendKeys(description);
		submitBtn.click();
	}
	
	
	public void fillFormForCollegeSales(String firstName,
										String lastName,
										String email,
										String phoneNumber, 
										String orgType,
										String institutionType,
										String company,
										String companySize,
										String jobRole,
										String department,
										String businessNeeds,
										String noOfLearners,
										String country,
										String state) {
		forEnterpriseElem.click();
		firstNameElem.sendKeys(firstName);
		lastNameElem.sendKeys(lastName);
		emailElem.sendKeys(email);
		phoneNumberElem.sendKeys(phoneNumber);
		SelectUtils.selectFromVisibleText(orgTypeElem, orgType);
		SelectUtils.selectFromVisibleText(institutionElem,institutionType);
		companyElem.sendKeys(company);
		SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		SelectUtils.selectFromVisibleText(jobRoleElem, jobRole);
		SelectUtils.selectFromVisibleText(departmentElem, department);
		SelectUtils.selectFromVisibleText(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(noOfLearnersElem,	noOfLearners);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
	}
	
	public void fillFormForCollege(String firstName,
								   String lastName,
								   String email,
								   String phoneNumber, 
								   String orgType,
								   String institutionType,
								   String company,
								   String companySize,
								   String jobRole,
								   String department,
								   String businessNeeds,
								   String country,
								   String state,
								   String description) {
		forEnterpriseElem.click();
		firstNameElem.sendKeys(firstName);
		lastNameElem.sendKeys(lastName);
		emailElem.sendKeys(email);
		phoneNumberElem.sendKeys(phoneNumber);
		SelectUtils.selectFromVisibleText(orgTypeElem, orgType);
		SelectUtils.selectFromVisibleText(institutionElem,institutionType);
		companyElem.sendKeys(company);
		SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		SelectUtils.selectFromVisibleText(jobRoleElem, jobRole);
		SelectUtils.selectFromVisibleText(departmentElem, department);
		SelectUtils.selectFromVisibleText(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
	}
	
	public void fillFormForCollegeOthers(String firstName,
									     String lastName,
									     String email,
									     String phoneNumber, 
									     String orgType,
									     String institutionType,
									     String company,
									     String companySize,
									     String jobRole,
									     String department,
									     String businessNeeds,
									     String country,
									     String state,
									     String description) {
		forEnterpriseElem.click();
		firstNameElem.sendKeys(firstName);
		lastNameElem.sendKeys(lastName);
		emailElem.sendKeys(email);
		phoneNumberElem.sendKeys(phoneNumber);
		SelectUtils.selectFromVisibleText(orgTypeElem, orgType);
		SelectUtils.selectFromVisibleText(institutionElem,institutionType);
		companyElem.sendKeys(company);
		SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		SelectUtils.selectFromVisibleText(jobRoleElem, jobRole);
		SelectUtils.selectFromVisibleText(departmentElem, department);
		SelectUtils.selectFromVisibleText(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		descriptionElem.sendKeys(description);
		submitBtn.click();
	}
	
	public void fillFormForNonProfitSales(String firstName,
										  String email,
										  String phoneNumber, 
										  String lastName,
										  String orgType,
										  String jobTitle,
										  String company,
										  String companySize,
										  String businessNeeds,
										  String noOfLearners,
										  String country,
										  String state) {
		forEnterpriseElem.click();
		firstNameElem.sendKeys(firstName);
		lastNameElem.sendKeys(lastName);
		emailElem.sendKeys(email);
		phoneNumberElem.sendKeys(phoneNumber);
		SelectUtils.selectFromVisibleText(orgTypeElem, orgType);
		titleElem.sendKeys(jobTitle);
		companyElem.sendKeys(company);
		SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		SelectUtils.selectFromVisibleText(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(noOfLearnersElem, noOfLearners);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
	}
	
	public void fillFormForNonProfit (String firstName,
									  String email,
									  String phoneNumber, 
									  String lastName,
									  String orgType,
									  String jobTitle,
									  String company,
									  String companySize,
									  String businessNeeds,
									  String country,
									  String state) {
		forEnterpriseElem.click();
		firstNameElem.sendKeys(firstName);
		lastNameElem.sendKeys(lastName);
		emailElem.sendKeys(email);
		phoneNumberElem.sendKeys(phoneNumber);
		SelectUtils.selectFromVisibleText(orgTypeElem, orgType);
		titleElem.sendKeys(jobTitle);
		companyElem.sendKeys(company);
		SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		SelectUtils.selectFromVisibleText(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
	}
	
	public void fillFormForNonProfitOthers(String firstName,
										   String email,
										   String phoneNumber, 
										   String lastName,
										   String orgType,
										   String jobTitle,
										   String company,
										   String companySize,
										   String businessNeeds,
										   String country,
										   String state,
										   String description) {
		forEnterpriseElem.click();
		firstNameElem.sendKeys(firstName);
		lastNameElem.sendKeys(lastName);
		emailElem.sendKeys(email);
		phoneNumberElem.sendKeys(phoneNumber);
		SelectUtils.selectFromVisibleText(orgTypeElem, orgType);
		titleElem.sendKeys(jobTitle);
		companyElem.sendKeys(company);
		SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		SelectUtils.selectFromVisibleText(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		descriptionElem.sendKeys(description);
		submitBtn.click();
	}
	
}
