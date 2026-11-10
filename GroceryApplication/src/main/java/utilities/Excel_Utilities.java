package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class Excel_Utilities {
	static FileInputStream f; //to read excel file from our system
 	static XSSFWorkbook w;  // to access entire excel workbook
 	static XSSFSheet sh; //to access sheet1 from the excel
  
 	public static String readStringData(int row, int col, String sheet) throws IOException { 
 		f = new FileInputStream(Constant.TEST_DATA);//to read the excel file path from the Constant class
 		w = new XSSFWorkbook(f); //to load excel file into memory using apache poi
 		sh = w.getSheet(sheet); //to select sheet1 from the excel workbook
 		XSSFRow r = sh.getRow(row); //to get the row based on the row number as in the parameter
 		XSSFCell c = r.getCell(col); // to get the cell based on the column number as in the parameter
 		return c.getStringCellValue(); //to return in the form of string
  
 	} 
  
 	public static String readIntegerData(int row, int col, String sheet) throws IOException { 
 		f = new FileInputStream(Constant.TEST_DATA); //to read the excel file path from the Constant class
 		w = new XSSFWorkbook(f); 
 		sh = w.getSheet(sheet); 
 		XSSFRow r = sh.getRow(row); 
 		XSSFCell c = r.getCell(col); 
 		int val =   (int) c.getNumericCellValue();  //convert double to int using typecasting 
 		return String.valueOf(val);   //convert int to string using valueOf() method 
  
 	 
 	} 


}
