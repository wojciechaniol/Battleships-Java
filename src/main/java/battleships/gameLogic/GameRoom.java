package battleships.gameLogic;

import battleships.player.Player;

import java.util.ArrayList;

public class GameRoom {
    private final ArrayList<GamePlayer> players;
    private final static String[] names = {"Turtle", "Tortoise"};
    private Game game;

    public GameRoom(Player player1) {
        if (player1 == null)
            throw new IllegalArgumentException("First player can't be null");

        players = new ArrayList<>();
        GamePlayer gamePlayer1 = new GamePlayer(player1);
        players.add(gamePlayer1);
    }

    public GameRoom() {
        players = new ArrayList<>();
        players.add(null);
        players.add(null);
    }

    protected boolean moreThan2Players() {
        int numOfPlayers = 0;

        for (GamePlayer p : players) {
            if (p != null) numOfPlayers++;
        }

        return numOfPlayers >= 2;
    }

    public void addGuestPlayer(String nickname, int index) {
        if (moreThan2Players()) {
            throw new IllegalStateException("Can't be more than 2 players in one game");
        }

        if (index >= 2)
            throw new IllegalArgumentException("Index can only be equal to 0 or 1");

        String realNickname;

        if (nickname.isEmpty()) {
            realNickname = names[index];
        } else {
            realNickname = nickname;
        }

        GamePlayer gamePlayer = new GamePlayer(realNickname);
        players.set(index, gamePlayer);
    }

    public GamePlayer getPlayer(int index) {
        return players.get(index);
    }
}
