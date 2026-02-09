package Interface;

import java.util.Random;

public abstract class RandomGenerator {
    protected static Random random = new Random();

    public static int rnd(int min, int max) {
        return random.nextInt(min, max+1);
    }
}
