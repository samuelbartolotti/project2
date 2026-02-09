package Rooms;

import Game.GameData;

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
        Point xy = super.generateRoomXY();
        int maxEnemies = 10;
        int minEnemies = 2;

        this.numOfEnemies = rnd(minEnemies, maxEnemies);
        this.width = xy.x;
        this.height = xy.y;
        this.display = new String[width][height];
        chance = 30;

        this.generateEnemies();
    }

    public void generateEnemies() {
        for (int i = 0; i < numOfEnemies; i++) {
            Point xy = super.generateXY(this.width, this.height);
            if(display[xy.x][xy.y] == null){
                int chooseEnemy = rnd(0, GameData.getEnemies().size());
                display[xy.x][xy.y] = GameData.getEnemies().get(chooseEnemy);
            }
        }
    }
}
