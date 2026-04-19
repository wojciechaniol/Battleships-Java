package battleships.gameLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestShipsBoard extends ShipsBoard {
    public TestShipsBoard() {
        super();
    }

    char getVisualBoard(int x, int y) { return visualBoard[y][x]; }
    Square getSquare(int x, int y) { return board[y][x]; }
    boolean isSurroundingClear(int startingLetter, int startingNumber,
                                int endingLetter, int endingNumber, boolean isHorizontal) {
        return isSurroundingAreaClear(startingLetter, startingNumber,
                endingLetter, endingNumber, isHorizontal);
    }
}

class ShipsBoardTest {
    TestShipsBoard testShipsBoard;

    @BeforeEach
    void setUp() {
        testShipsBoard = new TestShipsBoard();
    }

    @Test
    void isShipPlacedThere() {
        testShipsBoard = new TestShipsBoard();
    }

    // ==== True tests for isSurroundingAreaClear (No ships on board) ======
    // End of the name of test indicates which position on board the test is checking
    // 00 - means coordinate 0,0; 100 - means coordinate 10,0 etc.

    @Test
    void isSurroundingAreaClearHorizontalTrue00() {
        boolean success = testShipsBoard.isSurroundingClear(1, 1,
                2, 1, true);

        assertTrue(success);
    }

    @Test
    void isSurroundingAreaClearVerticalTrue00() {
        boolean success = testShipsBoard.isSurroundingClear(1, 1,
                1, 2, false);

        assertTrue(success);
    }

    @Test
    void isSurroundingAreaClearHorizontalTrue010() {
        boolean success = testShipsBoard.isSurroundingClear(8, 0,
                10, 0, true);

        assertTrue(success);
    }

    @Test
    void isSurroundingAreaClearVerticalTrue010() {
        boolean success = testShipsBoard.isSurroundingClear(0, 8,
                0, 10, false);

        assertTrue(success);
    }

    @Test
    void isSurroundingAreaClearHorizontalTrue1010() {
        boolean success = testShipsBoard.isSurroundingClear(8, 10,
                10, 10, true);

        assertTrue(success);
    }

    @Test
    void isSurroundingAreaClearVerticalTrue1010() {
        boolean success = testShipsBoard.isSurroundingClear(10, 8,
                10, 10, false);

        assertTrue(success);
    }

    @Test
    void isSurroundingAreaClearHorizontalTrue100() {
        boolean success = testShipsBoard.isSurroundingClear(8, 0,
                10, 0, true);

        assertTrue(success);
    }

    @Test
    void isSurroundingAreaClearVerticalTrue100() {
        boolean success = testShipsBoard.isSurroundingClear(10, 0,
                10, 2, false);

        assertTrue(success);
    }

    @Test
    void isSurroundingAreaClearHorizontalTrueMiddle() {
        boolean success = testShipsBoard.isSurroundingClear(5, 5,
                8, 5, true);

        assertTrue(success);
    }

    @Test
    void isSurroundingAreaClearVerticalTrueMiddle() {
        boolean success = testShipsBoard.isSurroundingClear(5, 4,
                5, 7, false);

        assertTrue(success);
    }

    // ==== False tests for isSurroundingAreaClear (Two ships on board, one blocking) ======

    @Test
    void isSurroundingAreaClearHorizontalFalseShipTooCloseMiddle() {
        IShip ship = new ShipFour();
        Coordinate coord = new Coordinate('D', 5);

        testShipsBoard.placeShipHorizontally(ship, coord);

        boolean success = testShipsBoard.isSurroundingClear(2, 5,
                5, 5, true);

        assertFalse(success);
    }

    @Test
    void isSurroundingAreaClearVerticalFalseShipTooCloseMiddle() {
        IShip ship = new ShipFour();
        Coordinate coord = new Coordinate('D', 5);

        testShipsBoard.placeShipHorizontally(ship, coord);

        boolean success = testShipsBoard.isSurroundingClear(3, 2,
                3, 4, false);

        assertFalse(success);
    }

    @Test
    void isSurroundingAreaClearHorizontalFalseShipTooCloseEdge() {
        IShip ship = new ShipThree();
        Coordinate coord = new Coordinate('C', 2);

        testShipsBoard.placeShipHorizontally(ship, coord);

        boolean success = testShipsBoard.isSurroundingClear(1, 1,
                3, 1, true);

        assertFalse(success);
    }

