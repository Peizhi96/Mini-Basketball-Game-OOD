/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;


public class BasketBallGameModel1Test {

  private Player player1;
  private Player player2;
  private Statistics stat1;
  private Statistics stat2;
  private BasketBallGameModel1 game;

  @Before
  public void setUp() {
    stat1 = new Statistics(14, 3, 2);
    stat2 = new Statistics(11, 2, 2);
    player1 = new Player("Player1", stat1);
    player2 = new Player("Player2", stat2);
    game = new BasketBallGameModel1(player1, player2);
  }

  @Test
  public void testInitialState() {
    assertFalse("Game should not be over at start", game.isGameOver());
    assertNull("Winner should be null at start", game.getWinner());
    assertEquals("Initial action list should be empty", 0, game.getActions().size());

  }
  @Test
  public void testActionSuccessfulExecution() {
    player1.setCurrentMode(new OffenseMode(stat1));
    player2.setCurrentMode(new DefenseMode(stat2));
    assertFalse("Game should not be over before action", game.isGameOver());


    game.action();

    assertEquals("Action list should have one action after one move", 1, game.getActions().size());
  }

  @Test(expected = IllegalStateException.class)
  public void testActionWhenGameOver() {
    player1.getStats().addScores(Scores.TWO_POINTERS);
    game.action();
    assertTrue("Game should be over", game.isGameOver());
  }

  @Test
  public void testGetCurrentScore() {
    String score = game.getCurrentScore();
    assertNotNull("Score should not be null", score);
  }

  @Test
  public void testGameOver() {
    assertFalse("Game should be over", game.isGameOver());
  }

  @Test
  public void testGetWinner() {
    player1.getStats().addScores(Scores.TWO_POINTERS);
    assertEquals("Player 1 should be the winner", player1, game.getWinner());
  }

  @Test
  public void testShowStats() {
    Statistics[] stats = game.showStats();
    assertNotNull("Stats should not be null", stats);
    assertTrue("Stats should contain at least one element", stats.length > 0);
  }

  @Test
  public void testIterator() {
    Iterator<BasketBallAction> iterator = game.iterator();
    assertNotNull("Iterator should not be null", iterator);
  }

}

