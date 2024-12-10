package example;

	 // Import Rest Assured classes
   
    import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
    
    public class getUsers {
    
    	@Test
    	public void testGetAllUsers() {
    	    Response resp = RestAssured.get("http://apitesting.shariqsp.com:8080/api/users/all");
    	    System.out.println(resp.asPrettyString()); // Use this to format the response as a string and print it once
    	}

    }

