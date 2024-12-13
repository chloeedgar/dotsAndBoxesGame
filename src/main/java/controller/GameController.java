package controller;


import model.GameState;
import utils.MoveValidator;
import view.ConsoleView;
import view.GameView;

public class GameController {
    private GameState gameState;
    private GameView view;


    public GameController(GameState gameState, ConsoleView view) {
        this.gameState = gameState;
        this.view = view;
    }

    public void startGame() {
        view.displayMessage("Welcome to Dots and Boxes!");
        view.renderBoard(gameState.getBoard());

        while (!gameState.isGameOver()) {
            view.renderScores(gameState.getPlayer1Score(), gameState.getPlayer2Score());

            String move = getValidMove();

            if (move.equals("Q")) {
                view.displayMessage("Thanks for playing! Goodbye!");
                break;
            }

            gameState.makeMove(move);
            gameState.switchPlayer();
            view.renderBoard(gameState.getBoard());
        }

        view.renderWinner(gameState.getPlayer1Score(), gameState.getPlayer2Score());

    }

    /**
     * Prompts the player for a valid move and validates the input.
     *
     * @return A valid move string or "Q" if the player quits.
     */
    private String getValidMove() {
        while (true) {
            view.displayMessage("Player " + gameState.getCurrentPlayer()
                    + ", input a move <column><row> (or 'Q' to quit): ");
            String move = view.getMove();

            if (move.equalsIgnoreCase("Q")) {
                return move; // Player chooses to quit
            }

            if (MoveValidator.isMoveValid(move, gameState.getBoard())) {
                return move; // Valid move
            }

            view.displayMessage("Invalid move. Please try again.");
        }
    }

}