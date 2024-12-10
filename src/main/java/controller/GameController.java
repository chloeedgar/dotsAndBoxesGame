package controller;


import model.GameSession;
import utils.MoveValidator;
import view.ConsoleView;
import view.GameView;

public class GameController {
    private GameSession gameSession;
    private GameView view;


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
                break;
            }

            gameSession.makeMove(move);
            gameSession.switchPlayer();
            view.renderBoard(gameSession.getBoard());
        }

        view.renderWinner(gameSession.getPlayer1Score(), gameSession.getPlayer2Score());

    }

    /**
     * Prompts the player for a valid move and validates the input.
     *
     * @return A valid move string or "Q" if the player quits.
     */
    private String getValidMove() {
        while (true) {
            view.displayMessage("Player " + gameSession.getCurrentPlayer()
                    + ", input a move <column><row> (or 'Q' to quit): ");
            String move = view.getMove();

            if (move.equalsIgnoreCase("Q")) {
                return move; // Player chooses to quit
            }

            if (MoveValidator.isMoveValid(move, gameSession.getBoard())) {
                return move; // Valid move
            }

            view.displayMessage("Invalid move. Please try again.");
        }
    }

}