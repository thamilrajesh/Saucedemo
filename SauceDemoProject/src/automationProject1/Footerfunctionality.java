package automationProject1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Footerfunctionality {
	
	WebDriver driver;

	TestClass p = PageFactory.initElements(driver, TestClass.class);
		
	@BeforeTest
	public void launchBrowser() throws Exception {
		driver = p.setUp();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		p.login("standard_user", "secret_sauce");
	}
	@Test(priority = 1)
	 public void Footer() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)", "");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	Assert.assertTrue(p.FooterText.isDisplayed(),"FooterText is Displayed");
    	Assert.assertTrue(p.TwitterIcon.isDisplayed(),"TwitterIcon is Displayed");	
    	Assert.assertTrue(p.FacebookIcon.isDisplayed(),"FacebookIcon is Displayed");
    	Assert.assertTrue(p.LinkedInIcon.isDisplayed(),"LinkedInIcon is Displayed");
    	    	
    } 
	@Test(priority = 2)
    public void TwitterPage() throws Exception {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)", "");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	p.TwitterIcon.click();
    }
	@Test(priority = 3)
    public void FacebookPage() throws Exception {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)", "");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       	p.FacebookIcon.click();
    }
	@Test(priority = 4)
    public void LinkedInPage() throws Exception {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)", "");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       	p.LinkedInIcon.click();
    }
	 
	 @AfterTest
	    public void closingbrowser() {
	    	driver.quit();	
	    }

}
