package com.kpmg.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataSource {

	@DataProvider(name = "validLoginData")
	public String[][] loginCredentials() throws Exception {

		/*
		 * String[][] loginDetails = new String[2][4];
		 * 
		 * loginDetails[0][0] = "admin"; loginDetails[0][1] = "pass"; loginDetails[0][2]
		 * = "18"; loginDetails[0][3] = "Calendar";
		 * 
		 * loginDetails[1][0] = "physician"; loginDetails[1][1] = "physician";
		 * loginDetails[1][2] = "18"; loginDetails[1][3] = "Calendar";
		 * 
		 * return loginDetails;
		 */

		FileInputStream file = new FileInputStream("src/test/resources/test-data/Open-EMR-data.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("validLoginTest");
		/*
		 * String value = sheet.getRow(1).getCell(0).getStringCellValue();
		 * System.out.println(value);
		 */

		int rowlength = sheet.getPhysicalNumberOfRows();

		int columnlength = sheet.getRow(0).getPhysicalNumberOfCells();

		// System.out.println(rowlength);
		// System.out.println(columnlength);

		String[][] logindata = new String[rowlength - 1][columnlength];

		for (int i = 0; i < rowlength - 1; i++) {

			for (int j = 0; j < columnlength; j++) {
				DataFormatter type = new DataFormatter();
				logindata[i][j] = type.formatCellValue(sheet.getRow(i + 1).getCell(j));
				// String value = sheet.getRow(i).getCell(j).getStringCellValue();
				// System.out.println(value);
			}

		}

		book.close();
		file.close();

		/*
		 * for(String[] logData:logindata) {
		 * System.out.println(Arrays.toString(logData)); }
		 */
		return logindata;
	}

	@DataProvider
	public Object[][] commonDataProvider(Method mtd) throws Exception 
	{
		String sheetName=mtd.getName();
		Object[][] data= ExcelUtilities.loginDatatwodimensional("src/test/resources/test-data/Open-EMR-data.xlsx",sheetName);
		return data;
	}
}
	
	
	