package battleships.UI.OfflineGame.GameStates;

import battleships.UI.CoordinateParser;
import battleships.gameLogic.Coordinate;
import battleships.gameLogic.Game;
import battleships.gameLogic.GamePlayer;

import java.util.Scanner;

public class ShootingState implements IState {
    private final Game game;
    private final Scanner scanner;

    public ShootingState(Game game, Scanner scanner) {
        this.game = game;
        this.scanner = scanner;
    }

    private ShootingState(ShootingState state) {
        if (state == null)
            throw new IllegalArgumentException("Shooting state can't be null");

        this.game = state.game;
        this.scanner = state.scanner;
    }

    protected boolean getShotResult(Coordinate coord) {
        return game.fireShoot(coord);
    }

    @Override
    public void render() {
//        for (GamePlayer player : game.getPlayers()) {
//            System.out.print(player.getNickname() + ": \t");
//            player.getShootsBoard().renderVisualBoard();
//        }

        System.out.println("Currently playing: " + game.getCurrentPlayer().getNickname());
    }

    @Override
    public IState takeInput() {
        System.out.println("Input coordinates: ");

        while (true) {
            try {
                String input = scanner.nextLine();
                Coordinate coord = CoordinateParser.parse(input);
                boolean hit = getShotResult(coord);

                if (hit) {
                    System.out.println("You hit your opponent's ship");
                } else {
                    System.out.println("You missed");
                }

                game.changePlayer();
                return new ShootingState(this);
            } catch (IllegalArgumentException e) {
                System.out.print("Invalid input: " + e.getMessage() + " Try again: ");
            }
        }


    }
}
