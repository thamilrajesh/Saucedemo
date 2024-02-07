package automationProject1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginWithValidUser {
	

	WebDriver driver;
	
	TestClass p = PageFactory.initElements(driver, TestClass.class);
		
	@BeforeTest
	public void launchBrowser() throws Exception {
		driver = p.setUp();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority = 1)
    public void logintest() throws Exception {
    	
    	for(String[] userdata : p.usersAndPasswords) {
    		p.usernameInput.sendKeys(userdata[0]);
            p.passwordInput.sendKeys(userdata[1]);
            p.loginButton.click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")); 
            System.out.println("Login successful for user: "+userdata[0]);
           driver.get("https://www.saucedemo.com/");
          p.usernameInput.clear();
          p.passwordInput.clear();
       	}
    			
    }
	 @AfterTest
	    public void closingbrowser() {
	    	driver.quit();	
	    }
	

}
