package aoc4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Input {
      public static void main(String[] args) throws Exception {
          File file = new File(
              "/Users/anshupitlia/demo/input2.txt");
          BufferedReader br
              = new BufferedReader(new FileReader(file));

          String st;
          st = br.readLine();
          String[] randomNumbers = st.split(",");
          Random random = new Random(randomNumbers);
          Game game = new Game(random);
          while ((st = br.readLine()) != null) {
              String[][] numbers = new String[5][5];
              int i = 0;
              while (st != null && i < 5) {
                  if (!st.isEmpty()) {
                      st = st.trim();
                      numbers[i++] = st.split("\\s+");
                  }
                  st = br.readLine();
              }
              Card card = new Card(numbers);
              game.addCard(card);
          }
          WinningCard winningCard = game.play();
          while (!random.gameEnd() && winningCard == null) {
              winningCard = game.play();
          }
          System.out.println("sum is " + winningCard.getFinalScore());

      }
}
