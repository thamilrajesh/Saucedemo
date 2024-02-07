package automationProject1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Logout {
	
   WebDriver driver;
	
	TestClass p = PageFactory.initElements(driver, TestClass.class);
		
	@BeforeTest
	public void launchBrowser() throws Exception {
		driver = p.setUp();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		p.login("standard_user","secret_sauce");
	}
	@Test
	 public void logout() 
	    {
	    	p.LeftNaviButton.click();
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	JavascriptExecutor jse = (JavascriptExecutor) driver;
	    	jse.executeScript("arguments[0].click();", p.logoutlink);
	    	Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/"),"Logout successful");
	        	    	
	    }
	@AfterTest
    public void closingbrowser() {
    	driver.quit();	
    }


}
