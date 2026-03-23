package org.example.gameLogic;

public class Coordinate {
    private final static char LETTER_LOWER_BOUND = 'A';
    private final static char LETTER_UPPER_BOUND = 'J';
    private final static int NUMBER_LOWER_BOUND = 1;
    private final static int NUMBER_UPPER_BOUND = 10;

    private final char letter;
    private final int numberCorrespondingToLetter;
    private final int number;

    public Coordinate(char letter, int number) {
        char upperCaseLetter;
        upperCaseLetter = Character.toUpperCase(letter);
        if (!isNumberInBoundaries(number) || !isLetterInBoundaries(upperCaseLetter))
            throw new IllegalArgumentException("Coordinate is bounded between 1 and 10 and A and J");

        this.letter = upperCaseLetter;
        this.numberCorrespondingToLetter = (int)(upperCaseLetter-64);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public char getLetter() {
        return letter;
    }

    public int getNumberCorrespondingToLetter() {
        return numberCorrespondingToLetter;
    }

    public static boolean isLetterInBoundaries(char letter) {
        char upperCaseLetter = Character.toUpperCase(letter);

        return (upperCaseLetter >= LETTER_LOWER_BOUND && upperCaseLetter <= LETTER_UPPER_BOUND);
    }

    public static boolean isNumberInBoundaries(int number) {
        return (number >= NUMBER_LOWER_BOUND && number <= NUMBER_UPPER_BOUND);
    }
}
