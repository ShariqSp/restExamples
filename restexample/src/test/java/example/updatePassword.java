package example;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class updatePassword 
{
  @Test
  void testUpdatePasswords()
  {
	  JSONObject bodyContent = new JSONObject();
	  bodyContent.put("password", "update");
	  
	  given()
	  .header("Content-Type","Application/JSON")
	  .patch("http://apitesting.shariqsp.com:8080/api/users/update/passwod/12")
	  .then()
	  .assertThat()
	  .log();
  }
}
