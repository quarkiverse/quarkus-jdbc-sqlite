package io.quarkiverse.sqlite4j.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class JDBCSqliteResourceTest {

    @Test
    public void testConnectionEndpoint() {
        given()
                .when().get("/Sqlite4j/Connection")
                .then()
                .statusCode(200)
                .body(is("1/leo/2/yui/"));
    }

    @Test
    public void testAgoralEndpoint() {
        given()
                .when().get("/Sqlite4j/Agoral")
                .then()
                .statusCode(200)
                .body(is("1/leo/2/yui/"));
    }
}
