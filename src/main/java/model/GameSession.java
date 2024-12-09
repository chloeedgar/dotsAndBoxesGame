package model;

import utils.BoardInitializer;

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
        this.board = BoardInitializer.initializeBoard(boardSize);
        this.scores = new int[2];
        this.currentPlayer = 1; // Player 1 starts
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
        //ToDo

        return false; // Placeholder
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = true;
    }

    public char[][] getBoard() {
        return board;
    }

    public void makeMove(String move) {
        // Parse the move into column and row
        char columnChar = move.charAt(0);  // Column (A-G)
        int row = Character.getNumericValue(move.charAt(1)) +1; // Second character is the row (1-7), adjusting for 0-indexing

        // Convert column letter (A-G) to a column index (0-6)
        int column = columnChar - 'A' + 1;  // Adjust column: 'A' -> 1, 'B' -> 2, ..., 'G' -> 7

        updateBoard(row, column);

        int completedSquares = checkForCompletedBoxes(row, column);

        if (completedSquares > 0){
            scores[currentPlayer -1] += completedSquares; // Award points
        }

    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }

    private int checkForCompletedBoxes(int row, int column) {
        System.out.println("check for completed boxes");
        return  0; //placeholder
        //ToDo
    }

    private void updateBoard(int row, int column) {
        // Determine whether to place a '|' (vertical line) or '-' (horizontal line)
        if (row % 2 == 0) {
            // Even rows correspond to vertical lines ('|')
            board[row][column] = '|';
        } else {
            // Odd rows correspond to horizontal lines ('-')
            board[row][column] = '-';
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    private boolean isHorizontalMove(int row, int column) {
        // Horizontal moves occur on odd-numbered rows and even-numbered columns
        return row % 2 == 1 && column % 2 == 0;
    }

    private boolean isVerticalMove(int row, int column) {
        // Vertical moves occur on even-numbered rows and odd-numbered columns
        return row % 2 == 0 && column % 2 == 1;
    }
}

