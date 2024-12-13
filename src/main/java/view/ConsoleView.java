package view;

import java.util.Scanner;

public class ConsoleView implements GameView {

    Scanner scanner = new Scanner(System.in);

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void renderWinner(int player1Score, int player2Score) {
        System.out.println();
        System.out.print("Game over. ");
        String result = (player1Score > player2Score) ? "Player 1 is the winner!"
                : (player2Score > player1Score) ? "Player 2 is the winner!"
                : "It's a tie!";
        System.out.println(result);
        System.out.println("Thanks for playing! Goodbye!");
    }

    public void renderBoard(char[][] board) {
        StringBuilder output = new StringBuilder();

        for (char[] row : board) {
            for (char cell : row) {
                output.append(cell);
            }
            output.append('\n');
            System.out.println(output);
        }
    }

    @Override
    public void renderScores(int player1Score, int player2Score) {
        System.out.println("SCORE Player 1: " + player1Score +
                " Player 2: " + player2Score);
    }

    @Override
    public String getMove() {
        return scanner.nextLine().toUpperCase();
    }
}
