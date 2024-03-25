/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {
  private Statistics stats;

  @Before
  public void setUp() {
    stats = new Statistics(10, 5, 3); // Initialize with some sample values
  }

  @Test
  public void testConstructor() {
    assertNotNull("The object should not be null", stats);
    assertEquals("Scores should be initialized correctly", Integer.valueOf(10), stats.getScores());
    assertEquals("Blocks should be initialized correctly", Integer.valueOf(5), stats.getBlocks());
    assertEquals("Steals should be initialized correctly", Integer.valueOf(3), stats.getSteals());
  }

  @Test
  public void testAddScores() {
    stats.addScores(Scores.THREE_POINTERS);
    assertEquals("Adding scores should work correctly", Integer.valueOf(13), stats.getScores());
  }

  @Test
  public void testAddBlocks() {
    stats.addBlocks(2);
    assertEquals("Adding blocks should work correctly", Integer.valueOf(7), stats.getBlocks());
  }

  @Test
  public void testAddSteals() {
    stats.addSteals(1);
    assertEquals("Adding steals should work correctly", Integer.valueOf(4), stats.getSteals());
  }
}
