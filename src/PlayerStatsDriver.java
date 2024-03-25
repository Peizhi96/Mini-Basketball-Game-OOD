/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
public class PlayerStatsDriver {
  public static void main(String[] args) {

    Statistics stats1 = new Statistics(25, 7, 8);
    Statistics stats2 = new Statistics(15, 3, 4);


    Player player1 = new Player("Player 1", stats1);
    Player player2 = new Player("Player 2", stats2);


    PlayerStats statsManager = new PlayerStatsImp("Game Stats", new Statistics());


    statsManager.addStats(player1, player1.getStats());
    statsManager.addStats(player2, player2.getStats());

    int totalNum = statsManager.getSize()-1;
    System.out.println("Total number of players: " + totalNum);


    System.out.println("\nAll player stats:");
    statsManager.allStats().forEach(playerName -> System.out.println(playerName));


    Statistics newStatsForPlayer2 = new Statistics(18, 6, 2);
    statsManager.addStats(player2, newStatsForPlayer2);


    System.out.println("\nPlayer stats after updates:");
    System.out.println(statsManager.allStats());


    System.out.println("\nPlayers with more than 20 scores:");
    System.out.println(statsManager.allStats(p -> p.getStats() != null && p.getStats().getScores() != null && p.getStats().getScores() > 20));


    System.out.println("\nNumber of players in the game after updates: " + statsManager.getSize());

    statsManager.printPlayers();
  }
}
