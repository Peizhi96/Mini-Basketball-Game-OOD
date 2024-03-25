/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.List;
public interface TreeNode<T> {
  //add child node to the root node
  TreeNode<T> addChild(Predicate<Player> identifier, TreeNode<T> child);
  //return a list of all the nodes
  List<T> toList();
  //use map method to get the specific nodes we want
  <R> TreeNode<R> map(Function<T, R> transform);
  //combine a series of values into a single value
  T reduce(T initialValue, BiFunction<T,T,T> combiner);
  //print the nodes in the tree structure
  void print();
  //return a list of specific nodes
  List<T> toList(Predicate<T> predicate);
}
