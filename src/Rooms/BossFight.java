package Rooms;

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
        this.display = new String[fight.width][fight.length];
        this.numOfBoss = 1;
    }
}
