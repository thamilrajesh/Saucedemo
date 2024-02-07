package automationProject1;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestClass {

    private WebDriver driver;
    
    String[][] usersAndPasswords = {
            {"standard_user", "secret_sauce"},
            {"problem_user","secret_sauce"},
            {"performance_glitch_user","secret_sauce"},
            {"error_user","secret_sauce"},
            {"visual_user","secret_sauce"}
    };
        
    @FindBy(id = "user-name")
     WebElement usernameInput;

    @FindBy(id = "password")
     WebElement passwordInput;

    @FindBy(id = "login-button")
     WebElement loginButton;
    
    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
     WebElement errormsg;
    
    @FindBy(id = "react-burger-menu-btn")
     WebElement LeftNaviButton;
    
    @FindBy(id = "logout_sidebar_link")
     WebElement logoutlink;

    @FindBy(className = "select_container")
    WebElement soption;
            
    @FindBy(className = "inventory_item_img")
     WebElement productimg;
      
    @FindBy (className = "inventory_item_name")
     WebElement itemname;
    
    @FindBy(xpath = "//button[text()='Add to cart']")
     WebElement Addtocartbutton;
    
    @FindBy(xpath = "//button[text()='Remove']")
    WebElement removebutton;
    
    @FindBy(css = "a.shopping_cart_link")
     WebElement carticon;
    
    @FindBy(id = "item_1_title_link")
     WebElement twoitem;
    
    @FindBy(id = "item_4_title_link")
     WebElement removeitem;
    
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
     WebElement itemcartone;
    
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
     WebElement itemcarttwo;

    @FindBy(className = "cart_list")
     WebElement cartproductdetails;
        
    @FindBy(id = "remove-sauce-labs-backpack")
     WebElement removeButton;
    
    @FindBy(id = "continue-shopping")
    WebElement continueshoppingButton;
    
    @FindBy(id = "checkout")
     WebElement checkoutButton;
    
    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
     WebElement lastNameInput;
    
    @FindBy(id = "postal-code")
    WebElement postCodeInput;

   @FindBy(id = "continue")
     WebElement continueButton;
         
   @FindBy(className = "cart_list")
   WebElement checkoutproductdetails;
   
   @FindBy(className = "summary_info")
   WebElement checkoutsummary;

   @FindBy(id = "cancel")
    WebElement cancelcheckout;
   
   @FindBy(id = "finish")
    WebElement finishcheckout;
   
   @FindBy(className = "complete-header")
     WebElement orderConfirmation;
   
   @FindBy(xpath = "//*[@id=\"cancel\"]")
    WebElement cancelorder;
   
   @FindBy(id = "back-to-products")
   WebElement backhome;
   
   @FindBy(className = "footer_copy")
    WebElement FooterText;
   
   @FindBy(linkText = "Twitter")
  WebElement TwitterIcon;
   
   @FindBy(linkText = "Facebook")
    WebElement FacebookIcon;
   
   @FindBy(linkText = "LinkedIn")
    WebElement LinkedInIcon;

   // Launch the browser
    public WebDriver setUp() {
       
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Thamil\\Desktop\\Manual and Selinium Testing\\Selenium\\Jars\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
		return driver;
    }
    //Login
    public void login(String username, String password) throws Exception {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginButton.click();
    }
   
     
}

