package Player;

import Exceptions.CantWalkIntoWall;
import Exceptions.PlaceInFrontOfYouIsOccupied;
import Exceptions.YouAreInFightException;
import Items.Weapons;
import Rooms.Room;
import Map.Map;

import java.awt.*;

public class Player {
    private String name;
    private int kills;
    private int deaths;
    private int level;
    private int hp;
    private int maxHp;
    private double defence;
    private double attack;
    private Point position;
    private Point currentRoom;
    private Point facing;
    private int currentSlot;
    private Inventory inv;
    private int playersGold;
    private Map map;
    private boolean inFight;
    private boolean inMenu;
    private boolean dead;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void addKill() {
        this.kills++;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void addDeath() {
        this.deaths++;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void addLevel() {
        this.level++;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void addHp(int hp) {
        if (!(this.hp + hp > this.maxHp)) {
            this.hp += hp;
        }
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inventory) {
        this.inv = inventory;
    }

    public void takeDamage(int damage) {
        this.hp -= (int) (damage / defence);
        if (this.hp < 0) {
            addDeath();
            setDead(true);
        }
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void addMaxHp(int hp) {
        this.maxHp += hp;
    }

    public double getDefence() {
        return defence;
    }

    public void setDefence(double defence) {
        this.defence = defence;
    }

    public void addDefence(double defence) {
        this.defence += defence;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public void addAttack(double attack) {
        this.attack += attack;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Point getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Point currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getX() {
        return getPosition().x;
    }

    public int getY() {
        return getPosition().y;
    }

    public Point getFacing() {
        return facing;
    }

    public int facingX() {
        return getFacing().x;
    }

    public int facingY() {
        return getFacing().y;
    }

    public void setFacing(Point facing) {
        this.facing = facing;
    }

    public int getCurrentSlot() {
        return currentSlot;
    }

    public void setCurrentSlot(int currentSlot) {
        this.currentSlot = currentSlot;
    }

    public int getPlayersGold() {
        return playersGold;
    }

    public void setPlayersGold(int playersGold) {
        this.playersGold = playersGold;
    }

    public void addGold(int amount) {
        this.playersGold += amount;
    }

    public void subtractGold(int amount){
        this.playersGold -= amount;
    }

    public Map getMap() {
        return map;
    }

    public Room getRoom(Point position) {
        return map.getRoom(position);
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public boolean isInFight() {
        return inFight;
    }

    public void setInFight(boolean inFight) {
        this.inFight = inFight;
    }

    public boolean isInMenu() {
        return inMenu;
    }

    public void setInMenu(boolean inMenu) {
        this.inMenu = inMenu;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean movePlayer(int x, int y, int before, Room room) {
        if (x < room.getWidth() && y < room.getHeight() && x >= 0 && y >= 0) {
            if (room.isPlaceEmpty(x, y, room)) {
                this.setPosition(new Point(x, y));
                room.setObj(x, y, this);
                this.positionBefore(x, y, before, room);

            } else {
                this.setFacing(new Point(x, y));
                return true;
            }
            return true;

        } else {
            if (!moveToAnotherRoom(x, y, room)) {
                throw new CantWalkIntoWall("You are at the end of the room. You cannot walk into wall.");

            } else {
                this.positionBefore(x, y, before, room);
                return true;
            }
        }
    }

    public void positionBefore(int x, int y, int before, Room room) {
        if (Math.abs(before) == 1) {
            room.setObj(x + before, y, null);
            this.setFacing(new Point(x - before, y));
        } else {
            room.setObj(x, y + Integer.signum(before), null);
            this.setFacing(new Point(x, y - Integer.signum(before)));
        }
    }

    public boolean moveToAnotherRoom(int x, int y, Room room) {
        if (!inFight) {
            int width = room.getWidth();
            int height = room.getHeight();

            int thirdWidth;
            if (width % 3 == 0 || width % 3 == 1) {
                thirdWidth = width / 3;
            } else {
                thirdWidth = (int) Math.ceil(width / 3.0);
            }

            int thirdHeight;
            if (height % 3 == 0 || height % 3 == 1) {
                thirdHeight = height / 3;
            } else {
                thirdHeight = (int) Math.ceil(height / 3.0);
            }

            int mapX = (int) this.currentRoom.getX();
            int mapY = (int) this.currentRoom.getY();

            if (room.isNorth() && y == height && x >= thirdWidth && x < width - thirdWidth) {
                Point newPoint = new Point(mapX, mapY + 1);
                Room newRoom = this.getRoom(newPoint);

                this.setCurrentRoom(newPoint);
                this.position = new Point(newRoom.getWidth() / 2, 0);
                this.facing = new Point(newRoom.getWidth() / 2, 1);
                newRoom.setObj(this.getX(), this.getY(), this);
                return true;
            }

            if (room.isSouth() && y == -1 && x >= thirdWidth && x < width - thirdWidth) {
                Point newPoint = new Point(mapX, mapY - 1);
                Room newRoom = this.getRoom(newPoint);

                this.setCurrentRoom(newPoint);
                this.position = new Point(newRoom.getWidth() / 2, newRoom.getHeight() - 1);
                this.facing = new Point(newRoom.getWidth() / 2, newRoom.getHeight() - 2);
                newRoom.setObj(this.getX(), this.getY(), this);
                return true;
            }

            if (room.isWest() && x == -1 && y >= thirdHeight && y < height - thirdHeight) {
                Point newPoint = new Point(mapX - 1, mapY);
                Room newRoom = this.getRoom(newPoint);

                this.setCurrentRoom(newPoint);
                this.position = new Point(newRoom.getWidth() - 1, newRoom.getHeight() / 2);
                this.facing = new Point(newRoom.getWidth() - 2, newRoom.getHeight() / 2);
                newRoom.setObj(this.getX(), this.getY(), this);
                return true;
            }

            if (room.isEast() && x == width && y >= thirdHeight && y < height - thirdHeight) {
                Point newPoint = new Point(mapX + 1, mapY);
                Room newRoom = this.getRoom(newPoint);

                this.setCurrentRoom(newPoint);
                this.position = new Point(0, newRoom.getHeight() / 2);
                this.facing = new Point(1, newRoom.getHeight() / 2);
                newRoom.setObj(this.getX(), this.getY(), this);
                return true;
            }
        } else {
            throw new YouAreInFightException("You cannot leave room, while in fight.");
        }
        return false;
    }

    public String displayStats() {
        Weapons slot1 = (Weapons) inv.getItem(1);
        Weapons slot2 = (Weapons) inv.getItem(2);

        StringBuilder sb = new StringBuilder();
        sb.append("Stats:").append("\n\n");
        sb.append("maxHp - ").append(maxHp).append("\n");
        sb.append("hp - ").append(hp).append("\n");
        sb.append("defence - ").append(defence).append("\n");
        sb.append("attackPower - ").append(attack).append("\n");

        if (slot1 != null) {
            sb.append("slot 1 - ").append(slot1.getRarity().colorize(slot1.getName())).append("\n");
        }

        if (slot2 != null) {
            sb.append("slot 2 - ").append(slot2.getRarity().colorize(slot2.getName())).append("\n");
        }
        sb.append("Gold - ").append(playersGold).append("\n");
        return sb.toString();
    }

    public Player() {
        kills = 0;
        deaths = 0;
        level = 1;
        maxHp = 100;
        hp = 100;
        defence = 1;
        attack = 1;
        playersGold = 0;
        currentSlot = 1;

        this.inv = new Inventory();
    }

    @Override
    public String toString() {
        return "P";
    }
}
