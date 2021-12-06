package aoc5;

public class Matrix {
    private final int bound = 990;
    private int[][] coordinates = new int[bound][bound];


    public void increment(int x, int y) {
       coordinates[x][y]++;
    }

    public void print() {
        for (int i=0; i<bound; i++) {
            for (int j=0; j<bound; j++) {
                System.out.print(coordinates[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int count() {
        int sum=0;
        for (int i=0; i<bound; i++) {
            for (int j=0; j<bound; j++) {
                if (coordinates[i][j] >= 2) {
                    sum = sum + 1;
                }
             }
            }
        return sum;
    }


}