    @Test
    void isSurroundingAreaClearVerticalFalseShipTooCloseEdge() {
        IShip ship = new ShipThree();
        Coordinate coord = new Coordinate('B', 2);

        testShipsBoard.placeShipHorizontally(ship, coord);

        boolean success = testShipsBoard.isSurroundingClear(1, 1,
                1, 4, false);

        assertFalse(success);
    }

    @Test
    void isSurroundingAreaClearHorizontalFalseShipTooCloseAdjacentDiagonallyBeginning() {
        IShip ship = new ShipThree();
        Coordinate coord = new Coordinate('C', 2);

        testShipsBoard.placeShipHorizontally(ship, coord);

        // test for a ship of length 4 at coordinate E3
        boolean success = testShipsBoard.isSurroundingClear(4, 2,
                7, 2, true);

        assertFalse(success);
    }

    @Test
    void isSurroundingAreaClearVerticalFalseShipTooCloseAdjacentDiagonallyBeginning() {
        IShip ship = new ShipThree();
        Coordinate coord = new Coordinate('C', 2);

        testShipsBoard.placeShipHorizontally(ship, coord);

        // test for a ship of length 3 on coordinate E3 placed vertically
        boolean success = testShipsBoard.isSurroundingClear(4, 2,
                4, 4, false);

        assertFalse(success);
    }

    @Test
    void isSurroundingAreaClearHorizontalFalseShipTooCloseAdjacentDiagonallyEnd() {
        IShip ship = new ShipThree();
        Coordinate coord = new Coordinate('C', 5);

        testShipsBoard.placeShipHorizontally(ship, coord);

        boolean success = testShipsBoard.isSurroundingClear(1, 4,
                2, 4, true);

        assertFalse(success);
    }

    @Test
    void isSurroundingAreaClearVerticalFalseShipTooCloseAdjacentDiagonallyEnd() {
        IShip ship = new ShipThree();
        Coordinate coord = new Coordinate('C', 5);

        testShipsBoard.placeShipHorizontally(ship, coord);

        boolean success = testShipsBoard.isSurroundingClear(4, 2,
                4, 4, false);

        assertFalse(success);
    }

    // // ==== True tests for isSurroundingAreaClear (Two ships on board, but not blocking) ======

    @Test
    void isSurroundingAreaClearHorizontalTrueShipCloseButWithEnoughSpace() {
        IShip ship = new ShipThree();
        Coordinate coord = new Coordinate('C', 2);

        testShipsBoard.placeShipHorizontally(ship, coord);

        boolean success = testShipsBoard.isSurroundingClear(0, 0,
                0, 0, true);

        assertTrue(success);
    }

    @Test
    void isSurroundingAreaClearVerticalTrueShipCloseButWithEnoughSpace() {
        IShip ship = new ShipThree();
        Coordinate coord = new Coordinate('C', 2);

        testShipsBoard.placeShipHorizontally(ship, coord);

        boolean success = testShipsBoard.isSurroundingClear(0, 1,
                0, 4, false);

        assertTrue(success);
    }

    @Test
    void isSurroundingAreaClearHorizontalTrueShipCloseButWithEnoughSpaceMiddle() {
        IShip ship = new ShipThree();
        Coordinate coord = new Coordinate('C', 2);

        testShipsBoard.placeShipHorizontally(ship, coord);

        boolean success = testShipsBoard.isSurroundingClear(7, 3,
                9, 3, true);

        assertTrue(success);
    }

    @Test
    void isSurroundingAreaClearVerticalTrueShipCloseButWithEnoughSpaceMiddle() {
        IShip ship = new ShipThree();
        Coordinate coord = new Coordinate('C', 2);

        testShipsBoard.placeShipHorizontally(ship, coord);

        boolean success = testShipsBoard.isSurroundingClear(7, 3,
                7, 5, false);

        assertTrue(success);
    }

    // ====== End of isSurroundingAreaClear Tests =================

    @Test
    void placeShipHorizontallyShipNull() {
        assertThrows(IllegalArgumentException.class,
                () -> testShipsBoard.placeShipHorizontally(null, new Coordinate('D',2)));
    }

    @Test
    void placeShipHorizontallyCoordinateNull() {
        assertThrows(IllegalArgumentException.class,
                () -> testShipsBoard.placeShipHorizontally(new ShipFour(), null));
    }

