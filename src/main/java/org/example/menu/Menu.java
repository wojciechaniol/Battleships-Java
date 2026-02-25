package org.example.menu;

import java.util.Scanner;

public class Menu extends IMenu {
    private final static String label = "Main Menu";

    public Menu(Scanner scanner) {
        super(scanner, label);
    }
}
