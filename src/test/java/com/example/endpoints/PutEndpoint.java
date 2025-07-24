package com.example.endpoints;

import io.restassured.response.Response;

import static com.example.base.BaseTest.requestSpec;
import static io.restassured.RestAssured.*;

public class PutEndpoint {

    public Response updateUser(int id, Object payload) {
        return given()
                .spec(requestSpec)
                .body(payload)
                .when()
                .put("/users/" + id);
    }

    public Response updateUserWithStringId(String id, Object payload) {
        return given()
                .contentType("application/json")
                .body(payload)
                .when()
                .put("/users/" + id);
    }
}
