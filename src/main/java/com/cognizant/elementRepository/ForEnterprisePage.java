package com.cognizant.elementRepository;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.cognizant.base.Base_Page;
<<<<<<< HEAD
import com.cognizant.utilities.MiscUtils;
import com.cognizant.utilities.SelectUtils;

// This class represents the "For Enterprise" page and contains methods to interact with its elements.
public class ForEnterprisePage extends Base_Page {
=======
//import com.cognizant.utilities.ActionUtils;
import com.cognizant.utilities.MiscUtils;
import com.cognizant.utilities.SelectUtils;

public class ForEnterprisePage extends Base_Page{
	//Locators & Variables
//	ActionUtils action = new ActionUtils(driver);
	FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
	@FindBy(id="FirstName") private WebElement firstNameElem;
	@FindBy(id="LastName") private WebElement lastNameElem;
	@FindBy(id="Email") private WebElement emailElem;
	@FindBy(id="Phone") private WebElement phoneNumberElem;
	@FindBy(id="rentalField9") private WebElement orgTypeElem;
	@FindBy(id="Title") private WebElement titleElem;
	@FindBy(xpath="//*[@id=\"What_the_lead_asked_for_on_the_website__c\"]") private WebElement needDiscribeElem;
	@FindBy(id="Self_reported_employees_to_buy_for__c") private WebElement noOfLearnersElem;
	@FindBy(id="Country") private WebElement countryElem;
	@FindBy(id="State") private WebElement stateElem;
	@FindBy(xpath="//*[@id=\"mktoForm_2666\"]/div[54]/span/button") private WebElement submitBtn; 
	@FindBy(id="rentalField5") private WebElement descriptionElem;
	@FindBy(linkText="For Enterprise") private WebElement forEnterpriseElem;
	@FindBy(id="Institution_Type__c") private WebElement institutionElem;
	@FindBy(id="C4C_Job_Title__c") private WebElement jobRoleElem;
	@FindBy(id="Department") private WebElement departmentElem;
	@FindBy(id="Company") private WebElement companyElem;
	@FindBy(id="Employee_Range__c") private WebElement companySizeElem;
	@FindBy(id="ValidMsgEmail") private WebElement emailErrorElem;
	@FindBy(id="ValidMsgPhone") private WebElement phoneErrorElem;
>>>>>>> 75b26091b13454dcfcded71f351ad8b18dbef805

	// FluentWait instance for explicit waits with custom polling and ignoring exceptions.
	// Initialized here, but its 'driver' dependency will be set via the constructor.
	FluentWait<WebDriver> wait;

	// Locators for various web elements on the "For Enterprise" form.
	@FindBy(id = "FirstName")
	private WebElement firstNameElem;
	@FindBy(id = "LastName")
	private WebElement lastNameElem;
	@FindBy(id = "Email")
	private WebElement emailElem;
	@FindBy(id = "Phone")
	private WebElement phoneNumberElem;
	@FindBy(id = "rentalField9")
	private WebElement orgTypeElem;
	@FindBy(id = "Title")
	private WebElement titleElem;
	@FindBy(xpath = "//*[@id=\"What_the_lead_asked_for_on_the_website__c\"]")
	private WebElement needDiscribeElem; // Renamed from needDescribeElem for consistency
	@FindBy(id = "Self_reported_employees_to_buy_for__c")
	private WebElement noOfLearnersElem;
	@FindBy(id = "Country")
	private WebElement countryElem;
	@FindBy(id = "State")
	private WebElement stateElem;
	@FindBy(xpath = "//*[@id=\"mktoForm_2666\"]/div[54]/span/button")
	private WebElement submitBtn;
	@FindBy(id = "rentalField5")
	private WebElement descriptionElem;
	@FindBy(linkText = "For Enterprise")
	private WebElement forEnterpriseElem;
	@FindBy(id = "Institution_Type__c")
	private WebElement institutionElem;
	@FindBy(id = "C4C_Job_Title__c")
	private WebElement jobRoleElem;
	@FindBy(id = "Department")
	private WebElement departmentElem;
	@FindBy(id = "Company")
	private WebElement companyElem;
	@FindBy(id = "Employee_Range__c")
	private WebElement companySizeElem;
	@FindBy(id = "ValidMsgEmail")
	private WebElement emailErrorElem;
	@FindBy(id = "ValidMsgPhone")
	private WebElement phoneErrorElem;

	// Instance of MiscUtils for common utility methods.
	MiscUtils mu = new MiscUtils();

