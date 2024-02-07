package automationProject1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginWithInvalidData {
    
    WebDriver driver;
        
    TestClass p = PageFactory.initElements(driver, TestClass.class);
          
    @BeforeTest
    public void launchBrowser() throws Exception {
        driver = p.setUp();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void ClearUserAndPasswordTextbox() throws Exception {
        p.usernameInput.clear();
        p.passwordInput.clear();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     }

    @Test(priority = 1)
    public void InvalidUsername() throws Exception {
        p.login("rtrgf", "secret_sauce");
        Assert.assertTrue(p.errormsg.getText().contains("Epic sadface: Username and password do not match any user in this service"),
                "Correct Error Message Displayed for Invalid Entries");
       
    }

    @Test(priority = 2)
    public void InvalidPassword() throws Exception {
    	p.login("standard_user", "dfgf");
        Assert.assertTrue(p.errormsg.getText().contains("Epic sadface: Username and password do not match any user in this service"),
                "Correct Error Message Displayed for Invalid Entries");
        
    }
    @Test(priority = 3)
    public void InvalidUserAndPswd() throws Exception {
    	p.login("fdgfgh", "rtrth55");
        Assert.assertTrue(p.errormsg.getText().contains("Epic sadface: Username and password do not match any user in this service"),
                "Correct Error Message Displayed for Invalid Entries");
        
    }

   @AfterTest
    public void closingbrowser() {
        driver.quit();
    }
}