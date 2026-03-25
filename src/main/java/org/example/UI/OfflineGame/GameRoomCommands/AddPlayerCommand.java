package org.example.UI.OfflineGame.GameRoomCommands;

import org.example.gameLogic.Game;
import org.example.gameLogic.GameRoom;
import org.example.menu_commands.MenuCommand;

public class AddPlayerCommand implements MenuCommand {
    private final int playerNumber;
    private final GameRoom room;

    public AddPlayerCommand(int playerNumber, GameRoom room) {
        this.playerNumber = playerNumber;
        this.room = room;
    }

    @Override
    public String getLabel() {
        return "Add Player "+playerNumber;
    }

    @Override
    public void execute() {
        room.addGuestPlayer("", playerNumber-1);
    }
}