    @Test
    void placeShipHorizontallyTooLong() {
        IShip ship = new ShipFour();
        Coordinate coord = new Coordinate('H', 2);

        boolean success = testShipsBoard.placeShipHorizontally(ship, coord);

        assertFalse(success);
    }

    @Test
    void placeShipHorizontallyCorrect() {
        IShip ship = new ShipTwo();
        Coordinate coord = new Coordinate('H', 2);

        boolean success = testShipsBoard.placeShipHorizontally(ship, coord);

        assertTrue(success);
    }

    @Test
    void placeShipHorizontallyCheckPresence() {
        IShip ship = new ShipFour();
        Coordinate coord = new Coordinate('F', 2);

        testShipsBoard.placeShipHorizontally(ship, coord);

        for (int i = coord.getNumberCorrespondingToLetter()-1; i < coord.getNumberCorrespondingToLetter()+ship.getLength() - 1; i++) {
            assertTrue(testShipsBoard.isShipPlacedThere(i, coord.getNumber()-1));
        }
    }

    @Test
    void placeShipHorizontallyCheckVisualPresence() {
        IShip ship = new ShipFour();
        Coordinate coord = new Coordinate('F', 2);
        char presenceCheck = 'X'; //⬛

        testShipsBoard.placeShipHorizontally(ship, coord);

        for (int i = coord.getNumberCorrespondingToLetter()-1; i < coord.getNumberCorrespondingToLetter()+ship.getLength() - 1; i++) {
            assertEquals(presenceCheck, testShipsBoard.getVisualBoard(i, coord.getNumber()-1));
        }
    }

    @Test
    void placeShipVerticallyShipNull() {
        assertThrows(IllegalArgumentException.class,
                () -> testShipsBoard.placeShipVertically(null, new Coordinate('D',2)));
    }

    @Test
    void placeShipVerticallyCoordinateNull() {
        assertThrows(IllegalArgumentException.class,
                () -> testShipsBoard.placeShipVertically(new ShipFour(), null));
    }

    @Test
    void placeShipVerticallyTooLong() {
        IShip ship = new ShipFour();
        Coordinate coord = new Coordinate('H', 8);

        boolean success = testShipsBoard.placeShipVertically(ship, coord);

        assertFalse(success);
    }

    @Test
    void placeShipVerticallyCorrect() {
        IShip ship = new ShipFour();
        Coordinate coord = new Coordinate('H', 5);

        boolean success = testShipsBoard.placeShipVertically(ship, coord);

        assertTrue(success);
    }

    @Test
    void placeShipVerticallyCheckPresence() {
        IShip ship = new ShipFour();
        Coordinate coord = new Coordinate('H', 5);

        testShipsBoard.placeShipVertically(ship, coord);

        for (int i = coord.getNumber()-1; i < coord.getNumber()+ship.getLength() - 1; i++) {
            assertTrue(testShipsBoard.isShipPlacedThere(coord.getNumberCorrespondingToLetter()-1, i));
        }
    }

    @Test
    void placeShipVerticallyCheckVisualPresence() {
        IShip ship = new ShipFour();
        Coordinate coord = new Coordinate('H', 5);
        char presenceCheck = 'X'; // ⬛

        testShipsBoard.placeShipVertically(ship, coord);

        for (int i = coord.getNumber()-1; i < coord.getNumber()+ship.getLength() - 1; i++) {
            assertEquals(presenceCheck, testShipsBoard.getVisualBoard(coord.getNumberCorrespondingToLetter()-1, i));
        }
    }


    @Test
    void processHit() {
        IShip ship = new ShipFour();
        Coordinate coord = new Coordinate('A', 2);

        testShipsBoard.placeShipHorizontally(ship, coord);

        testShipsBoard.processHit(coord.getNumberCorrespondingToLetter()-1, coord.getNumber()-1);

        assertTrue(testShipsBoard.getSquare(coord.getNumberCorrespondingToLetter()-1, coord.getNumber()-1).getIsHit());
        assertEquals(1, ship.getHitsNumber());
    }

    @Test
    void processHitMissed() {
        IShip ship = new ShipFour();
        Coordinate coord = new Coordinate('A', 2);

        testShipsBoard.placeShipHorizontally(ship, coord);

        testShipsBoard.processHit(coord.getNumberCorrespondingToLetter()-1, coord.getNumber());

        assertTrue(testShipsBoard.getSquare(coord.getNumberCorrespondingToLetter()-1, coord.getNumber()).getIsHit());
        assertEquals(0, ship.getHitsNumber());
    }
}