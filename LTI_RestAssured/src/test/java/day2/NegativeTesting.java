//https://documenter.getpostman.com/view/401288/SWLceUSf?version=latest
//FirstName, LastName, and Email are required
//FirstName and LastName allow only alphabetic characters, plus spaces, hyphens, and apostrophes
//Email must be in standard format
//FirstName is limited to 20 characters
//Email is limited to 50 characters
//All other fields are limited to 30 characters
package day2;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTesting {
	
	@Test(enabled= false,description = "Checking With Missing parameter")
	public void addingContactMissingParameter() {
		
		
		
		JSONObject details = new JSONObject();
		JSONObject loc = new JSONObject();
		JSONObject emp = new JSONObject();
		
		loc.put("city", "Bulandshahr");
		loc.put("country", "India");
		emp.put("jobTitle", "AT");
		emp.put("company", "LTI");
		details.put("firstName", "");
		details.put("lastName", "Sharma");
		details.put("email", "ishan@xyz.com");
		details.put("location", loc);
		details.put("employer", emp);
		
		
		String error = given().header("Content-Type","application/json")
		.body(details.toJSONString())
		.post("http://3.13.86.142:3000/contacts")
		.then()
		.log()
		.body()
		.statusCode(400)
		.extract()
		.path("err");
		
		Assert.assertTrue(error.contains("Contacts validation failed: firstName: First Name is required"));
		
	}
	@Test(enabled= false,description = "Checking With too many charcter in city")
	public void addingTooManyCharacter() {
		
		
		
		JSONObject details = new JSONObject();
		JSONObject loc = new JSONObject();
		JSONObject emp = new JSONObject();
		
		loc.put("city", "BulandshahrBulandshahrBulandshahrBulandshahrBulandshahrBulandshahr");
		loc.put("country", "India");
		emp.put("jobTitle", "AT");
		emp.put("company", "LTI");
		details.put("firstName", "Ishan");
		details.put("lastName", "Sharma");
		details.put("email", "ishan@xyz.com");
		details.put("location", loc);
		details.put("employer", emp);
		
		
		String error = given().header("Content-Type","application/json")
				.body(details.toJSONString())
				.post("http://3.13.86.142:3000/contacts")
				.then()
				.log()
				.body()
				.statusCode(400)
				.extract()
				.path("err");
		//System.out.println(error);
		Assert.assertTrue(error.contains("is longer than the maximum allowed length (30)"));
		
	}
	@Test(enabled= true,description = "Checking With Invalid parameter")
	public void addingInvalidCharacter() {
		
		
		
		JSONObject details = new JSONObject();
		JSONObject loc = new JSONObject();
		JSONObject emp = new JSONObject();
		
		loc.put("city", "Bulandshahr");
		loc.put("country", "India");
		emp.put("jobTitle", "AT");
		emp.put("company", "LTI");
		details.put("firstName", "I@shan");
		details.put("lastName", "Sharma");
		details.put("email", "ishan@xyz.com");
		details.put("location", loc);
		details.put("employer", emp);
		
		
		String error = given().header("Content-Type","application/json")
				.body(details.toJSONString())
				.post("http://3.13.86.142:3000/contacts")
				.then()
				.log()
				.body()
				.statusCode(400)
				.extract()
				.path("err");
		//System.out.println(error);
		Assert.assertTrue(error.contains("Contacts validation failed: firstName: Validator failed for path `firstName` with value"));
		
	}

}
