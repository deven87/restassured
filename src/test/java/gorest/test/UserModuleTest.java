package gorest.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;

import gorest.logger.Log;
import gorest.pomEndpoints.UserEndPoints;
import gorest.reports.ExtentReport;
import io.restassured.response.Response;

public class UserModuleTest extends Base{


	Faker faker;
	UserEndPoints uep = new UserEndPoints();
	int id;


	@Test (priority = 1, enabled = false)
	public void createUserTest() {

		Log.logInfo("inside createUserTest");

		Response res = uep.createUser(up);

		System.out.println("response is " + res.asPrettyString());

		id = res.jsonPath().getInt("id");

		Assert.assertEquals(res.getStatusCode(), 201);

		Log.logInfo("created user with id " + id);

	}

	@Test (priority = 2, enabled = false)
	public void getUserTest() {

		Log.logInfo("getting user with id " + id);

		Log.logInfo("inside get user details");

		Response res = uep.readUser(id);

		System.out.println("response is " + res.asPrettyString());

		Assert.assertEquals(res.getStatusCode(), 200);


	}

	@Test
	public void myTestUserModule() {
		
		Log.logInfo("myTestUserModule");
		ExtentReport.getTest().log(Status.INFO, "myTestUserModule info");
		
		Assert.assertTrue(true);

	}
	@Test
	public void myTestUserModule1() {
		
		Log.logInfo("myTestUserModule1");
		ExtentReport.getTest().log(Status.INFO, "myTestUserModule1 info");
		
		Assert.assertTrue(false);

	}

}
