package battleships.UI.OfflineGame.GameStates.PlacingShipsStates;

import battleships.UI.OfflineGame.GameStates.IState;
import battleships.UI.OfflineGame.GameStates.PlacingShipsState;
import battleships.gameLogic.*;

import java.util.Scanner;

public class PlacementResultState implements IState {
    private final Scanner scanner;
    private final Game game;
    private final PlacementContext context;
    private boolean success;

    public PlacementResultState(Game game, Scanner scanner, PlacementContext context) {
        this.game = game;
        this.scanner = scanner;
        this.context = context;
        success = false;
    }

    @Override
    public void render() {
        int shipsLength = context.getLength();
        IShip ship = IShip.ofLength(shipsLength);

        if (context.getOrientation() == 1) {
            success = game.placeShipHorizontally(ship, context.getCoord());
        } else {
            success = game.placeShipVertically(ship, context.getCoord());
        }

        if (success)
            System.out.println("Ship placed successfully!");
        else
            System.out.println("It was not possible to place the ship there. Try again");
    }

    @Override
    public IState takeInput() {
        System.out.println("Press any key and Enter to continue...");
        scanner.nextLine();

        if (success) {
            return new PlacingShipsState(game, scanner);
        } else {
            context.clearContext();
            return new ChoosingOrientationState(game, scanner, context);
        }
    }
}
