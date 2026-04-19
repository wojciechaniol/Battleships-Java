package battleships.UI.OfflineGame.GameStates;

import battleships.gameLogic.GamePlayer;

import java.util.Scanner;

public interface IState {
    void render();
    IState takeInput();
}
