package factory;

import dataprovider.ConfigdataProvider;
import dataprovider.ExcelDataprovider;

public class Dataproviderfactory 
{

	
	public static ConfigdataProvider getconfig()
	{
		
		ConfigdataProvider config=new ConfigdataProvider();
		return config;
	}
	
	public static ExcelDataprovider getexcel()
	{
		ExcelDataprovider excel=new ExcelDataprovider();
		return excel;
	}
}
