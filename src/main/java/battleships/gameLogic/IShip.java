package battleships.gameLogic;

public abstract class IShip {
    private boolean isAlive;
    private int hitsNumber;

    protected IShip() {
        isAlive = true;
        hitsNumber = 0;
    }

    public int getHitsNumber() {
        return hitsNumber;
    }

    public void incrementHit() {
        hitsNumber++;

        if (hitsNumber == getLength())
            this.sink();
    }

    public void sink() {
        if (hitsNumber == getLength())
            isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public abstract int getLength();

    public static IShip ofLength(int length) {
        return switch (length) {
            case 1 -> new ShipOne();
            case 2 -> new ShipTwo();
            case 3 -> new ShipThree();
            case 4 -> new ShipFour();
            default -> throw new IllegalArgumentException("Invalid ship length: " + length);
        };
    }
}
