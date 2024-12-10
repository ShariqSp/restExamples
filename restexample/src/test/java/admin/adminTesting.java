package admin;

import static io.restassured.RestAssured.*;

import java.util.Base64;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class adminTesting {
	 @Test
     public void testAddAdmin() {
			JSONObject bodyContent = new JSONObject();
	
			bodyContent.put("id", "123");
			bodyContent.put("username", "admin");
			bodyContent.put("password", "password");
			
		    given()
		    .header("Content-Type","application/JSON")
		    .body(bodyContent.toString())
		    .post("http://apitesting.shariqsp.com:8080/api/admin/add")
		    .then()
		    .assertThat()
		    .statusCode(201)
		    .log();
     }
	 @Test
     public void testLoginAdmin() {
			
		 String originalInput = "admin:password";
         String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
         System.out.println("Base64 Encoded: " + encodedString);
			
         given()
         .header("Authorization", "Basic " + encodedString)
		    .post("http://apitesting.shariqsp.com:8080/api/admin/login")
		    .then()
		    .assertThat()
		    .statusCode(200)
		    .log()
		    .all();
     }
	 
	 @Test
	 public void displayAdmins()
	 {
		 given()
		 .get("http://apitesting.shariqsp.com:8080/api/admin/all")
		 .then()
		 .log()
		 .all();
	 }
	 
	 @Test
	 public void deleteAdmin()
	 {
		 given()
		 .delete("http://apitesting.shariqsp.com:8080/api/admin/2")
		 .then()
		 .log()
		 .all();
	 }
	 
	 
	 
}
