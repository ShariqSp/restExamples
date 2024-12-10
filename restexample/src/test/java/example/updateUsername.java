package example;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class updateUsername 
{
   @Test
   void testUpdateUserName()
   {
	   JSONObject bodyContent = new JSONObject();
	   bodyContent.put("username", "updated");
	   
	   given()
	   .header("Content-Type","Application/JSON")
	   .body(bodyContent.toString())
	   .patch("http://apitesting.shariqsp.com:8080/api/users/update/username/12")
	   .then()
	   .assertThat()
	   .statusCode(200)
	   .log();
   
   }
}
