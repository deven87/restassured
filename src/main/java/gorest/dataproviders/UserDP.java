package gorest.dataproviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.github.javafaker.Faker;

import gorest.logger.Log;
import gorest.utilities.ExcelUtility;

public class UserDP {


	@DataProvider(name = "userDP")
	public String[][] userDataProvider() throws IOException {

		Faker faker = new Faker();

		String[][] data = new String[2][4];	

		/*
		data[0][0] = faker.name().fullName();
		data[0][1] = faker.internet().emailAddress();
		data[0][2] = "male";
		data[0][3] = "active";

		data[1][0] = faker.name().fullName();
		data[1][1] = faker.internet().emailAddress();
		data[1][2] = "female";
		data[1][3] = "active";
		 */


		ExcelUtility eu = new ExcelUtility(System.getProperty("user.dir")+"/testdata/Book1.xlsx");

		for(int i = 1; i < 3; i++) {

			for (int j = 0; j < 4; j++) {


				data[i-1][j] = eu.getCellValue("Sheet1", i, j);

			}
		}


		for(String[] data1: data) {

			for(String data2: data1) {

				Log.logInfo("data is " + data2);
			}

		}

		return data;

	}

	public static void writeID(int id, int counter) throws IOException {

		ExcelUtility eu = new ExcelUtility(System.getProperty("user.dir")+"/testdata/Book1.xlsx");


		eu.writeCellValue("Sheet2", counter, 0, String.valueOf(id));


	}

	@DataProvider(name="idDP")
	public String[] idDataProvider() throws IOException {


		String[] idArray = new String[2];
		ExcelUtility eu = new ExcelUtility(System.getProperty("user.dir")+"/testdata/Book1.xlsx");

		for	(int i = 0; i < 2; i++) {

			idArray[i] = eu.getCellValue("Sheet2", i, 0);

		}

		return idArray;


	}

}
