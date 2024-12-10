package example;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class updateTest 
{
   @Test
   void testUpdate()
   {
	   JSONObject bodyContent = new JSONObject();
	   bodyContent.put("id", 12);
	   bodyContent.put("username", "testinggss");
	   bodyContent.put("email", "testing@shariqsp.com");
	   bodyContent.put("mobile", "98765434565");
	   bodyContent.put("password", "98765");
	   
	   given()
	   .header("Content-Type","Application/JSON")
	   .body(bodyContent.toString())
	   .put("http://apitesting.shariqsp.com:8080/api/users/update/12")
	   .then()
	   .assertThat()
	   .statusCode(200)
	   .log();
   }
}
