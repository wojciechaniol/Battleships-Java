package org.example.menu_commands;

import org.example.authentication.AuthenticationService;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class RegisterCommand implements MenuCommand {
    private final AuthenticationService authService;
    private final Scanner scanner;
    private final Runnable onSuccess;

    public RegisterCommand(Scanner scanner, Runnable onSuccess) {
        URL resource = getClass().getClassLoader().getResource("authentication/passwords.txt");
        File file;
        try {
            file = new File(resource.toURI());
            authService =  new AuthenticationService(file);
        } catch (URISyntaxException | NullPointerException | IllegalArgumentException e) {
            System.err.println("File path is parsed incorrectly");
            throw new RuntimeException("Failed to initialize the Authentication Service");
        }

        this.scanner = scanner;
        this.onSuccess = onSuccess;
    }

    public RegisterCommand(Scanner scanner, AuthenticationService authServ, Runnable onSuccess) {
        authService = authServ;
        this.scanner = scanner;
        this.onSuccess = onSuccess;
    }

    @Override
    public String getLabel() {
        return "Register new user";
    }

    @Override
    public void execute() {
        System.out.println("Username: ");
        String username = scanner.nextLine();
        String first_password;
        String second_password;

        do {
            System.out.println("Password: ");
            first_password = scanner.nextLine();

            System.out.println("Repeat your password: ");
            second_password = scanner.nextLine();

            if (!first_password.equals(second_password))
                System.out.println("Passwords do not match. Try again");
        } while (!first_password.equals(second_password));

        if (authService.registerUser(username, first_password)) {
            System.out.println("Password set successfully.");
            onSuccess.run();
        } else {
            System.out.println("Failed to set the password");
        }
    }
}
