package example;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class testingcomapaniesTest 
{
   @Test
   void testComp() {
	  given()
	  .get("http://apitesting.shariqsp.com:8080/api/companies")
	  .then()
	  .log()
	  .all();
   }
}
