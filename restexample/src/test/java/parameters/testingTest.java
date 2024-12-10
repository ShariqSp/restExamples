package parameters;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class testingTest 
{
	
	 @Test
     public void testSearchEventsByNameAndLocation() {
         given()
             .param("name", "Tech Conference")
             .param("location", "San Francisco")
         .when()
             .get("http://apitesting.shariqsp.com:8080/api/events/searchByNameAndLocation")
         .then()
             .statusCode(200)
             .body("name[0]", Matchers.equalTo("Tech Conference"))
             .body("location[0]", Matchers.equalTo("San Francisco"))
             .log()
             .all();
     }
	
}
