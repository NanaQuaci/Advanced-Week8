package com.example.endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetEndpoint {

    public Response getAllUsers() {
        return when().get("/users");
    }

    public Response getUserById(int id) {
        return when().get("/users/" + id);
    }

    public Response getUserByStringId(String id) {
        return when().get("/users/" + id);
    }

    public Response getWithoutId() {
        return when().get("/users/");
    }
}
