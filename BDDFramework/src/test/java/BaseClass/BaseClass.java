package BaseClass;

import java.util.Properties;
import java.util.logging.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.ApplyforLoan;

public class BaseClass {
	
	public WebDriver driver;
	
	public ApplyforLoan apply;
	
	public  Logger logger; 
	public Properties prop;
	

	
	
	
public static String RandomMail()
	
	{
		String randomMail = RandomStringUtils.randomAlphabetic(5);
		 return randomMail;
	}

}
