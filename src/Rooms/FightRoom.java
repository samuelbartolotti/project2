package Rooms;

import java.awt.*;

public class FightRoom extends Room {
    private int numOfEnemies;

    public int getNumOfEnemies() {
        return numOfEnemies;
    }

    public void setNumOfEnemies(int numOfEnemies) {
        this.numOfEnemies = numOfEnemies;
    }

    public FightRoom() {
        Point xy = super.generateXY();
        int maxEnemies = 10;
        int minEnemies = 2;

        this.numOfEnemies = rnd(minEnemies, maxEnemies);
        this.width = xy.x;
        this.length = xy.y;
        this.display = new String[width][length];
    }
}
