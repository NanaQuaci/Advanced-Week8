package com.example.tests;

import com.example.base.BaseTest;
import com.example.endpoints.PostEndpoint;
import com.example.testdata.PostTestsData;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

@Epic("Users API")
@Feature("POST /users")
public class CreateUserTest extends BaseTest {

    PostEndpoint post = new PostEndpoint();

    @Test
    @Story("TC_001: Create user successfully with valid data")
    @Severity(SeverityLevel.CRITICAL)
    public void testCreateUser() {
        Response response = post.createUser(PostTestsData.createUserPayload());

        response.then()
                .statusCode(201)
                .body("name", equalTo("Test User"))
                .body("email", equalTo("tester@example.com"));

    }

    @Test
    @Story("TC_002: Create user with missing name")
    @Severity(SeverityLevel.NORMAL)
    public void testCreateUserMissingName() {
        Map<String, Object> payload = PostTestsData.userMissingName();
        Response response = post.createUser(payload);

        response.then().statusCode(201);

    }

    @Test
    @Story("TC_003: Create user with invalid email format")
    @Severity(SeverityLevel.NORMAL)
    public void testCreateUserInvalidEmail() {
        Map<String, Object> payload = PostTestsData.userWithInvalidEmail();
        Response response = post.createUser(payload);

        response.then().statusCode(201);
    }

    @Test
    @Story("TC_004: Create user with empty body")
    @Severity(SeverityLevel.MINOR)
    public void testCreateUserEmptyBody() {
        Response response = post.createUser("{}");
        response.then().statusCode(201);
    }

    @Test
    @Story("TC_005: Create user with unexpected extra fields")
    @Severity(SeverityLevel.MINOR)
    public void testCreateUserWithExtraFields() {
        Map<String, Object> payload = PostTestsData.userWithExtraFields();
        Response response = post.createUser(payload);

        response.then().statusCode(201)
                .body("extra", equalTo("unexpected"));
    }

    @Test
    @Story("TC_006: Create user with only username")
    @Severity(SeverityLevel.MINOR)
    public void testCreateUserOnlyUsername() {
        Map<String, Object> payload = PostTestsData.userWithOnlyUsername();
        Response response = post.createUser(payload);

        response.then().statusCode(201)
                .body("username", equalTo("lonelyuser"));
    }
}
