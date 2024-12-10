package view;

public interface GameView {

    void renderBoard(char[][] board);
    void renderScores(int player1Score, int player2Score);
    void displayMessage(String message);
    void renderWinner(int player1Score, int player2Score);
    String getMove();
}
