package battleships.UI.OfflineGame.GameStates;

import battleships.UI.OfflineGame.GameStates.PlacingShipsStates.ChoosingOrientationState;
import battleships.UI.OfflineGame.GameStates.PlacingShipsStates.PlacementContext;
import battleships.gameLogic.Game;

import java.util.Scanner;

public class PlacingShipsState implements IState {
    private final Game game;
    private final Scanner scanner;
    private IState currentState;

    public PlacingShipsState(Game game, Scanner scanner) {
        this.game = game;
        this.scanner = scanner;
        currentState = new ChoosingOrientationState(game, scanner, new PlacementContext());
    }

    @Override
    public void render() {
        game.getCurrentPlayerShipsBoard().renderVisualBoard();
        if (currentState != null)
            currentState.render();
    }

    @Override
    public IState takeInput() {
        if (currentState != null)
            currentState = currentState.takeInput();

        return currentState;
    }

}
