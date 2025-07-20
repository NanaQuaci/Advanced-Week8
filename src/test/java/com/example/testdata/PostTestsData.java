package com.example.testdata;

import java.util.HashMap;
import java.util.Map;

public class PostTestsData {

    public static Map<String, Object> createUserPayload() {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "Test User");
        user.put("username", "tester123");
        user.put("email", "tester@example.com");
        return user;
    }

    public static Map<String, Object> userMissingName() {
        Map<String, Object> user = new HashMap<>();
        user.put("username", "no_name");
        user.put("email", "noname@example.com");
        return user;
    }

    public static Map<String, Object> userWithInvalidEmail() {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "Invalid Email");
        user.put("username", "invalid_email");
        user.put("email", "invalid-email-format");
        return user;
    }

    public static Map<String, Object> userWithExtraFields() {
        Map<String, Object> user = new HashMap<>();
        user.put("name", "Extra Fields User");
        user.put("username", "extrafield");
        user.put("email", "extra@example.com");
        user.put("extra", "unexpected");
        return user;
    }

    public static Map<String, Object> userWithOnlyUsername() {
        Map<String, Object> user = new HashMap<>();
        user.put("username", "lonelyuser");
        return user;
    }
}
