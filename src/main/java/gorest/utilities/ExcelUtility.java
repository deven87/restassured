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

public class ExcelUtility {




	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;

	String path;

	public ExcelUtility(String path) {

		this.path = path;
	}


	public int getRowCount(String sheetName) throws IOException {

		fis = new FileInputStream(this.path);
		workbook = new XSSFWorkbook(this.path);

		sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();

		workbook.close();
		fis.close();

		return rowCount;

	}


	public int getCellCount(String sheetName, int rowNumber) throws IOException {

		fis = new FileInputStream(this.path);

		workbook = new XSSFWorkbook(fis);

		sheet = workbook.getSheet(sheetName);

		int cellCount = sheet.getRow(rowNumber).getLastCellNum();

		workbook.close();
		fis.close();

		return cellCount;

	}

	public String getCellValue(String sheetName, int rowNumber, int colNumber) throws IOException {

		fis = new FileInputStream(this.path);

		workbook = new XSSFWorkbook(fis);

		sheet = workbook.getSheet(sheetName);

		row = sheet.getRow(rowNumber);

		cell = row.getCell(colNumber);

		DataFormatter df = new DataFormatter();

		String data;

		try {

			data = df.formatCellValue(cell);

		} catch (Exception e) {

			data = "";
		}

		workbook.close();
		fis.close();


		return data;

	}

	public void writeCellValue(String sheetName, int rowNumber, int colNumber, String data) throws IOException {


		File f = new File(this.path);

		if(!f.exists()) {

			workbook = new XSSFWorkbook();
			fos = new FileOutputStream(this.path);
			workbook.write(fos);
		}

		fis = new FileInputStream(this.path);

		workbook = new XSSFWorkbook(fis);

		if (workbook.getSheetIndex(sheetName) == -1) {

			workbook.createSheet(sheetName);

		}

		sheet = workbook.getSheet(sheetName);

		if (sheet.getRow(rowNumber) == null) {

			sheet.createRow(rowNumber);
		}

		row = sheet.getRow(rowNumber);

		cell = row.createCell(colNumber);

		cell.setCellValue(data);
		fos = new FileOutputStream(this.path);
		workbook.write(fos);

		workbook.close();
		fos.close();

	}
}
