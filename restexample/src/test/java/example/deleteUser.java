package example;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class deleteUser 
{
   @Test
   void deleteUser()
   {
	  given()
	  .delete("http://apitesting.shariqsp.com:8080/api/users/delete/12")
	  .then()
	  .assertThat()
	  .statusCode(200)
	  .log();
   }
}
