package org.example.gameLogic;

import org.example.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GamePlayerTest {
    Player alicePlayer;
    GamePlayer alice;
    GamePlayer guestGamePlayer;

    @BeforeEach
    void setUp() {
        alicePlayer = new Player("Alice");
        alice = new GamePlayer(alicePlayer);
        guestGamePlayer = new GamePlayer("Guest");
    }

    @Test
    void playerConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            Player player1 = null;
            GamePlayer player = new GamePlayer(player1);
        });
    }

    @Test
    void setShipsBoardNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            alice.setShipsBoard(null);
        });
    }

    @Test
    void setShipsBoardAlreadySet() {
        ShipsBoard board1 = new ShipsBoard();
        alice.setShipsBoard(board1);
        ShipsBoard board2 = new ShipsBoard();

        assertThrows(IllegalArgumentException.class, () -> {
            alice.setShipsBoard(board2);
        });
    }

    @Test
    void setShootsBoardNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            alice.setShootsBoard(null);
        });
    }

    @Test
    void setShootsBoardAlreadySet() {
        ShootsBoard board1 = new ShootsBoard();
        alice.setShootsBoard(board1);
        ShootsBoard board2 = new ShootsBoard();

        assertThrows(IllegalArgumentException.class, () -> {
            alice.setShootsBoard(board2);
        });
    }

    @Test
    void addShipNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            alice.addShip(null);
        });
    }

    @Test
    void addShip() {
        IShip ship = new ShipFour();
        alice.addShip(ship);
        ArrayList<IShip> fleet = alice.getFleet();
        assertFalse(fleet.isEmpty());
    }

    @Test
    void allShipsSankFalse() {
        IShip ship1 = new ShipOne();
        IShip ship2 = new ShipTwo();
        alice.addShip(ship1);
        alice.addShip(ship2);

        ship1.sink();

        assertFalse(alice.allShipsSank());
    }

    @Test
    void allShipsSankEmpty() {
        assertThrows(RuntimeException.class, () -> {
            alice.allShipsSank();
        });
    }

    @Test
    void allShipsSankTrue() {
        IShip ship1 = new ShipOne();
        IShip ship2 = new ShipTwo();
        alice.addShip(ship1);
        alice.addShip(ship2);

        ship1.incrementHit();
        ship2.incrementHit();
        ship2.incrementHit();

        ship1.sink();
        ship2.sink();

        assertTrue(alice.allShipsSank());
    }

    @Test
    void getShipsBoardNull() {
        ShipsBoard board = alice.getShipsBoard();
        assertNull(board);
    }

    @Test
    void getShipsBoard() {
        ShipsBoard boardToSet = new ShipsBoard();
        alice.setShipsBoard(boardToSet);
        ShipsBoard boardToGet = alice.getShipsBoard();
        assertEquals(boardToGet, boardToSet);
    }

    @Test
    void getShootsBoardNull() {
        ShootsBoard boardToGet = alice.getShootsBoard();
        assertNull(boardToGet);
    }

    @Test
    void getShootsBoard() {
        ShootsBoard boardToSet = new ShootsBoard();
        alice.setShootsBoard(boardToSet);
        ShootsBoard boardToGet = alice.getShootsBoard();
        assertEquals(boardToGet, boardToSet);
    }

    @Test
    void getNicknameAlice() {
        String aliceString = "Alice";
        assertEquals(aliceString, alice.getNickname());
    }

    @Test
    void getNicknameGuest() {
        String guestString = "Guest";
        assertEquals(guestString, guestGamePlayer.getNickname());
    }

    @Test
    void getIsReadyFalse() {
        assertFalse(alice.getIsReady());
    }

    @Test
    void getIsReadyTrue() {
        alice.setReady();
        assertTrue(alice.getIsReady());
    }
}