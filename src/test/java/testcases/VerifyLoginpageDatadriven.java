package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataprovider.ExcelDataprovider;
import pages.Homepage;
import pages.Loginpage;
import factory.Browserfactory;
import factory.Dataproviderfactory;

public class VerifyLoginpageDatadriven 
{

	WebDriver driver;
	
	
	@BeforeMethod
	public void setUP()
	{		
		driver=Browserfactory.getbrowser("firefox");
		
		driver.get(Dataproviderfactory.getconfig().getapplicationurl());
		
	}
		
	@Test(dataProvider="loginpage")
	public void testhomepage(String user,String pass)
	{
		Homepage home=PageFactory.initElements(driver, Homepage.class);
		
		String title=home.getapplcationtitle();
		
		Assert.assertTrue(title.contains("Demo Store"));
				
		System.out.println("The Title is :"+title);
				
		home.clicklogin();
		
		Loginpage page=PageFactory.initElements(driver, Loginpage.class);
		
		page.loginapplication(user, pass);
		
		page.clicksignout();
	}
	
	@AfterMethod
	public void teardown()
	{
		Browserfactory.closebrowser(driver);
		
	}
	
	
	@DataProvider(name="loginpage")
	public Object[][] passdatas()
	{
		ExcelDataprovider config=new ExcelDataprovider();
		
		int row=config.getrowcount(0);
		
		row=row+1;
		
		Object[][] data=new Object[row][2];
		
		for(int i=0;i<row;i++)
		{
			
			data[i][0]=config.getdata(0, i, 0);
			
			data[i][1]=config.getdata(0, i, 1);
			
		}
				
		return data;
		
	}
		
}

