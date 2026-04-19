package battleships.gameLogic;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;

public class Game {
    ArrayList<GamePlayer> players;
    GamePlayer currentPlayer;
    int currentPlayerIndex;

    public Game(GamePlayer p1, GamePlayer p2) {
        if (p1 == null || p2 == null)
            throw new IllegalArgumentException("Players can't be null");

        players = new ArrayList<>();
        currentPlayer = null;
        players.add(p1);
        players.add(p2);
        setBoards();
        selectStartingPlayerRandomly();
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

    public ShipsBoard getCurrentPlayerShipsBoard() {
        return currentPlayer.getShipsBoard();
    }

    public GamePlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean arePlayersShipsSet() { return currentPlayer.fleetCompleted(); }

    public boolean tooManyShipsOfSize(int size) { return currentPlayer.tooManyShipsOfSize(size); }

    public void changePlayer() {
        int tempIndex = (currentPlayerIndex+1)%2;
        currentPlayer = players.get(tempIndex);
        currentPlayerIndex = tempIndex;
    }

    private void setCurrentPlayer(int index) {
        if (index != 0 && index != 1)
            throw new IllegalArgumentException("Index should have value either 0 or 1");

        currentPlayer = players.get(index);
        currentPlayerIndex = index;
    }

    public ArrayList<GamePlayer> getPlayers() {
        return players;
    }

    private void selectStartingPlayerRandomly() {
        Random rand = new Random();

        int randomNumber = rand.nextInt(100);
        int index = randomNumber%2;

        setCurrentPlayer(index);
    }

    public boolean placeShipVertically(IShip ship, Coordinate coord) {
        return currentPlayer.placeShipVertically(ship, coord);
    }

    public boolean placeShipHorizontally(IShip ship, Coordinate coord) {
        return currentPlayer.placeShipHorizontally(ship, coord);
    }

    public boolean fireShoot(Coordinate coord) {
        if (coord == null)
            throw new IllegalArgumentException("Coordinate can't be null");

        int indexOfOpposingPlayer = (currentPlayerIndex+1)%2;

        return players.get(indexOfOpposingPlayer).getShipsBoard().processShot(coord);
    }

    public boolean isGameOver() {
        for (GamePlayer player : players) {
            if (player.allShipsSank())
                return true;
        }

        return false;
    }
}
