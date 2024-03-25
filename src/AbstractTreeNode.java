
import java.util.List;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
public abstract class AbstractTreeNode<T> implements TreeNode<T> {

  protected T data;
  protected List<TreeNode<T>> children;

  public AbstractTreeNode(T data) {
    this.data = data;
    this.children = new ArrayList<>();
  }


  public abstract TreeNode<T> addChild(Predicate<Player> predicate, TreeNode<T> child);

  //return a list of all the nodes
  public List<T> toList() {
    List<TreeNode<T>> result = new ArrayList<>();
    result.add(this);
    return (List<T>) result;
  }

  public List<T> toList(Predicate<T> predicate) {
    List<TreeNode<T>> result = new ArrayList<>();
    if (predicate.test((T) this.data))result.add(this);
    return (List<T>) result;
  }

  //use map method to get the specific nodes we want
  public abstract <R> TreeNode<R> map(Function<T, R> transform);

  //combine a series of values into a single value
  public abstract T reduce(T initialValue, BiFunction<T, T, T> combiner);

  public void print() {
    System.out.println(this);
  }
}
