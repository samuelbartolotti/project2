package Interface;

import java.util.Random;

public abstract class RandomGenerator {
    protected Random random = new Random();

    public int rnd(int min, int max) {
        return random.nextInt(min, max+1);
    }
}
