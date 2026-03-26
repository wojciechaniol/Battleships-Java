package battleships.gameLogic;

public class ShootsBoard extends AbstractBoard {
    public ShootsBoard() {
        super();
        initializeSquareBoard();
        initializeVisualBoard();
    }

    protected void markSquareBoard(int x, int y) {
        board[y][x].setHit();
    }

    protected void markShipPresenceSquareBoard(int x, int y) {
        board[y][x].markShipThere();
    }

    protected void changeVisualBoard(int x, int y, char character) {
        visualBoard[y][x] = character;
    }

    public void processMiss(Coordinate coord) {
        int x = coord.getNumberCorrespondingToLetter()-1;
        int y = coord.getNumber()-1;

        changeVisualBoard(x, y, '●'); //●•
        markSquareBoard(x, y);
    }

    public void processHit(Coordinate coord) {
        int x = coord.getNumberCorrespondingToLetter()-1;
        int y = coord.getNumber()-1;

        changeVisualBoard(x, y, 'X');
        markSquareBoard(x, y);
        markShipPresenceSquareBoard(x, y);
    }

    protected boolean isEmpty(int x, int y) {
        return !board[y][x].getIsShipThere();
    }

    public void processSinkingShip(Coordinate coord) {
        int x = coord.getNumberCorrespondingToLetter()-1;
        int y = coord.getNumber()-1;

        int left_x = x-1;
        int right_x = x+1;

        int bottom_y = y+1;
        int upper_y = y-1;

        char missChar = '●';

        drawMissesOnSidesOfSinkingShip(y, left_x, bottom_y, upper_y);

        drawMissesOnSidesOfSinkingShip(y, right_x, bottom_y, upper_y);

        if (Coordinate.isNumberInBoundaries(bottom_y+1) && isEmpty(x, bottom_y)) {
            changeVisualBoard(x, bottom_y, missChar);
        }

        if (Coordinate.isNumberInBoundaries(upper_y+1) && isEmpty(x, upper_y)) {
            changeVisualBoard(x, upper_y, missChar);
        }
    }

    protected void drawMissesOnSidesOfSinkingShip(int current_y, int side_x, int bottom_y, int upper_y) {
        char missChar = '●';

        if (Coordinate.isNumberInBoundaries(side_x+1) && isEmpty(side_x, current_y)) {
            changeVisualBoard(side_x, current_y, missChar);

            if (Coordinate.isNumberInBoundaries(bottom_y+1) && isEmpty(side_x, bottom_y)) {
                changeVisualBoard(side_x, bottom_y, missChar);
            }

            if (Coordinate.isNumberInBoundaries(upper_y+1) && isEmpty(side_x, upper_y)) {
                changeVisualBoard(side_x, upper_y, missChar);
            }
        }
    }
}
