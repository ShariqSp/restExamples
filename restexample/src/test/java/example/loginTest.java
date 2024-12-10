package example;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;
public class loginTest {
	
	
	@Test
	void testLogin()
	{
		userDataTest ud = new userDataTest();
		JSONObject bodyContent = new JSONObject();
		bodyContent.put("username", ud.getUsername());
		bodyContent.put("password", ud.getPassword());
		
	    given()
	    .header("Content-Type","application/JSON")
	    .body(bodyContent.toString())
	    .post("http://apitesting.shariqsp.com:8080/api/users/login")
	    .then()
	    .assertThat()
	    .statusCode(200)
	    .log();
		
	}
	
}
