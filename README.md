# Identify Courses - Web Automation Project

This project focuses on automating web interactions to identify and extract information about web development courses, specifically targeting beginner-level courses in English. It also includes a task to test form validation on a suggested e-learning platform.

## Problem Statement

The core problem is to programmatically search for and display information about web development courses, and to test form submission with invalid input on a specific enterprise section of a website.

## Detailed Description

This project comprises two main tasks:

### Task 1: Course Identification and Extraction

1.  **Search Criteria:** Search for "web development courses" tailored for:
    * Beginners level
    * English Language
2.  **Data Extraction:** Extract and display the following information for the first two relevant courses:
    * Course Name
    * Total Learning Hours
    * Rating
3.  **Language and Level Exploration:** Additionally, the automation should explore and display all available languages and different learning levels offered on the chosen platform.

### Task 2: Form Validation Testing

1.  **Navigation:** Navigate to the "For Enterprise" section on the suggested website (coursera.org).
2.  **Product Selection:** Under "Product," locate and access "Courses for Campus."
3.  **Form Interaction:** Fill the "Ready to transform" form with at least one invalid input (e.g., an invalid email address format).
4.  **Error Capture:** Capture and display the warning/error message generated due to the invalid input.
5.  **Suggested Site:** coursera.org

## Key Automation Scope

The automation solution will demonstrate capabilities in:

* **Handling Different Browser Windows:** Managing multiple browser tabs or windows if encountered during navigation.
* **Search Option Interaction:** Effectively interacting with search bars and submitting queries.
* **Extracting Multiple Dropdown List Items:** Retrieving and storing data from dropdown menus.
* **Navigating Back to Home Page:** Implementing logic to return to the website's homepage.
* **Filling Forms:** Interacting with various form elements (text fields, checkboxes, radio buttons, etc.) across different web page objects.
* **Capturing Warning Messages:** Identifying and extracting error or warning messages displayed on the web page.
* **Scrolling Down in Web Page:** Automating scrolling to reveal hidden elements or navigate long pages.

## Technologies Used

* Primary programming language used: Java
* Primary web automation framework: Selenium WebDriver, TestNG, Apache POI, Hybrid Automation Framework 

## Setup and Installation

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/SuryaBhaiCognizant/IdentifyCourses.git](https://github.com/SuryaBhaiCognizant/IdentifyCourses.git)
    ```
2.  **Install dependencies:**
    ```bash
    cd <Project Path>
    mvn clean test
    ```
3.  Download the appropriate browser(e.g., Chrome for ChromeDriver, MS Edge for EdgeDriver)



## Project Structure

IdentifyCourses/  
├─ src/main/java/  
│  ├─ com.cognizant.base/  
│  │  ├─ Base_Page.java  
│  │  ├─ Base_Test.java  
│  ├─ com.cognizant.element.repository/  
│  │  ├─ ForEnterprisePage.java  
│  │  ├─ HomePage.java  
│  │  ├─ ResultPage.java  
│  ├─ com.cognizant.utilities/  
│  │  ├─ ExcelUtils.java  
│  │  ├─ ExtentReportManager.java  
│  │  ├─ MiscUtils.java  
│  │  ├─ SelectUtils.java    
├─ src/main/resources/  
│  ├─ Checkwords.xlsx  
│  ├─ config.properties  
│  ├─ log4j2.xml        
├─ src/test/java/  
│  ├─ com.cognizant.testscripts/  
│  │  ├─ TSCourseSearch.java  
│  │  ├─ TSForEnterpriseForm.java  
│  │  ├─ TSLanguageLearning.java  
├─ src/test/testdata/  
│  ├─ FormTestData.xlsx  
│  ├─ testNG.xml  
├─ logs/  
├─ reports/  
├─ screenshots/  
├─ POM.xml  
├─ test-outputs/  
├─ .gitignore  
├─ README.md  
