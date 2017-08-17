package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.Homepage;
import pages.Loginpage;
import utility.Capturescreenshot;
import factory.Browserfactory;
import factory.Dataproviderfactory;

public class VerifyLoginpageReportswithScreenshot 
{

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUP()
	{		
		report=new ExtentReports("./Reports/loginpage.html",true);
		
		logger=report.startTest("Login page Test started");
			
		driver=Browserfactory.getbrowser("chrome");
		
		driver.get(Dataproviderfactory.getconfig().getapplicationurl());
		
		logger.log(LogStatus.INFO, "Application is up and running");
		
	}
		
	@Test
	public void testhomepage()
	{
		Homepage home=PageFactory.initElements(driver, Homepage.class);
		
		String title=home.getapplcationtitle();
		logger.log(LogStatus.INFO, "Title is verified");
			
		Assert.assertTrue(title.contains("Demo Store"));
		logger.log(LogStatus.PASS, "Home page loaded and verified");
				
		System.out.println("The Title is :"+title);
		logger.log(LogStatus.INFO, "Title is verified successfully");
		
		home.clicklogin();
		
		Loginpage page=PageFactory.initElements(driver, Loginpage.class);
				
		page.loginapplication(Dataproviderfactory.getexcel().getdata(0, 0, 0), Dataproviderfactory.getexcel().getdata(0, 0, 1));
		logger.log(LogStatus.PASS,"Datas passed successfully");	
		logger.log(LogStatus.INFO,logger.addScreenCapture(Capturescreenshot.screenshot(driver,"loginSuccessful")));
		
		page.clicksignout();
		logger.log(LogStatus.INFO,logger.addScreenCapture(Capturescreenshot.screenshot(driver,"logoutSucced")));
		
		
	}
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path=Capturescreenshot.screenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
						
		}
		
		Browserfactory.closebrowser(driver);
		logger.log(LogStatus.INFO, "Browser closed successfuly");
		report.endTest(logger);
		report.flush();
	}
	
}
