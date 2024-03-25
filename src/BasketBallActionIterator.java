/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
public class BasketBallActionIterator implements Iterator<BasketBallAction> {
  private List<BasketBallAction> actions;
  private int index;

  public BasketBallActionIterator(List<BasketBallAction> actions) {
    this.actions = actions;
    this.index = 0;
  }

  @Override
  public boolean hasNext() {
    return index < actions.size();
  }

  @Override
  public BasketBallAction next() {
    if (!hasNext()) {
        throw new NoSuchElementException();
    }
    return actions.get(index++);
  }
}
