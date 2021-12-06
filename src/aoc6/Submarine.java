package aoc6;

import java.util.ArrayList;
import java.util.List;

public class Submarine {
    private List<Fish> fishes = new ArrayList<Fish>();
    private int days;

    public Submarine(int days) {
        this.days = days;
    }

    public void addFish(Fish fish) {
        this.fishes.add(fish);
    }

    public int fishCount() {
        return this.fishes.size();
    }

    public void startSpawning() {
        List<Fish> newFishes = new ArrayList<>();
        for (int i=1; i<= days; i++) {
            for (Fish fish: fishes) {
                fish.stateChange();
                if (fish.isShouldGiveBirth()) {
                    newFishes.add(Fish.getNewFish());
                    fish.resetShouldGiveBirth();
                }
            }
            fishes.addAll(newFishes);
            newFishes.clear();
        }
    }
}