	/**
	 * Constructor for ForEnterprisePage.
	 * Initializes the WebDriver and the FluentWait instance.
	 * @param driver The WebDriver instance to be used for interacting with the web page.
	 */
	public ForEnterprisePage(WebDriver driver) {
		super(driver);
		// Initialize FluentWait here, after 'driver' is available from the super constructor.
		wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
	}

	/**
	 * Checks if the email error message is displayed and returns its text.
	 * @return The text of the email error message if displayed, otherwise null.
	 */
	public String errorEmailChecker() {
		try {
			if (emailErrorElem.isDisplayed())
				return emailErrorElem.getText();
			return null;
		} catch (Exception e) {
			// Catching generic Exception for robustness if element is not found or other issues.
			return null;
		}
	}

	/**
	 * Checks if the phone number error message is displayed and returns its text.
	 * @return The text of the phone number error message if displayed, otherwise null.
	 */
	public String errorPhoneChecker() {
		try {
			if (phoneErrorElem.isDisplayed())
				return phoneErrorElem.getText();
			return null;
		} catch (Exception e) {
			// Catching generic Exception for robustness.
			return null;
		}
	}

	/**
	 * Checks for any displayed error messages (email or phone) and returns the first one found.
	 * @return The text of the error message if found, otherwise null.
	 */
	public String errorChecker() {
		String error = errorEmailChecker();
		if (error != null)
			return error;
		error = errorPhoneChecker();
		if (error != null)
			return error;
		return null;
	}

	/**
	 * Fills in the mandatory information for any "For Enterprise" form.
	 * Scrolls to the element, clicks "For Enterprise", clears and sends values to fields.
	 * @param firstName The first name.
	 * @param lastName The last name.
	 * @param email The email address.
	 * @param phoneNumber The phone number.
	 * @param orgType The organization type.
	 */
	public void mandatoryInfo(String firstName, String lastName, String email, String phoneNumber, String orgType) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
<<<<<<< HEAD
		js.executeScript("window.scrollTo(0,9350)"); // Scrolls to a specific pixel height.
		forEnterpriseElem.click(); // Clicks on the "For Enterprise" link/element.
		// Clear and send values to mandatory fields.
=======
		js.executeScript("window.scrollTo(0,9350)");
		forEnterpriseElem.click();
//		action.mouseHoverToElement(firstNameElem);
>>>>>>> 75b26091b13454dcfcded71f351ad8b18dbef805
		firstNameElem.clear();
		mu.sendValues(firstNameElem, firstName);
		lastNameElem.clear();
		mu.sendValues(lastNameElem, lastName);
		emailElem.clear();
		mu.sendValues(emailElem, email);
		phoneNumberElem.clear();
		mu.sendValues(phoneNumberElem, phoneNumber);
		SelectUtils.selectFromVisibleText(orgTypeElem, orgType);
	}

