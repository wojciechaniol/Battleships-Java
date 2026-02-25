package org.example.menu;

import java.util.Scanner;

public class TypeOfGameMenu extends IMenu {
    private final static String label = "How would you like to play?";

    public TypeOfGameMenu(Scanner scanner) {
        super(scanner, label);
    }
}
