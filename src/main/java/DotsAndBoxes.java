import controller.GameController;
import model.GameSession;
import view.ConsoleView;

public class DotsAndBoxes {

    public static void main(String[] args) {

        int gridOfDotsSize = 4; // 4 x 4 of stars


        GameSession gameSession = new GameSession(gridOfDotsSize);
        ConsoleView consoleView = new ConsoleView();
        GameController gameController = new GameController(gameSession, consoleView);

        gameController.startGame();


    }
}
