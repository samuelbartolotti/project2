package Rooms;

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
        this.numOfBoss = 1;
        chance = 10;

        generateBosses();
    }

    public void generateBosses() {
        for (int i = 0; i < numOfBoss; i++) {
            Point xy = super.generateXY(this.width, this.height);
            if(display[xy.x][xy.y] == null){
                int chooseBoss = rnd(0, GameData.getBossList().size()-1);
                display[xy.x][xy.y] = GameData.getBossList().get(chooseBoss);
            }
        }
    }
}
