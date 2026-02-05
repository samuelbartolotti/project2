package Rooms;

import Game.GameData;
import Interface.RandomGenerator;
import Items.Consumables;
import Items.Weapons;

import java.awt.*;
import java.util.ArrayList;

public abstract class Room extends RandomGenerator {
    protected final int maxLength = 20;
    protected final int minLength = 10;
    protected Object[][] display;
    protected boolean north;
    protected boolean south;
    protected boolean east;
    protected boolean west;
    protected int ID;
    protected int chance;

    protected int width;
    protected int length;

    public int getMaxLength() {
        return maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Object[][] getDisplay() {
        return display;
    }

    public void setDisplay(Object[][] display) {
        this.display = display;
    }

    public boolean isNorth() {
        return north;
    }

    public void setNorth(boolean north) {
        this.north = north;
    }

    public boolean isSouth() {
        return south;
    }

    public void setSouth(boolean south) {
        this.south = south;
    }

    public boolean isEast() {
        return east;
    }

    public void setEast(boolean east) {
        this.east = east;
    }

    public boolean isWest() {
        return west;
    }

    public void setWest(boolean west) {
        this.west = west;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public Point generateXY() {
        int width = rnd(minLength, maxLength);
        int length = rnd(minLength, maxLength);

        return new Point(width, length);
    }

    public Object chooseItem(SpawnType type) {
        if (type == SpawnType.CONSUMABLE){
            return new Consumables();
        } else {

            int number = rnd(1, GameData.getWeapons().size());
            return GameData.getWeapons().get(number);
        }
    }

    public Room generateRoomType(){
        int number = rnd(1, 100);

        Room[] rooms = {
                new EmptyRoom(),
                new FightRoom(),
                new BossFight(),
                new Shop()
        };

        int baseValue = 0;

        for (Room r : rooms) {
           int chance = r.getChance();
            if(baseValue < number && number <= chance + baseValue){
                return r;
            }
            baseValue += chance;
        }

        return null;
    }

    public void generateChances(SpawnType... spawnTypes) {
        int number = rnd(1, 100);
        int currentRangeStart = 0;
        SpawnType choosedType = null;

        for (SpawnType spawnType : spawnTypes) {
            int chance = spawnType.getChance();
            if (number > currentRangeStart && number <= chance) {
                choosedType = spawnType;
                break;
            }
            currentRangeStart += chance;
        }
        if (choosedType != null) {
            int x;
            int y;

            do {
                x = rnd(1, width);
                y = rnd(1, length);
            }
            while (display[x][y] != null);

            if (choosedType == SpawnType.CHEST_ROOM) {
                display[x][y] = "CH";
            } else {
                display[x][y] = chooseItem(choosedType);
            }
        }
    }

    public StringBuilder displayRoom() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int y = 0; y < length; y++) {
                sb.append(display[y][i]);
            }
            sb.append("\n");
        }
        return sb;
    }
}
