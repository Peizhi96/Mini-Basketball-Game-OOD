/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
public class DefenseMode implements PlayMode{
  private Statistics stats;
  public DefenseMode(Statistics stats) {
    this.stats = stats;
  }
  public void play() {
    System.out.println("Playing in defense mode.");
  }

  public void addBlocks(Integer blocks) {
    this.stats.addBlocks(blocks);
  }

  public void addSteals(Integer steals) {
    this.stats.addSteals(steals);
  }

}
