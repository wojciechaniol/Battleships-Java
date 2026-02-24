package org.example.menu;

import org.example.menu_commands.MenuCommand;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final ArrayList<MenuCommand> commands;
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        commands = new ArrayList<>();
        this.scanner = scanner;
    }

    public void addCommand(MenuCommand command) {
        commands.add(command);
    }

    public void renderMenu() {
        while(true) {
            System.out.println("==== Main Menu ====");
            for (int i = 0; i < commands.size(); i++) {
                System.out.println((i+1) + ". " + commands.get(i).getLabel());
            }
            System.out.println("0. Exit");
            System.out.println("Choose an option");

            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) break;
            if (choice >= 1 && choice <= commands.size()) {
                commands.get(choice-1).execute();
            } else {
                System.out.println("Invalid option");
            }
        }
    }
}
