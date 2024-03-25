/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
import java.util.Random;
public class BlockAction extends BasketBallAction{
  public BlockAction(Player player) {
    super(player);
  }

  public void execute() {
    if (player.getCurrentMode() instanceof DefenseMode) {
      Random random = new Random();
      boolean isBlockSuccessful = random.nextBoolean();
      if (isBlockSuccessful) {
        player.getStats().addBlocks(1);
        System.out.println(player.getName() + " get " + player.getStats().getBlocks() + " blocks;");
      } else {
        System.out.println(player.getName() + " attempted to block but failed.");
      }
    }
  }

  public String toString() {
    return player.getName() + " blocks";
  }
}
