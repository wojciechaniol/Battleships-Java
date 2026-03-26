package battleships.UI.OfflineGame.GameStates;

import battleships.gameLogic.GamePlayer;

import java.util.Scanner;

public class PlacingShipsState implements IState {
    private GamePlayer currentPlayer;
    private final Scanner scanner;
    private IState currentState;

    public PlacingShipsState(GamePlayer player, Scanner scanner) {
        currentPlayer = player;
        this.scanner = scanner;
        currentState = null;
    }

    private void shipsCoordinates() {
        System.out.println("The coordinate you input is where the ship will begin");
        System.out.println("Input ships coordinate");
    }

    private void shipsLength() {
        System.out.println("Choose ships length: ");
    }

    private void additionUnsuccessful() {
        System.out.println("It was not possible to add this ship");
        System.out.println("Try again");
    }

    private void additionSuccessful() {
        System.out.println("You successfully added a ship");
    }

    private void setCurrentState(IState comm) {
        currentState = comm;
    }

    @Override
    public void render() {
        currentPlayer.getShipsBoard().renderVisualBoard();
    }

    @Override
    public IState takeInput() {
        return null;
    }

    @Override
    public void setPlayer(GamePlayer player) {
        this.currentPlayer = player;
    }
}
