# YOUTUBE LINK:
https://youtu.be/QyHA9vlC0r8


# Test Case Description

## Feature to be Tested: User Login Functionality

### Functionality: 
Verify that users can log in with valid credentials.

### Sub-Features:

* Successful login with correct usernames and passwords.
* Handling incorrect password scenarios.
* Password recovery process.

## Scenarios:

* Valid login with correct credentials.
* Invalid login with incorrect password.
* Password recovery using registered email.

# Test Strategy

## Types of Tests:

* **Functional Tests:** To verify each aspect of the login feature.
* **Smoke Tests:** To ensure the most important functionalities are always up and running. Trigger everyday.
* **Regression Tests:** To ensure new changes do not break existing functionality. Trigger before releases and after major changes.


## Automation Approach (Tool and Framework):

* **Selenium WebDriver:** For browser automation.
* **Cucumber:** For implementing the BDD approach.
* **JUnit:** For test execution and reporting.

## BDD Approach:

* **Feature Files:** Describe the test scenarios in Gherkin language.
* **Step Definitions:** Java methods implementing the steps in the feature files.
* **Page Object Model (POM):** To create reusable page objects for different web pages.

## Test Data:
Managing test data through Cucumber Examples or Scenario Outline.

# Rationale

## Prioritization:

* Login functionality is critical as it is the entry point for users.
* Ensuring security through rigorous testing of login processes.

## Alignment with Business Logic:

* Ensuring a seamless user experience by validating both positive and negative scenarios.
* Protecting user data by identifying and mitigating security risks.

## Innovation and Efficiency:

* Leveraging BDD for better collaboration between technical and non-technical stakeholders.
* Using POM to enhance code maintainability and reusability.
