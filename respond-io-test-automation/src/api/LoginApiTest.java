import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginApiTest {
    @Test
    public void testValidLoginApi() {
        RestAssured.baseURI = "https://api.respond.io";
        Response response = RestAssured
            .given()
            .header("Content-Type", "application/json")
            .body("{\"email\": \"testuser@example.com\", \"password\": \"password123\"}")
            .when()
            .post("/user/login");

        Assert.assertEquals(response.getStatusCode(), 200);
        // Additional assertions can be made here
    }
}

