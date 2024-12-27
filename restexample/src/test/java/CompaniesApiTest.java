import io.restassured.RestAssured;
              import io.restassured.response.Response;
              import io.restassured.path.json.JsonPath;
              import org.testng.Assert;
              import org.testng.annotations.BeforeClass;
              import org.testng.annotations.Test;
              
              import java.util.List;
              
              public class CompaniesApiTest {
              
                  // Base URI setup
                  @BeforeClass
                  public void setup() {
                      RestAssured.baseURI = "http://apitesting.shariqsp.com:8080/api/companies";
                  }
              
                  @Test
                  public void testExtractCompanyNames() {
                      // Send GET request and extract response
                      Response response = RestAssured
                              .given()
                              .get()
                              .then()
                              .statusCode(200) // Validate status code
                              .extract()
                              .response();
              
                      JsonPath jsonPath = response.jsonPath();

                      // Extract brands with 256GB storage
                      List<String> brands = jsonPath.getList("mobileItems.brand");
                    		    
                      System.out.println("Brands with 256GB storage: " + brands);
                      // Assert at least one company is returned
                    //  Assert.assertTrue(companyNames.size() > 0, "No companies found in response.");
                  }
              
//                  @Test
//                  public void testExtractSamsungDevicePrices() {
//                      // Send GET request and extract response
//                      Response response = RestAssured
//                              .given()
//                              .get()
//                              .then()
//                              .statusCode(200) // Validate status code
//                              .extract()
//                              .response();
//              
//                      // Parse response with JSONPath
//                      JsonPath jsonPath = response.jsonPath();
//              
//                      // Extract Samsung device prices
//                      List samsungPrices = jsonPath.getList("$[*].mobileItems[?(@.brand=='Samsung')].price");
//                      System.out.println("Samsung Device Prices: " + samsungPrices);
//              
//                      // Assert that the Samsung prices are not empty
//                      Assert.assertTrue(samsungPrices.size() > 0, "No Samsung devices found.");
//                  }
//              
//                  @Test
//                  public void testGalaxyS23UltraAvailability() {
//                      // Send GET request and extract response
//                      Response response = RestAssured
//                              .given()
//                              .get()
//                              .then()
//                              .statusCode(200) // Validate status code
//                              .extract()
//                              .response();
//              
//                      // Parse response with JSONPath
//                      JsonPath jsonPath = response.jsonPath();
//              
//                      // Extract store availability for Galaxy S23 Ultra
//                      List stores = jsonPath.getList("$[*].mobileItems[?(@.model=='Galaxy S23 Ultra')].availability[*].store");
//                      System.out.println("Galaxy S23 Ultra Stores: " + stores);
//              
//                      // Assert at least one store is available
//                      Assert.assertTrue(stores.size() > 0, "Galaxy S23 Ultra is not available in any store.");
//                  }
              }
                  