package example;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class requestChainingTest {
	@Test
	void requestTest()
	{
		JSONObject payload = new JSONObject();
		payload.put("username", "test1");
		payload.put("email", "me@shariqsp.com");
		payload.put("phone", "1231231231");
		payload.put("password", "1234");
			
	
		
		Response data = given()
		   .header("Content-Type","application/JSON")
		   .body(payload.toString())
		   .post("http://apitesting.shariqsp.com:8080/api/users/register")
		   ;		
		
		int id =data.jsonPath().get("id");
		
		System.out.println(id);
		given()
		   .header("Content-Type","application/JSON")
		   .delete("http://apitesting.shariqsp.com:8080/api/users/delete/"+id)
		   .then()
		   .log()
		   .all()
		   ;
		
	}
}
