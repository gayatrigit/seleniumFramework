  package com.crm.qa.util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtill extends TestBase {
	static Workbook book;
	static FileInputStream fis;
	static Sheet sheet;

	public static String TESTDATA_SHEET_PATH="./data/input1.xlsx";
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_TIMEOUT=20;
	
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static void sleepTest() {
		try {
		Thread.sleep(3000);
		}
		catch(Exception e) {}
	}
	
	public static Object[][] getTestData(String sheetName) {
		try {
		fis=new FileInputStream(TESTDATA_SHEET_PATH);
		}
		catch(Exception e) {}
		
		try {
			book=WorkbookFactory.create(fis);
		}
		catch(Exception e) {
		e.printStackTrace();	
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
		
	}
}
