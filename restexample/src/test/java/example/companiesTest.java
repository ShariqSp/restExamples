package example;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class companiesTest {


    @Test
    void testCompanyName() {
        given()
        .get("http://apitesting.shariqsp.com:8080/api/companies")
        .then()
        .assertThat()
        .body("name[0]", Matchers.equalTo("TechCorp")); // Verify company name
    }

    @Test
    void testCompanyLocation() {
        given()
        .get("http://apitesting.shariqsp.com:8080/api/companies")
        .then()
        .assertThat()
        .body("location[0]", Matchers.equalTo("New York")); // Verify location
    }

    @Test
    void testCompanyPhone() {
        given()
        .get("http://apitesting.shariqsp.com:8080/api/companies")
        .then()
        .assertThat()
        .body("phone[0]", Matchers.equalTo("+1234567890")); // Verify phone number
    }

    @Test
    void testCompanyEmail() {
        given()
        .get("http://apitesting.shariqsp.com:8080/api/companies")
        .then()
        .assertThat()
        .body("email[0]", Matchers.equalTo("contact@techcorp.com")); // Verify email
    }

    @Test
    void testLastUpdated() {
        given()
        .get("http://apitesting.shariqsp.com:8080/api/companies")
        .then()
        .assertThat()
        .body("lastUpdated", Matchers.notNullValue()); // Verify last updated is not null
    }

    @Test
    void testMobileItemBrand() {
        given()
        .get("http://apitesting.shariqsp.com:8080/api/companies")
        .then()
        .assertThat()
        .body("mobileItems[0].brand[0]", Matchers.equalTo("Samsung")); // Verify first mobile item's brand
    }

    @Test
    void testMobileItemModel() {
        given()
        .get("http://apitesting.shariqsp.com:8080/api/companies")
        .then()
        .assertThat()
        .body("mobileItems[0].model[0]", Matchers.equalTo("Galaxy S23 Ultra")); // Verify first mobile item's model
    }

    @Test
    void testMobileItemPrice() {
        given()
        .get("http://apitesting.shariqsp.com:8080/api/companies")
        .then()
        .assertThat()
        .body("mobileItems[0].price[0]", Matchers.equalTo(1199.99f)); // Verify first mobile item's price
    }

    @Test
    void testMobileItemSpecifications() {
        given()
        .get("http://apitesting.shariqsp.com:8080/api/companies")
        .then()
        .assertThat()
        .body("mobileItems[0].specifications.processor[0]", Matchers.equalTo("Snapdragon 8 Gen 2"))
        .body("mobileItems[0].specifications.ram[0]", Matchers.equalTo("12GB"))
        .body("mobileItems[0].specifications.storage[0]", Matchers.equalTo("256GB"))
        .body("mobileItems[0].specifications.rearCamera[0]", Matchers.equalTo("200MP"))
        .body("mobileItems[0].specifications.frontCamera[0]", Matchers.equalTo("40MP"))
        .body("mobileItems[0].specifications.battery[0]", Matchers.equalTo(5000))
        .body("mobileItems[0].specifications.os[0]", Matchers.equalTo("Android 13")); // Verify mobile specifications
    }

    @Test
    void testMobileItemWarranty() {
        given()
        .get("http://apitesting.shariqsp.com:8080/api/companies")
        .then()
        .assertThat()
        .body("mobileItems[0].warranty.coverage[0]", Matchers.equalTo("Manufacturer"))
        .body("mobileItems[0].warranty.duration[0]", Matchers.equalTo(2)); // Verify warranty details
    }

    @Test
    void testAvailabilityBestBuy() {
        given()
        .get("http://apitesting.shariqsp.com:8080/api/companies")
        .then()
        .assertThat()
        .body("mobileItems[0].availability[0].store[0]", Matchers.equalTo("Best Buy"))
        .body("mobileItems[0].availability[0].store[1]", Matchers.equalTo("Amazon"))
        .body("mobileItems[0].availability[0].stock[0]", Matchers.equalTo(25)) // Verify stock at Best Buy
        .body("mobileItems[0].availability[0].stock[1]", Matchers.equalTo(50)); // Verify stock at Best Buy
    }

    @Test
    void testAvailabilityAmazon() {
        given()
        .get("http://apitesting.shariqsp.com:8080/api/companies")
        .then()
        .assertThat()
        .body("mobileItems[0].availability[1].store", Matchers.equalTo("Amazon"))
        .body("mobileItems[0].availability[1].stock", Matchers.equalTo(50)); // Verify stock at Amazon
    }

}
