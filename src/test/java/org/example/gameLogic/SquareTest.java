package org.example.gameLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    Square square;
    int number = 1;
    char letter = 'A';

    @BeforeEach
    void setUp() {
        Coordinate coord = new Coordinate(letter, number);
        square = new Square(coord);
    }

    @Test
    void nullConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            Square square = new Square(null);
        });
    }

    @Test
    void getCoordNumber() {
        assertEquals(number, square.getCoordNumber());
    }

    @Test
    void getCoordLetter() {
        assertEquals(letter, square.getCoordLetter());
    }

    @Test
    void getIsShipThereFalse() {
        assertFalse(square.getIsShipThere());
    }

    @Test
    void getIsShipThereTrue() {
        IShip ship = new ShipOne();
        square.setShipThere(ship);

        assertTrue(square.getIsShipThere());
    }

    @Test
    void getIsShipThereTrueWithoutShip() {
        square.markShipThere();

        assertTrue(square.getIsShipThere());
    }

    @Test
    void getIsHitFalse() {
        assertFalse(square.getIsHit());
    }

    @Test
    void getIsHitTrue() {
        square.setHit();
        assertTrue(square.getIsHit());
    }

    @Test
    void setShipThere() {
        IShip ship = new ShipFour();
        square.setShipThere(ship);

        assertEquals(ship, square.getShip());
    }

    @Test
    void getShipNull() {
        assertNull(square.getShip());
    }
}