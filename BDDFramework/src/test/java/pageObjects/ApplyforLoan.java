package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseClass.BaseClass;

public class ApplyforLoan  {

	public WebDriver driver;
	
	
	
	@FindBy(id="applyForLoan")
	@CacheLookup
	WebElement applylink;
	
	@FindBy(id="applyButton")
	@CacheLookup
	WebElement applybtn;
	
	
	@FindBy(id="email")
	@CacheLookup
	WebElement email;
	
	
	@FindBy(id="amount")
	@CacheLookup
	WebElement amount;
	
	@FindBy(id="term")
	@CacheLookup
	WebElement dropdown; 

	@FindBy(id="income")
	@CacheLookup
	WebElement income;
	
	@FindBy(id="age")
	@CacheLookup
	WebElement age;
	
	@FindBy(id="submitButton")
	@CacheLookup
	WebElement submit;
	
	@FindBy(xpath="//h1[text()=' Congrats! ']")
	@CacheLookup
	WebElement succestxt;
	
	public ApplyforLoan (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickApplyLoan()
	{
		 applylink.click();
		
	}
	
	public void applybutton()
	{
		 applybtn.click();
	
	}
	public void setmail(String mail)
	{
		email.sendKeys(mail);
	}
	
	public void applyloanform(String amt,String term,String inc,String ag) throws InterruptedException
	
	{	
		
		amount.sendKeys(amt);
		Select sel = new Select(dropdown);
		sel.selectByVisibleText(term);
		income.sendKeys(inc);
		age.sendKeys(ag);
		
		}
	public void Clicksubmit()
	{
		submit.click();
			
	}
	public WebElement VerfiyLoanApply() {
		return succestxt;
	}


	
	
	
	
	}
