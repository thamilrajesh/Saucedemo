package automationProject1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginWithBlankData {
    
    WebDriver driver;
        
    TestClass p = PageFactory.initElements(driver, TestClass.class);
      
    @BeforeTest
    public void launchBrowser() throws Exception {
    	driver = p.setUp();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
              
    }

   @BeforeMethod
    public void ClearUserAndPasswordTextbox() throws Exception {
	   WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.visibilityOf(p.usernameInput));
       p.usernameInput.clear();
       wait.until(ExpectedConditions.visibilityOf(p.passwordInput));
       p.passwordInput.clear();
      }
   @Test(priority = 1)
   public void InvalidUserAndPswd() throws Exception {
   	   p.usernameInput.sendKeys("");
       p.passwordInput.sendKeys("");
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       p.loginButton.click();
       Assert.assertTrue(p.errormsg.getText().contains("Epic sadface: Username is required"),
       		"Correct Error Message Displayed for Blank Entries in Username field");
       
   }
    
   @Test(priority = 2)
    public void InvalidPassword() throws Exception {
    	    p.usernameInput.sendKeys("standard_user");
    		p.passwordInput.sendKeys("");
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        p.loginButton.click();
        Assert.assertTrue(p.errormsg.getText().contains("Epic sadface: Password is required"),
        		"Correct Error Message Displayed for Blank Entries in password field");
        
    }
    

   @AfterTest
    public void closingbrowser() {
        driver.quit();
    }
}