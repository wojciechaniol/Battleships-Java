package org.example.menu;

import java.util.Scanner;

public class AIorAnotherPlayerMenu extends IMenu {
    private final static String label = "Against Who?";

    public AIorAnotherPlayerMenu(Scanner scanner) {
        super(scanner, label);
    }
}
