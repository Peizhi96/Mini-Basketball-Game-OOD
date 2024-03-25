/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
public interface IList<T> {
  void add(T b);
  void remove(T b);
  T get(int index) throws IllegalArgumentException;
  int getSize();
  <R>IList<R> map(Function<T,R> converter);
  IList<T> filter(Predicate predicate);
  <R> R fold(R initial, BiFunction<R, T, R> acc);
}
