/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/

import java.util.List;
import java.util.function.Predicate;

public interface PlayerStats {
  void addStats(Player player, Statistics stats);
  int getSize();
  List<String> allStats();
  List<String> allStats(Predicate<Player> predicate);
  void printPlayers();
}
