package battleships.UI;

import battleships.gameLogic.Coordinate;

public class CoordinateParser {
    public static Coordinate parse(String input) {
        if (input == null || input.isBlank())
            throw new IllegalArgumentException("Input cannot be empty");

        String[] parts = input.trim().split("\\s+");

        if (parts.length != 2)
            throw new IllegalArgumentException("Input must be in format: A 1");

        if (parts[0].length() != 1)
            throw new IllegalArgumentException("Letter must be a single character");

        char letter = parts[0].charAt(0);

        int number;
        try {
            number = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Number must be a valid integer");
        }

        try {
            return new Coordinate(letter, number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Coordinate doesn't exist: " + e.getMessage());
        }
    }
}
