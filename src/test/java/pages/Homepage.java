package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage 
{

	WebDriver driver;
	
	public Homepage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	
	@FindBy(xpath="//a[text()='Home']") WebElement home;
	
	@FindBy(xpath="//a[text()='My Account']")WebElement myaccount;
	
	@FindBy(xpath="//a[text()='Wishlist']")WebElement wishlist;
	
	@FindBy(xpath="//a[text()='My Cart (0)']")WebElement mycart;
	
	@FindBy(xpath="//a[text()='Log In']")WebElement login;
	
	@FindBy(xpath="//a[text()='Checkout']")WebElement checkout;
	
	
	
	public void clicklogin()
	{
		
		login.click();
		
	}
	
	public void clickhome()
	{
		
		home.click();
		
	}
	
	public void clickmycart()
	{
		
		mycart.click();
		
	}
	
	public String getapplcationtitle()
	{
		return driver.getTitle();
	}
	
		
	
	
	
	
	
}
