package parameters;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class bearerTest 
{
	String token;
	
	@Test
	void aBearerToken()
	{
	 token = RestAssured.given()
            .post("http://apitesting.shariqsp.com:8080/inventory/token")
            .then()
            .statusCode(200)
            .log()
            .all()
            .extract()
            .asString()
            ;
        System.out.println("Generated Token: " + token);
	}
	
	@Test
	void bBearerTokenPost()
	{
		
		 System.out.println("test2");
		 JSONObject newItem = new JSONObject();
		 newItem.put("itemName", "samsung");
		 newItem.put("id", "1234");
		 newItem.put("quantity", "10");
		
		 RestAssured.given()
		    .auth().oauth2(token)
		    .contentType(ContentType.JSON)
		    .body(newItem.toString())
		    .post("http://apitesting.shariqsp.com:8080/inventory")
		    .then()
		    .log().all()  // Logs response details
		    .statusCode(200);


	}
	
	@Test
	void cBearerTokenGet()
	{
		Response response = RestAssured.given()
				.auth().oauth2(token)
				.get("http://apitesting.shariqsp.com:8080/inventory")
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .response();
            System.out.println("Inventory Items: " + response.asString());
	}
}
