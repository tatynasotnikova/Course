import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestApi {

    @Test
    public void apiGetTest() {
        given().baseUri("https://postman-echo.com/")
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .param("foo3", "bar3")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("args.foo3", equalTo("bar3"))
                .log()
                .all();
    }
    @Test
    public void apiPostTest() {
        String json = "{json1:This is the request body\"\n" +
                "\"json2\":\"json2\"\n" +
                "}";

        given().baseUri("https://postman-echo.com/")
                .header("Content-Type", "application/json")
                .queryParam("hand", "wave")
                .body(json)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("args.hand", equalTo("wave"))
                .body("data", equalTo(json))
                .log()
                .all();
    }

    @Test
    public void apiPostRawDataTest() {
        String rawData = "RawData";

        given().baseUri("https://postman-echo.com/")
                .body(rawData)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(rawData))
                .log()
                .all();
    }

    @Test
    public void apiPutTest() {

        String json = "{json1:This is the request body\"\n" +
                "\"json2\":\"json2\"\n" +
                "}";

        given().baseUri("https://postman-echo.com/")
                .header("Content-Type", "application/json")
                .queryParam("hand", "wave")
                .body(json)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("args.hand", equalTo("wave"))
                .body("data", equalTo(json))
                .log()
                .all();
    }

    @Test
    public void apiPatchTest() {

        String patchData = "patch data";

        given().baseUri("https://postman-echo.com/")
                .body(patchData)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(patchData))
                .log()
                .all();
    }

    @Test
    public void apiDeleteTest() {

        String deleteData = "detele data";

        given().baseUri("https://postman-echo.com/")
                .body(deleteData)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo(deleteData))
                .log()
                .all();
    }

}