package com.kpmg.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	
	public static Object[][] loginDatatwodimensional(String filepath, String sheetName) throws Exception {

		FileInputStream file = new FileInputStream(filepath);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet(sheetName);
		DataFormatter type = new DataFormatter();
		int rowlength = sheet.getPhysicalNumberOfRows();

		int columnlength = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[rowlength - 1][columnlength];

		for (int i = 0; i < rowlength - 1; i++) {

			for (int j = 0; j < columnlength; j++) {
				
				data[i][j] = type.formatCellValue(sheet.getRow(i + 1).getCell(j));

			}
		}

		book.close();
		file.close();

		return data;
	}
}
