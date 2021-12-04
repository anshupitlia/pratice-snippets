package aoc4;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Card> cards = new ArrayList<>();
    private Random random;

    public Game(Random random) {
        this.random = random;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public WinningCard play() {
        int number = random.pop();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            card.strikeOut(number);
            if (card.isWinning()) {
                System.out.println("I am winning " + i + "with number " + number);
                WinningCard winningCard = new WinningCard(card, number);
                return winningCard;
            }
        }
        return null;
    }
}
