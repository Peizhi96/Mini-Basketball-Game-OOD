/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
import java.util.LinkedList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.List;
import java.util.ArrayList;

//this group node implement all method in tree node and do the work
public class GroupNode<T> extends AbstractTreeNode<T>{
  protected List<TreeNode<T>> children;
  public GroupNode(T data){
    super(data);
    children = new LinkedList<>();
  }

  @Override
  public TreeNode<T> addChild(Predicate<Player> identifier, TreeNode<T> child) {
    if (identifier.test((Player) data)) {
      this.children.add(child);
      return this;
    }

    for (int i = 0;i < this.children.size(); i++) {
      this.children.set(i,
          this.children.get(i).addChild(identifier, child));
    }
    return this;
  }


  //return a list of all the nodes

  @Override
  public List<T> toList() {
    List<T> res = new ArrayList<>();
    res.add(this.data);
    if (children != null) {
      for (TreeNode<T> c: children) {
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
    if (predicate.test(this.data)) res.add(this.data);
    if (children != null) {
      for (TreeNode<T> c: children) {
        if (c != null) {
          res.addAll(c.toList(predicate));
        }
      }
    }
    return res;
  }


  //use map method to get the specific nodes we want
  public <R> TreeNode<R> map(Function<T, R> transform) {
    GroupNode<R> newNode = new GroupNode<>(transform.apply(this.data));
    for (TreeNode<T> c: this.children) {
      newNode.children.add(c.map(transform));
    }
    return newNode;
  }

  //combine a series of values into a single value
  public T reduce(T initialValue, BiFunction<T, T, T> combiner) {
    T res = combiner.apply(initialValue, this.data);
    for (TreeNode<T> c : children) {
      res = c.reduce(res, combiner);
    }
    return res;
  }


  @Override
  public void print() {
    System.out.println(this.data.toString());
    for (TreeNode<T> child : children) {
      child.print();
    }
  }

}
