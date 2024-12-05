package model;

public class GameSession {

    private int boardSize;
    private int[] scores;
    // scores[0]=player 1's score, scores[1]=player 2's score
    private char[][] board;
    //2D array for board - efficient at accessing and modifying elements using row and column indice

    private int currentPlayer;
    private boolean gameOver;

    public GameSession(int gridOfDotsSize) {
        this.boardSize = gridOfDotsSize*2-1;
        this.board = initializeBoard();
        this.scores = new int[2];
        this.currentPlayer = 1; // Player 1 starts
    }

    private char[][] initializeBoard() {
        //Rules for a 4x4 grid of dots
        // First row is space then A-G for 4x4 grid (7 letters = 8-1)
        // First column is space then 0 to 6
        // the grid (not including first column and first row) consists of
        // *'s in every other square for even row numbers
        // ' ' (spaces) in every odd row

        //int boardSize = gridSize * 2; // Includes spaces for lines
        char[][] board = new char[boardSize + 1][boardSize + 1];

        System.out.println("board size is: " + board.length);


        // Fill column labels (A-G) in the first row
        //LHS upper corner is a space
        board[0][0] = ' ';

        for (int col = 1; col <= boardSize; col++) {
            board[0][col] = (char) ('A' + col - 1);  // This is the key part to set letters from 'A' to 'G'
        }

        //2nd row onwards
        for (int row = 1; row <= boardSize; row++) {
            board[row][0] = (char) ('0' + row -1); // Assign row number (0 to 6) in the first column
            board[row][1] = ' '; // Add a space after the number for alignment

            if (row % 2 == 1) { // Odd-numbered rows (contain stars and spaces)
                for (int col = 1; col <= boardSize; col++) {
                    board[row][col] = (col % 2 == 1) ? '*' : ' '; // Alternate stars and spaces
                }
            } else { // Even-numbered rows (only spaces between lines)
                for (int col = 1; col <= boardSize; col++) {
                    board[row][col] = ' '; // Fill entire row with spaces
                }
            }
        }


        return board;
    }


    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int getPlayer1Score() {
        return scores[0];
    }

    public int getPlayer2Score() {
        return scores[1];
    }

    public boolean isGameOver() {
        // Check if all boxes are completed

        return false; // Placeholder
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = true;
    }

    public char[][] getBoard() {
        return board;
    }

}

