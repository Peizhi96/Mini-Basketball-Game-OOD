/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

  private Player player;
  private Statistics stats;


  @Before
  public void setUp() {

    stats = new Statistics(0, 0, 0);
    player = new Player("Curry", stats);
  }

  @Test
  public void testGetName() {
    assertEquals("Curry", player.getName());
  }

  @Test
  public void testGetStats() {
    assertNotNull(player.getStats());
  }

  @Test
  public void testGetCurrentMode() {
    assertTrue(player.getCurrentMode() instanceof OffenseMode);
  }

  @Test
  public void testSetName() {
    player.setName("Curry");
    assertEquals("Curry", player.getName());
  }


  @Test
  public void testAddScores() {
    player.addScores(Scores.THREE_POINTERS);
    assertEquals((Integer) 3, player.getStats().getScores());
  }

  @Test
  public void testAddBlocks() {
    player.setBlocked(true);
    player.addBlocks(1);
    assertEquals((Integer) 1, player.getStats().getBlocks());
  }

  @Test
  public void testAddSteals() {
    player.setStolen(true);
    player.addSteals(1);
    assertEquals((Integer) 1, player.getStats().getSteals());
  }
}
