package org.example.gameLogic;

public abstract class IShip {
    private boolean isAlive;
    private int hitsNumber;

    protected IShip() {
        isAlive = false;
        hitsNumber = 0;
    }

    public void incrementHit() {
        hitsNumber++;
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
