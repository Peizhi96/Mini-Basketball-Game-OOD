/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//this leaf node implements all methods in tree node
//we can transfer leaf node into group node to achieve specific tasks
public class LeafNode<T> extends AbstractTreeNode<T>{
  protected List<TreeNode<T>> children;
  public LeafNode(T data) {
    super(data);
    this.children = new ArrayList<>();
  }

  @Override
  public TreeNode<T> addChild(Predicate<Player> predicate, TreeNode<T> child) {
    if (predicate.test((Player) this.data)) {
      GroupNode<T> newNode = new GroupNode<>(this.data);
      newNode.addChild(predicate, child);
      return newNode;
    }
    return this;
  }

  @Override
  public List<T> toList() {
    List<T> res = new ArrayList<>();
    GroupNode<T> newNode = new GroupNode<>(this.data);
    newNode.children = new ArrayList<>(this.children);
    res.add(this.data);
    if (children != null) {
      for (TreeNode<T> c: newNode.children) {
        if (c != null) {
          res.addAll(c.toList());
        }
      }
    }
    return res;
  }

  @Override
  public List<T> toList(Predicate<T> predicate) {
    List<T> res = new ArrayList<>();
    GroupNode<T> newNode = new GroupNode<>(this.data);
    newNode.children = new ArrayList<>(this.children);
    if (predicate.test((T) this.data)) res.add(this.data);
    if (children != null) {
      for (TreeNode<T> c: newNode.children) {
        if (c != null) {
          res.addAll(c.toList(predicate));
        }
      }
    }
    return res;
  }

  @Override
  public <R> TreeNode<R> map(Function<T, R> transform) {
    AbstractTreeNode<R> newNode = new LeafNode<>(transform.apply(this.data));
    return newNode;
  }

  @Override
  public T reduce(T initialValue, BiFunction<T,T,T> combiner) {
    return combiner.apply(initialValue, this.data);
  }

  @Override
  public void print() {
    System.out.println(this.data);
  }

}

