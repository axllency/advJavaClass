package com.hw4.Hw4;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmployeeRestTest {
	/** methods to test:
	 * CREATE: with single employee 
	 * READ: all employees
	 * UPDATE: Single employee (/id)
	 * DELETE: Single employee (/id)
	 */
		
	static String applicationUrl = "http://midtermapplication.us-east-2.elasticbeanstalk.com";
	private int createdTestEmployee;
	
	@Test(priority=2)
	public void createEmployee() {
		RestAssured.baseURI = applicationUrl;
		RequestSpecification httprequest = RestAssured.given();
		
		JSONObject reqparams = new JSONObject();
		reqparams.put("name", "newEmployeeTest");
		reqparams.put("title", "the new guy");
		httprequest.header("Content-Type","application/json");
		httprequest.body(reqparams.toJSONString());
		
		Response response = httprequest.request(Method.POST, "/api/v1/employees");
		String res = response.getBody().asString();
		
		createdTestEmployee = response.getBody().jsonPath().getInt("id");
		
		System.out.println("Response for method 'CREATE' is " + res);
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test(priority=1)
	public void getEmployees() {
		RestAssured.baseURI = applicationUrl;
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET, "/api/v1/employees");
		String res = response.getBody().asString();
		
		System.out.println("Response for method 'READ' is " + res);
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test(priority=3)
	public void updateEmployee() {
		RestAssured.baseURI = applicationUrl;
		RequestSpecification httprequest = RestAssured.given();
		
		JSONObject reqparams = new JSONObject();
		reqparams.put("name", "updateEmployeeTest");
		reqparams.put("title", "the less new guy");
		httprequest.header("Content-Type","application/json");
		httprequest.body(reqparams.toJSONString());
		
		Response response = httprequest.request(Method.PATCH, "/api/v1/employees/" + createdTestEmployee);
		String res = response.getBody().asString();
		
		System.out.println("Response for method 'UPDATE' is " + res);
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test(priority=4)
	public void deleteEmployee() {
		RestAssured.baseURI = applicationUrl;
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.DELETE, "/api/v1/employees/" + createdTestEmployee);
		String res = response.getBody().asString();
		
		System.out.println("Response for method 'DELETE' is " + res);
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);

	}
}
