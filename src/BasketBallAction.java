/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
public abstract class BasketBallAction {
  protected Player player;

  public BasketBallAction(Player player) {
    this.player = player;
  }
  public abstract void execute();
}
