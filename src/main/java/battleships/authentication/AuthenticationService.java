package battleships.authentication;

import java.io.*;
import java.util.Scanner;

public class AuthenticationService implements Closeable {
    private final File usersDB;
    private final FileWriter writer;

    public AuthenticationService(File file) throws IllegalArgumentException {
        if (file == null)
            throw new IllegalArgumentException("File for users database must not be null");

        usersDB = file;
        try {
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            System.err.println("File for authentication service not found");
            throw new IllegalArgumentException("Pass correct file");
        }
    }

    public boolean isUserInDB(String username) {
        if (username == null) return false;
        return findPasswordForUser(username) != null;
    }

    private boolean arePasswordsMatching(String expectedPassword, String password) {
        return password.equals(expectedPassword);
    }

    private String findPasswordForUser(String username) {
        try (Scanner scanner = new Scanner(usersDB)) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(" ", 2);
                if (parts.length == 2 && parts[0].equals(username)) {
                    return parts[1];
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Authentication Service file not found");
            return null;
        }

        return null;
    }

    public boolean registerUser(String username, String password) {
        boolean success = false;

        if (username == null || password == null)
            return success;

        if (isUserInDB(username)) {
            System.out.println("Username already exists");
            return success;
        }

        try {
            writer.write(username + " " + password + "\n");
            writer.flush();
            success = true;
        } catch (IOException e) {
            System.err.println("An error occurred when writing to a file");
        }

        return success;
    }

    public boolean login(String username, String password) {
        boolean success = false;

        if (username == null || password == null)
            return success;

        if (!isUserInDB(username)) {
            System.out.println("There is no such username");
            return success;
        }

        String expectedPassword;
        expectedPassword = findPasswordForUser(username);

        if (arePasswordsMatching(expectedPassword, password)) {
            success = true;
        } else {
            System.out.println("Passwords are not matching");
        }

        return success;
    }

    public boolean logout() {
        return false;
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
