package com.example.tests;

import com.example.base.BaseTest;
import com.example.endpoints.GetEndpoint;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Epic("Users API")
@Feature("GET /users")
public class ReadUserTest extends BaseTest {

    GetEndpoint get = new GetEndpoint();

    @Test
    @Story("TC_001: Fetch all users")
    @Severity(SeverityLevel.NORMAL)
    public void testGetAllUsers() {
        Response response = get.getAllUsers();

        response.then()
                .statusCode(200)
                .body("size()", equalTo(10));
    }

    @Test
    @Story("TC_002: Fetch user by valid ID")
    @Severity(SeverityLevel.NORMAL)
    public void testGetUserById() {
        Response response = get.getUserById(1);

        response.then()
                .statusCode(200)
                .body("name", equalTo("Leanne Graham"));
    }

    @Test
    @Story("TC_003: Fetch user by non-existent ID")
    @Severity(SeverityLevel.MINOR)
    public void testGetNonExistentUser() {
        Response response = get.getUserById(9999);

        response.then().statusCode(200)
                .body("id", nullValue());  // JSONPlaceholder returns empty {}
    }

    @Test
    @Story("TC_004: Fetch user by negative ID")
    @Severity(SeverityLevel.MINOR)
    public void testGetUserNegativeId() {
        Response response = get.getUserById(-1);

        response.then().statusCode(200)
                .body("id", nullValue());
    }

    @Test
    @Story("TC_005: Fetch user by string ID")
    @Severity(SeverityLevel.NORMAL)
    public void testGetUserByStringId() {
        Response response = get.getUserByStringId("abc");

        response.then().statusCode(404);
    }

    @Test
    @Story("TC_006: Fetch user with no ID (trailing slash)")
    @Severity(SeverityLevel.NORMAL)
    public void testGetUserWithoutId() {
        Response response = get.getWithoutId();

        response.then().statusCode(200)
                .body("size()", equalTo(10)); // same as /users
    }
}
