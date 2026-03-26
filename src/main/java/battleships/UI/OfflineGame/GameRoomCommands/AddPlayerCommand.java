package battleships.UI.OfflineGame.GameRoomCommands;

import battleships.gameLogic.GameRoom;
import battleships.menu_commands.MenuCommand;

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
