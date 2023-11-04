package ru.netology.PostmanEcho;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class PostmanEchoTest {
    @Test
    void ShouldReturn() {
        String test = "test";
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("some data")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("", hasSize(1))
                .body("[0].data", equalTo("some data"));
    }

}
