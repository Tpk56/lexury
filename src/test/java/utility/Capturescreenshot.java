package utility;

import java.io.File;


import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Capturescreenshot 
{


		
	public static String screenshot(WebDriver driver, String screenshotname)
	{
			TakesScreenshot ts=(TakesScreenshot)driver;	
					
			File src=ts.getScreenshotAs(OutputType.FILE);
			
			String designation="C:\\Users\\net\\Desktop\\DESIGNING_HYBRID_FRAMWORK\\Com.Hydridframework.com\\Screenshot\\"+screenshotname+System.currentTimeMillis()+".png";
				
			try 
			{
				FileUtils.copyFile(src, new File(designation));
			} 
			
			catch (IOException e)
			{
				System.out.println(e.getMessage());
			}
			
			return designation;
				
	}
	
}
