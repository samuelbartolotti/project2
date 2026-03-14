package Rooms;

import Characters.Enemies;
import Game.GameData;
import Interface.RandomGenerator;
import Items.Consumables;
import Player.Player;

import java.awt.*;
import java.util.ArrayList;

/**
 * Base class for all the rooms.
 *
 * @author Samuel Barolotti.
 */
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
    protected ArrayList<Enemies> enemies;

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

    public ArrayList<Enemies> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemies> enemies) {
        this.enemies = enemies;
    }

    public void addEnemies(Enemies enemies) {
        this.enemies.add(enemies);
    }

    /**
     * This method generates size of room.
     * @return returns dimensions of room.
     */
    public Point generateRoomXY() {
        int width = rnd(minLength, maxLength);
        int length = rnd(minLength, maxLength);

        return new Point(width, length);
    }

    /**
     * This method chooses random square in room.
     * @param width width of room.
     * @param height height of room.
     * @return returns chosen square.
     */
    public Point generateXY(int width, int height) {
        int x = rnd(0, width - 1);
        int y = rnd(0, height - 1);

        return new Point(x, y);
    }

    /**
     * This method generates loot from chest.
     * @param type Possible loot types.
     * @return returns chosen object.
     */
    public Object chooseItem(SpawnType type) {
        if (type == SpawnType.CONSUMABLE) {
            return new Consumables();
        } else {

            int number = rnd(0, GameData.getWepList().size() - 1);
            return GameData.getWepList().get(number);
        }
    }

    /**
     * Generates which type the room will be.
     * @return returns room type, which is assigned to map.
     */
    public static Room generateRoomType() {
        int number = rnd(1, 100);

        Room[] rooms = {
                new EmptyRoom(),
                new FightRoom(),
                new Shop(),
                new ChestRoom()
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

    /**
     * This method has chance to generate object like weapon or consumable in room.
     */
    public void generateChances() {
        SpawnType[] spawnTypes = SpawnType.values();
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
                x = rnd(0, width-1);
                y = rnd(0, height-1);
            }
            while (display[x][y] != null);

            if (choosedType == SpawnType.CHEST_ROOM) {
                display[x][y] = "CH";
            } else {
                display[x][y] = chooseItem(choosedType);
            }
        }
    }

    /**
     * Checks if player has killed all the enemies.
     * @return If not than true.
     */
    public boolean isInFight() {
        if(this instanceof FightRoom || this instanceof BossFight) {
            return !enemies.isEmpty();
        }
        return false;
    }

    /**
     * This method makes enemies play in combat.
     * @param player Needed for getting damage and movement of enemies.
     */
    public void fight(Player player) {
        for(Enemies enemy: enemies){
            enemy.playRound(player, this);
        }
    }

    /**
     *This method is needed for visualization of room. It contains all the important conditions.
     * @return visual part of room.
     */
    public String displayRoom() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");

        int thirdWidth = 0;
        int thirdHeight = 0;

        if (width % 3 == 0 || width % 3 == 1) {
            thirdWidth = width / 3;
        } else {
            thirdWidth = (int) Math.ceil((double) width / 3);
        }

        if (height % 3 == 0 || height % 3 == 1) {
            thirdHeight = height / 3;
        } else {
            thirdHeight = (int) Math.ceil((double) height / 3);
        }

        for (int i = height; i >= -1; i--) {
            for (int y = 0; y < width; y++) {

                if (y == 0 && i != -1 && i < height) {
                    if (i > thirdHeight - 1 && i < height - thirdHeight && this.west) {
                        sb.append("*");
                    } else {
                        sb.append("|");
                    }
                } else if (i == -1) {
                    if (y > thirdWidth - 1 && y < width - thirdWidth && this.south) {
                        sb.append(" ").append("*").append(" ");
                    } else {
                        if (y == 0) {
                            sb.append(" ");
                        }
                        sb.append(" ").append("‾").append(" ");
                    }
                }

                if (i != -1 && i < height) {
                    if (display[y][i] == null) {
                        sb.append(" ").append(" ").append(" ");
                    } else if (display[y][i].equals("ch")) {
                        sb.append("ch").append(" ");
                    } else {
                        sb.append(" ").append(display[y][i]).append(" ");
                    }
                }

                if (y + 1 == width && i != -1 && i < height) {
                    if (i > thirdHeight - 1 && i < height - thirdHeight && this.east) {
                        sb.append("*");
                    } else {
                        sb.append("|");
                    }
                } else if (i == height) {
                    if (y > thirdWidth - 1 && y < width - thirdWidth && this.north) {
                        sb.append(" ").append("*").append(" ");
                    } else {
                        sb.append(" ").append("_").append(" ");
                    }
                }
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
