/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
import java.io.IOException;

public class BasketBallGameView1 implements BasketBallGameView{
  final Appendable out;
  public BasketBallGameView1(Appendable out) {
    this.out = out;
  }
  @Override
  public void disPlay(String s) throws IOException {
    out.append(s).append("\n");
  }
}
