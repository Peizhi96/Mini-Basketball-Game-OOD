/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.function.Predicate;

public class PlayerStatsTest {

  private PlayerStatsImp playerStats;

  @Before
  public void setUp() {
    Statistics initialStats = new Statistics(0,0,0);
    playerStats = new PlayerStatsImp("IPlayer", initialStats);
  }

  @Test
  public void testAddStats() {
    Statistics newStats = new Statistics(1,1,1);
    Player newPlayer = new Player("NewPlayer", newStats);
    playerStats.addStats(newPlayer, newStats);
    assertEquals("Size should increase after adding a player", 2, playerStats.getSize());
    assertTrue("New player's stats should be in the list", playerStats.allStats().contains(newPlayer.getName()));
  }

  @Test
  public void testGetSize() {
    assertEquals("Initially, size should be 1", 1, playerStats.getSize());
  }

  @Test
  public void testAllStats() {
    List<String> stats = playerStats.allStats();
    assertNotNull("List of stats should not be null", stats);
    assertFalse("List of stats should not be empty", stats.isEmpty());
  }

  @Test
  public void testAllStatsWithPredicate() {
    Statistics statsForPredicateTest = new Statistics(2, 2, 2);
    Player playerForPredicateTest = new Player("new player2", statsForPredicateTest);
    playerStats.addStats(playerForPredicateTest, statsForPredicateTest);
    Predicate<Player> predicate = p -> p.getName().contains("PredicateTest");
    List<String> filteredStats = playerStats.allStats(predicate);
    assertNotNull("Filtered list should not be null", filteredStats);
  }

}
