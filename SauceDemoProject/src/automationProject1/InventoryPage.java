package automationProject1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InventoryPage {

	WebDriver driver;
	
	TestClass p = PageFactory.initElements(driver, TestClass.class);
		
	@BeforeTest
	public void launchBrowser() throws Exception {
		driver = p.setUp();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		p.login("standard_user", "secret_sauce");
	}
	@Test(priority = 1)
	 public void navigateInventory()throws Exception {
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"),"Login successful and application Navigates to Inventory Page");
	
	}	
    @Test(priority = 2)
	public void Invdetailschk()throws Exception
    {
	List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));
    
    for (WebElement product : products) 
    {
    	String productName = product.findElement(By.className("inventory_item_name")).getText();
    	String productPrice = product.findElement(By.className("inventory_item_price")).getText();
    	boolean priceresult = product.isDisplayed();
    	
    	Assert.assertTrue(priceresult);
    	System.out.println(productName+" is displayed with price "+productPrice);
        }
    	Assert.assertTrue(p.productimg.isDisplayed(),"product Images are displayed");
    	
    	Assert.assertTrue(p.Addtocartbutton.isDisplayed(),"Add to cart buttons are visible");
        
    	Assert.assertTrue(p.Addtocartbutton.isEnabled(),"Add to cart buttons are Enable");
             
    }
    @Test(priority = 3)
    public void CartImage(){
        Assert.assertTrue(p.carticon.isDisplayed(),"Carticon is visible");
        Assert.assertTrue(p.carticon.isEnabled(),"Carticon is visible");
    }
    @Test(priority = 4)
    public void AddtoCartOneProduct() throws Exception {
    	p.itemcartone.click();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     }
    @Test(priority = 5)
    public void addToCartNameChange(){
        Assert.assertTrue(p.removebutton.getText().contains("Remove"),"After Click the AddtoCart button, Button name is changed to Remove"); 
        }
    @Test(priority = 6)
    public void AddtoCartMultiProduct() throws Exception {
    	p.itemcarttwo.click();
       	p.carticon.click();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	
    }
              
    @AfterTest
    public void closingbrowser() {
    	driver.quit();	
    }
}