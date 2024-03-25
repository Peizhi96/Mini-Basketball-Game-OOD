/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PlayerStatsImp implements PlayerStats{
  private TreeNode<Player> root;
  public PlayerStatsImp(String name, Statistics stats) {
    root = new LeafNode<>(new Player(name, stats));
  }
  @Override
  public void addStats(Player player, Statistics stats) {
    TreeNode<Player> newNode = new LeafNode<>(new Player(player.getName(), stats));
    root = root.addChild(p->true, newNode);
  }

  @Override
  public int getSize() {
    TreeNode<Integer> size = root.map(e->1);
    return size.reduce(0, (a,b)->a+b);
  }

  @Override
  public List<String> allStats() {
    return root.toList().stream().map(e->e.getName()).collect(Collectors.toList());
  }

  @Override
  public List<String> allStats(Predicate<Player> predicate) {
      return root.toList(predicate).stream()
          .map(p->p.getName())
          .collect(Collectors.toList());
  }


  public void printPlayers() {
    root.print();
  }

}
