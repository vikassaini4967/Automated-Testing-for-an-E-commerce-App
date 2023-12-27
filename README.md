Navigate to the project directory:

bash

cd FantazySeleniumTest

Install project dependencies:

bash

    mvn clean install

Running the Test

    Execute the main test script:

    bash

    mvn exec:java -Dexec.mainClass="Fantazy.StandAloneTest"

    This will launch the Chrome browser, navigate to the Fantazy website, perform the test, and close the browser.

Test Description

    The script logs in to the Fantazy website using predefined credentials.
    Searches for a specific product ("ZARA COAT 3") and adds it to the cart.
    Proceeds to the checkout and completes the order process.
    Verifies the confirmation message.

Configuration

    The product name to search for is defined in the script (productName variable).
    WebDriverManager is used to manage the ChromeDriver version.

Dependencies

    Selenium WebDriver
    TestNG
    WebDriverManager
    Bonigarcia WebDriverManager

Additional Notes

    The script uses explicit waits to ensure elements are visible before interacting with them.
    Ensure proper network connectivity and website availability during the test execution.
    Make sure to update the login credentials if needed.

A

Feel free to customize the README file based on your specific project details and requirements.



