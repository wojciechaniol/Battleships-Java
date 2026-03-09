package org.example.gameLogic;

public abstract class AbstractBoard {
    protected final static int BOARD_SIZE = 10;
    protected Square[][] board;
    protected char[][] visualBoard;

    protected AbstractBoard() {
        board = new Square[BOARD_SIZE][BOARD_SIZE];
        visualBoard = new char[BOARD_SIZE][BOARD_SIZE];
    }

    protected void initializeSquareBoard() {
        char letter = 'A';

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Coordinate coord = new Coordinate(letter, j+1);
                board[i][j] = new Square(coord);
            }
            letter++;
        }
    }

    protected void initializeVisualBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (i == 0 && j == 0) {
                    visualBoard[i][j] = '┌';
                } else if (i == 0 && j == BOARD_SIZE-1) {
                    visualBoard[i][j] = '└';
                } else if (i == BOARD_SIZE-1 && j == 0) {
                    visualBoard[i][j] = '┐';
                } else if (i == BOARD_SIZE-1 && j == BOARD_SIZE-1) {
                    visualBoard[i][j] = '┘';
                } else if (i == 0 || i == BOARD_SIZE-1) {
                    visualBoard[i][j] = '│';
                } else if (j == 0 || j == BOARD_SIZE - 1) {
                    visualBoard[i][j] = '─';
                } else {
                    visualBoard[i][j] = ' ';
                }
            }
        }
    }

    public void renderVisualBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(visualBoard[i][j]);
            }
            System.out.println("\n");
        }
    }
}
