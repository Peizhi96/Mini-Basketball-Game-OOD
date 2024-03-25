/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
public class Player {
  private String name;
  private Statistics stats;
  private PlayMode currentMode;
  private PlayMode defenseMode;
  private PlayMode offenseMode;
  private boolean isBlocked;
  private boolean isStolen;


  public Player(String name, Statistics stats)
  {
    this.name = name;
    this.stats = stats;
    this.offenseMode = new OffenseMode(stats);
    this.defenseMode = new DefenseMode(stats);
    this.currentMode = offenseMode;
  }

  public String getName() {return name;}
  public Statistics getStats() {return stats;}
  public PlayMode getCurrentMode() {return currentMode;}
  public void setName(String name) {this.name=name;}

  public void setBlocked(boolean block) {
    isBlocked = block;
    if(isBlocked) {
      switchMode();
    }
  }
  public void setStolen(boolean steal) {
    isStolen = steal;
    if(isStolen) {
      switchMode();
    }
  }
  public void setCurrentMode(PlayMode mode) {
    this.currentMode = mode;
  }

  public void switchMode() {
    if (currentMode instanceof OffenseMode) {
      currentMode = defenseMode;
    } else if (currentMode instanceof DefenseMode) {
      currentMode = offenseMode;
    }else {
      throw new IllegalStateException("Unknown mode: " + currentMode);
    }
  }

  public void addScores(Scores score) {
    if (currentMode instanceof OffenseMode) {
      ((OffenseMode) currentMode).addScores(score);
    }
  }

  public void addBlocks(Integer blocks) {
    if (currentMode instanceof DefenseMode) {
      ((DefenseMode) currentMode).addBlocks(blocks);
    }
  }

  public void addSteals(Integer steals) {
    if (currentMode instanceof DefenseMode) {
      ((DefenseMode) currentMode).addSteals(steals);
    }
  }

  public String toString() {
    return "Name: " + name + " Statistics: " + stats.toString();
  }

}
