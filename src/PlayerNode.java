/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class PlayerNode<T> implements INode<T>{
  private T m;
  private INode<T> nextNode;

  public PlayerNode(T m, INode nextNode) {
    this.m = m;
    this.nextNode = nextNode;
  }

  @Override
  public int count() {
    return countHelp(0);
  }

  @Override
  public int countHelp(int acc) {
    if (nextNode != null) {
      return nextNode.countHelp(acc+1);
    } else {return 1 + acc;}
  }

  @Override
  public INode remove(T b) {
    if(this.m.equals(b)) {
      return this.nextNode;
    } else {
      this.nextNode = nextNode.remove(b);
      return this;
    }
  }

  @Override
  public INode add(T b) {
    this.nextNode = nextNode.add(b);
    return this;
  }

  @Override
  public T get(int index) throws IllegalArgumentException {
    if (index == 0) return this.m;
    return this.nextNode.get(index-1);
  }

  public String toString() {
    if (this.nextNode != null) {return this.m.toString() + this.nextNode.toString();}
    else {
      return this.nextNode.toString();
    }
  }

  @Override
  public <R> INode<R> map(Function<T, R> converter) {
    return new PlayerNode<R>(converter.apply(this.m), this.nextNode.map(converter));
  }

  @Override
  public INode<T> filter(Predicate<T> predicate) {
    if (predicate.test(m)) {
      return new PlayerNode<T>(m, nextNode.filter(predicate));
    }
    return nextNode.filter(predicate);
  }

  public <R> R fold(R initial, BiFunction<R, T, R> acc) {
    R foldedVal = acc.apply(initial, this.m);
    if (this.m != null) {
      return this.nextNode.fold(foldedVal, acc);
    }
    else return foldedVal;
  }
}
