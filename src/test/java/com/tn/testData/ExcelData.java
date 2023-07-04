package com.tn.testData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelData {
	
	@DataProvider(name = "tutorialsNinja")
	public static Object[][] getRediffData() throws Exception {
		Object[][] data = ExcelData.readDataFromExcel("TN");
		return data;
	}
	
	public static Object[][] readDataFromExcel(String sheetName) throws IOException {
		
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\tn\\testData\\ExcelData_TN.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(ip);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		
		for(int i=0; i<rows; i++) {
			XSSFRow row = sheet.getRow(i+1);
			
		for(int j=0; j<cols; j++) {
			XSSFCell cell = row.getCell(j);
			
			CellType celltype = cell.getCellType();
			
			switch(celltype) {
			
			case STRING:
				data[i][j] = cell.getStringCellValue();
				break;
				
			case NUMERIC:
				data[i][j] = Integer.toString((int)cell.getNumericCellValue());
				break;
				
			case BOOLEAN:
				data[i][j] = cell.getBooleanCellValue();
			}
		}
		}
		
		return data;
	}

}
