package org.example;

import org.example.menu.Menu;
import org.example.menu_commands.LoginCommand;
import org.example.menu_commands.RegisterCommand;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu mainMenu = new Menu(scanner);
        mainMenu.addCommand(new LoginCommand(scanner));
        mainMenu.addCommand(new RegisterCommand(scanner));
        mainMenu.renderMenu();
    }
}