/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/

import java.util.function.Predicate;
public class LinkedListImp {
  public static void main(String[] args) {
    PlayerList<Statistics> statsPlayerList1 = new PlayerList<>();
    PlayerList<Statistics> statsPlayerList2 = new PlayerList<>();

    Statistics statsPlayer1 = new Statistics(0,0,0);
    Statistics statsPlayer2 = new Statistics(0,0,0);

    statsPlayerList1.add(new Statistics(statsPlayer1.getScores(), statsPlayer1.getBlocks(), statsPlayer1.getSteals()));
    statsPlayerList2.add(new Statistics(statsPlayer2.getScores(), statsPlayer2.getBlocks(), statsPlayer2.getSteals()));

    statsPlayer1.addScores(Scores.THREE_POINTERS);
    statsPlayerList1.add(new Statistics(statsPlayer1.getScores(), statsPlayer1.getBlocks(), statsPlayer1.getSteals()));
    statsPlayer2.addBlocks(1);
    statsPlayerList2.add(new Statistics(statsPlayer2.getScores(), statsPlayer2.getBlocks(), statsPlayer2.getSteals()));
    statsPlayer1.addSteals(1);
    statsPlayerList1.add(new Statistics(statsPlayer1.getScores(), statsPlayer1.getBlocks(), statsPlayer1.getSteals()));
    statsPlayer1.addScores(Scores.THREE_POINTERS);
    statsPlayerList1.add(new Statistics(statsPlayer1.getScores(), statsPlayer1.getBlocks(), statsPlayer1.getSteals()));
    statsPlayer2.addScores(Scores.TWO_POINTERS);
    statsPlayerList2.add(new Statistics(statsPlayer2.getScores(), statsPlayer2.getBlocks(), statsPlayer2.getSteals()));
    statsPlayer2.addBlocks(1);
    statsPlayerList2.add(new Statistics(statsPlayer2.getScores(), statsPlayer2.getBlocks(), statsPlayer2.getSteals()));
    statsPlayer2.addScores(Scores.TWO_POINTERS);
    statsPlayerList2.add(new Statistics(statsPlayer2.getScores(), statsPlayer2.getBlocks(), statsPlayer2.getSteals()));
    statsPlayer1.addScores(Scores.THREE_POINTERS);
    statsPlayerList1.add(new Statistics(statsPlayer1.getScores(), statsPlayer1.getBlocks(), statsPlayer1.getSteals()));

    for (int i = 0; i < statsPlayerList1.getSize(); i++) {
      Statistics stats = statsPlayerList1.get(i);
      System.out.println("Player1: " + "Scores: " + stats.getScores() + ", Blocks: " + stats.getBlocks() + ", Steals: " + stats.getSteals());
    }
    System.out.println("\n");
    for (int i = 0; i < statsPlayerList2.getSize(); i++) {
      Statistics stats = statsPlayerList2.get(i);
      System.out.println("Player2: " + "Scores: " + stats.getScores() + ", Blocks: " + stats.getBlocks() + ", Steals: " + stats.getSteals());
    }

    System.out.println("\n");
    int size1 = statsPlayerList1.getSize();
    int size2 = statsPlayerList2.getSize();
    System.out.println("The size of player1's stats " + size1);
    System.out.println("The size of player2's stats " + size2);

    System.out.println("\n");
    System.out.println(statsPlayerList1.get(0).toString());
    System.out.println(statsPlayerList2.get(4).toString());
    System.out.println("\n");
    Statistics playerToMove = statsPlayerList1.get(3);
    statsPlayerList1.remove(playerToMove);
    for (int i = 0; i < statsPlayerList1.getSize(); i++) {
      Statistics stats = statsPlayerList1.get(i);
      System.out.println("Player1: " + "Scores: " + stats.getScores() + ", Blocks: " + stats.getBlocks() + ", Steals: " + stats.getSteals());
    }



    //map method
    IList<Integer> scoresLength1 = statsPlayerList1.map(s->s.getScores());
    for (int i=0;i<scoresLength1.getSize();i++) {
      System.out.println("Time when player1's scored : " + i+1 + ": " + scoresLength1.get(i));
    }
    IList<Integer> scoresLength2 = statsPlayerList2.map(s->s.getScores());
    for (int i=0;i<scoresLength2.getSize();i++) {
      System.out.println("Time when player2's scored : " + i+1 + ": " + scoresLength2.get(i));
    }
    System.out.println("\n");


    //filter method
    Predicate<Statistics> scoreGreaterThanTwo = stats -> stats.getScores() > 2;
    IList<Statistics> highScoringStats1 = statsPlayerList1.filter(scoreGreaterThanTwo);
    IList<Statistics> highScoringStats2 = statsPlayerList2.filter(scoreGreaterThanTwo);

    System.out.println("When player1 scored more than 2: ");
    for (int i = 0; i < highScoringStats1.getSize(); i++) {
      Statistics stats = highScoringStats1.get(i);
      System.out.println("Player1: " + stats.getScores());
    }
    System.out.println("\n");
    System.out.println("When player2 scored more than 2: ");
    for (int i = 0; i < highScoringStats2.getSize(); i++) {
      Statistics stats = highScoringStats2.get(i);
      System.out.println("Player2: " + stats.getScores());
    }
    System.out.println("\n");


    //fold method
    int len1 = statsPlayerList1.fold(0, (acc, stats) -> acc + 1);
    System.out.println("The length of statsPlayerList1: "+len1);
    int len2 = statsPlayerList2.fold(0, (acc, stats) -> acc + 1);
    System.out.println("The length of statsPlayerList2: "+len2);












  }
}
