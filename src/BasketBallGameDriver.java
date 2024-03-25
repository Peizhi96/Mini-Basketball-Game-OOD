/*******
 Name: Peizhi Yan
 Assignment: Final
 Date: Dec 10 2023
 ******/
public class BasketBallGameDriver {
  public static void main(String[] args) {
    Statistics stats1 = new Statistics(0,0,0);
    Statistics stats2 = new Statistics(0,0,0);

    Player player1 = new Player("Player1", stats1);
    Player player2 = new Player("Player2", stats2);


    BasketBallGameModel1 model = new BasketBallGameModel1(player1, player2);
    BasketBallGameView1 view = new BasketBallGameView1(System.out);
    BasketBallGameControllerImp controller = new BasketBallGameControllerImp(model, view);
    controller.playGame(model);

  }
}
