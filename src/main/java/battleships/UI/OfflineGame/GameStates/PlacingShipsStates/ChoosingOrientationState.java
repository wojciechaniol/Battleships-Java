package battleships.UI.OfflineGame.GameStates.PlacingShipsStates;

import battleships.UI.OfflineGame.GameStates.IState;
import battleships.gameLogic.Game;

import java.util.Scanner;

public class ChoosingOrientationState implements IState {
    private final Scanner scanner;
    private final Game game;
    private final PlacementContext context;

    public ChoosingOrientationState(Game game, Scanner scanner, PlacementContext context) {
        this.game = game;
        this.scanner = scanner;
        this.context = context;
    }

    private void shipsOrientation() {
        System.out.println("Horizontally or vertically?");
        System.out.println("1. Horizontally \t 2. Vertically");
    }

    @Override
    public void render() {
        shipsOrientation();
    }

    @Override
    public IState takeInput() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                context.setOrientation(choice);
                return new ChoosingCoordinateState(game, scanner, context);
            } catch (IllegalArgumentException e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }
}
