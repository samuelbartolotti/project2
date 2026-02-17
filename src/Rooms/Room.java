package Rooms;

import Game.GameData;
import Interface.RandomGenerator;
import Items.Consumables;

import java.awt.*;

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
    protected int height;

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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Object[][] getDisplay() {
        return display;
    }

    public Object getObj(int x, int y) {
        return display[x][y];
    }

    public void setObj(int x, int y, Object o) {
        display[x][y] = o;
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

    public boolean isPlaceEmpty(int x, int y, Room room) {
        return room.getObj(x, y) == null;
    }

    public Point generateRoomXY() {
        int width = rnd(minLength, maxLength);
        int length = rnd(minLength, maxLength);

        return new Point(width, length);
    }

    public Point generateXY(int width, int height) {
        int x = rnd(0, width - 1);
        int y = rnd(0, height - 1);

        return new Point(x, y);
    }

    public Object chooseItem(SpawnType type) {
        if (type == SpawnType.CONSUMABLE) {
            return new Consumables();
        } else {

            int number = rnd(0, GameData.getWepList().size());
            return GameData.getWepList().get(number);
        }
    }

    public static Room generateRoomType() {
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
            if (baseValue < number && number <= chance + baseValue) {
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
                y = rnd(1, height);
            }
            while (display[x][y] != null);

            if (choosedType == SpawnType.CHEST_ROOM) {
                display[x][y] = "CH";
            } else {
                display[x][y] = chooseItem(choosedType);
            }
        }
    }

    public String displayRoom() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int y = 0; y < height; y++) {
                sb.append(display[y][i]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "R";
    }
}
