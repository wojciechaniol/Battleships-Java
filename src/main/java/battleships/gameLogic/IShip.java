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
}
