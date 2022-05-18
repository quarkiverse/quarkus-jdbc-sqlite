package io.quarkiverse.jdbc.sqlite.jdbc.sqlite.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class JDBCSqliteResourceTest {

    @Test
    public void testConnectionEndpoint() {
        given()
                .when().get("/JDBC-Sqlite/Connection")
                .then()
                .statusCode(200)
                .body(is("1/leo/2/yui/"));
    }

    @Test
    public void testAgoralEndpoint() {
        given()
                .when().get("/JDBC-Sqlite/Agoral")
                .then()
                .statusCode(200)
                .body(is("1/leo/2/yui/"));
    }
}
