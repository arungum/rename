package test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.ResourceBundle;


import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

public class ApiTokenExample {
	
	
    @Test(priority = 1)
    public void testApiWithToken() {
    	ResourceBundle rs=ResourceBundle.getBundle("sample");
    	String string = rs.getString("test");
    	System.out.println("/////////////////"+string);
    	RestAssured.baseURI="https://reqres.in/";
    	
    Response response = RestAssured.given().when().get("/api/users/2");
    String string1 = response.getBody().asString();
    
    int code = response.getStatusCode();
    
    System.out.println(code);
    System.out.println(string1);
    }
    int string99;
    
    @Test(priority = 2)
    public void testApiWithToken1() {
    	RestAssured.baseURI="https://reqres.in/";
    	String body="{\r\n"
    			+ "    \"name\": \"morpheus\",\r\n"
    			+ "    \"job\": \"leader\"\r\n"
    			+ "}";
    	
    Response response1 = RestAssured.given().body(body).when().post("/api/users");
    String string9 = RestAssured.given().body(body).when().post("/api/users").then().extract().path("id").toString();
    string99=Integer.parseInt(string9);
    System.out.println("////////////"+string9);
    System.out.println("////////////"+string99);
    
    String string2 = response1.getBody().asString();
    
    int code1= response1.getStatusCode();
    
    System.out.println(code1);
    System.out.println(string2);
    System.err.println(string99);
    response1.then().statusCode(201);
    
    }
    @Test(priority = 3,enabled = true)
    public void testApiWithToken2() {
    	RestAssured.baseURI="https://reqres.in/";
    	System.out.println(".............."+string99);
    	RestAssured.given().delete("/api/users/"+ string99).then().statusCode(204);
    	
    	// RestAssured.given().get("/api/users/"+string99).then().statusCode(404);
    	 
    	 //System.err.println(statusCode);
    	Faker fb=new Faker();
    	String name = fb.name().firstName();
    	System.err.println(name);
    
    }
}