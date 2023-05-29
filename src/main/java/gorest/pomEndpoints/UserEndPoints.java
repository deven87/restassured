package gorest.pomEndpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import gorest.logger.Log;
import gorest.payloads.UserPayload;
import gorest.payloads.UserPayload2;
import gorest.utilities.ReadConfig;

public class UserEndPoints {


	public Response createUser(UserPayload payload) {



		Response response = given().auth().oauth2(ReadConfig.getProperty("authToken")).contentType(ReadConfig.getProperty("contentType")).
				body(payload).when().post(Routes.getPostUrl());

		return response;


	}

	public Response readUser(int id) {		

		Response response = given().auth().oauth2(ReadConfig.getProperty("authToken")).contentType(ReadConfig.getProperty("contentType")).pathParam("id", id)
				.when().get(Routes.getGetUrl());

		return response;

	}

	public Response deleteUser(int id) {

		Log.logInfo("inside deleteUser");


		Response response = given().auth().oauth2(ReadConfig.getProperty("authToken")).contentType(ReadConfig.getProperty("contentType")).pathParam("id", id)

				.when().delete(Routes.getDeleteUrl());

		return response;
	}

	public Response updateUser(int id, UserPayload payload) {

		Log.logInfo("inside updateUser");


		Response response = given().auth().oauth2(ReadConfig.getProperty("authToken")).contentType(ReadConfig.getProperty("contentType")).pathParam("id", id)
				.body(payload)
				.when().put(Routes.getGetUrl());

		return response;
	}

	public Response patchUser(int id, UserPayload2 payload) {

		Log.logInfo("inside patchUser");


		Response response = given().auth().oauth2(ReadConfig.getProperty("authToken")).contentType(ReadConfig.getProperty("contentType")).pathParam("id", id)
				.body(payload)
				.when().patch(Routes.getGetUrl());

		return response;
	}




}
