package model;

import utils.BoardInitializer;
import utils.MoveValidator;

import java.util.stream.IntStream;

public class GameState {

    private final int boardSize;
    private final int[] scores; // scores[0]=Player 1, scores[1]=Player 2
    private final char[][] board;
    private int currentPlayer;

    public GameState(int gridOfDotsSize) {
        this.boardSize = gridOfDotsSize * 2;
        this.board = BoardInitializer.initializeBoard(boardSize);
        this.scores = new int[2];
        this.currentPlayer = 1; // Player 1 starts
    }

    /**
     * Makes a move by updating the board and awarding points for completed squares.
     */
    public void makeMove(String move) {
        int row = MoveValidator.parseRow(move);
        int column = MoveValidator.parseColumn(move);

        updateBoard(row, column);

        int completedSquares = checkCompletedSquares(row, column);
        awardPointsForCompletedSquares(completedSquares);
    }

    /**
     * Determines if the game is over (all boxes are completed).
     */
    public boolean isGameOver() {
        return areAllBoxesCompleted();
    }

    /**
     * Switches to the next player.
     */
    public void switchPlayer() {
        currentPlayer = 3 - currentPlayer; // Toggles between 1 and 2
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

    public char[][] getBoard() {
        return board;
    }

    /**
     * Checks for completed boxes around a given move and updates the board.
     */
    private int checkCompletedSquares(int row, int column) {
        int completedSquares = 0;

        // Check for squares above, below, left, and right of the move
        if (isHorizontalMove(row, column)) {
            // Horizontal move can complete squares above and below
            completedSquares += completeBoxIfFilled(row - 1, column); // Above
            completedSquares += completeBoxIfFilled(row + 1, column); // Below
        } else if (isVerticalMove(row, column)) {
            // Vertical move can complete squares to the left and right
            completedSquares += completeBoxIfFilled(row, column - 1); // Left
            completedSquares += completeBoxIfFilled(row, column + 1); // Right
        }

        return completedSquares;
    }

    /**
     * Marks a box as completed by the current player if all sides are filled.
     */
    private int completeBoxIfFilled(int row, int column) {
        // Ensure row and column are within bounds
        if (row <= 0 || row >= board.length - 1 || column <= 0 || column >= board[0].length - 1) {
            return 0;
        }

        // A square is completed if all four surrounding positions are occupied
        if (board[row - 1][column] == '-' &&  // Top
                board[row + 1][column] == '-' &&  // Bottom
                board[row][column - 1] == '|' &&  // Left
                board[row][column + 1] == '|') {  // Right
            board[row][column] = (char) ('0' + currentPlayer); // Mark square with current player's number
            return 1; // 1 square completed
        }

        return 0; // No square completed
    }

    /**
     * Checks if all boxes on the board are completed.
     */
    private boolean areAllBoxesCompleted() {
        return IntStream.range(2, board.length)      // Start from row index 2
                .filter(row -> row % 2 == 0)         // Only even rows (representing boxes)
                .noneMatch(row -> IntStream.range(2, board[row].length)  // Start from column index 2
                        .filter(col -> col % 2 == 0) // Only even columns (representing boxes)
                        .anyMatch(col -> board[row][col] == ' ')); // If any box is empty, return false
    }

    private void updateBoard(int row, int column) {
        board[row][column] = isHorizontalMove(row, column) ? '-' : '|';
    }

    /**
     * Checks if a move is horizontal.
     */
    private boolean isHorizontalMove(int row, int column) {
        // Horizontal moves occur on odd-numbered rows and even-numbered columns
        return row % 2 == 1 && column % 2 == 0;
    }

    /**
     * Checks if a move is vertical.
     */
    private boolean isVerticalMove(int row, int column) {
        // Vertical moves occur on even-numbered rows and odd-numbered columns
        return row % 2 == 0 && column % 2 == 1;
    }

    private void awardPointsForCompletedSquares(int completedSquares) {
        scores[currentPlayer - 1] += completedSquares; // Award points to current player
    }
}

