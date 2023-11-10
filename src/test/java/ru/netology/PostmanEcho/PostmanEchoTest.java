package ru.netology.PostmanEcho;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class PostmanEchoTest {
    @Test
    void ShouldReturn() {
        given()
                .baseUri("https://postman-echo.com")
                //.contentType("text/plain; charset=UTF-8")
                .body("some data")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("some data"));
    }

}
