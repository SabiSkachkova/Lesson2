import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class PostmanEchoTests {

    private final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testPost() {
        String requestBody = "{\"foo\":\"bar\"}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(BASE_URL + "/post");

        response.then()
                .statusCode(200)
                .body("json.foo", equalTo("bar"));
    }

    @Test
    public void testGet() {
        Response response = RestAssured.given()
                .queryParam("foo", "bar")
                .when()
                .get(BASE_URL + "/get");

        response.then()
                .statusCode(200)
                .body("args.foo", equalTo("bar"));
    }

    @Test
    public void testPut() {
        String requestBody = "{\"foo\":\"bar\"}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put(BASE_URL + "/put");

        response.then()
                .statusCode(200)
                .body("json.foo", equalTo("bar"));
    }

    @Test
    public void testDelete() {
        Response response = RestAssured.given()
                .queryParam("foo", "bar")
                .when()
                .delete(BASE_URL + "/delete");

        response.then()
                .statusCode(200)
                .body("args.foo", equalTo("bar"));
    }

    @Test
    public void testPatch() {
        String requestBody = "{\"foo\":\"bar\"}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .patch(BASE_URL + "/patch");

        response.then()
                .statusCode(200)
                .body("json.foo", equalTo("bar"));
    }
}
