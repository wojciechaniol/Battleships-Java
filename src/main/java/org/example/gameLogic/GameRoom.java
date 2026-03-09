package org.example.gameLogic;

import org.example.player.Player;

import java.util.ArrayList;

public class GameRoom {
    ArrayList<GamePlayer> players;
    Game game;

    GameRoom(Player player1) {
        if (player1 == null)
            throw new IllegalArgumentException("First player can't be null");

        players = new ArrayList<>();
        GamePlayer gamePlayer1 = new GamePlayer(player1);
        players.add(gamePlayer1);

        game = new Game();
    }

    public void addGuestPlayer(String nickname) {
        GamePlayer gamePlayer2 = new GamePlayer(nickname);
    }
}
