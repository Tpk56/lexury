package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.Loginpage;
import factory.Browserfactory;
import factory.Dataproviderfactory;

public class VerifyLoginpage 
{

	WebDriver driver;
	
	
	@BeforeMethod
	public void setUP()
	{		
		driver=Browserfactory.getbrowser("firefox");
		
		driver.get(Dataproviderfactory.getconfig().getapplicationurl());
		
	}
		
	@Test
	public void testhomepage()
	{
		Homepage home=PageFactory.initElements(driver, Homepage.class);
		
		String title=home.getapplcationtitle();
		
		Assert.assertTrue(title.contains("Demo Store"));
				
		System.out.println("The Title is :"+title);
				
		home.clicklogin();
		
		Loginpage page=PageFactory.initElements(driver, Loginpage.class);
		
		page.loginapplication(Dataproviderfactory.getexcel().getdata(0, 0, 0), Dataproviderfactory.getexcel().getdata(0, 0, 1));
		
		page.clicksignout();
	}
	
	@AfterMethod
	public void teardown()
	{
		Browserfactory.closebrowser(driver);
		
	}
	
}
