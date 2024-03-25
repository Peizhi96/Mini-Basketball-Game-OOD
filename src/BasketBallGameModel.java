/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
import java.util.List;

public interface BasketBallGameModel {
  void action();
  boolean isGameOver();
  String getCurrentScore();
  Player getWinner();
  List<BasketBallAction> getActions();
  Statistics[] showStats();
}
