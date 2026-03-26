package battleships.menu_commands;

import battleships.authentication.AuthenticationService;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class LoginCommand implements MenuCommand {
    private final AuthenticationService authService;
    private final Scanner scanner;
    private final Runnable onSuccess;

    public LoginCommand(Scanner scanner, Runnable onSuccess) {
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

    public LoginCommand(Scanner scanner, AuthenticationService authServ, Runnable onSuccess) {
        this.scanner = scanner;
        this.authService = authServ;
        this.onSuccess = onSuccess;
    }

    @Override
    public String getLabel() {
        return "Log in";
    }

    @Override
    public void execute() {
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        boolean success = authService.login(username, password);

        if (success) {
            System.out.println("Login successful, " + username);
            onSuccess.run();
        }
        else {
            System.out.println("Invalid credentials");
        }
    }
}
