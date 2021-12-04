package aoc4;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Card> cards = new ArrayList<>();
    private Random random;
    private boolean foundLastWinning;
    private int size;
    private WinningCard winCard;

    public Game(Random random) {
        this.random = random;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public boolean isGameEnd() {
        return random.gameEnd() || foundLastWinning;
    }

    public WinningCard play() {
        int number = random.pop();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            if (!card.isRemoved()) {
                card.strikeOut(number);
                if (card.isWinning()) {
                    System.out.println("I am winning " + i + "with number " + number);
                    WinningCard winningCard = new WinningCard(card, number);
                    if (size > 1) {
                        card.remove();
                        size--;
                    } else {
                        this.foundLastWinning = true;
                    }
                    winCard = winningCard;
                }
            }
        }
        return null;
    }

    public void initializeSize() {
        size = cards.size();
    }

    public WinningCard getWinCard() {
        return winCard;
    }
}
