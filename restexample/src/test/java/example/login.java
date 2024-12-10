package example;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class login {
	
	
	@Test
	void testLogin()
	{
		userData ud = new userData();
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
