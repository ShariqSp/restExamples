package admin;
import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
 
@Listeners(MyTestListener.class)
 class MyTest	 {

    @Test
    public void testMethod1() {
    	given()
        .get("http://apitesting.shariqsp.com:8080/api/companies")
        .then()
        .log()
        .all();
    Response res =  given()
     .get("http://apitesting.shariqsp.com:8080/api/companies")
     ;
    if (res.statusCode() == 200) {
        // Extract the names using JSONPath
        JsonPath jsonPath = res.jsonPath();
        // Get all company names
        List<String> brands = jsonPath.getList("$.[*].mobileItems[0].brand");
        
        // Print the names
        System.out.println("Company Names: " + brands);
    } else {
        System.out.println("Failed to fetch data. Status Code: " + res.statusCode());
    }

    }

    
}

// Listener implementation
