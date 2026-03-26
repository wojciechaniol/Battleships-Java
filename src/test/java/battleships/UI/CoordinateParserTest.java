package battleships.UI;

import battleships.gameLogic.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateParserTest {
    @Test
    void parseNull() {
        assertThrows(IllegalArgumentException.class,
                () -> { CoordinateParser.parse(null); });
    }

    @Test
    void parseEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> { CoordinateParser.parse(""); });
    }

    @Test
    void parseManyWhiteSpaces() {
        String input = "D       2";
        Coordinate coord = CoordinateParser.parse(input);
        assertEquals(2, coord.getNumber());
        assertEquals('D', coord.getLetter());
    }

    @Test
    void parseNoWhiteSpace() {
        String input = "D2";
        assertThrows(IllegalArgumentException.class,
                () -> { CoordinateParser.parse(input); });
    }

    @Test
    void parseMultipleLetters() {
        String input = "DD 2";
        assertThrows(IllegalArgumentException.class,
                () -> { CoordinateParser.parse(input); });
    }

    @Test
    void parseWrongInt() {
        String input = "D A";
        assertThrows(IllegalArgumentException.class,
                () -> { CoordinateParser.parse(input); });
    }

    @Test
    void parseWrongCoordLetter() {
        String input = "Z 10";
        assertThrows(IllegalArgumentException.class,
                () -> { CoordinateParser.parse(input); });
    }

    @Test
    void parseWrongCoordinateNumber() {
        String input = "A 0";
        assertThrows(IllegalArgumentException.class,
                () -> { CoordinateParser.parse(input); });
    }

    @Test
    void parseCorrect() {
        String input = "A 1";
        Coordinate coord = CoordinateParser.parse(input);
        assertEquals(1, coord.getNumber());
        assertEquals('A', coord.getLetter());
    }
}