package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	public WebDriver driver;
		
		// Page factory
		
		@FindBy(id="username")
		@CacheLookup
		 WebElement username;
		
		@FindBy(id="password")
		@CacheLookup
		 WebElement password;
		
		@FindBy(xpath="//button[@class='btn btn-block btn-blue btn-xl']")
		@CacheLookup
		WebElement submitBtn;
		
		@FindBy(id="emailHelp")
		@CacheLookup
		 WebElement register;
		
		@FindBy(xpath="//img[@class='vertical-center']")
		@CacheLookup
		 WebElement logo;
		
		@FindBy(xpath="//a[text()='Logout']")
		@CacheLookup
		WebElement logout;

		public LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		


		public String validateTittle()
		{
			return driver.getTitle();
			 
		}
		 public  boolean validateLogo()
		 {
			return logo.isDisplayed();
			 
		 }
		 
//		 public  HomePage login(String us , String pass) {
//		 username.sendKeys(us);
//		 password.sendKeys(pass);
//		 submitBtn.click();
//		 return  new HomePage();
//		 }
		 
		 public void setusername(String UserName)
		 {
			 username.clear();
			 username.sendKeys(UserName);
		 }
		 
		 public void setpassword(String Password)
		 {	 
			 password.clear();
			 password.sendKeys(Password);
		 }
		 
		 
		 public void clicksubmit()
		 {
			 
			 submitBtn.click();
			 
		 }
		 
		 public void clicklogout()
		 {
			 logo.click();
		 }
		 
		
	}


