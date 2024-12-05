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

            view.displayMessage("Player " + (gameSession.getCurrentPlayer()) + ", input a move <column><row> (or 'Q' to quit): ");

            String move = view.getMove();
            if (move.equals("Q")) {
                view.displayMessage("Thanks for playing! Goodbye!");
                gameSession.setGameOver(true);
                break;
            }
            view.renderBoard(gameSession.getBoard());

            view.displayMessage("Invalid move. Please try again.");
            move = view.getMove();




        }

    }



    private boolean isMoveValid(String move) {
        //ToDo
        return true;
    }
}