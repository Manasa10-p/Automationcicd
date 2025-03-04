package Seleniumlearning.Manasaproject;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Seleniumlearning.PageObjects.CartPage;
import Seleniumlearning.PageObjects.ConfirmationPage;
import Seleniumlearning.PageObjects.ProductCatalogue;
import Seleniumlearning.TestComponents.BaseTest;

public class ProjectTestNG extends BaseTest {
	String ProductName = "Blackberry";

	@Test(dataProvider = "getData", groups= {"Purchase"})
	public void submitOrder(String email, String pwd, String ProductName) throws IOException, InterruptedException {
		// TODO Auto-generated method stub throws InterruptedException, IOException

		landingpage.loginApplication(email, pwd);
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
		Boolean match = CartPage.checkOut(ProductName);
		Assert.assertTrue(match);
		ConfirmationPage confirmationpage = CartPage.completeCheckout();
		String txtmsg = confirmationpage.verifyOrder();
		System.out.println(txtmsg);
		Assert.assertEquals("Success!", txtmsg);

	}
	
	

	@DataProvider
	public Object[][] getData() {

		return new Object[][] { { "rahulshettyacademy", "learning", "Blackberry" },
				{ "rahulshettyacademy", "learning", "iphone X" } };
	}

}
