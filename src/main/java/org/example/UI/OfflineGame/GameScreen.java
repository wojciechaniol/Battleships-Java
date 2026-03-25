package org.example.UI.OfflineGame;

import org.example.UI.IScreen;
import org.example.UI.ScreenManager;
import org.example.gameLogic.Game;

import java.util.Scanner;

public class GameScreen implements IScreen {
    private final Game game;
    private final ScreenManager manager;
    private final Scanner scanner;

    public GameScreen(Game game, ScreenManager manager, Scanner scanner) {
        this.game = game;
        this.manager = manager;
        this.scanner = scanner;
    }

    @Override
    public void run(ScreenManager manager) {

    }
}
