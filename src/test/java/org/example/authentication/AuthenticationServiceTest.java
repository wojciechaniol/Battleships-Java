package org.example.authentication;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceTest {
    private AuthenticationService authServ;

    @BeforeEach
    void setUp() {
        try {
            URL resource = getClass().getClassLoader().getResource("authentication/passwordsTestFile.txt");
            assertNotNull(resource);
            File file = new File(resource.toURI());
            authServ = new AuthenticationService(file);
        } catch (Exception e) {
            System.err.println("An error occurred when creating new Authentication Service");
        }
        String username = "koala";
        String password = "1234";
        authServ.registerUser(username, password);
    }

    @Test
    void checkNotExistingUser() {
        String fakeUsername = "koal";
        boolean success = authServ.isUserInDB(fakeUsername);
        assertFalse(success);
    }

    @Test
    void checkExistingUser() {
        String usernameToBeLookedFor = "koala";
        boolean success = authServ.isUserInDB(usernameToBeLookedFor);
        assertTrue(success);
    }

    @Test
    void checkIfPasswordIsTakenIntoAccountWhenLookingForUsers() {
        String passwordUsername = "1234";
        boolean success = authServ.isUserInDB(passwordUsername);
        assertFalse(success);
    }

    @Test
    void checkNullInUsers() {
        boolean success = authServ.isUserInDB(null);
        assertFalse(success);
    }

    @Test
    void registerNewUser() {
        String newUsername = "koala123";
        String newPassword = "4321";
        boolean success = authServ.registerUser(newUsername, newPassword);
        assertTrue(success);
    }

    @Test
    void registerNullUser() {
        String newUsername = null;
        String newPassword = "4321";
        boolean success = authServ.registerUser(newUsername, newPassword);
        assertFalse(success);
    }

    @Test
    void registerNullPassword() {
        String newUsername = "koala123";
        String newPassword = null;
        boolean success = authServ.registerUser(newUsername, newPassword);
        assertFalse(success);
    }

    @Test
    void registerUserWithTheSameNickname() {
        String newUsername = "koala";
        String newPassword = "4321";
        boolean success = authServ.registerUser(newUsername, newPassword);
        assertFalse(success);
    }

    @Test
    void login() {
    }

    @AfterEach
    void cleanup() throws IOException {
        authServ.close();
    }
}