/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class PlayerList<T> implements IList<T>{
  private INode<T> head;
  public PlayerList() {
    head = new EmptyNode<>();
  }

  public PlayerList(INode<T> head) {
    this.head = head;
  }

  @Override
  public void add(T b) {
    head = head.add(b);
  }

  @Override
  public void remove(T b) {
    head = head.remove(b);
  }

  @Override
  public int getSize() {
    return head.count();
  }

  @Override
  public T get(int index) throws IllegalArgumentException {
    if ((index >= 0) && (index < getSize())) {
      return head.get(index);
    }
    else throw new IllegalArgumentException("Invalid index");
  }

  public String toString(){
    return head.toString();
  }

  public <R>IList<R> map(Function<T,R> converter) {
    return new PlayerList<R>(head.map(converter));
  }

  public IList<T> filter(Predicate predicate) {
    return new PlayerList<T>(head.filter(predicate));
  }

  public <R> R fold(R initial, BiFunction<R, T, R> acc) {
    if (head == null) {
      return initial;
    } else {
      return head.fold(initial, acc);
    }
  }
}
