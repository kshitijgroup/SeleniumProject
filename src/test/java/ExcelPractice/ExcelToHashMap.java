package ExcelPractice;

import java.util.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToHashMap {
	public static void main(String[] args) throws Exception {
		
		String filePath = "SeleniumProject/DataFiles/Student.xlsx";
		XSSFWorkbook wb = new XSSFWorkbook(filePath);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int rows = sheet.getLastRowNum();
		
		Map<String, String> hm = new HashMap<String, String>();
		
		for(int r=0;r<=rows;r++) {
			
			String key = sheet.getRow(r).getCell(0).getStringCellValue();
			String value = sheet.getRow(r).getCell(1).getStringCellValue();
			hm.put(key,value);
		}
		
		for(Map.Entry<String, String> entry : hm.entrySet()) {
			System.out.println(entry.getKey() +" "+ entry.getValue() );
		}
		wb.close();

	}

}
