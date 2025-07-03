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
    open project in Eclipse and update the project (Right click on project folder > Maven > Update Project)
    ```
3.  Download the appropriate browser(e.g., Chrome for ChromeDriver, MS Edge for EdgeDriver)

## How to Run

1.  **Ensure WebDriver is set up correctly.**
2.  **Execute the main automation script:**
    ```bash
    
    ```

## Project Structure


Here's a README.md file content suitable for your Git repository, based on the provided project description:

Markdown

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
3.  **Suggested Site:** coursera.org (however, the automation should be flexible enough to work on other legitimate e-learning sites).
4.  **Language and Level Exploration:** Additionally, the automation should explore and display all available languages and different learning levels offered on the chosen platform.

### Task 2: Form Validation Testing

1.  **Navigation:** Navigate to the "For Enterprise" section on the suggested website (coursera.org).
2.  **Product Selection:** Under "Product," locate and access "Courses for Campus."
3.  **Form Interaction:** Fill the "Ready to transform" form with at least one invalid input (e.g., an invalid email address format).
4.  **Error Capture:** Capture and display the warning/error message generated due to the invalid input.
5.  **Suggested Site:** coursera.org (however, the automation should be flexible enough to work on other legitimate e-learning sites).

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

* [List your primary programming language, e.g., Python]
* [List your primary web automation framework, e.g., Selenium WebDriver]
* [Any other relevant libraries or tools]

## Setup and Installation

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/your-username/your-repository-name.git](https://github.com/your-username/your-repository-name.git)
    cd your-repository-name
    ```
2.  **Install dependencies:**
    ```bash
    pip install -r requirements.txt
    ```
    *(Create a `requirements.txt` file listing all Python dependencies, e.g., `selenium`)*
3.  **Download WebDriver:**
    * Download the appropriate WebDriver for your browser (e.g., ChromeDriver for Chrome, GeckoDriver for Firefox).
    * Place the WebDriver executable in your system's PATH or specify its path in the code.

## How to Run

1.  **Ensure WebDriver is set up correctly.**
2.  **Execute the main automation script:**
    ```bash
    python main.py
    ```
    *(Replace `main.py` with the actual name of your primary script)*

## Project Structure

.
├── src/                      # Source code for automation scripts
│   ├── pages/                # Page Object Model (POM) classes (if used)
│   ├── utils/                # Utility functions
│   └── tests/                # Test scripts (if applicable)
├── config/                   # Configuration files (e.g., URLs, selectors)
├── reports/                  # Generated reports or screenshots
├── requirements.txt          # Python dependencies
├── README.md                 # This file
└── .gitignore                # Files to ignore in Git