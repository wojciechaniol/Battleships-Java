package org.example.player;

import java.util.UUID;

public class Player implements IPlayer {
    private String nickname;
    private int gamesPlayed;
    private int gamesWon;
    private final UUID playerID;
    private PlayerStatus status;

    Player(String nickname) {
        this.nickname = nickname;
        gamesPlayed = 0;
        gamesWon = 0;
        playerID = UUID.randomUUID();
        status = PlayerStatus.ONLINE; // status should depend on heartbeats and should not be hardcoded
    }

    @Override
    public String getNickname() {
        return nickname;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public String getPlayerID() {
        return playerID.toString();
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void incrementGamesPlayed() {
        gamesPlayed++;
    }

    public void incrementGamesWon() {
        gamesWon++;
    }

    public void changeStatusToOFFLINE() {
        status = PlayerStatus.OFFLINE;
    }

    public void changeStatusToONLINE() {
        status = PlayerStatus.ONLINE;
    }

    public void changeStatusToINGAME() {
        status = PlayerStatus.IN_GAME;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof Player otherPlayer))
            return false;

        return nickname.equals(otherPlayer.getNickname()) &&
                playerID.toString().equals(otherPlayer.getPlayerID()) &&
                gamesPlayed == otherPlayer.getGamesPlayed() &&
                gamesWon == otherPlayer.getGamesWon();
    }
}
