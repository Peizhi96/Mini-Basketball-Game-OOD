/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
public class OffenseMode implements PlayMode{
  private Statistics stats;

  public OffenseMode(Statistics stats) {
    this.stats = stats;
  }
  public void play() {
    System.out.println("Playing in offense mode.");
  }
  public void addScores(Scores score) {
    this.stats.addScores(score);
  }
}
