package ExcelPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {

	public static void main(String[] args) throws Exception {

		String filePath = "SeleniumProject/DataFiles/Voting.xlsx";
		FileInputStream fis = new FileInputStream(filePath);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);

		int rows = sheet.getLastRowNum();
		System.out.println(" Total number of rows present in the sheet : " + rows);

		// get column count present in the sheet
		int colcount = sheet.getRow(1).getLastCellNum();
		System.out.println(" Total number of columns present in the sheet : " + colcount);

		for (int i = 1; i <= rows; i++) {
			XSSFCell cell = sheet.getRow(i).getCell(1);
			String cellText = "";
			if (cell.getCellType() == CellType.NUMERIC) {
				cellText = String.valueOf(cell.getNumericCellValue());
			} else if (cell.getCellType() == CellType.STRING) {
				cellText = cell.getStringCellValue();
			}
			if(Double.parseDouble(cellText)>=18)
			 {
				 sheet.getRow(i).getCell(2).setCellValue("Major");
			 }
			 else
			 {
				 sheet.getRow(i).getCell(2).setCellValue("Minor");
			 }
		}
		fis.close();
		FileOutputStream fout = new FileOutputStream(filePath);
		wb.write(fout);
		wb.close();
		fout.close();

		System.out.println("File updated successfully");
	}

}
