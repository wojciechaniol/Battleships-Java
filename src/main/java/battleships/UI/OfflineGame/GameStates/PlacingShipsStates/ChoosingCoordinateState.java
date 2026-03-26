package battleships.UI.OfflineGame.GameStates.PlacingShipsStates;

import battleships.UI.CoordinateParser;
import battleships.UI.OfflineGame.GameStates.IState;
import battleships.gameLogic.Coordinate;
import battleships.gameLogic.GamePlayer;

import java.util.Scanner;

public class ChoosingCoordinateState implements IState {
    private final Scanner scanner;
    private GamePlayer currentPlayer;
    private PlacementContext context;

    public ChoosingCoordinateState(GamePlayer player, Scanner scanner, PlacementContext context) {
        this.currentPlayer = player;
        this.scanner = scanner;
        this.context = context;
    }

    private void shipsCoordinate() {
        System.out.println("Input the coordinate");
        System.out.println("(Coordinate points to where the ship begins)");
    }

    @Override
    public void render() {
        shipsCoordinate();
    }

    // use coordinate parser somehow and catch the exceptions
    @Override
    public IState takeInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                Coordinate coord = CoordinateParser.parse(input);
                context.setCoord(coord);
                return new ChoosingLengthState(currentPlayer, scanner, context);
            } catch (IllegalArgumentException e) {
                System.out.print("Invalid input: " + e.getMessage() + " Try again: ");
            }
        }
    }

    @Override
    public void setPlayer(GamePlayer player) {
        currentPlayer = player;
    }
}
