/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmptyNode<T> implements INode<T>{

  @Override
  public int count() {
    return 0;
  }

  @Override
  public int countHelp(int acc) {
    return acc;
  }

  @Override
  public INode remove(T b) {
    return this;
  }

  @Override
  public INode add(T b) {
    return new PlayerNode(b, this);
  }

  @Override
  public T get(int index) throws IllegalArgumentException {
    throw new IllegalArgumentException("Wrong index");
  }


  @Override
  public <R> INode<R> map(Function<T, R> converter) {
    return new EmptyNode<R>();
  }

  @Override
  public INode<T> filter(Predicate<T> predicate) {
    return new EmptyNode<T>();
  }
  @Override
  public <R> R fold(R initial, BiFunction<R, T, R> acc) {
    return initial;
  }

  public String toString() {
    return "";
  }
}
