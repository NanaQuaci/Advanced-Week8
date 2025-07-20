package com.example.tests;

import com.example.base.BaseTest;
import com.example.endpoints.DeleteEndpoint;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

@Epic("Users API")
@Feature("DELETE /users")
public class DeleteUserTest extends BaseTest {

    DeleteEndpoint delete = new DeleteEndpoint();

    @Test
    @Story("TC_001: Delete a user by valid ID")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeleteUser() {
        Response response = delete.deleteUser(1);
        response.then().statusCode(200);
    }

    @Test
    @Story("TC_002: Delete a user with non-existent ID")
    @Severity(SeverityLevel.NORMAL)
    public void testDeleteNonExistentUser() {
        Response response = delete.deleteUser(9999);
        response.then().statusCode(200); // JSONPlaceholder still returns 200
    }

    @Test
    @Story("TC_003: Delete a user with negative ID")
    @Severity(SeverityLevel.MINOR)
    public void testDeleteWithNegativeId() {
        Response response = delete.deleteUser(-1);
        response.then().statusCode(200); // still returns 200 on JSONPlaceholder
    }

    @Test
    @Story("TC_004: Delete a user with string ID")
    @Severity(SeverityLevel.NORMAL)
    public void testDeleteWithStringId() {
        Response response = delete.deleteUserWithStringId("abc");
        response.then().statusCode(404); // endpoint is malformed
    }

    @Test
    @Story("TC_005: Delete user with no ID in URL")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeleteWithNoId() {
        Response response = delete.deleteWithoutId();
        response.then().statusCode(404);
    }
}
