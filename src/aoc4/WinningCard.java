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
        return getSum() * winningNumber;
    }
}
