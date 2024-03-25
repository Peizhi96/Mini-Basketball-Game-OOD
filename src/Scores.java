/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/

public enum Scores {
  TWO_POINTERS(2),
  THREE_POINTERS(3);

  private final int points;

  Scores(int points) {
    this.points = points;
  }

  public int getPoints() {
    return this.points;
  }
}
