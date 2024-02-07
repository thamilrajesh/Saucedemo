package automationProject1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SortByOrder {
	
	WebDriver driver;
	
	WebElement sorder;
	
	TestClass p = PageFactory.initElements(driver, TestClass.class);
		
	@BeforeTest
	public void launchBrowser() throws Exception {
		driver = p.setUp();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		p.login("standard_user", "secret_sauce");
	}
	@Test(priority = 1)
	 public void sortoption() {
    	p.soption.click();
    	
    }
	@Test(priority = 2)
    public void sortbyAtoZ()throws Exception {
		p.soption.click();
		sorder = driver.findElement(By.cssSelector("option[value='" +"az"+ "']"));
		sorder.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
   @Test(priority = 3)  
   	public void sortbyZtoA()throws Exception {
   		p.soption.click();
		sorder = driver.findElement(By.cssSelector("option[value='" +"za"+ "']"));
		sorder.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   		   		
   	}
    @Test(priority = 4)  
   	public void sortbyLowtoHigh()throws Exception {
    	p.soption.click();
		sorder = driver.findElement(By.cssSelector("option[value='" +"lohi"+ "']"));
		sorder.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   	   		
   	}
    @Test(priority = 5)  
   	public void sortbyHightoLow()throws Exception {
    	p.soption.click();
		sorder = driver.findElement(By.cssSelector("option[value='" +"hilo"+ "']"));
		sorder.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   		  	
   	}
    @AfterTest
    public void closingbrowser() {
    	driver.quit();	
    }

}
