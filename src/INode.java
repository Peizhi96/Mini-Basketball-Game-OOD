/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
public interface INode<T> {
  int count();
  int countHelp(int acc);
  INode remove(T b);
  INode add(T b);
  T get(int index) throws IllegalArgumentException;
  <R> INode<R> map(Function<T, R> converter);
  INode<T> filter(Predicate<T> predicate);
  <R> R fold(R initial, BiFunction<R, T, R> acc);
}
