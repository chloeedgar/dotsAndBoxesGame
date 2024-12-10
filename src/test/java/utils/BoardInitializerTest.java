package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardInitializerTest {

    @Test
    public void testInitializeBoardWithSize8() {
        int gridSize = 8;
        char[][] board = BoardInitializer.initializeBoard(gridSize);

        // Validate labels and grid for size 8
        assertBoardStructure(board, gridSize);
    }

    @Test
    public void testInitializeBoardForGridSize10() {
        int gridSize = 10;
        char[][] board = BoardInitializer.initializeBoard(gridSize);

        // Validate labels and grid for size 10
        assertBoardStructure(board, gridSize);
    }

    // Helper method to check board structure
    private void assertBoardStructure(char[][] board, int gridSize) {
        // Check column labels
        assertColumnLabels(board, gridSize);

        // Check row labels
        assertRowLabels(board, gridSize);

        // Check grid pattern
        assertGridPattern(board, gridSize);
    }

    // Helper method to check column labels
    private void assertColumnLabels(char[][] board, int gridSize) {
        for (int col = 1; col < gridSize; col++) {
            char expectedColumnLabel = (char) ('A' + col - 1);
            assertEquals(expectedColumnLabel, board[0][col], "Column label mismatch at column " + col);
        }
    }

    // Helper method to check row labels
    private void assertRowLabels(char[][] board, int gridSize) {
        for (int row = 1; row < gridSize; row++) {
            char expectedRowLabel = (char) ('0' + row - 1);
            assertEquals(expectedRowLabel, board[row][0], "Row label mismatch at row " + row);
        }
    }

    // Helper method to check grid pattern for odd and even rows
    private void assertGridPattern(char[][] board, int gridSize) {
        for (int row = 1; row < gridSize; row++) {
            for (int col = 1; col < gridSize; col++) {
                char expectedCell;
                if (row % 2 == 1) {
                    // Odd rows alternate '*' and ' ' (starting with *)
                    expectedCell = (col % 2 == 1) ? '*' : ' ';
                } else {
                    // Even rows should be all spaces
                    expectedCell = ' ';
                }
                assertEquals(expectedCell, board[row][col], "Pattern mismatch at [" + row + "][" + col + "]");
            }
        }
    }
}
