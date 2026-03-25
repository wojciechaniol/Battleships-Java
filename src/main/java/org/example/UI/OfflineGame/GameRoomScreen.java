package org.example.UI.OfflineGame;

import org.example.UI.IScreen;
import org.example.UI.OfflineGame.GameRoomCommands.AddPlayerCommand;
import org.example.UI.OfflineGame.GameRoomCommands.StartGameCommand;
import org.example.UI.ScreenManager;
import org.example.gameLogic.GameRoom;
import org.example.menu.IMenu;
import org.example.menu_commands.GoBackCommand;

import java.util.Scanner;

public class GameRoomScreen extends IMenu {
    private final static String label = "Game Room Options";
    private final GameRoom room;
    private final ScreenManager manager;

    public GameRoomScreen(GameRoom room, ScreenManager manager, Scanner scanner) {
        super(scanner, label);
        this.room = room;
        this.manager = manager;
    }

    protected void printPlayers() {
        System.out.println("       Players:      ");
        for (int i = 0; i < 2; i++) {
            System.out.println("  Player "+(i+1)+". "+((room.getPlayer(i) != null) ? room.getPlayer(i).getNickname() : "Empty"));
        }
    }

    private void printTitle() {
        System.out.println("===== Game Room =====");
    }

    private void addCommands() {
        super.addCommand(new AddPlayerCommand(1, room));
        super.addCommand(new AddPlayerCommand(2, room));
        super.addCommand(new StartGameCommand(manager, room, scanner));
        super.addCommand(new GoBackCommand(manager::pop));
    }

    @Override
    public void run(ScreenManager manager) {
        if (commands.isEmpty())
            addCommands();

        printTitle();
        printPlayers();
        try {
            super.run(manager);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
