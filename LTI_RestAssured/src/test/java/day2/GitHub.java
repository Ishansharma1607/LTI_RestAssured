//https://api.github.com/user/repos


package day2;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class GitHub {
	
	
	@BeforeTest
	public void beforeTest() {
		baseURI= "https://api.github.com/user/repos";
		authentication= oauth2("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");
		
		
	}
	
	 @Test(enabled=false)
	  public void gettingAllRepositories() {
		   get()
	.then()
		  .log()
		  .body()
		  .statusCode(200);
	  }
	
	
  @Test(enabled=true)
  public void createRepositories() {
	  
	  JSONObject data = new JSONObject();
	
		
		data.put("name", "RestAssuredCreations3");
		data.put("description", "I am Created By RestAssured Tool");
		data.put("homepage", "https://github.com/Ishansharma1607");
	  
	given()
//			.auth()
//			.oauth2("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")
			.header("Content-Type","application/json")
			.body(data.toJSONString())
	//System.out.println(data.toJSONString());
	.when()
			.post()
	.then()
		.log()
		.body()
		.statusCode(201);
			
		//.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);
  }



 
	 
}
