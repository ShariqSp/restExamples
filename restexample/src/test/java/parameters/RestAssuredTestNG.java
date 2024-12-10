package parameters;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestAssuredTestNG {

    private static String token;

    @BeforeClass
    public void setup() {
        // Set base URI and port for the API
        RestAssured.baseURI = "http://http://apitesting.shariqsp.com:8080/";
       
    }

    @Test(priority = 1)
    public void generateToken() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"username\": \"inventory\", \"password\": \"password\"}") // Replace with actual credentials
                .post("/authenticate"); // Endpoint to generate token

        Assert.assertEquals(response.statusCode(), 200, "Token generation failed!");

        // Extract token from response
        token = response.jsonPath().getString("token");
        System.out.println("Generated Token: " + token);

        Assert.assertNotNull(token, "Token is null!");
    }

    @Test(priority = 2, dependsOnMethods = {"generateToken"})
    public void addItem() {
        // Request body for adding inventory item
        String requestBody = "{\"itemName\": \"iphone\", \"quantity\": 20}";

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/inventory"); // Endpoint to add inventory item

        // Assert that the item was added successfully
        Assert.assertEquals(response.statusCode(), 201, "Failed to add inventory item!");
        System.out.println("Response: " + response.asString());
    }
}
