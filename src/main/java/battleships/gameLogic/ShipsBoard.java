package battleships.gameLogic;

public class ShipsBoard extends AbstractBoard {
    public ShipsBoard() {
        super();
        initializeSquareBoard();
        initializeVisualBoard();
    }

    private void placeShip(IShip ship, int x, int y) {
        board[y][x].setShipThere(ship);
    }

    private void placeShipVisualBoard(int x, int y) {
        visualBoard[y][x] = 'X';
    } // ⬛

    protected boolean isSurroundingAreaClear(int startingLetter, int startingNumber, int endingLetter, int endingNumber, boolean isHorizontal) {
        int longStart = isHorizontal ? startingLetter : startingNumber;
        int longEnd   = isHorizontal ? endingLetter   : endingNumber;
        int shortPos  = isHorizontal ? startingNumber : startingLetter;

        for (int i = longStart - 1; i < longEnd + 2; i++) {
            if (!Coordinate.isNumberInBoundaries(i + 1)) continue;

            for (int j = shortPos - 1; j < shortPos + 2; j++) {
                if (!Coordinate.isNumberInBoundaries(j + 1)
                        || (j == shortPos && (i >= longStart && i <= longEnd))) {
                    continue;
                }

                int col = isHorizontal ? i : j;
                int row = isHorizontal ? j : i;

                if (isShipPlacedThere(col, row)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean processShot(Coordinate coord) {
        int x = coord.getNumberCorrespondingToLetter()-1;
        int y = coord.getNumber()-1;

        processHit(x, y);

        return isShipPlacedThere(x, y);
    }

    public boolean isShipPlacedThere(int x, int y) {
        return board[y][x].getIsShipThere();
    }

    protected void shipPlacementErrorMessage(int number, char letter, int length, String additionalText) {
        System.out.println("The given coordinate: (" + number + ", " + letter + ")" +
                " doesn't allow to place a ship of length: " + length + " there");

        if (additionalText != null && !additionalText.isBlank())
            System.out.println(additionalText);

        System.out.println("Provide the coordinates again");
    }

    public boolean placeShipHorizontally(IShip ship, Coordinate coord) {
        if (ship == null || coord == null)
            throw new IllegalArgumentException("Ship and Coordinate can't be null");

        int length = ship.getLength();
        int startingNumber = coord.getNumber();
        char letter = coord.getLetter();
        int startingLetter = coord.getNumberCorrespondingToLetter();
        int endingLetter = (startingLetter + length) - 1;

        if (!Coordinate.isNumberInBoundaries(endingLetter)) {
            shipPlacementErrorMessage(startingNumber, letter, length, "Ship is out of boundaries horizontally");
            return false;
        }

        for (int i = startingLetter-1; i < endingLetter; i++) {
            if (isShipPlacedThere(i, startingNumber-1)) {
                shipPlacementErrorMessage(startingNumber, letter, length, "There is another ship at those coordinates");
                return false;
            }
        }

        if (!isSurroundingAreaClear(startingLetter-1, startingNumber-1, endingLetter-1, startingLetter-1, true)) {
            shipPlacementErrorMessage(startingNumber, letter, length, "There is another ship in this area");
            return false;
        }

        for (int i = startingLetter-1; i < endingLetter; i++) {
            placeShip(ship, i, startingNumber-1);
            placeShipVisualBoard(i, startingNumber-1);
        }

        return true;
    }

    public boolean placeShipVertically(IShip ship, Coordinate coord) {
        if (ship == null || coord == null)
            throw new IllegalArgumentException("Ship and Coordinate can't be null");

        int length = ship.getLength();
        int startingNumber = coord.getNumber();
        char letter = coord.getLetter();
        int startingLetter = coord.getNumberCorrespondingToLetter();
        int endingNumber = (startingNumber+length) - 1;

        if (!Coordinate.isNumberInBoundaries(endingNumber)) {
            shipPlacementErrorMessage(startingNumber, letter, length, "Ship is out of boundaries vertically");
            return false;
        }

        for (int i = startingNumber-1; i < endingNumber; i++) {
            if (isShipPlacedThere(startingLetter-1, i)) {
                shipPlacementErrorMessage(startingNumber, letter, length, "There is another ship at those coordinates");
                return false;
            }
        }

        if (!isSurroundingAreaClear(startingLetter-1, startingNumber-1, startingLetter-1, endingNumber-1, false)) {
            shipPlacementErrorMessage(startingNumber, letter, length, "There is another ship in this area");
            return false;
        }

        for (int i = startingNumber-1; i < endingNumber; i++) {
            placeShip(ship, startingLetter-1, i);
            placeShipVisualBoard(startingLetter-1,i);
        }

        return true;
    }

    public void processHit(int x, int y) {
        board[y][x].setHit();

        if (isShipPlacedThere(x, y)) {
            board[y][x].getShip().incrementHit();
        }
    }
}
