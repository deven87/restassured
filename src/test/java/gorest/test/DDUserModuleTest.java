package gorest.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;

import gorest.dataproviders.UserDP;
import gorest.logger.Log;
import gorest.payloads.UserPayload;
import gorest.payloads.UserPayload2;
import gorest.pomEndpoints.UserEndPoints;
import gorest.reports.ExtentReport;
import io.restassured.response.Response;



public class DDUserModuleTest extends Base{


	String[] id;
	int cellValue = 0;

	UserEndPoints uep = new UserEndPoints();

	@Test (priority = 1, dataProvider = "userDP", dataProviderClass = UserDP.class, enabled = false)
	public void createUserTest(String name, String email, String gender, String userStatus) throws IOException {

		Log.logInfo("inside createUserTest");

		UserPayload up = new UserPayload();

		up.setName(name);
		up.setEmail(email);
		up.setGender(gender);
		up.setStatus(userStatus);
		Response response = uep.createUser(up);

		Log.logInfo("created user with id " + response.jsonPath().getInt("id"));

		UserDP.writeID(response.jsonPath().getInt("id"), cellValue);

		cellValue++;

		Log.logInfo("create user response is " + response.asPrettyString());


		Assert.assertEquals(response.statusCode(), 201);


	}

	@Test (priority = 2, enabled = false, dataProvider = "idDP", dataProviderClass = UserDP.class)
	public void getUserTest(String id) {

		Log.logInfo("getting user with id " + id);

		Log.logInfo("inside get user details");

		Response res = uep.readUser(Integer.parseInt(id));

		Log.logInfo("get user response is " + res.asPrettyString());

		Assert.assertEquals(res.getStatusCode(), 200);


	}

	@Test (priority = 3, enabled = false, dataProvider = "idDP", dataProviderClass = UserDP.class)
	public void updateUserTest(String id) {

		Log.logInfo("getting user with id " + id);

		Log.logInfo("inside update user details");

		UserPayload up = new UserPayload();
		Faker faker = new Faker();
		up.setEmail(faker.internet().safeEmailAddress());
		up.setName(faker.name().fullName());
		up.setGender("male");
		up.setStatus("active");

		Response res = uep.updateUser(Integer.parseInt(id), up);

		Log.logInfo("update user response is " + res.asPrettyString());

		Assert.assertEquals(res.getStatusCode(), 200);


	}

	@Test (priority = 4, enabled = false, dataProvider = "idDP", dataProviderClass = UserDP.class)
	public void patchUserTest(String id) {

		Log.logInfo("getting user with id " + id);

		Log.logInfo("inside patch user details");

		UserPayload2 up = new UserPayload2();
		Faker faker = new Faker();
		up.setEmail(faker.internet().safeEmailAddress());
		Response res = uep.patchUser(Integer.parseInt(id), up);

		Log.logInfo("patch user response is " + res.asPrettyString());

		Assert.assertEquals(res.getStatusCode(), 200);


	}



	@Test (priority = 5, enabled = false, dataProvider = "idDP", dataProviderClass = UserDP.class)
	public void deleteUserTest(String id) {

		Log.logInfo("getting user with id " + id);

		Log.logInfo("inside delete user details");

		Response res = uep.deleteUser(Integer.parseInt(id));

		Log.logInfo("delete user response is " + res.asPrettyString());

		Assert.assertEquals(res.getStatusCode(), 204);


	}

	@Test
	public void myTestDDUserModule() {

		Log.logInfo("myTestDDUserModule");
		ExtentReport.getTest().log(Status.INFO, "myTestDDUserModule info");
	}

}
