package utils;

public class MoveValidator {

    public static boolean isMoveValid(String move, char[][] board) {
        if (move.length() != 2) {
            return false;
        }

        char columnChar = move.charAt(0);
        char rowChar = move.charAt(1);

        // Ensure the move format is valid (letter followed by a digit)
        if (!Character.isLetter(columnChar) || !Character.isDigit(rowChar)) {
            return false;
        }

        // Convert column letter and row digit to indices
        int column = columnChar - 'A' + 1; // 'A' -> 1, 'B' -> 2, etc.
        int row = Character.getNumericValue(rowChar) + 1; // '1' -> 2, '2' -> 3, etc.

        // Validate indices are within the board's bounds
        if (column <= 0 || column >= board.length || row <= 0 || row >= board.length) {
            return false;
        }

        // Check if the position is restricted
        if (isRestrictedPosition(row, column)) {
            return false;
        }

        // Check if the move is unoccupied
        return isUnoccupied(row, column, board);

    }

    private static boolean isRestrictedPosition(int row, int column) {
        // Middle box positions have even row indices and even column indices
        return row % 2 == 0 && column % 2 == 0;
    }

    private static boolean isUnoccupied(int row, int column, char[][] board) {
        // Assume a placeholder character like ' ' indicates an unoccupied position
        return board[row][column] == ' ';
    }

    }
