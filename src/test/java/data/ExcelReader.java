package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class ExcelReader {
	static FileInputStream fis = null;
	
	
	
	public FileInputStream getFileInputStream()
	{
		String filepath = "C:\\Users\\Amine\\eclipse-workspace\\taf\\src\\test\\java\\data\\userdatafromexcel.xlsx"; 
		//C:\Users\Amine\eclipse-workspace\taf\src\test\java\data\
		File srcfile = new File(filepath);
		try {
			fis = new FileInputStream(srcfile);
			
		} catch (FileNotFoundException e) {

			System.out.println("error = "+e.getMessage());
			System.exit(0);
		}
		System.out.println("created ....");
		return fis;
	}

	public Object[][] getExcelData() throws IOException
	{

		fis =  getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("registration");
		int totalnumberofrows = 5;
		int totalnumberofcolumn = 5;
		
		String[][] arrayExcelData = new String[totalnumberofrows][totalnumberofcolumn];
		
		for (int i = 0; i < totalnumberofrows; i++) 
		{
			for (int j = 0; j < totalnumberofcolumn; j++) 
			{
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString();
			}
			System.out.println("i m here ....");
		}
		wb.close();
		return arrayExcelData;
	}
}
