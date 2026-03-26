package battleships.UI.OfflineGame.GameStates.PlacingShipsStates;

import battleships.UI.OfflineGame.GameStates.IState;
import battleships.UI.OfflineGame.GameStates.PlacingShipsState;
import battleships.gameLogic.Coordinate;
import battleships.gameLogic.GamePlayer;

import java.util.Scanner;

public class PlacementResultState implements IState {
    private final Scanner scanner;
    private GamePlayer currentPlayer;
    private PlacementContext context;

    public PlacementResultState(GamePlayer player, Scanner scanner, PlacementContext context) {
        this.currentPlayer = player;
        this.scanner = scanner;
        this.context = context;
    }

    @Override
    public void render() {
        // place the ship in player's board
        // add the ship to the fleet
        // render success or failure
    }

    @Override
    public IState takeInput() {
        // if success return null
        // else clear context and return ChoosingOrientation to repeat the process
        return null;
    }

    @Override
    public void setPlayer(GamePlayer player) {
        currentPlayer = player;
    }
}
