package org.example.UI.OfflineGame.GameRoomCommands;

import org.example.UI.OfflineGame.GameScreen;
import org.example.UI.ScreenManager;
import org.example.gameLogic.Game;
import org.example.gameLogic.GameRoom;
import org.example.menu_commands.MenuCommand;

import java.util.Scanner;

public class StartGameCommand implements MenuCommand {
    private final ScreenManager manager;
    private final GameRoom room;
    private final Scanner scanner;

    public StartGameCommand(ScreenManager manager, GameRoom room, Scanner scanner) {
        this.manager = manager;
        this.room = room;
        this.scanner = scanner;
    }

    @Override
    public String getLabel() {
        return "Start Game";
    }

    @Override
    public void execute() {
        Game game = new Game(room.getPlayer(0), room.getPlayer(1));
        manager.push(new GameScreen(game, manager, scanner));
    }
}
