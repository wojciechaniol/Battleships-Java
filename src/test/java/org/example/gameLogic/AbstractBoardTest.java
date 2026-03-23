package org.example.gameLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestBoard extends AbstractBoard {
    public TestBoard() {
        super();
        initializeSquareBoard();
        initializeVisualBoard();
    }

    char getVisualBoard(int x, int y) { return visualBoard[y][x]; }
    Square getSquare(int x, int y) { return board[y][x]; }
    int getSize() { return BOARD_SIZE; }
}

class AbstractBoardTest {
    TestBoard testBoard;

    @BeforeEach
    void setUp() {
        testBoard = new TestBoard();
    }

    @Test
    void initializeSquareBoard() {
        char letter = 'A';

        for (int i = 0; i < testBoard.getSize(); i++) {
            for (int j = 0; j < testBoard.getSize(); j++) {
                Square square = testBoard.getSquare(j, i);
                assertEquals(letter, square.getCoordLetter());
                assertEquals(j + 1, square.getCoordNumber());
            }

            letter++;
        }
    }

    @Test
    void initializeVisualBoardUpper() {
        char[] upperPartExpected = {'┌', '─', '┐'};
        int j = 0;

        for (int i = 0; i < testBoard.getSize(); i++) {
            char boardPiece = testBoard.getVisualBoard(i, j);
            if (i == 0) assertEquals(upperPartExpected[0], boardPiece);
            else if (i == testBoard.getSize()-1) assertEquals(upperPartExpected[2], boardPiece);
            else assertEquals(upperPartExpected[1], boardPiece);
        }
    }

    @Test
    void initializeVisualBoardMiddle() {
        char[] middlePartExpected = {'│',' '};

        for (int i = 1; i < testBoard.getSize()-1; i++) {
            for (int j = 0; j < testBoard.getSize(); j++) {
                char boardPiece = testBoard.getVisualBoard(j, i);
                if (j == 0 || j == testBoard.getSize()-1) assertEquals(middlePartExpected[0], boardPiece);
                else assertEquals(middlePartExpected[1], boardPiece);
            }
        }
    }

    @Test
    void initializeVisualBoardBottom() {
        char[] bottomPartExpected = {'└', '─', '┘'};
        int j = testBoard.getSize()-1;

        for (int i = 0; i < testBoard.getSize(); i++) {
            char boardPiece = testBoard.getVisualBoard(i, j);
            if (i == 0) assertEquals(bottomPartExpected[0], boardPiece);
            else if (i == testBoard.getSize()-1) assertEquals(bottomPartExpected[2], boardPiece);
            else assertEquals(bottomPartExpected[1], boardPiece);
        }
    }
}