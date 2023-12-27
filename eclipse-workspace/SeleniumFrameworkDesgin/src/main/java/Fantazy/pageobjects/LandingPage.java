package Fantazy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Fantazy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
	
		super(driver);
		//Initialisation
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmails=driver.findElement(By.id("userEmail"));
	//PageFactory
	@FindBy(id="userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement passwordEle;
	@FindBy(id="login")
	WebElement submit;
	
	public ProeductCatalouge loginApplication(String email, String password )
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProeductCatalouge proeductCatalouge= new ProeductCatalouge(driver);
		return proeductCatalouge;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
		
		
		
	}
	
	
	
}
