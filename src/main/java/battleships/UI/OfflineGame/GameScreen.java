package battleships.UI.OfflineGame;

import battleships.UI.IScreen;
import battleships.UI.OfflineGame.GameStates.FinishState;
import battleships.UI.OfflineGame.GameStates.IState;
import battleships.UI.OfflineGame.GameStates.PlacingShipsState;
import battleships.UI.OfflineGame.GameStates.ShootingState;
import battleships.UI.ScreenManager;
import battleships.gameLogic.Game;
import battleships.gameLogic.GameRoom;

import java.util.Scanner;

public class GameScreen implements IScreen {
    private final Game game;
    private final ScreenManager manager;
    private final Scanner scanner;
    private IState state;

    public GameScreen(Game game, ScreenManager manager, Scanner scanner) {
        this.game = game;
        this.manager = manager;
        this.scanner = scanner;
        this.state = new PlacingShipsState(game, scanner);
    }

    @Override
    public void run(ScreenManager manager) {
        if (state instanceof PlacingShipsState) {
            if (game.arePlayersShipsSet()) {
                game.changePlayer();
                if (game.arePlayersShipsSet()) {
                    state = new ShootingState(game, scanner);
                }
            }
        } else if (state instanceof ShootingState) {
            if (game.isGameOver()) {
                state = new FinishState();
            }
        } else if (state == null) {
            throw new IllegalStateException("State is null");
        }

        state.render();
        state = state.takeInput();
    }
}