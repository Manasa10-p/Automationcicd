package Seleniumlearning.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Seleniumlearning.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
WebDriver driver;
	
	
	public LandingPage(WebDriver driver)//constructor Initialization
	
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//WebElement username=driver.findElement(By.id("username"));
	
	//pageFactory
	
	@FindBy(id="username")
	WebElement username;
	
	//driver.findElement(By.id("password")).sendKeys("learning");
	
	@FindBy(id="password")
	WebElement password;
	
	//driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
	
	@FindBy(xpath="(//span[@class='checkmark'])[2]")
	WebElement checkbox;
	
	
	//driver.findElement(By.id("okayBtn")).click();
	
	@FindBy(xpath="//button[@id='okayBtn']")
	WebElement okayBtn;
	

	//WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
	
	@FindBy(xpath="//select[@class='form-control']")
	WebElement selecttext;
	//driver.findElement(By.id("signInBtn")).click();
	
	@FindBy(id="signInBtn")
	WebElement signin;
	
	@FindBy(css=".alert-danger")
	WebElement incorrectemailorpassword;
	
	
	public void loginApplication(String email, String pwd)
	{
		username.sendKeys(email);
		password.sendKeys(pwd);
		checkbox.click();
		
		}
	
	public void selectokay(){
		
		waitForElementToClickable(okayBtn);
		okayBtn.click();
		
	}
	public void goTo()
	{
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	}
	
	public void selectDropdown(String visibletext)
	{
	
		Select select=new Select(selecttext);
		select.selectByVisibleText(visibletext);
	}
	
	public ProductCatalogue SigninButton() {
		
		signin.click();
		ProductCatalogue ProductCatalogue = new ProductCatalogue(driver);
		return ProductCatalogue;
		
	}
	
	public String getErrorMsg() {
		
		waitForWebElementToClickable(incorrectemailorpassword);
		return incorrectemailorpassword.getText();
		
	}
	
	public void scrollToDown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
	}
	
	
	}



	
	
	

