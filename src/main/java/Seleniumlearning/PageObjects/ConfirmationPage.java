package Seleniumlearning.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Seleniumlearning.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {
WebDriver driver;
	
	
	public ConfirmationPage(WebDriver driver)//constructor Initialization
	
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.xpath("//div/strong"))
	
	//pageFactory
	
	@FindBy(xpath="//div/strong")
	WebElement txtmessage;
	
	public String verifyOrder() {
		
		return txtmessage.getText();
	
		
	}
	

	
	
	
	
	
	
	
	}



	
	
	

