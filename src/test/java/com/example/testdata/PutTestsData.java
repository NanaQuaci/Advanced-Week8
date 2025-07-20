package com.example.testdata;

import java.util.HashMap;
import java.util.Map;

public class PutTestsData {

    public static Map<String, Object> updateUserPayload() {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "Updated User");
        user.put("email", "updated@example.com");
        return user;
    }

    public static Map<String, Object> updateUserMissingName() {
        Map<String, Object> user = new HashMap<>();
        user.put("email", "updated@example.com");
        return user;
    }

    public static Map<String, Object> updateUserWithInvalidEmail() {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "Invalid Email");
        user.put("email", "invalid-email");
        return user;
    }
}
