package battleships.gameLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IShipTest {
    IShip ship;
    int length;

    @BeforeEach
    void setUp() {
        ship = new ShipFour();
        length = 4;
    }

    @Test
    void incrementHitOnce() {
        ship.incrementHit();

        assertTrue(ship.isAlive());
        assertEquals(1, ship.getHitsNumber());
    }

    @Test
    void incrementHitTillSank() {
        for (int i = 0; i < ship.getLength(); i++)
            ship.incrementHit();

        assertFalse(ship.isAlive());
    }

    @Test
    void sinkFalse() {
        ship.sink();

        assertTrue(ship.isAlive());
    }

    @Test
    void isAlive() {
        assertTrue(ship.isAlive());
    }

    @Test
    void getLength() {
        assertEquals(length, ship.getLength());
    }
}