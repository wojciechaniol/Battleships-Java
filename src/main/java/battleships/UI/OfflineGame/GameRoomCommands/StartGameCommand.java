package battleships.UI.OfflineGame.GameRoomCommands;

import battleships.UI.OfflineGame.GameScreen;
import battleships.UI.ScreenManager;
import battleships.gameLogic.Game;
import battleships.gameLogic.GameRoom;
import battleships.menu_commands.MenuCommand;

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
