package dataprovider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataprovider 
{

	XSSFWorkbook wb;
	
	XSSFSheet sheet1;
	public ExcelDataprovider()
	{
		
		try {
			File src=new File("./Applicationdata/appdata.xlsx");
			
			FileInputStream fis=new FileInputStream(src);
			
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) 
		{

			System.out.println(e.getMessage());
		}				
	}
	
	public String getdata(int sheetnumber,int row,int column)
	{
		String data=wb.getSheetAt(sheetnumber).getRow(row).getCell(column).getStringCellValue();
		
		return data;
	}
	
	public int getrowcount(int sheetindex)
	{
		
		int row=wb.getSheetAt(sheetindex).getLastRowNum();
		
		return row;
		
	}
}
