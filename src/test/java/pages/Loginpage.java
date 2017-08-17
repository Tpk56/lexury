package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage 
{

	WebDriver driver;
	
	
	public Loginpage(WebDriver ldriver)
	{
		this.driver=ldriver;
				
	}
	
	@FindBy(id="account_sign_in_form_email_id")WebElement username;
	
	@FindBy(id="account_sign_in_form_passwd_id")WebElement password;
	
	@FindBy(xpath="//button[@id='send2']")WebElement submit;
	
	By signout=By.xpath("//a[text()='Log Out']");
	
	public void loginapplication(String user,String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.click();
		
	}
	
	public void clicksignout()
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(signout));
		
		driver.findElement(signout).click();
			
	}
}
