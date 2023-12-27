package Fantazy;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Fantazy.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

    public static void main(String[] args) {
        // Product name to search for
        String productName = "ZARA COAT 3";

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the website
        driver.get("https://rahulshettyacademy.com/client");

        // Initialize LandingPage object
        LandingPage landingPage = new LandingPage(driver);

        // Login to the website
        driver.findElement(By.id("userEmail")).sendKeys("testfantazy4967@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Tulsi4967@");
        driver.findElement(By.id("login")).click();

        // Wait for product elements to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));

        // Get list of product elements
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        // Find the product by name
        WebElement prod = products.stream()
                .filter(product -> product.findElement(By.tagName("b")).getText().equals(productName))
                .findFirst().orElse(null);

        // Click on the last button in the product card
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        // Wait for toast container to be visible and ng-animating to be invisible
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

        // Go to the cart
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        // Get list of product elements in the cart
        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

        // Check if the desired product is in the cart
        boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);

        // Click on the button in the total row
        driver.findElement(By.cssSelector(".totalRow button")).click();

        // Wait for the country input to be visible
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input[placeholder='Select Country']")));

        // Perform actions on the country input
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build().perform();

        // Wait for the list group to be visible
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".list-group")));

        // Perform actions to select the country (assuming it's the second button)
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

        // Click on the submit button
        driver.findElement(By.cssSelector(".action__submit")).click();

        // Get the confirmation message
        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();

        // Assert that the confirmation message is as expected
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANK YOU FOR THE ORDER."));

        // Close the browser
        driver.close();
    }
}
