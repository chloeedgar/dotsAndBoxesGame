package utils;

public class BoardInitializer {

    public static char[][] initializeBoard(int boardSize) {
        char[][] board = new char[boardSize][boardSize];

        // Initialize top-left corner
        board[0][0] = ' ';

        // Fill column labels (A, B, C...)
        for (int col = 1; col < boardSize; col++) {
            board[0][col] = (char) ('A' + col - 1);
        }

        // Fill the board with row labels and the grid
        for (int row = 1; row < boardSize; row++) {
            // Fill row labels (1, 2, 3...)
            board[row][0] = (char) ('0' + row - 1);

            // Fill the grid with stars (*) and spaces
            for (int col = 1; col < boardSize; col++) {
                if (row % 2 == 1) {
                    board[row][col] = (col % 2 == 1) ? '*' : ' '; // Odd rows alternate '*' and ' '
                } else {
                    board[row][col] = ' '; // Even rows are empty spaces initially
                }
            }
        }

        return board;
    }
}
