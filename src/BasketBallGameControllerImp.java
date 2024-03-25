/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
import java.io.IOException;
import java.util.Iterator;

public class BasketBallGameControllerImp implements BasketBallGameController{
  final BasketBallGameModel model;
  final BasketBallGameView view;

  public BasketBallGameControllerImp(BasketBallGameModel model, BasketBallGameView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public void playGame(BasketBallGameModel model) {
    try {
      while (!model.isGameOver()) {
        model.action();
        System.out.println("Current score: " + model.getCurrentScore() + "\n");
      }

      Player winner = model.getWinner();
      if (winner != null) {
        view.disPlay("Winner is " + winner.getName() + "!\n");
      } else {
        view.disPlay("No winner in this game.\n");
      }

      model.showStats();
      Statistics[] stats = model.showStats();
      for (Statistics stat: stats) {
        System.out.println(stat.toString());
      }

      System.out.println("\nGame recap: ");
      Iterator<BasketBallAction> actionIterator = new BasketBallActionIterator(model.getActions());
      while (actionIterator.hasNext()) {
        BasketBallAction action = actionIterator.next();
        try {
          view.disPlay("Action: " + action.toString() + "\n");
        } catch (IOException e) {
          e.getMessage();
        }
      }
    } catch (Exception e) {
      throw new IllegalStateException("Game error: " + e.getMessage());
    }


  }
}

