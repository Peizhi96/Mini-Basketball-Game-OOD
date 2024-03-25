/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/

import java.util.Random;
public class StealAction extends BasketBallAction{
  public StealAction(Player player) {
    super(player);

  }

  @Override
  public void execute() {
    if (player.getCurrentMode() instanceof DefenseMode) {
      Random random = new Random();
      boolean isStealSuccessful = random.nextBoolean();
      if (isStealSuccessful) {
        player.getStats().addSteals(1);
        System.out.println(player.getName() + " get " + player.getStats().getSteals() + " steals;");
      } else {
        System.out.println(player.getName() + " attempted to steal but failed.");
      }
    }
  }

  public String toString() {
    return player.getName() + " steals";
  }
}
