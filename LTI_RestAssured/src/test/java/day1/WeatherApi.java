package day1;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.ParamConfig;
import io.restassured.response.Response;

public class WeatherApi {
	@Test(enabled = false, description = "Getting Weather onformation of Specific City")
	public void getWeather() {

		RestAssured.given() // Some Pre-Condition Like Authentication
				.when() // Performs Some Steps
				.get("https://api.openweathermap.org/data/2.5/weather?q=Bulandshahr&appid=394d52b8a88d8d95aa17bfee802be00b")
				.then() // Some Post-Condition
				.log() // Print Data in console
				.body().statusCode(200);
	}

	@Test(description = "Getting Weather information of Specific City")
	public void getWeather2() {

		Response res = RestAssured.given() // Some Pre-Condition Like Authentication
				.when() // Performs Some Steps
				.get("https://api.openweathermap.org/data/2.5/weather?q=Bulandshahr&appid=394d52b8a88d8d95aa17bfee802be00b");
		System.out.println(res.prettyPrint());
		System.out.println(res.getTime());
		System.out.println(res.getStatusCode());
		System.out.println(res.getContentType());
		Assert.assertEquals(res.getStatusCode(), 200, "Test Failed");

	}

	@Test(description = "Getting Weather information of Specific City")
	public void getWeather3() {

		Response res = RestAssured.given().queryParam("q", "Bulandshahr")
				.queryParam("appid", "394d52b8a88d8d95aa17bfee802be00b")
				// Some Pre-Condition Like Authentication
				.when() // Performs Some Steps
				.get("https://api.openweathermap.org/data/2.5/weather");
		System.out.println(res.prettyPrint());
		System.out.println(res.getTime());
		System.out.println(res.getStatusCode());
		System.out.println(res.getContentType());
		Assert.assertEquals(res.getStatusCode(), 200, "Test Failed");

	}

	@Test(description="Getting Weather information of Specific City")
	public void getWeather4() {
		Map<String,String> param = new HashMap<String, String>();
		param.put("q", "Bulandshahr");
		param.put("appid", "394d52b8a88d8d95aa17bfee802be00b");
				
				RestAssured.given() 
				.queryParams(param)
				
																//Some Pre-Condition Like Authentication
		.when()			//Performs Some Steps
		.get("https://api.openweathermap.org/data/2.5/weather")
		 .then()			//Some Post-Condition
			.log() //Print Data in console
			.body()
			.statusCode(200);
		
	}

}
