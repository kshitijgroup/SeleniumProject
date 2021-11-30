package ExcelPractice;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

public class ReadExcelFile {

	public static void main(String[] args) throws Exception {

		String excelFilePath = "SeleniumProject/DataFiles/countries.xlsx";
		FileInputStream fis = new FileInputStream(excelFilePath);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		// *** Using For Loop

//		int rows = sheet.getLastRowNum();
//		int cols = sheet.getRow(1).getLastCellNum();
//
//		for (int r = 0; r <= rows; r++) {
//			XSSFRow row = sheet.getRow(r);
//			for(int c=0;c<cols;c++)
//			{
//				XSSFCell cell=row.getCell(c);
//				
//				switch(cell.getCellType())
//				{
//				case Cell.CELL_TYPE_STRING: System.out.print(cell.getStringCellValue()); break;
//				case Cell.CELL_TYPE_NUMERIC: System.out.print(cell.getNumericCellValue());break;
//				case Cell.CELL_TYPE_BOOLEAN: System.out.print(cell.getBooleanCellValue()); break;
//				}
//				System.out.print(" | ");
//			}
//			System.out.println();
//		}
		
		// *** Using Iterator
		
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			XSSFRow row = (XSSFRow) rowIterator.next();
			
			Iterator<Cell> cellIterator = row.cellIterator();
			while(cellIterator.hasNext()) {
				XSSFCell cell = (XSSFCell) cellIterator.next();
				switch(cell.getCellType())
				{
				case STRING: System.out.print(cell.getStringCellValue()); break;
				case NUMERIC: System.out.print(cell.getNumericCellValue());break;
				case BOOLEAN: System.out.print(cell.getBooleanCellValue()); break;
				}
				System.out.print(" | ");
			}
			System.out.println();
			
		}

	}

}
