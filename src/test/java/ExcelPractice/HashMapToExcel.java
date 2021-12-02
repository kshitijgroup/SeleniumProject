package ExcelPractice;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashMapToExcel {

	public static void main(String[] args) throws Exception {
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Student Data");
		
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("John", "101");
		hm.put("Smith", "102");
		hm.put("Jane", "103");
		hm.put("Anderson", "104");
		
		int rownum=0;
		
		for(Entry<String, String> entry : hm.entrySet()) {
			
			XSSFRow row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(entry.getKey());
			row.createCell(1).setCellValue(entry.getValue());
		}
		
		FileOutputStream fout = new FileOutputStream("SeleniumProject/DataFiles/Student.xlsx");
		wb.write(fout);
		wb.close();
		fout.close();
		
		System.out.println("File created successfully");
	}

}
