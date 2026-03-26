package battleships.menu;

import java.util.Scanner;

public class CreateGameMenu extends IMenu {
    private final static String label = "Create or Join a Game";

    public CreateGameMenu(Scanner scanner) {
        super(scanner, label);
    }
}
