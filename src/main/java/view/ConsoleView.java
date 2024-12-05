package view;

import java.util.Scanner;

public class ConsoleView implements GameView{

    Scanner scanner = new Scanner(System.in);

    public void displayMessage(String message) {
        System.out.println(message);
    }


    @Override
    public void renderWinner(int winnerPlayer) {

    }

    public void renderBoard(char[][] board) {
        //int boardSize = gameSession.getBoardSize();

        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }


    @Override
    public void renderScores(int player1Score, int player2Score) {
        System.out.println("SCORE Player 1: " + player1Score +
                " Player 2: " + player2Score);
    }

    @Override
    public String getPlayerInput() {
        //ToDo
        return null;
    }

    public String getMove() {
        return scanner.nextLine().toUpperCase();
    }
}
