/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/

public class Statistics {
  private Integer scores;
  private Integer blocks;
  private Integer steals;
  private Integer currentRoundScore = 0;

  public Statistics(Integer scores, Integer blocks, Integer steals) {
    this.scores = scores;
    this.blocks = blocks;
    this.steals = steals;
  }

  public Statistics(){}


  public Integer getScores() {return this.scores;}
  public Integer getBlocks() {return this.blocks;}
  public Integer getSteals() {return this.steals;}


  public void addScores(Scores score) {
    this.scores += score.getPoints();
    this.currentRoundScore += score.getPoints();
    resetCurrentRoundScore();
  }
  public void addBlocks(Integer blocks) {this.blocks=this.blocks+blocks;}
  public void addSteals(Integer steals) {this.steals=this.steals+steals;}

  public void resetCurrentRoundScore() {
    this.currentRoundScore = 0;
  }

  public boolean hasScoredThisRound() {
    return this.currentRoundScore > 0;
  }

  @Override
  public String toString() {
    return "scores: " + scores + " blocks: " + blocks + " steals: " + steals;
  }
}
