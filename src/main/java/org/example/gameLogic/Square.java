package org.example.gameLogic;

public class Square {
    private final Coordinate coord;
    private boolean isShipThere;
    private boolean isHit;
    private IShip ship;

    public Square(Coordinate coord) {
        if (coord == null)
            throw new IllegalArgumentException("Coordinate shouldn't be null");

        this.coord = coord;
        isShipThere = false;
        isHit = false;
    }

    public int getCoordNumber() {
        return coord.getNumber();
    }

    public char getCoordLetter() {
        return coord.getLetter();
    }

    public boolean getIsShipThere() {
        return isShipThere;
    }

    public boolean getIsHit() {
        return isHit;
    }

    public void setShipThere(IShip ship) {
        this.ship = ship;
        isShipThere = true;
    }

    public IShip getShip() {
        return ship;
    }

    public void markShipThere() {
        isShipThere = true;
    }

    public void setHit() {
        isHit = true;
    }
}
