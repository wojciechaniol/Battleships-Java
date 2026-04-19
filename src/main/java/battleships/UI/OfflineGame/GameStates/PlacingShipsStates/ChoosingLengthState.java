package battleships.UI.OfflineGame.GameStates.PlacingShipsStates;

import battleships.UI.OfflineGame.GameStates.IState;
import battleships.gameLogic.Game;

import java.util.Scanner;

public class ChoosingLengthState implements IState {
    private final Scanner scanner;
    private final Game game;
    private final PlacementContext context;

    public ChoosingLengthState(Game game, Scanner scanner, PlacementContext context) {
        this.game = game;
        this.scanner = scanner;
        this.context = context;
    }

    private void shipsLength() {
        System.out.println("Input the length");
        System.out.println("Choose between 1 and 4");
    }

    @Override
    public void render() {
        shipsLength();
    }

    @Override
    public IState takeInput() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                context.setLength(choice);
                return new PlacementResultState(game, scanner, context);
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }
}
