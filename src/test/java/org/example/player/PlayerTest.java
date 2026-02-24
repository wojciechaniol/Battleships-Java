package org.example.player;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private static Player Alice;
    private static Player Bob;

    @BeforeAll
    static void setUp() {
        Alice = new Player("Alice");
        Bob = new Player("Bob");
    }

    @Test
    void getNickname() {
        String alice = "Alice";
        String nickname = Alice.getNickname();
        assertEquals(alice, nickname);
    }

    @Test
    void getGamesPlayed() {
        int gamesPlayed = 0;
        int aliceGamesPlayed = Alice.getGamesPlayed();
        assertEquals(gamesPlayed, aliceGamesPlayed);
    }

    @Test
    void getGamesWon() {
        int gamesWon = 0;
        int aliceGamesWon = Alice.getGamesWon();
        assertEquals(gamesWon, aliceGamesWon);
    }

    @Test
    void getPlayerID() {
        String playerID = Alice.getPlayerID();
        assertEquals(36, playerID.length());
    }

    @Test
    void equalsNull() {
        assertNotEquals(null, Alice);
    }

    @Test
    void equalsOtherPlayer() {
        assertNotEquals(Alice, Bob);
    }

    @Test
    void equalsSamePlayer() {
        assertEquals(Alice, Alice);
    }

    @Test
    void getStatus() {
        PlayerStatus status = PlayerStatus.ONLINE;
        PlayerStatus aliceStatus = Alice.getStatus();
        assertEquals(status, aliceStatus);
    }

    @Test
    void setNickname() {
        String newNickname = "Alice123";
        Alice.setNickname(newNickname);
        String currentNickname = Alice.getNickname();
        assertEquals(newNickname, currentNickname);
    }

    @Test
    void incrementGamesPlayed() {
        int expectedGames = Alice.getGamesPlayed() + 1;
        Alice.incrementGamesPlayed();
        int currentGames = Alice.getGamesPlayed();
        assertEquals(expectedGames, currentGames);
    }

    @Test
    void incrementGamesWon() {
        int expectedGames = Alice.getGamesWon() + 1;
        Alice.incrementGamesWon();
        int currentGames = Alice.getGamesWon();
        assertEquals(expectedGames, currentGames);
    }

    @Test
    void changeStatusToOFFLINE() {
        Alice.changeStatusToOFFLINE();
        PlayerStatus expectedStatus = PlayerStatus.OFFLINE;
        PlayerStatus currentStatus = Alice.getStatus();
        assertEquals(expectedStatus, currentStatus);
    }

    @Test
    void changeStatusToONLINE() {
        Alice.changeStatusToONLINE();
        PlayerStatus expectedStatus = PlayerStatus.ONLINE;
        PlayerStatus currentStatus = Alice.getStatus();
        assertEquals(expectedStatus, currentStatus);
    }

    @Test
    void changeStatusToINGAME() {
        Alice.changeStatusToINGAME();
        PlayerStatus expectedStatus = PlayerStatus.IN_GAME;
        PlayerStatus currentStatus = Alice.getStatus();
        assertEquals(expectedStatus, currentStatus);
    }
}