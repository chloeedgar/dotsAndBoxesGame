package utils;

public class MoveValidator {

    /**
     * Validates if a given move is valid based on the current board state.
     *
     * @param move  The player's move as a string (e.g., "A1").
     * @param board The game board as a 2D char array.
     * @return true if the move is valid; false otherwise.
     */
    public static boolean isMoveValid(String move, char[][] board) {
        if (!hasValidFormat(move)) return false;
        int column = parseColumn(move);
        int row = parseRow(move);
        if (!isWithinBounds(row, column, board)) return false;
        if (isRestrictedPosition(row, column)) return false;
        return isUnoccupied(row, column, board);
    }

    /**
     * Checks if the format of the move is valid (e.g., a letter followed by a number).
     */
    private static boolean hasValidFormat(String move) {
        if (move == null || move.length() != 2) return false;
        char columnChar = move.charAt(0);
        char rowChar = move.charAt(1);

        return Character.isLetter(columnChar) && Character.isDigit(rowChar);
    }

    /**
     * Checks if the position of the move is within the bounds of the board.
     */
    private static boolean isWithinBounds(int row, int column, char[][] board) {
        return row >= 0 && row < board.length && column >= 0 && column < board[0].length;
    }

    /**
     * Checks if the move is on a restricted position, such as the center of the board.
     */
    private static boolean isRestrictedPosition(int row, int column) {
        // Middle box positions have even row indices and even column indices
        return row % 2 == 0 && column % 2 == 0;
    }

    /**
     * Checks if the position is unoccupied on the board.
     */
    private static boolean isUnoccupied(int row, int column, char[][] board) {
        return board[row][column] == ' ';  // Assuming ' ' denotes an unoccupied space
    }

    /**
     * Parses the row index from a move string.
     */
    public static int parseRow(String move) {
        return Character.getNumericValue(move.charAt(1)) + 1; // Adjust for board indexing
    }

    /**
     * Parses the column index from a move string.
     */
    public static int parseColumn(String move) {
        return move.charAt(0) - 'A' + 1; // Convert 'A' -> 1, 'B' -> 2, etc.
    }

    }
