package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    Workbook workbook;
    Sheet sheet;

    public ExcelReader(String excelPath, String fileName) {

        try {
            FileInputStream fis = new FileInputStream(excelPath);
            String fileExtension= excelPath.substring(excelPath.indexOf('.'));
            if (fileExtension.equals(".xlsx"))
            workbook = new XSSFWorkbook(fis);
            else if (fileExtension.equals(".xls"))
                workbook = new HSSFWorkbook(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCellData(String sheetName, int row, int column) {

        sheet = workbook.getSheet(sheetName);

        DataFormatter formatter = new DataFormatter();

        return formatter.formatCellValue(sheet.getRow(row).getCell(column));
    }

    public int getRowCount(String sheetName) {

        sheet = workbook.getSheet(sheetName);

        return sheet.getLastRowNum();
    }

    public int getColumnCount(String sheetName) {

        sheet = workbook.getSheet(sheetName);

        return sheet.getRow(0).getLastCellNum();
    }
    

    public Object[][] getData(String sn) {

//        ExcelReader reader =
//                new ExcelReader("src/test/resources/testdata/TestData.xlsx");
    	sheet=workbook.getSheet(sn);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][cols];

        for(int i=1;i<=rows;i++) {

            for(int j=0;j<cols;j++) {

                data[i-1][j] = sheet.getRow(i).getCell(j).toString();
            }
        }

        return data;
    }
}
