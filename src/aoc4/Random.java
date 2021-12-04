package aoc4;

public class Random {
    private String[] strRandomNumbers;
    private int[] randomNumbers;
    private int index;

    public Random(String[] strRandomNumbers) {
        this.strRandomNumbers = strRandomNumbers;
        convertStringToNumbers();
        this.index = 0;
    }


    private void convertStringToNumbers() {
        randomNumbers = new int[strRandomNumbers.length];
        for (int i = 0; i < strRandomNumbers.length; i++) {
            this.randomNumbers[i] = Integer.parseInt(strRandomNumbers[i]);
        }
    }
    public int pop() {
        if (index < randomNumbers.length) {
            return randomNumbers[index++];
        }
        return 500;
    }
    public boolean gameEnd() {
        return index == randomNumbers.length ;
    }
}
