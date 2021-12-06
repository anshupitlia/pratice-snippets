package aoc6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File(
            "/Users/anshupitlia/demo/input4.txt");
        BufferedReader br
            = new BufferedReader(new FileReader(file));

        String st;
        st = br.readLine();
        String[] fishTimersStr = st.split(",");
        Submarine submarine = new Submarine(80);
        for (int i = 0; i < fishTimersStr.length; i++) {
            submarine.addFish(new Fish(Integer.parseInt(fishTimersStr[i])));
        }
        System.out.println("fish count" + submarine.fishCount());
        submarine.startSpawning();
        System.out.println("fish count" + submarine.fishCount());

    }

}
