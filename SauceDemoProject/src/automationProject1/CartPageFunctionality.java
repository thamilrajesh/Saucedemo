package automationProject1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartPageFunctionality {
	
WebDriver driver;
	
	TestClass p = PageFactory.initElements(driver, TestClass.class);
		
	@BeforeTest
	public void launchBrowser() throws Exception {
		driver = p.setUp();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		p.login("standard_user", "secret_sauce");
	}
	@Test(priority = 1)
	public void CartproductDetails() throws Exception {
		    p.itemcartone.click();
			p.itemcarttwo.click();
			p.carticon.click();
	    	Assert.assertTrue(p.cartproductdetails.isDisplayed());
	    	System.out.println(p.cartproductdetails.getText());
	    	
	    }
	@Test(priority = 2)
	 public void removeProductFromCart() throws Exception  {
	    	String removeitemname = p.removeitem.getText();
	    	p.removebutton.click();
	    	System.out.println(removeitemname+" removed from the cart");
	      }
	@Test(priority = 3)
	 public void ContinueShopping() throws Exception {
	    	p.continueshoppingButton.click();
	    	
	    }
	@Test(priority = 4)
	 public void Checkoutbutton() throws Exception {
		    driver.navigate().to("https://www.saucedemo.com/cart.html");
	    	p.checkoutButton.click();    
	    }
	
	 @AfterTest
	    public void closingbrowser() {
	    	driver.quit();	
	    }

}
