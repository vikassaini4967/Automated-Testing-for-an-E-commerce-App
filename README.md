 E-commerce Automation Test

This repository contains a Java-based automation test script for a sample e-commerce website using Selenium WebDriver and TestNG. The test script navigates through the website, adds a specific product to the cart, and completes the checkout process.
Prerequisites

    Java JDK installed
    Maven installed
    Chrome browser installed

Setup

    Clone the repository to your local machine.
    Open the project in your preferred Java IDE.
    Ensure that the necessary dependencies are resolved using Maven.

Test Execution

    Update the productName variable in the StandAloneTest class with the desired product name.
    Run the main method in the StandAloneTest class.

Description

    The test script utilizes Selenium WebDriver for browser automation and TestNG for test management.
    It navigates to the specified e-commerce website, logs in, searches for a product, adds it to the cart, and completes the checkout process.
    The test uses the Page Object Model (POM) pattern, separating the page-specific actions into a separate LandingPage class.

Dependencies

    Selenium WebDriver: Manages browser automation.
    TestNG: Manages test execution and assertions.
    WebDriverManager: Automates the browser driver setup.
    Boni Garcia's WebDriverManager: Simplifies WebDriver management.

Project Structure

    Fantazy package: Contains the main test script.
    Fantazy.pageobjects: Contains the LandingPage class for page-specific actions.

Configuration

    ChromeDriver is used by default. Ensure compatibility with your Chrome browser version.
    The test script assumes a specific website structure. Adjust locators and wait conditions as needed.

Notes

    This script is a basic demonstration and may require modifications based on website changes or specific requirements.
    Ensure that you have the necessary permissions to execute the test on the specified website.
