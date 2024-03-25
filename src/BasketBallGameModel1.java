/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class BasketBallGameModel1 implements BasketBallGameModel, Iterable<BasketBallAction> {
  private Player player1;
  private Player player2;
  private Player currPlayer;
  private boolean gameOver;
  private Player winner;
  private List<BasketBallAction> actions = new ArrayList<>();
  private Random random = new Random();

  public BasketBallGameModel1(Player player1, Player player2) {
    this.player1 = player1;
    this.player2 = player2;
    this.currPlayer = player1;
    this.gameOver = false;
    this.winner = null;
  }

  public void action() {
    if (isGameOver()) {
      throw new IllegalStateException("Game is over.");
    }

    BasketBallAction newAction;
    if (currPlayer.getCurrentMode() instanceof OffenseMode) {
      newAction = new ShootAction(currPlayer);
    } else if (currPlayer.getCurrentMode() instanceof DefenseMode) {
      newAction = random.nextBoolean() ? new BlockAction(currPlayer) : new StealAction(currPlayer);
    } else {
      throw new IllegalStateException("Unknown mode for current player.");
    }

    newAction.execute();
    actions.add(newAction);
    currPlayer.switchMode();
    currPlayer = currPlayer == player1 ? player2 : player1;
  }

  @Override
  public boolean isGameOver() {
    return getWinner() != null;
  }

  @Override
  public String getCurrentScore() {
    return "Player 1: " + player1.getStats().getScores() + " - Player 2: " + player2.getStats().getScores();
  }


  @Override
  public Player getWinner() {
    int score1 = player1.getStats().getScores() != null ? player1.getStats().getScores() : 0;
    int score2 = player2.getStats().getScores() != null ? player2.getStats().getScores() : 0;
    if (score1>15){
      return player1;
    }
    if (score2>15){
      return player2;
    }
    return null;
  }

  @Override
  public Statistics[] showStats() {
    if (getWinner() == player1) {
      return new Statistics[]{player1.getStats()};
    }
    if (getWinner() == player2) {
      return new Statistics[]{player2.getStats()};
    }
    return new Statistics[]{player1.getStats(), player2.getStats()};
  }

  @Override
  public Iterator<BasketBallAction> iterator() {
    return new BasketBallActionIterator(actions);
  }
  @Override
  public List<BasketBallAction> getActions() {
    return new ArrayList<>(actions);
  }

}
