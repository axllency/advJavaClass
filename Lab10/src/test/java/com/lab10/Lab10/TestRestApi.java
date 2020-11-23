package com.lab10.Lab10;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestRestApi {

	@Test
	public void getUser()
	{
		RestAssured.baseURI="https://gorest.co.in/public-api/users";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET,"/123");
		String res = response.getBody().asString();
		System.out.println("Response is " + res);
			int statusCode = response.statusCode();
			Assert.assertEquals(statusCode, 200);
		}

	@Test
	public void addCustomer(){
		RestAssured.baseURI=("http://dummy.restapiexample.com/api/v1");
		RequestSpecification httprequest = RestAssured.given();
		JSONObject reqparams = new JSONObject();
		reqparams.put("name", "btest");
		reqparams.put("salary", "3000");
		reqparams.put("age", "23");
		httprequest.header("Content-Type","application/json");
		httprequest.body(reqparams.toJSONString());
		Response response = httprequest.request(Method.POST, "/create");
		String res = response.getBody().asString();
		System.out.println("Response is " + res);
			int statusCode = response.statusCode();
			Assert.assertEquals(statusCode, 200);
			String statusMessage = response.jsonPath().get("status");
			Assert.assertEquals(statusMessage, "success");
		}


}
