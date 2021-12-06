package aoc5;

import aoc4.Card;
import aoc4.Game;
import aoc4.Random;
import aoc4.WinningCard;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Input {
    public static void main(String[] args) throws Exception {
        File file = new File(
            "/Users/anshupitlia/demo/inputcoord2.txt");
        BufferedReader br
            = new BufferedReader(new FileReader(file));

        Matrix matrix = new Matrix();

        String st;
        st = br.readLine();
        int x1, y1, x2, y2;
        while (st != null) {
            String[] initialSplittedCoords = st.split("[->,\\s]");
            String[] splittedCoords = Arrays.stream(initialSplittedCoords)
                .filter(value ->
                    value != null && value.length() > 0
                )
                .toArray(size -> new String[size]);
            x1 = Integer.parseInt(splittedCoords[0]);
            y1 = Integer.parseInt(splittedCoords[1]);
            x2 = Integer.parseInt(splittedCoords[2]);
            y2 = Integer.parseInt(splittedCoords[3]);
            Coordinates coordinate1 = new Coordinates(x1, y1);
            Coordinates coordinate2 = new Coordinates(x2, y2);
            if (coordinate1.isLine(coordinate2) == TypeOfLine.HORIZONTAL) {
                if (x1 < x2) {
                    for (int i = x1; i <= x2; i++) {
                        matrix.increment(y1, i);
                    }
                } else
                {
                    for (int i = x2; i <= x1; i++) {
                        matrix.increment(y1, i);
                    }
                }

            } else if (coordinate1.isLine(coordinate2) == TypeOfLine.VERTICAL) {
                if (y1 < y2) {
                    for (int i = y1; i <= y2; i++) {
                        matrix.increment(i, x1);
                    }
                }
                {
                    for (int i = y2; i <= y1; i++) {
                        matrix.increment(i, x1);
                    }
                }
            } else if (coordinate1.isLine(coordinate2) == TypeOfLine.DIAGONAL_1) {
                if ((y1 < y2) && (x1 < x2)){
                    for (int i = y1, j = x1; i <= y2; i++, j++) {
                        matrix.increment(i, j);
                    }
                } else if (y1 < y2)
                {
                    for (int i = y1, j=x1; i <= y2; i++, j--) {
                        matrix.increment(i, j);
                    }
                } else if (x1 < x2) {
                    for (int i = y2, j=x2; i <= y1; i++, j--) {
                        matrix.increment(i, j);
                    }
                } else if ((y2 < y1) && (x2 < x1)){
                    for (int i = y2, j = x2; i <= y1; i++, j++) {
                        matrix.increment(i, j);
                    }
                }
            }
            st = br.readLine();
        }
        matrix.print();
        System.out.println("Count=" + matrix.count());
    }
}
