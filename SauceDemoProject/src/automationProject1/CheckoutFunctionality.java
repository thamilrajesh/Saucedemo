package automationProject1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckoutFunctionality {
	
WebDriver driver;
	
	TestClass p = PageFactory.initElements(driver, TestClass.class);
		
	@BeforeTest
	public void launchBrowser() throws Exception {
		driver = p.setUp();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		p.login("standard_user", "secret_sauce");
	}
	@Test(priority = 1)
	public void cancelCheckout() throws Exception {
		p.itemcartone.click();
		p.carticon.click();
		p.checkoutButton.click();
		p.cancelorder.click();
				    	
    }
	@Test(priority = 2)
	public void Checkoutprocess() throws Exception {
		p.checkoutButton.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,100)", "");
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	p.firstNameInput.sendKeys("Ravi");
        p.lastNameInput.sendKeys("Krishna");
        p.postCodeInput.sendKeys(String.valueOf(350024));
        p.continueButton.click();
     }
	@Test(priority = 3)
	 public void CheckoutDetails() throws Exception {
	    	Thread.sleep(2000);
	    	Assert.assertTrue(p.checkoutproductdetails.isDisplayed());
	    		System.out.println(p.checkoutproductdetails.getText());
	    	Assert.assertTrue(p.checkoutsummary.isDisplayed());
	    		System.out.println(p.checkoutsummary.getText());
	    	
	 }
	@Test(priority = 4)
	 public void finishCheckout() throws Exception {
	    	p.finishcheckout.click();
	    	Assert.assertTrue(p.orderConfirmation.getText().contains("Thank you for your order!"));
	    		System.out.println(p.orderConfirmation.getText());
	    	   	
	    }
	@Test(priority = 5)
	 public void BackHome() throws Exception {
	    	p.backhome.click();
	    	
	    }

	 @AfterTest
	    public void closingbrowser() {
	    	driver.quit();	
	    }
}
