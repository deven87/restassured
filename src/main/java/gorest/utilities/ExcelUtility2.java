package gorest.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility2 {

	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String path;


	public ExcelUtility2(String path) {

		this.path = path;

	}

	public int rowCount(String sheetName) throws IOException {

		fis = new FileInputStream(this.path);

		workbook = new XSSFWorkbook(fis);

		sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();

		fis.close();
		workbook.close();

		return rowCount;

	}

	public int getCellCount(String sheetName, int rowNumber) throws IOException {

		fis = new FileInputStream(this.path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);

		row = sheet.getRow(rowNumber);

		int cellCount = row.getLastCellNum();

		fis.close();
		workbook.close();

		return cellCount;

	}

	public String getCellData(String sheetName, int rowNumber, int columnNumber) throws IOException {
		fis = new FileInputStream(this.path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		cell = row.getCell(columnNumber);

		DataFormatter df = new DataFormatter();

		String data ;

		try {

			data = df.formatCellValue(cell);

		} catch(Exception e) {

			data = "";
		}


		return data;

	}

	public void writeCellData(String sheetName, int rowNumber, int colNumber, String data) throws IOException {

		File f = new File(this.path);

		if(!f.exists()) {

			fos = new FileOutputStream(f);
			workbook = new XSSFWorkbook();
			workbook.write(fos);
			fos.close();
			workbook.close();

		}

		fis = new FileInputStream(this.path);
		workbook = new XSSFWorkbook(fis);

		if(workbook.getSheetIndex(sheetName) == -1) {

			workbook.createSheet(sheetName);

		}

		sheet = workbook.getSheet(sheetName);

		if(sheet.getRow(rowNumber) == null) {
			sheet.createRow(rowNumber);
		}

		row = sheet.getRow(rowNumber);
		cell = row.getCell(colNumber);

		cell.setCellValue(data);
		fos = new FileOutputStream(this.path);
		workbook.write(fos);

		workbook.close();
		fos.close();
		fis.close();


	}

}