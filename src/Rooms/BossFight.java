package Rooms;

import Characters.Boss;
import Game.GameData;

import java.awt.*;

public class BossFight extends Room {
    private FightRoom fight;
    private int numOfBoss;

    public FightRoom getFight() {
        return fight;
    }

    public void setFight(FightRoom fight) {
        this.fight = fight;
    }

    public int getNumOfBoss() {
        return numOfBoss;
    }

    public void setNumOfBoss(int numOfBoss) {
        this.numOfBoss = numOfBoss;
    }

    public BossFight(){
        this.fight = new FightRoom();
        this.width = fight.width;
        this.height = fight.height;

        this.display =  fight.getDisplay();
        this.enemies = fight.getEnemies();
        this.numOfBoss = 1;
        chance = 10;

        generateBosses();
        generateChances();
    }

    public void generateBosses() {
        for (int i = 0; i < numOfBoss; i++) {
            Point xy = super.generateXY(this.width, this.height);
            if(this.getObj(xy.x, xy.y) == null){
                int chooseBoss = rnd(0, GameData.getBossList().size()-1);
                Boss boss = new Boss(GameData.getBossList().get(chooseBoss));
                boss.setLocation(xy);
                this.setObj(xy.x, xy.y, boss);
                enemies.add(boss);
            }
        }
    }
}
