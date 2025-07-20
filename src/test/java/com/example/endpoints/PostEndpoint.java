package com.example.endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostEndpoint {
    public Response createUser(Object user) {
        return given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/users");
    }
}
