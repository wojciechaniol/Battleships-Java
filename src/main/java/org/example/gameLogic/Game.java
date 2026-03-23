package org.example.gameLogic;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;

public class Game {
    ArrayList<GamePlayer> players;
    GamePlayer currentPlayer;
    int currentPlayerIndex;
    // GameState

    public Game(GamePlayer p1, GamePlayer p2) {
        if (p1 == null || p2 == null)
            throw new IllegalArgumentException("Players can't be null");

        players = new ArrayList<>();
        currentPlayer = null;
        players.add(p1);
        players.add(p2);
    }

    private void setBoards() {
        ShipsBoard shipsBoardP1 = new ShipsBoard();
        ShootsBoard shootsBoardP1 = new ShootsBoard();
        players.getFirst().setShipsBoard(shipsBoardP1);
        players.getFirst().setShootsBoard(shootsBoardP1);

        ShipsBoard shipsBoardP2 = new ShipsBoard();
        ShootsBoard shootsBoardP2 = new ShootsBoard();
        players.get(1).setShipsBoard(shipsBoardP2);
        players.get(1).setShootsBoard(shootsBoardP2);
    }

    private void setCurrentPlayer(int index) {
        if (index != 0 && index != 1)
            throw new IllegalArgumentException("Index should have value either 0 or 1");

        currentPlayer = players.get(index);
        currentPlayerIndex = index;
    }

    private void selectStartingPlayerRandomly() {
        Random rand = new Random();

        int randomNumber = rand.nextInt(100);
        int index = randomNumber%2;

        setCurrentPlayer(index);
    }

    public boolean placeShipVertically(IShip ship, Coordinate coord) {
        return currentPlayer.getShipsBoard().placeShipVertically(ship, coord);
    }

    public boolean placeShipHorizontally(IShip ship, Coordinate coord) {
        return currentPlayer.getShipsBoard().placeShipHorizontally(ship, coord);
    }

    public boolean fireShoot(Coordinate coord) {
        int x = coord.getNumberCorrespondingToLetter()-1;
        int y = coord.getNumber()-1;
        int indexOfOpposingPlayer = abs(currentPlayerIndex-1);

        return players.get(indexOfOpposingPlayer).getShipsBoard().isShipPlacedThere(x, y);
    }

    public boolean isGameOver() {
        for (GamePlayer player : players) {
            if (player.allShipsSank())
                return true;
        }

        return false;
    }
}
