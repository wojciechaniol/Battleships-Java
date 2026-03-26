package battleships.menu;

import battleships.UI.IScreen;
import battleships.UI.ScreenManager;
import battleships.menu_commands.MenuCommand;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class IMenu implements IScreen {
    protected final ArrayList<MenuCommand> commands;
    protected final Scanner scanner;
    protected final String menuLabel;

    protected IMenu(Scanner scanner, String label) {
        commands = new ArrayList<>();
        this.scanner = scanner;
        menuLabel = label;
    }

    public void addCommand(MenuCommand command) {
        commands.add(command);
    }

    protected void printMenu() {
        System.out.println("==== " + menuLabel + " ====");
        for (int i = 0; i < commands.size(); i++) {
            System.out.println((i+1) + ". " + commands.get(i).getLabel());
        }
        System.out.println("0. Exit");
        System.out.println("Choose an option");
    }

    protected int readChoice() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }

    protected void executeChoice(int choice) {
        if (choice >= 1 && choice <= commands.size()) {
            commands.get(choice - 1).execute();
        } else {
            System.out.println("Invalid option.");
        }
    }

    public void run(ScreenManager screenManager) {
        printMenu();
        int choice = readChoice();

        if (choice == 0) {
            System.out.println("Goodbye!");
            screenManager.clearAll();
            return;
        }

        executeChoice(choice);
    }
}