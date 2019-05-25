package com.selenium.testproject.testproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWriteExample {

	public static void main(String[] args) throws Exception {

		FileInputStream fis = new FileInputStream("C:\\Users\\kschaudhary\\Desktop\\FrameworkQueries.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("Sheet1");

		int rowCount = sheet.getLastRowNum();
		System.out.println("Total number of rows in the sheet are: " + rowCount);

		int colCount = sheet.getRow(1).getLastCellNum();
		System.out.println("Total number of columns in the sheet are: " + colCount);

		for (int i = 1; i < rowCount; i++) {

			XSSFCell cell = sheet.getRow(i).getCell(1);
			String cellText = "";

			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				cellText = cell.getStringCellValue();
			} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				cellText = String.valueOf(cell.getNumericCellValue());
			}
			
			if (Double.parseDouble(cellText) >= 18) {
				sheet.getRow(i).getCell(2).setCellValue("Major");
			} else {
				sheet.getRow(i).getCell(2).setCellValue("Minor");
			}
		}

		FileOutputStream fout = new FileOutputStream("C:\\Users\\kschaudhary\\Desktop\\FrameworkQueriesUpdated.xlsx");
		wb.write(fout);
		fout.flush();
		
		System.out.println("********Execution completed*******");
	}

}
