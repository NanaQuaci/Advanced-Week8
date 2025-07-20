package com.example.tests;

import com.example.base.BaseTest;
import com.example.endpoints.PutEndpoint;
import com.example.testdata.PutTestsData;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Epic("Users API")
@Feature("PUT /users")
public class UpdateUserTest extends BaseTest {

    PutEndpoint put = new PutEndpoint();

    @Test
    @Story("TC_001: Update a user with valid data")
    @Severity(SeverityLevel.CRITICAL)
    public void testUpdateUser() {
        Response response = put.updateUser(1, PutTestsData.updateUserPayload());

        response.then()
                .statusCode(200)
                .body("name", equalTo("Updated User"))
                .body("email", equalTo("updated@example.com"));
    }

    @Test
    @Story("TC_002: Update user with non-existent ID")
    @Severity(SeverityLevel.NORMAL)
    public void testUpdateNonExistentUser() {
        Response response = put.updateUser(9999, PutTestsData.updateUserPayload());

        response.then()
                .statusCode(200)
                .body("name", equalTo("Updated User"));
    }

    @Test
    @Story("TC_003: Update user with missing name field")
    @Severity(SeverityLevel.MINOR)
    public void testUpdateUserMissingName() {
        Response response = put.updateUser(1, PutTestsData.updateUserMissingName());

        response.then()
                .statusCode(200)
                .body("email", equalTo("updated@example.com"));
    }

    @Test
    @Story("TC_004: Update user with invalid email format")
    @Severity(SeverityLevel.MINOR)
    public void testUpdateUserInvalidEmail() {
        Response response = put.updateUser(1, PutTestsData.updateUserWithInvalidEmail());

        response.then()
                .statusCode(200)
                .body("email", equalTo("invalid-email"));
    }

    @Test
    @Story("TC_005: Update user with string ID")
    @Severity(SeverityLevel.NORMAL)
    public void testUpdateUserStringId() {
        Response response = put.updateUserWithStringId("abc", PutTestsData.updateUserPayload());

        response.then().statusCode(404); // Invalid endpoint
    }

    @Test
    @Story("TC_006: Update user with empty body")
    @Severity(SeverityLevel.NORMAL)
    public void testUpdateUserEmptyBody() {
        Response response = put.updateUser(1, "{}");

        response.then()
                .statusCode(200)
                .body("", notNullValue()); // Accepts empty update
    }
}
