package Rooms;

import Characters.Enemies;
import Characters.Enemy;
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
        this.display = new Object[width][height];
        chance = 30;

        this.generateEnemies();
        generateChances();
    }

    public void generateEnemies() {
        for (int i = 0; i < numOfEnemies; i++) {
            Point xy = super.generateXY(this.width, this.height);
            if(this.getObj(xy.x, xy.y) == null){
                int chooseEnemy = rnd(0, GameData.getEneList().size()-1);
                Enemies enemy = GameData.getEneList().get(chooseEnemy);
                enemy.setLocation(xy);
                this.setObj(xy.x, xy.y, enemy);
            }
        }
    }
}
