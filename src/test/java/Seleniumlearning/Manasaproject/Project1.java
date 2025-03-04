package Seleniumlearning.Manasaproject;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Project1 {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//new comments added
	
	
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		Thread.sleep(2000);
	    driver.findElement(By.id("okayBtn")).click();
	    //driver.findElement(By.xpath("//select[@class='form-control']")).click();
	    
		WebElement dropdown=driver.findElement(By.xpath("//select[@class='form-control']"));
		Select student=new Select(dropdown);
	    student.selectByVisibleText("Consultant");
	    driver.findElement(By.id("signInBtn")).click();
	    
	    Thread.sleep(3000);
	  
		//Assert.assertEquals("Consultant", driver.findElement(By.xpath("//select[@class='form-control']")).getText());
	    
	    JavascriptExecutor j=(JavascriptExecutor) driver;
	    j.executeScript("window.scrollBy(0, 500)");
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
	WebElement prod=products.stream().filter(s->s.findElement(By.cssSelector("h4")).getText().equals("Blackberry")).findFirst().orElse(null);
	
	prod.findElement(By.cssSelector(".card-footer button:last-of-type")).click();
	
	
	driver.findElement(By.cssSelector("a[class*='btn']")).click();
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".container")));
	List<WebElement> cartprod=driver.findElements(By.cssSelector("h4"));
	Boolean match=cartprod.stream().anyMatch(cart->cart.getText().equalsIgnoreCase("Blackberry"));
	Assert.assertTrue(match);
	driver.findElement(By.cssSelector(".btn-success")).click();
	driver.findElement(By.cssSelector(".btn-success")).click();
	String txtmsg=driver.findElement(By.xpath("//div/strong")).getText();
	System.out.println(txtmsg);
	Assert.assertEquals("Success!", txtmsg);
	
	}
}
	
	
	
	
	
	
	
	
	


