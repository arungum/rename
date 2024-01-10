package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class apiChaing {
	@Test
	public void grtListUser() {
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="api/users";
		RequestSpecification fr=RestAssured.given().header("content-Type", "application/json")
		.queryParam("page", "2");
		Response request = fr.request(Method.POST);
		
		String string = request.then().log().all().toString();
		
		System.out.println(string);
		
	}

}
