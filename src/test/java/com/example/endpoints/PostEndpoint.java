package com.example.endpoints;

import com.example.base.BaseTest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class PostEndpoint extends BaseTest {
    public Response createUser(Object user) {
        return given()
                .spec(requestSpec)
                .body(user)
                .when()
                .post("/users");
    }
}
