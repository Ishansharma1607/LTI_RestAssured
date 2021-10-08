package day2;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GitHub {
  @Test
  public void gettingAllRepoitories() {
	  
	given()
			.auth()
			.oauth2("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")
			.when()
			.get("https://api.github.com/user/repos")
		.then()
		.log()
		.body()
		.statusCode(200);
  }
}
