package battleships.gameLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {
    Coordinate coord;
    int number = 1;
    char letter = 'A';

    @BeforeEach
    void setUp() {
        coord = new Coordinate(letter, number);
    }

    @Test
    void wrongLetterConstructor() {
        char letter = 'Z';
        int number = 2;

        assertThrows(IllegalArgumentException.class, () -> {
            Coordinate coord1 = new Coordinate(letter, number);
        });
    }

    @Test
    void wrongNumberConstructor() {
        char letter = 'A';
        int number = 0;

        assertThrows(IllegalArgumentException.class, () -> {
            Coordinate coord1 = new Coordinate(letter, number);
        });
    }

    @Test
    void smallLetterConstructor() {
        char letter = 'j';
        int number = 2;
        Coordinate coord1 = new Coordinate(letter, number);

        assertEquals('J', coord1.getLetter());
    }

    @Test
    void getNumber() {
        assertEquals(number, coord.getNumber());
    }

    @Test
    void getLetter() {
        assertEquals(letter, coord.getLetter());
    }

    @Test
    void getNumberCorrespondingToLetter() {
        assertEquals(number, coord.getNumberCorrespondingToLetter());
    }

    @Test
    void isLetterInBoundariesFalse() {
        for (char a = 'K'; a < 'a'; a++){
            assertFalse(Coordinate.isLetterInBoundaries(a));
        }
    }

    @Test
    void isLetterInBoundariesTrueBigLetters() {
        for (char a = 'A'; a <= 'J'; a++) {
            assertTrue(Coordinate.isLetterInBoundaries(a));
        }
    }

    @Test
    void isLetterInBoundariesTrueSmallLetters() {
        for (char a = 'a'; a <= 'j'; a++) {
            assertTrue(Coordinate.isLetterInBoundaries(a));
        }
    }

    @Test
    void isNumberInBoundariesFalse() {
        for (int a = -10; a < 1; a++){
            assertFalse(Coordinate.isNumberInBoundaries(a));
        }

        assertFalse(Coordinate.isNumberInBoundaries(11));
    }

    @Test
    void isNumberInBoundariesTrue() {
        for (int a = 1; a <= 10; a++){
            assertTrue(Coordinate.isNumberInBoundaries(a));
        }
    }
}