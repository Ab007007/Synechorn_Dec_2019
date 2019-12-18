package com.synechron.selenium.actitime.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils 
{
	
	public static int getNumberofRows(String sheetName) throws EncryptedDocumentException, IOException
	{
		Workbook wb = getWorkbookObject();
		Sheet sh = wb.getSheet(sheetName);
		return sh.getLastRowNum()+1;
	}
	
	private static Workbook getWorkbookObject() throws FileNotFoundException, IOException {
		File file = new File("data\\actitimetestdata.xls");
		FileInputStream fis = new FileInputStream(file);
		
		Workbook wb = WorkbookFactory.create(fis);
		return wb;
	}
	
	public static String getExcelData(String sheetName, int rowNum, int columnNum) throws EncryptedDocumentException, IOException
	{
		Workbook wb = getWorkbookObject();
		Sheet sh = wb.getSheet(sheetName);
		
		Row row  = sh.getRow(rowNum);
		Cell cell = row.getCell(columnNum);
		return cell.toString();
	}
	


}
