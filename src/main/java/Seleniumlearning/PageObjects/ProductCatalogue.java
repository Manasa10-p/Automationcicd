package Seleniumlearning.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Seleniumlearning.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
WebDriver driver;
	
	
	public ProductCatalogue(WebDriver driver)//constructor Initialization
	
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	//pageFactory
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	//By productsby=By.cssSelector(".mb-3");
	
	//driver.findElement(By.cssSelector("a[class*='btn']")).click();
	@FindBy(css="a[class*='btn']")
	WebElement checkout;
	
	By addToCart=By.cssSelector(".card-footer button:last-of-type");
					
	
	public List<WebElement> getProductList()
	{
		
		//WaitForElementToAppear(productsby);
		
		return products;
		
	}
	
	public WebElement getProductName(String ProductName)
	{
		
		WebElement prod = getProductList().stream()
				.filter(s -> s.findElement(By.cssSelector("h4")).getText().equals(ProductName)).findFirst()
				.orElse(null);
		
		return prod;

	}
		
	public void addProductToCart(String ProductName) {
		
		WebElement prod=getProductName(ProductName);
		
		prod.findElement(addToCart).click();
		
	}
	public CartPage cartCheckout() {
		
		checkout.click();
		CartPage CartPage = new CartPage(driver);
		return CartPage;
		
	}
	
	
	
	
	
	
	
	
	}



	
	
	

