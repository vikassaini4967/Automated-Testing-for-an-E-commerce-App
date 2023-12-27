package Fantazy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Fantazy.pageobjects.CartPage;

public class AbstractComponents {
     
	protected WebDriver driver;
	
	
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;

	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage cartPage= new CartPage(driver);
		return cartPage;
	}
	public void waitForElementTodisappear(WebElement ele) throws InterruptedException {
		
		Thread.sleep(1000);
		//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(2));
		//	wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
}
