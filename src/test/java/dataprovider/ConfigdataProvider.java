package dataprovider;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ConfigdataProvider 
{

	Properties pro;
	
	public ConfigdataProvider()
	{
		File src=new File("./configuration/configa.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			
			pro=new Properties();
			
			pro.load(fis);
		} 
		 catch (IOException e) 
		{
		System.out.println(e.getMessage());
		}
		
	}
	
	public String getapplicationurl()
	{
		
		String url=pro.getProperty("url");
		return url;
	}
	
	public String getchromepath()
	{
		
		String url=pro.getProperty("chrome");
		return url;
	}
	public String getfirefoxpath()
	{
		
		String url=pro.getProperty("firefox");
		return url;
	}
	public String getiepath()
	{
		
		String url=pro.getProperty("iepath");
		return url;
	}
	
	
}
