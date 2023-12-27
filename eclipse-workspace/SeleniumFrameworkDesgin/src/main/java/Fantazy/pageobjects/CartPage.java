package Fantazy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Fantazy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{

	/*
	 List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));

		boolean match = cartproducts.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(pn));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
	 */
	   @FindBy(css=".totalRow button")
	   WebElement checkoutEle;
	   
	   @FindBy(css=".cartSection h3")
	private  List< WebElement> productTitles;
	   
	   public CartPage(WebDriver driver) {
		   
		   super(driver);
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
		   
		   
	   }
	   public boolean VerifyProductDisplay(String pn) {
		   Boolean match= productTitles.stream().anyMatch(product->product.getText().equalsIgnoreCase(pn));
		   return match;
	   }
	   
	   public CheckoutPage goToCheckout(){
		   checkoutEle.click();
		   return new CheckoutPage(driver);
	   }
	   
	}

