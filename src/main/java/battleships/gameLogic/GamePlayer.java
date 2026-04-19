package battleships.gameLogic;

import battleships.player.GuestPlayer;
import battleships.player.IPlayer;
import battleships.player.Player;

import java.util.ArrayList;

public class GamePlayer {
    private static final int LIMIT_OF_SHIPS = 1;
    private final IPlayer player;
    private boolean isReady;
    private ShipsBoard shipsBoard;
    private ShootsBoard shootsBoard;
    private final ArrayList<IShip> fleet;

    public GamePlayer(String nickname) {
        player = new GuestPlayer(nickname);
        fleet = new ArrayList<>();
        isReady = false;
    }

    public GamePlayer(Player player) {
        if (player == null)
            throw new IllegalArgumentException("Player can't be null");
        this.player = player;
        fleet = new ArrayList<>();
        isReady = false;
    }

    public void setShipsBoard(ShipsBoard board) {
        if (board == null || shipsBoard != null)
            throw new IllegalArgumentException("Board can't be null or be assigned multiple times");

        shipsBoard = board;
    }

    public void setShootsBoard(ShootsBoard board) {
        if (board == null || shootsBoard != null)
            throw new IllegalArgumentException("Board can't be null or be assigned multiple times");

        shootsBoard = board;
    }

    public boolean placeShipVertically(IShip ship, Coordinate coord) {
        boolean success = shipsBoard.placeShipVertically(ship, coord);

        if (success) {
            addShip(ship);
        }

        return success;
    }

    public boolean placeShipHorizontally(IShip ship, Coordinate coord) {
        boolean success = shipsBoard.placeShipHorizontally(ship, coord);

        if (success) {
            addShip(ship);
        }

        return success;
    }

    public boolean tooManyShipsOfSize(int size) {
        if (size < 1 || size > 4) {
            throw new IllegalArgumentException("Size of a ship must be between 1 and 4");
        }

        int count = 0;

        for (IShip ship : fleet) {
            if (ship.getLength() == size) {
                count++;
            }

            if (count > (4 - size + 1)) {
                return true;
            }
        }

        return false;
    }

    public boolean fleetCompleted() {
        return fleet.size() == LIMIT_OF_SHIPS;
    }

    public void addShip(IShip ship) {
        if (ship == null)
            throw new IllegalArgumentException("Ship can't be null");

        fleet.add(ship);
    }

    public boolean allShipsSank() {
        System.out.println("Chacking liveness of the fleet");
        if (fleet.isEmpty())
            throw new RuntimeException("There are no ships in the fleet");

        for (IShip ship : fleet) {
            System.out.println("Live lost: " + ship.getHitsNumber() + "/" + ship.getLength());
            if (ship.isAlive())
                return false;
        }

        return true;
    }

    public ArrayList<IShip> getFleet() {
        return fleet;
    }

    public ShipsBoard getShipsBoard() {
        return shipsBoard;
    }

    public ShootsBoard getShootsBoard() {
        return shootsBoard;
    }

    public String getNickname() {
        return player.getNickname();
    }

    public boolean getIsReady() {
        return isReady;
    }

    public void setReady() {
        isReady = true;
    }
}
