package org.example;

import org.example.UI.ScreenManager;
import org.example.menu.*;
import org.example.menu_commands.*;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScreenManager manager = new ScreenManager();

        IMenu mainMenu = new Menu(scanner);
        IMenu createGameMenu = new CreateGameMenu(scanner);
        IMenu typeOfGameMenu = new TypeOfGameMenu(scanner);
        IMenu aiOrAnotherPlayerMenu = new AIorAnotherPlayerMenu(scanner);
        IMenu functionNotAvailableMenu = new FunctionNotAvailableMenu(scanner);

        mainMenu.addCommand(new LoginCommand(scanner, () -> manager.push(createGameMenu)));
        mainMenu.addCommand(new RegisterCommand(scanner, () -> manager.push(createGameMenu)));

        createGameMenu.addCommand(new CreateNewGameCommand(() -> manager.push(typeOfGameMenu)));
        createGameMenu.addCommand(new JoinGameCommand(() -> manager.push(functionNotAvailableMenu)));

        typeOfGameMenu.addCommand(new PlayOnlineCommand(() -> manager.push(functionNotAvailableMenu)));
        typeOfGameMenu.addCommand(new PlayOfflineCommand(() -> manager.push(aiOrAnotherPlayerMenu)));

        aiOrAnotherPlayerMenu.addCommand(new AnotherPlayerCommand(manager, scanner));
        aiOrAnotherPlayerMenu.addCommand(new AIOpponentCommand(() -> manager.push(functionNotAvailableMenu)));

        functionNotAvailableMenu.addCommand(new GoBackCommand((manager::pop)));

        manager.push(mainMenu);
        manager.run();
    }
}