	/**
	 * Fills and submits the form for Business Sales.
	 * @param firstName The first name.
	 * @param lastName The last name.
	 * @param email The email address.
	 * @param phoneNumber The phone number.
	 * @param orgType The organization type.
	 * @param jobTitle The job title.
	 * @param company The company name.
	 * @param companySize The company size.
	 * @param businessNeeds Description of business needs.
	 * @param noOfLearners The number of learners.
	 * @param country The country.
	 * @param state The state.
	 * @return The title of the page after submission, or an error message if validation fails.
	 */
	public String fillFormForBusinessSales(String firstName, String lastName, String email, String phoneNumber,
			String orgType, String jobTitle, String company, String companySize, String businessNeeds,
			String noOfLearners, String country, String state) {
		mandatoryInfo(firstName, lastName, email, phoneNumber, orgType);
		mu.sendValues(titleElem, jobTitle);
		try {
			// These fields might not always be present or enabled depending on orgType, hence the try-catch.
			mu.sendValues(companyElem, company);
			SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		} catch (Exception e) {
			// Log the exception if needed, but for now, it just suppresses it.
		}
		mu.sendValues(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(noOfLearnersElem, noOfLearners);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
		String error = errorChecker();
		if (error != null)
			return error;
		wait.until(ExpectedConditions.titleContains("Thank")); // Waits until the page title contains "Thank".
		return driver.getTitle();
	}

	/**
	 * Fills and submits the form for College Others.
	 * @param firstName The first name.
	 * @param lastName The last name.
	 * @param email The email address.
	 * @param phoneNumber The phone number.
	 * @param orgType The organization type.
	 * @param instituteType The institution type.
	 * @param jobTitle The job title.
	 * @param businessNeeds Description of business needs.
	 * @param country The country.
	 * @param state The state.
	 * @param description Additional description.
	 * @return The title of the page after submission, or an error message if validation fails.
	 */
	public String fillFormForCollegeOthers(String firstName, String lastName, String email, String phoneNumber,
			String orgType, String instituteType, String jobTitle, String businessNeeds, String country, String state,
			String description) {
		mandatoryInfo(firstName, lastName, email, phoneNumber, orgType);
		mu.sendValues(titleElem, jobTitle);
		mu.sendValues(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		mu.sendValues(descriptionElem, description);
		submitBtn.click();
		String error = errorChecker();
		if (error != null)
			return error;
		wait.until(ExpectedConditions.titleContains("Thank"));
		return driver.getTitle();
	}

	/**
	 * Fills and submits the generic Business form.
	 * @param firstName The first name.
	 * @param lastName The last name.
	 * @param email The email address.
	 * @param phoneNumber The phone number.
	 * @param orgType The organization type.
	 * @param jobTitle The job title.
	 * @param company The company name.
	 * @param companySize The company size.
	 * @param businessNeeds Description of business needs.
	 * @param country The country.
	 * @param state The state.
	 * @return The title of the page after submission, or an error message if validation fails.
	 */
	public String fillFormForBusiness(String firstName, String lastName, String email, String phoneNumber,
			String orgType, String jobTitle, String company, String companySize, String businessNeeds, String country,
			String state) {
		mandatoryInfo(firstName, lastName, email, phoneNumber, orgType);
		mu.sendValues(titleElem, jobTitle);
		try {
			mu.sendValues(companyElem, company);
			SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		} catch (Exception e) {
			// Suppress exception if company fields are not applicable.
		}
		mu.sendValues(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
		String error = errorChecker();
		if (error != null)
			return error;
		wait.until(ExpectedConditions.titleContains("Thank"));
		return driver.getTitle();
	}

	/**
	 * Fills and submits the form for Government Upskilling.
	 * @param firstName The first name.
	 * @param lastName The last name.
	 * @param email The email address.
	 * @param phoneNumber The phone number.
	 * @param orgType The organization type.
	 * @param jobTitle The job title.
	 * @param company The company name.
	 * @param companySize The company size.
	 * @param businessNeeds Description of business needs.
	 * @param noOfLearners The number of learners.
	 * @param country The country.
	 * @param state The state.
	 * @return The title of the page after submission, or an error message if validation fails.
	 */
	public String fillFormForGovernmentUpskilling(String firstName, String lastName, String email, String phoneNumber,
			String orgType, String jobTitle, String company, String companySize, String businessNeeds,
			String noOfLearners, String country, String state) {
		mandatoryInfo(firstName, lastName, email, phoneNumber, orgType);
		mu.sendValues(titleElem, jobTitle);
		mu.sendValues(companyElem, company);
		SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		mu.sendValues(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(noOfLearnersElem, noOfLearners);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
		String error = errorChecker();
		if (error != null)
			return error;
		wait.until(ExpectedConditions.titleContains("Thank"));
		return driver.getTitle();
	}

	/**
	 * Fills and submits the form for Government Learner.
	 * @param firstName The first name.
	 * @param lastName The last name.
	 * @param email The email address.
	 * @param phoneNumber The phone number.
	 * @param orgType The organization type.
	 * @param jobTitle The job title.
	 * @param company The company name.
	 * @param companySize The company size.
	 * @param businessNeeds Description of business needs.
	 * @param country The country.
	 * @param state The state.
	 * @return The title of the page after submission, or an error message if validation fails.
	 */
	public String fillFormForGovernmentLearner(String firstName, String lastName, String email, String phoneNumber,
			String orgType, String jobTitle, String company, String companySize, String businessNeeds, String country,
			String state) {
		mandatoryInfo(firstName, lastName, email, phoneNumber, orgType);
		mu.sendValues(titleElem, jobTitle);
		mu.sendValues(companyElem, company);
		SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		mu.sendValues(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
		String error = errorChecker();
		if (error != null)
			return error;
		wait.until(ExpectedConditions.titleContains("Thank"));
		return driver.getTitle();
	}

	/**
	 * Fills and submits the form for Government Others.
	 * @param firstName The first name.
	 * @param lastName The last name.
	 * @param email The email address.
	 * @param phoneNumber The phone number.
	 * @param orgType The organization type.
	 * @param jobTitle The job title.
	 * @param company The company name.
	 * @param companySize The company size.
	 * @param businessNeeds Description of business needs.
	 * @param country The country.
	 * @param state The state.
	 * @param description Additional description.
	 * @return The title of the page after submission, or an error message if validation fails.
	 */
	public String fillFormForGovernmentOthers(String firstName, String lastName, String email, String phoneNumber,
			String orgType, String jobTitle, String company, String companySize, String businessNeeds, String country,
			String state, String description) {
		mandatoryInfo(firstName, lastName, email, phoneNumber, orgType);
		mu.sendValues(titleElem, jobTitle);
		mu.sendValues(companyElem, company);
		SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		mu.sendValues(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		mu.sendValues(descriptionElem, description);
		submitBtn.click();
		String error = errorChecker();
		if (error != null)
			return error;
		wait.until(ExpectedConditions.titleContains("Thank"));
		return driver.getTitle();
	}

	/**
	 * Fills and submits the form for College Sales.
	 * @param firstName The first name.
	 * @param lastName The last name.
	 * @param email The email address.
	 * @param phoneNumber The phone number.
	 * @param orgType The organization type.
	 * @param institutionType The institution type.
	 * @param company The company name.
	 * @param companySize The company size.
	 * @param jobRole The job role.
	 * @param department The department.
	 * @param businessNeeds Description of business needs.
	 * @param noOfLearners The number of learners.
	 * @param country The country.
	 * @param state The state.
	 * @return The title of the page after submission, or an error message if validation fails.
	 */
	public String fillFormForCollegeSales(String firstName, String lastName, String email, String phoneNumber,
			String orgType, String institutionType, String company, String companySize, String jobRole,
			String department, String businessNeeds, String noOfLearners, String country, String state) {
		mandatoryInfo(firstName, lastName, email, phoneNumber, orgType);
		SelectUtils.selectFromVisibleText(institutionElem, institutionType);
		mu.sendValues(companyElem, company);
		SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		SelectUtils.selectFromVisibleText(jobRoleElem, jobRole);
		SelectUtils.selectFromVisibleText(departmentElem, department);
		mu.sendValues(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(noOfLearnersElem, noOfLearners);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
		String error = errorChecker();
		if (error != null)
			return error;
		wait.until(ExpectedConditions.titleContains("Thank"));
		return driver.getTitle();
	}

	/**
	 * Overloaded method to fill and submit a College form (simpler version without company/company size).
	 * @param firstName The first name.
	 * @param lastName The last name.
	 * @param email The email address.
	 * @param phoneNumber The phone number.
	 * @param orgType The organization type.
	 * @param institutionType The institution type.
	 * @param jobRole The job role.
	 * @param department The department.
	 * @param businessNeeds Description of business needs.
	 * @param country The country.
	 * @param state The state.
	 * @return The title of the page after submission, or an error message if validation fails.
	 */
	public String fillFormForCollege(String firstName, String lastName, String email, String phoneNumber,
			String orgType, String institutionType, String jobRole, String department, String businessNeeds,
			String country, String state) {
		mandatoryInfo(firstName, lastName, email, phoneNumber, orgType);
		SelectUtils.selectFromVisibleText(institutionElem, institutionType);
		SelectUtils.selectFromVisibleText(jobRoleElem, jobRole);
		SelectUtils.selectFromVisibleText(departmentElem, department);
		mu.sendValues(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
		String error = errorChecker();
		if (error != null)
			return error;
		wait.until(ExpectedConditions.titleContains("Thank"));
		return driver.getTitle();
	}

	/**
	 * Overloaded method to fill and submit a College form (even simpler, without department).
	 * @param firstName The first name.
	 * @param lastName The last name.
	 * @param email The email address.
	 * @param phoneNumber The phone number.
	 * @param orgType The organization type.
	 * @param institutionType The institution type.
	 * @param jobRole The job role.
	 * @param businessNeeds Description of business needs.
	 * @param country The country.
	 * @param state The state.
	 * @return The title of the page after submission, or an error message if validation fails.
	 */
	public String fillFormForCollege(String firstName, String lastName, String email, String phoneNumber,
			String orgType, String institutionType, String jobRole, String businessNeeds, String country,
			String state) {
		mandatoryInfo(firstName, lastName, email, phoneNumber, orgType);
		SelectUtils.selectFromVisibleText(institutionElem, institutionType);
		SelectUtils.selectFromVisibleText(jobRoleElem, jobRole);
		mu.sendValues(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
		String error = errorChecker();
		if (error != null)
			return error;
		wait.until(ExpectedConditions.titleContains("Thank"));
		return driver.getTitle();
	}

	/**
	 * Overloaded method to fill and submit a College form (including company and company size).
	 * @param firstName The first name.
	 * @param lastName The last name.
	 * @param email The email address.
	 * @param phoneNumber The phone number.
	 * @param orgType The organization type.
	 * @param institutionType The institution type.
	 * @param jobRole The job role.
	 * @param department The department.
	 * @param company The company name.
	 * @param companySize The company size.
	 * @param businessNeeds Description of business needs.
	 * @param country The country.
	 * @param state The state.
	 * @return The title of the page after submission, or an error message if validation fails.
	 */
	public String fillFormForCollege(String firstName, String lastName, String email, String phoneNumber,
			String orgType, String institutionType, String jobRole, String department, String company,
			String companySize, String businessNeeds, String country, String state) {
		mandatoryInfo(firstName, lastName, email, phoneNumber, orgType);
		try {
			// Clear and send values if company fields are present and enabled.
			companyElem.clear();
			mu.sendValues(companyElem, company);
			SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		} catch (Exception e) {
			// Suppress exception.
		}
		SelectUtils.selectFromVisibleText(institutionElem, institutionType);
		SelectUtils.selectFromVisibleText(jobRoleElem, jobRole);
		SelectUtils.selectFromVisibleText(departmentElem, department);
		mu.sendValues(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
		String error = errorChecker();
		if (error != null)
			return error;
		wait.until(ExpectedConditions.titleContains("Thank"));
		return driver.getTitle();
	}
	
	/**
	 * Overloaded method to fill and submit a College form (including company and company size, without department).
	 * @param firstName The first name.
	 * @param lastName The last name.
	 * @param email The email address.
	 * @param phoneNumber The phone number.
	 * @param orgType The organization type.
	 * @param institutionType The institution type.
	 * @param jobRole The job role.
	 * @param company The company name.
	 * @param companySize The company size.
	 * @param businessNeeds Description of business needs.
	 * @param country The country.
	 * @param state The state.
	 * @return The title of the page after submission, or an error message if validation fails.
	 */
	public String fillFormForCollege(String firstName, String lastName, String email, String phoneNumber,
			String orgType, String institutionType, String jobRole, String company, String companySize,
			String businessNeeds, String country, String state) {
		mandatoryInfo(firstName, lastName, email, phoneNumber, orgType);
		try {
			mu.sendValues(companyElem, company);
			SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		} catch (Exception e) {
			// Suppress exception.
		}
		SelectUtils.selectFromVisibleText(institutionElem, institutionType);
		SelectUtils.selectFromVisibleText(jobRoleElem, jobRole);
		mu.sendValues(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
		String error = errorChecker();
		if (error != null)
			return error;
		wait.until(ExpectedConditions.titleContains("Thank"));
		return driver.getTitle();
	}


	/**
	 * Overloaded method to fill and submit the Business Others form (simpler, without company/company size).
	 * @param firstName The first name.
	 * @param lastName The last name.
	 * @param email The email address.
	 * @param phoneNumber The phone number.
	 * @param orgType The organization type.
	 * @param jobTitle The job title.
	 * @param businessNeeds Description of business needs.
	 * @param country The country.
	 * @param state The state.
	 * @param description Additional description.
	 * @return The title of the page after submission, or an error message if validation fails.
	 */
	public String fillFormForBusinessOthers(String firstName, String lastName, String email, String phoneNumber,
			String orgType, String jobTitle, String businessNeeds, String country, String state, String description) {
		mandatoryInfo(firstName, lastName, email, phoneNumber, orgType);
		mu.sendValues(titleElem, jobTitle);
		mu.sendValues(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		mu.sendValues(descriptionElem, description);
		submitBtn.click();
		String error = errorChecker();
		if (error != null)
			return error;
		wait.until(ExpectedConditions.titleContains("Thank"));
		return driver.getTitle();
	}

	/**
	 * Overloaded method to fill and submit the Business Others form (with company/company size).
	 * @param firstName The first name.
	 * @param lastName The last name.
	 * @param email The email address.
	 * @param phoneNumber The phone number.
	 * @param orgType The organization type.
	 * @param jobTitle The job title.
	 * @param company The company name.
	 * @param companySize The company size.
	 * @param businessNeeds Description of business needs.
	 * @param country The country.
	 * @param state The state.
	 * @param description Additional description.
	 * @return The title of the page after submission, or an error message if validation fails.
	 */
	public String fillFormForBusinessOthers(String firstName, String lastName, String email, String phoneNumber,
			String orgType, String jobTitle, String company, String companySize, String businessNeeds, String country,
			String state, String description) {
		mandatoryInfo(firstName, lastName, email, phoneNumber, orgType);
		mu.sendValues(titleElem, jobTitle);
		try {
			mu.sendValues(companyElem, company);
			SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		} catch (Exception e) {
			// Suppress exception.
		}
		mu.sendValues(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		mu.sendValues(descriptionElem, description);
		submitBtn.click();
		String error = errorChecker();
		if (error != null)
			return error;
		wait.until(ExpectedConditions.titleContains("Thank"));
		return driver.getTitle();
	}

	/**
	 * Fills and submits the form for Non-Profit Sales.
	 * @param firstName The first name.
	 * @param lastName The last name.
	 * @param email The email address.
	 * @param phoneNumber The phone number.
	 * @param orgType The organization type.
	 * @param jobTitle The job title.
	 * @param company The company name.
	 * @param companySize The company size.
	 * @param businessNeeds Description of business needs.
	 * @param noOfLearners The number of learners.
	 * @param country The country.
	 * @param state The state.
	 * @return The title of the page after submission, or an error message if validation fails.
	 */
	public String fillFormForNonProfitSales(String firstName, String lastName, String email, String phoneNumber,
			String orgType, String jobTitle, String company, String companySize, String businessNeeds,
			String noOfLearners, String country, String state) {
		mandatoryInfo(firstName, lastName, email, phoneNumber, orgType);
		mu.sendValues(titleElem, jobTitle);
		mu.sendValues(companyElem, company);
		SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		mu.sendValues(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(noOfLearnersElem, noOfLearners);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
		String error = errorChecker();
		if (error != null)
			return error;
		wait.until(ExpectedConditions.titleContains("Thank"));
		return driver.getTitle();
	}

	/**
	 * Fills and submits the generic Non-Profit form.
	 * @param firstName The first name.
	 * @param lastName The last name.
	 * @param email The email address.
	 * @param phoneNumber The phone number.
	 * @param orgType The organization type.
	 * @param jobTitle The job title.
	 * @param company The company name.
	 * @param companySize The company size.
	 * @param businessNeeds Description of business needs.
	 * @param country The country.
	 * @param state The state.
	 * @return The title of the page after submission, or an error message if validation fails.
	 */
	public String fillFormForNonProfit(String firstName, String lastName, String email, String phoneNumber,
			String orgType, String jobTitle, String company, String companySize, String businessNeeds, String country,
			String state) {
		mandatoryInfo(firstName, lastName, email, phoneNumber, orgType);
		mu.sendValues(titleElem, jobTitle);
		mu.sendValues(companyElem, company);
		SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		mu.sendValues(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		submitBtn.click();
		String error = errorChecker();
		if (error != null)
			return error;
		wait.until(ExpectedConditions.titleContains("Thank"));
		return driver.getTitle();
	}

	/**
	 * Fills and submits the form for Non-Profit Others.
	 * @param firstName The first name.
	 * @param lastName The last name.
	 * @param email The email address.
	 * @param phoneNumber The phone number.
	 * @param orgType The organization type.
	 * @param jobTitle The job title.
	 * @param company The company name.
	 * @param companySize The company size.
	 * @param businessNeeds Description of business needs.
	 * @param country The country.
	 * @param state The state.
	 * @param description Additional description.
	 * @return The title of the page after submission, or an error message if validation fails.
	 */
	public String fillFormForNonProfitOthers(String firstName, String lastName, String email, String phoneNumber,
			String orgType, String jobTitle, String company, String companySize, String businessNeeds, String country,
			String state, String description) {
		mandatoryInfo(firstName, lastName, email, phoneNumber, orgType);
		mu.sendValues(titleElem, jobTitle);
		mu.sendValues(companyElem, company);
		SelectUtils.selectFromVisibleText(companySizeElem, companySize);
		mu.sendValues(needDiscribeElem, businessNeeds);
		SelectUtils.selectFromVisibleText(countryElem, country);
		SelectUtils.selectFromVisibleText(stateElem, state);
		mu.sendValues(descriptionElem, description);
		submitBtn.click();
		String error = errorChecker();
		if (error != null)
			return error;
		wait.until(ExpectedConditions.titleContains("Thank"));
		return driver.getTitle();
	}
}