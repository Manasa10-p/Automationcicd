package Seleniumlearning.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Seleniumlearning.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
WebDriver driver;
	
	
	public CartPage(WebDriver driver)//constructor Initialization
	
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//List<WebElement> cartprod = driver.findElements(By.cssSelector("h4"));
	
	//pageFactory
	
	@FindBy(css="h4")
	List<WebElement> producTitles;
	
	//By visibility=By.xpath("//h4/a");
	
	//driver.findElement(By.cssSelector(".btn-success")).click();
	
	@FindBy(css=".btn-success")
	WebElement Clickcheckout;
	
	public Boolean checkOut(String ProductName) {
		
		//WaitForElementToAppear(visibility);
		Boolean match = producTitles.stream().anyMatch(cart -> cart.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	
	public ConfirmationPage completeCheckout()
	{
		Clickcheckout.click();
		Clickcheckout.click();
		ConfirmationPage confirmationpage=new ConfirmationPage(driver);
		return confirmationpage;
	}

	
	
	
	
	
	
	
	}



	
	
	

