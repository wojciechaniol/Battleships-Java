package org.example.menu_commands;

import org.example.UI.OfflineGame.GameRoomScreen;
import org.example.UI.ScreenManager;
import org.example.gameLogic.GameRoom;

import java.util.Scanner;

public class AnotherPlayerCommand implements MenuCommand {
    private final ScreenManager manager;
    private final Scanner scanner;

    public AnotherPlayerCommand(ScreenManager manager, Scanner scanner) {
        this.manager = manager;
        this.scanner = scanner;
    }

    @Override
    public String getLabel() {
        return "Another Player";
    }

    @Override
    public void execute() {
        GameRoom gameRoom = new GameRoom();
        manager.push(new GameRoomScreen(gameRoom, manager, scanner));
    }
}
