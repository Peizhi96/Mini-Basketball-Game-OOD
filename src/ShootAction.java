/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/

import java.util.Random;
public class ShootAction extends BasketBallAction{


  public ShootAction(Player player) {
    super(player);
  }

  @Override
  public void execute() {
    Random random = new Random();
    if (player.getCurrentMode() instanceof OffenseMode) {
      Scores scoreType = random.nextBoolean()?Scores.TWO_POINTERS: Scores.THREE_POINTERS;
      System.out.println(player.getName() + " scores " + scoreType.getPoints());
      player.getStats().addScores(scoreType);
      System.out.println(player.getName() + " get " + player.getStats().getScores() + " points in total now;");
    }
  }

  public String toString() {
    return player.getName() + " shoots";
  }
}
