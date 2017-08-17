package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Homepage;
import factory.Browserfactory;
import factory.Dataproviderfactory;

public class VerifyHomepage 
{

	WebDriver driver;
	
	
	@BeforeMethod
	public void setUP()
	{		
		driver=Browserfactory.getbrowser("chrome");
		
		driver.get(Dataproviderfactory.getconfig().getapplicationurl());
		
	}
		
	@Test
	public void testhomepage()
	{
		Homepage home=PageFactory.initElements(driver, Homepage.class);
		
		String title=home.getapplcationtitle();
		
		Assert.assertTrue(title.contains("Demo Store"));
		
		System.out.println("The Title is :"+title);
			
	}
	
	@AfterMethod
	public void teardown()
	{
		Browserfactory.closebrowser(driver);
		
	}
	
}
