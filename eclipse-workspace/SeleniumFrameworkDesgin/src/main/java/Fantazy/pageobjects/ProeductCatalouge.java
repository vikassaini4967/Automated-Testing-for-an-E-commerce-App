package Fantazy.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Fantazy.AbstractComponents.AbstractComponents;

public class ProeductCatalouge extends AbstractComponents{
	
	WebDriver driver;
	public ProeductCatalouge(WebDriver driver)
	{
		//Initialisation
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	//PageFactory
	@FindBy(css=".mb-3")
	List<WebElement> products ;
	
	@FindBy(css=".ng-animating")
	WebElement spinner ;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastmessage=By.cssSelector("#toast-container");
	
	
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String pn)
	
	{
		WebElement prod = getProductList().stream().filter(product -> product.findElement(By.tagName("b")).getText().equals(pn))
				.findFirst().orElse(null);	
		
		return prod;
	}
	
     public void addProductToCart(String pn) throws InterruptedException 
     {
    	 
    	 WebElement prod =getProductByName(pn);
    	 
    	 prod.findElement(addToCart).click();
    	 waitForElementToAppear(toastmessage);
    	 waitForElementTodisappear(spinner);
    
     }


	
}
