package admin;
// Import necessary libraries
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.*;

public class AdminApiTests {

   

    // Data Provider to fetch data from Excel
    @DataProvider(name = "AdminData")
    public Object[][] getAdminData() throws IOException {
        String filePath = "./lib/realtime_user_credentials.xlsx"; // Update path as needed
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet("user");
        int rowCount = sheet.getLastRowNum();

        Object[][] data = new Object[rowCount][2]; // 2 columns: Username and Password
        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            data[i - 1][0] = row.getCell(0).getStringCellValue(); // Username
            data[i - 1][1] = row.getCell(1).getStringCellValue(); // Password
        }

        workbook.close();
        return data;
    }

    // Test for Adding Admin
    @Test(dataProvider = "AdminData")
    public void testAddAdmin(String username, String password) {
            given()
            .header("Content-Type", "application/json")
            .body("{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}")
            .post("http://apitesting.shariqsp.com:8080/api/admin/add")
		    .then()
		    .assertThat()
		    .statusCode(201)
		    .log()
		    .all();
    }

    // Test for Admin Login
    @Test(dataProvider = "AdminData")
    public void testAdminLogin(String username, String password) {
        String encodedCredentials = java.util.Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        given()
            .header("Authorization", "Basic " + encodedCredentials)
            .post("http://apitesting.shariqsp.com:8080/api/admin/login")
		    .then()
		    .assertThat()
		    .statusCode(200)
		    .log()
		    .all(); // Validate response
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
}
    