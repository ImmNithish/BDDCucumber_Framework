package stepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import BaseClass.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ApplyforLoan;
import pageObjects.LoginPage;

public class steps extends BaseClass {

	
	@Before
	public void setup() throws IOException
	{
		//Reading Properties
		prop = new Properties();
		FileInputStream ip= new FileInputStream("Config.properties");
		prop.load(ip);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			

			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromepath"));
			driver = new ChromeDriver();
			

		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefox"));
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("edge"))
			
		{
			System.setProperty("webdriver.edge.driver", prop.getProperty("edgepath"));
			driver = new EdgeDriver();
			
		}
		

		logger = Logger.getLogger("BDDFramework"); // Added logger 
		PropertyConfigurator.configure("log4j.properties"); //added logger
		
	}
	
	LoginPage  login;

	@Given("User should launch chrome browser")
	public void user_should_launch_chrome_browser() {

		login = new LoginPage(driver) ;

	}

	@When("User should navigate to URL {string}")
	public void user_should_navigate_to_url(String url)
	{
		driver.get(url);
		logger.info("Opening url ");
		driver.manage().window().maximize();
	}

	@When("User should enter UserName as {string} and Password as {string}")
	public void user_should_enter_user_name_as_and_password_as(String username, String password)
	{
		logger.info("******* Providing login details *****");

		login.setusername(username);
		login.setpassword(password);
	}

	@When("Click submit button")
	public void click_submit_button() throws InterruptedException {
		login.clicksubmit();
		Thread.sleep(4000);
	}

	@Then("Verify User should landed on a HomePage {string}")
	public void verify_user_should_landed_on_a_home_page(String homeurl) 
	{ 
		if(driver.getPageSource().contains("login failed"))
		{	driver.close();
		logger.info("******* login failed *****");
		Assert.assertTrue(false);
		}
		else {
			logger.info("*******login passed*****");

			Assert.assertEquals(homeurl, driver.getCurrentUrl());
		}
	}

	@When("User click on Logout button")
	public void user_click_on_logout_button() throws InterruptedException 
	{
		login.clicklogout();
		logger.info("******* logged out *****");
		Thread.sleep(4000);
	}

	@Then("Verify User should landed on a LoginPage {string}")
	public void verify_user_should_landed_on_a_login_page(String tittle) throws InterruptedException
	{
     	Assert.assertEquals(tittle, driver.getTitle());
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		logger.info("******* Browser closed *****");
		driver.close();
	}

	// ******************* APPLY LOAN SCENARIO ***********************************

	@When("User should click Apply for a loan link")
	public void user_should_click_apply_for_a_loan_link() 
	{
		apply =new ApplyforLoan(driver);   
		apply.clickApplyLoan();
	}

	@When("Click Apply for a Loan")
	public void click_apply_for_a_loan() 
	{
		apply.applybutton();
		logger.info("******Apply loan button clicked *****");
	}


	@Then("Verify user landed on a Apply Loan page {string}")
	public void verify_user_landed_on_a_apply_loan_page(String loanpageurl) {

		Assert.assertEquals(loanpageurl, driver.getCurrentUrl());

	}

	@When("User should enter Email Id")
	public void user_should_enter_email_id( ) {

		String Email = BaseClass.RandomMail()+"@yahoo.com";
		apply.setmail(Email);
		logger.info("******* Email is given *****");
		}

	@When("User should Enter AMOUNT REQUIRED and Select LOAN TERM option and enter their INCOME and AGE")
	public void user_should_enter_amount_required_and_select_loan_term_option_and_enter_their_income_and_age(DataTable dataTable) throws InterruptedException 
	{
		List<List<String>> rows = dataTable.asLists();
		for (List<String> col : rows) 
		{
			apply.applyloanform(col.get(0),col.get(1),col.get(2),col.get(3));
			logger.info("******* Income, age,Amoiun required details were provided *****");

		}
		}


	@When("Click submit Loan Application")
	public void click_submit_loan_application() throws InterruptedException {
		apply.Clicksubmit();
		logger.info("****** Submit button was clicked *****");
		Thread.sleep(3000);
	}


	@Then("Verify the Loan status")
	public void verify_the_loan_status() 
	{
		//		WebElement element = apply.VerfiyLoanApply();
		//		WaitHelper.waitmethod(element);

		if(apply.VerfiyLoanApply().isDisplayed())
		{
			logger.info("******* Loan was approved  *****");
			Assert.assertTrue(true);

		}
		else
		{
			logger.info("******* Loan not approved *****");
			Assert.assertTrue(false);
		}
	}

}

