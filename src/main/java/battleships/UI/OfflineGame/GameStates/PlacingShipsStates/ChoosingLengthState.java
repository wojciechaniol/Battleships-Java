package battleships.UI.OfflineGame.GameStates.PlacingShipsStates;

import battleships.UI.OfflineGame.GameStates.IState;
import battleships.gameLogic.Coordinate;
import battleships.gameLogic.GamePlayer;

import java.util.Scanner;

public class ChoosingLengthState implements IState {
    private final Scanner scanner;
    private GamePlayer currentPlayer;
    private PlacementContext context;

    public ChoosingLengthState(GamePlayer player, Scanner scanner, PlacementContext context) {
        this.currentPlayer = player;
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
                return new PlacementResultState(currentPlayer, scanner, context);
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }

    @Override
    public void setPlayer(GamePlayer player) {
        currentPlayer = player;
    }
}
