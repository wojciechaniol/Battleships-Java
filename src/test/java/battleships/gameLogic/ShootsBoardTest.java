package battleships.gameLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestShootsBoard extends ShootsBoard {
    public TestShootsBoard() {
        super();
    }

    char getVisualBoard(int x, int y) { return visualBoard[y][x]; }
    Square getSquare(int x, int y) { return board[y][x]; }
    void markSquare(int x, int y) { markSquareBoard(x, y);}
    void markShipPresenceSquare(int x, int y) { markShipPresenceSquareBoard(x, y); }
    void changeVisual(int x, int y, char character) { changeVisualBoard(x, y, character); }
    boolean empty(int x, int y) { return isEmpty(x, y); }
}

class ShootsBoardTest {
    TestShootsBoard testShootsBoard;
    char miss = '●';
    char hit = 'X';

    @BeforeEach
    void setUp() {
        testShootsBoard = new TestShootsBoard();
    }

    @Test
    void setHitMarkSquareBoard() {
        testShootsBoard.markSquare(2, 3);

        assertTrue(testShootsBoard.getSquare(2, 3).getIsHit());
    }

    @Test
    void markShipPresenceSquare() {
        testShootsBoard.markShipPresenceSquare(2, 3);

        assertTrue(testShootsBoard.getSquare(2, 3).getIsShipThere());
    }

    @Test
    void changeVisual() {
        testShootsBoard.changeVisual(2, 3, miss);

        assertEquals(miss, testShootsBoard.getVisualBoard(2,3));
    }

    @Test
    void processMiss() {
        Coordinate coord = new Coordinate('A', 5);

        testShootsBoard.processMiss(coord);
        assertTrue(testShootsBoard.getSquare(coord.getNumberCorrespondingToLetter()-1,coord.getNumber()-1).getIsHit());
        assertEquals(miss, testShootsBoard.getVisualBoard(coord.getNumberCorrespondingToLetter()-1,coord.getNumber()-1));
    }

    @Test
    void processHit() {
        Coordinate coord = new Coordinate('A', 5);

        testShootsBoard.processHit(coord);
        assertTrue(testShootsBoard.getSquare(coord.getNumberCorrespondingToLetter()-1,coord.getNumber()-1).getIsHit());
        assertTrue(testShootsBoard.getSquare(coord.getNumberCorrespondingToLetter()-1,coord.getNumber()-1).getIsShipThere());
        assertEquals(hit, testShootsBoard.getVisualBoard(coord.getNumberCorrespondingToLetter()-1,coord.getNumber()-1));
    }

    @Test
    void noShipThere() {
        assertTrue(testShootsBoard.empty(2, 3));
    }

    @Test
    void processSinkingShip() {
        for (char j = 'C'; j <= 'D'; j++) {
            Coordinate coord = new Coordinate(j, 8);
            testShootsBoard.processHit(coord);
            testShootsBoard.processSinkingShip(coord);
        }

        for (int i = 6; i < 9; i++) {
            for (int j = 1; j < 5; j++) {
                if (testShootsBoard.isEmpty(j, i)) {
                    assertEquals(miss, testShootsBoard.getVisualBoard(j, i));
                }
                else {
                    assertEquals(hit, testShootsBoard.getVisualBoard(j, i));
                }
            }
        }

    }
}