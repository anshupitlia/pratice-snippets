package aoc6;

public class Fish {
    private int internalTimer;
    private boolean shouldGiveBirth;

    public static Fish getNewFish() {
        return new Fish(8);
    }

    public Fish(int internalTimer) {
        this.internalTimer = internalTimer;
    }

    public void resetTimer() {
        this.internalTimer = 6;
    }

    public void stateChange() {
        if (this.internalTimer > 0 ) {
            this.internalTimer = this.internalTimer - 1;
        }
        else {
            shouldGiveBirth = true;
            resetTimer();
        }
    }

    public boolean isShouldGiveBirth() {
        return shouldGiveBirth;
    }

    public void resetShouldGiveBirth() {
         shouldGiveBirth = false;
    }
}
