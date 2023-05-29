/**
 * 
 */
package gorest.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.github.javafaker.Faker;

import gorest.logger.Log;
import gorest.payloads.UserPayload;
import gorest.pomEndpoints.UserEndPoints;
import gorest.reports.ExtentReport;
import gorest.utilities.ReadConfig;

/**
 * @author intelligent
 *
 */
public class Base {


	Faker faker;
	UserPayload up;

	@BeforeSuite
	public void beforeSuite() {

		System.out.println("inside beforesuite");

		Log.logInfo("inside beforeSuite");

		// reading property file
		ReadConfig.readProperties();

		ExtentReport.startReporting();

	}

	@AfterSuite
	public void afterSuite(){

		System.out.println("inside afterSuite");

		ExtentReport.getReport().flush();

	}

	@BeforeClass
	public void beforeClass() {

		Log.logInfo("inside beforeClass");

		up = new UserPayload();
		faker = new Faker();
		up.setName(faker.name().fullName());
		up.setGender("male");
		up.setEmail(faker.internet().safeEmailAddress());
		up.setStatus("active");

	}


}
