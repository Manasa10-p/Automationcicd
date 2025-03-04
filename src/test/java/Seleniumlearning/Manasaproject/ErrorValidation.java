package Seleniumlearning.Manasaproject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Seleniumlearning.PageObjects.CartPage;
import Seleniumlearning.PageObjects.ConfirmationPage;
import Seleniumlearning.PageObjects.LandingPage;
import Seleniumlearning.PageObjects.ProductCatalogue;
import Seleniumlearning.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {

	@Test(groups= {"ErrorHandling"}, retryAnalyzer=Seleniumlearning.TestComponents.Retry.class)
	public void loginErrorValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub throws InterruptedException, IOException

		landingpage.loginApplication("rahulshettyacademy", "learnin");
		landingpage.selectokay();
		landingpage.selectDropdown("Consultant");
		landingpage.SigninButton();

		Assert.assertEquals("Incorrect usernam/password.", landingpage.getErrorMsg());

	}

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub throws InterruptedException, IOException

		String ProductName = "Blackberry";

		landingpage.loginApplication("rahulshettyacademy", "learning");
		landingpage.selectokay();
		landingpage.selectDropdown("Consultant");
		landingpage.SigninButton();
		Thread.sleep(4000);
		ProductCatalogue ProductCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = ProductCatalogue.getProductList();
		landingpage.scrollToDown();
		Thread.sleep(4000);
		ProductCatalogue.addProductToCart(ProductName);
		CartPage CartPage = ProductCatalogue.cartCheckout();
		Boolean match = CartPage.checkOut("Blackberryy");
		Assert.assertFalse(match);

	}

}
