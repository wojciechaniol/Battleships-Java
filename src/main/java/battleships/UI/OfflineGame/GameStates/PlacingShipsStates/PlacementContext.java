package battleships.UI.OfflineGame.GameStates.PlacingShipsStates;

import battleships.gameLogic.Coordinate;

public class PlacementContext {
    private int orientation;
    private Coordinate coord;
    private int length;

    public void clearContext() {
        orientation = 0;
        coord = null;
        length = 0;
    }

    public void setOrientation(int orientation) {
        if (orientation == 1 || orientation == 2)
            this.orientation = orientation;
        else
            throw new IllegalArgumentException("Orientation can be equal 1 or 2");
    }

    public void setCoord(Coordinate coord) {
        if (coord != null)
            this.coord = coord;
        else
            throw new IllegalArgumentException("Coordinate can't be null");
    }

    public void setLength(int length) {
        if (length >= 1 && length <= 4)
            this.length = length;
        else
            throw new IllegalArgumentException("Length must be between 1 and 4");
    }

    public int getOrientation() {
        return orientation;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public int getLength() {
        return length;
    }
}
