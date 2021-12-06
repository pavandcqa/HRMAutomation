package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	
	public static void main(String args[]) throws IOException {
		
		
		File f = new File("./testData.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet("Credentials");
		
		System.out.println(sheet.getLastRowNum());
		
//		XSSFRow row = sheet.getRow(1);
//		
//		String data = row.getCell(0).getStringCellValue();
//		
//		System.out.println(data);
		
		
		for(int i = 0; i<=sheet.getLastRowNum(); i++) {
			
			String data = sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(data);
		}
		wb.close();
	}
	
}
