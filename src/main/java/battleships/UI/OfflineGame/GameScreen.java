package battleships.UI.OfflineGame;

import battleships.UI.IScreen;
import battleships.UI.OfflineGame.GameStates.IState;
import battleships.UI.ScreenManager;
import battleships.gameLogic.Game;

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
    }

    @Override
    public void run(ScreenManager manager) {

    }
}
