package Rooms;

import Interface.RandomGenerator;

public abstract class Room extends RandomGenerator {
    protected final int maxLength = 20;
    protected final int minLength = 10;

    protected int width;
    protected int length;
}
