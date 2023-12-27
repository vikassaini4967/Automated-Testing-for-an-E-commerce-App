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

import Fantazy.pageobjects.CartPage;
import Fantazy.pageobjects.CheckoutPage;
import Fantazy.pageobjects.ConfirmationPage;
import Fantazy.pageobjects.LandingPage;
import Fantazy.pageobjects.ProeductCatalouge;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String pn = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		ProeductCatalouge proeductCatalouge=	landingPage.loginApplication("testfantazy4967@gmail.com", "Tulsi4967@");
		
		
		
		List<WebElement>  products= proeductCatalouge.getProductList();
	
				
		proeductCatalouge.addProductToCart(pn);
	CartPage cartPage=proeductCatalouge.goToCartPage();
		
	
		
		Boolean match=cartPage.VerifyProductDisplay(pn);
		Assert.assertTrue(match);
		
		CheckoutPage checkoutPage=cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();
		
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
		
		

	}

}
