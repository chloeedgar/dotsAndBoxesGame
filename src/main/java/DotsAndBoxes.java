import controller.GameController;
import model.GameState;
import view.ConsoleView;

public class DotsAndBoxes {

    public static void main(String[] args) {

        int gridOfDotsSize = 4; // 4 x 4 of stars

        GameState gameState = new GameState(gridOfDotsSize);
        ConsoleView consoleView = new ConsoleView();
        GameController gameController = new GameController(gameState, consoleView);

        gameController.startGame();

    }
}
