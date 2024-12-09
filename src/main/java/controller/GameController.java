package controller;


import model.GameSession;
import utils.MoveValidator;
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
            gameSession.switchPlayer();

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

            if (MoveValidator.isMoveValid(move, gameSession.getBoard())) {
                break;
            }

            view.displayMessage("Invalid move. Please try again.");
        } while (true);

        return move;
    }


}