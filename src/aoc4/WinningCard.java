package aoc4;

public class WinningCard {
    private Card card;
    private int winningNumber;

    public WinningCard(Card card, int winningNumber) {
        this.card = card;
        this.winningNumber = winningNumber;
    }

    private int getSum() {
        return card.sumUnmarked();
    }

    public int getFinalScore() {
        System.out.println("get sum" + getSum());
        System.out.println("winningNumber" + winningNumber);
        return getSum() * winningNumber;
    }
}
