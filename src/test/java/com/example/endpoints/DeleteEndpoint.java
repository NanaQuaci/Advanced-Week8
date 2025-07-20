package com.example.endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DeleteEndpoint {

    public Response deleteUser(int id) {
        return when().delete("/users/" + id);
    }

    public Response deleteUserWithStringId(String id) {
        return when().delete("/users/" + id);
    }

    public Response deleteWithoutId() {
        return when().delete("/users/");
    }
}
