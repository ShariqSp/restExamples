package example;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class registerUser 
{
   @Test
   public void RegisterUser()
   {
	   userData ud = new userData();
	   JSONObject bodyContent = new JSONObject();
	   bodyContent.put("id", ud.getId());
	   bodyContent.put("username", ud.getUsername());
	   bodyContent.put("email", ud.getEmail());
	   bodyContent.put("mobile", ud.getMobile());
	   bodyContent.put("password", ud.getPassword());
	   
	   given()
	   .header("Content-Type","application/JSON")
	   .body(bodyContent.toString())
	   .post("http://apitesting.shariqsp.com:8080/api/users/register")
	   .then()
	   .assertThat().statusCode(200);
	   ;
	   
   }
}
