package aoc4;

public class Card {
    private int[][] numbers;
    private String[][] strNumbers;
    private boolean removed;

    public Card(String[][] strNumbers) {
        this.strNumbers = strNumbers;
        convertStringToNumbers();
    }

    public void remove() {
        this.removed = true;
    }

    public boolean isRemoved() {
        return this.removed;
    }

    private void convertStringToNumbers() {
        numbers = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                numbers[i][j] = Integer.parseInt(strNumbers[i][j]);
            }
        }
    }

    public void strikeOut(int number) {
        for (int i=0; i<5;i++) {
            for (int j=0; j<5; j++) {
                if (numbers[i][j] == number) {
                    numbers[i][j] = 1000;
                }
            }
        }
    }

    public boolean isWinning() {
        for (int i=0; i<5;i++) {
          if ((numbers[i][0] == 1000) &&  (numbers[i][1] == 1000) &&  (numbers[i][2] == 1000) &&  (numbers[i][3] == 1000) &&  (numbers[i][4] == 1000)) {
              return true;
          }
        }
        for (int i=0; i<5; i++) {
            if ((numbers[0][i] == 1000) &&  (numbers[1][i] == 1000) &&  (numbers[2][i] == 1000) &&  (numbers[3][i] == 1000) &&  (numbers[4][i] == 1000)) {
                return true;
            }
        }
        return false;
    }

    public int sumUnmarked() {
        int sum = 0;
        for (int i=0; i<5;i++) {
            for (int j=0; j<5; j++) {
                if (numbers[i][j] != 1000) {
                    sum += numbers[i][j];
                }
            }
        }
        return sum;
    }
}
