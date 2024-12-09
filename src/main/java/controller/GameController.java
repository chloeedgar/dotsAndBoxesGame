package controller;


import model.GameSession;
import view.ConsoleView;

public class GameController {
    private GameSession gameSession;
    private ConsoleView view;


    public GameController(GameSession gameSession, ConsoleView view) {
        this.gameSession = gameSession;
        this.view = view;
    }

    public void startGame() {
        view.displayMessage("Welcome to Dots and Boxes!");
        view.renderBoard(gameSession.getBoard());

        while (!gameSession.isGameOver()) {
            view.renderScores(gameSession.getPlayer1Score(), gameSession.getPlayer2Score());

            String move = getValidMove();

            if (move.equals("Q")) {
                view.displayMessage("Thanks for playing! Goodbye!");
                gameSession.setGameOver(true);
                break;
            }

            gameSession.makeMove(move);
            view.renderBoard(gameSession.getBoard());

        }
    }

    private String getValidMove() {
        String move;
        do {
            view.displayMessage("Player " + (gameSession.getCurrentPlayer()) + ", input a move <column><row> (or 'Q' to quit): ");
            move = view.getMove();

            if (move.equals("Q")) {
                return move;  // Player chooses to quit
            }

            if (isMoveValid(move)) {
                break;
            }

            view.displayMessage("Invalid move. Please try again.");
        } while (true);

        return move;
    }

    private boolean isMoveValid(String move) {
        int boardSize = gameSession.getBoardSize() +1;

        if (move.length() != 2) {
            return false;
        }

        // Extract column and row from the move
        // Check if the format is correct: letter followed by a digit
        char columnChar = move.charAt(0);
        char rowChar = move.charAt(1);
        if (!Character.isLetter(columnChar) || !Character.isDigit(rowChar)) {
            return false;
        }

        // Convert the column letter to column index
        int column = columnChar - 'A' + 1;  // Adjust column: 'A' -> 1, 'B' -> 2, ..., 'G' -> 7

        int row;
        try {
            row = Character.getNumericValue(rowChar) +1; // Second character is the row, add 1
        } catch (NumberFormatException e) {//mightnt need this
            view.displayMessage("....");
            return false; // If row is not a valid number
        }

        int maxColumn = boardSize - 1; // Calculate last column based on board size
        if (column < 0 || column > maxColumn) {
            return false; // Column is out of valid range
        }

        // Validate row range (0-based)
        if (row < 0 || row > boardSize) {
            return false; // Row is out of valid range
        }

        // Check if the position is restricted
        if (isRestrictedPosition(row, column)) {
            return false;
        }

        // Check if the move is unoccupied
        return isUnoccupied(row, column);

    }

    private boolean isRestrictedPosition(int row, int column) {
        // Middle box positions have even row index and even column index
        return row % 2 == 0 && column % 2 == 0;
    }

    private boolean isUnoccupied(int row, int col) {
        // Assume a placeholder character like ' ' indicates an unoccupied position
        return gameSession.getBoard()[row][col] == ' ';
    }
}