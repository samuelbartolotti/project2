package Player;

import Exceptions.CantWalkIntoWall;
import Exceptions.PlaceInFrontOfYouIsOccupied;
import Rooms.Room;

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
        this.hp -= damage;
        if (this.hp < 0) {
            addDeath();
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

    public void movePlayer(int x, int y, int before, Room room) {
        if (x < room.getWidth() && y < room.getHeight() && x >= 0 && y >= 0) {
            if (room.isPlaceEmpty(x, y, room)) {
                this.setPosition(new Point(x, y));
                room.setObj(x, y, this);
                if (Math.abs(before) == 1) {
                    room.setObj(x + before, y, null);
                    this.setFacing(new Point(x - before, y));
                } else {
                    room.setObj(x, y + Integer.signum(before), null);
                    this.setFacing(new Point(x, y - Integer.signum(before)));
                }
            } else {
                this.setFacing(new Point(x, y));
                throw new PlaceInFrontOfYouIsOccupied("There is something in your path.");
            }
        } else {
            if(!moveToAnotherRoom(x,y,room)) {
                throw new CantWalkIntoWall("You are at the end of the room. You cannot walk into wall.");
            } else {

            }
        }
    }

    public boolean moveToAnotherRoom(int x, int y, Room room) {
        int width = room.getWidth();
        int height = room.getHeight();


        int thirdWidth = 0;
        int thirdHeight = 0;

        if(width % 3 == 0 || width % 3 == 1) {
            thirdWidth = width / 3;
        } else {
            thirdWidth = (int) Math.ceil((double) width/3);
        }

        System.out.println(thirdWidth);

        if(height % 3 == 0 || height % 3 == 1) {
            thirdHeight = height / 3;
        } else {
            thirdHeight = (int) Math.ceil((double) height/3);
        }

        int mapX = (int) this.currentRoom.getX();
        int mapY = (int) this.currentRoom.getY();

        if(room.isNorth() && y == height && x > thirdWidth-1 && x < width - thirdWidth){
            this.setCurrentRoom(new Point(mapX, mapY+1));
            return true;

        } else if (room.isSouth() && y==-1 && x > thirdWidth-1 && x < width - thirdWidth){
            this.setCurrentRoom(new Point(mapX, mapY-1));
            return true;

        } else if (room.isWest() && x==-1 && y > thirdHeight-1 && y < height - thirdHeight) {
            this.setCurrentRoom(new Point(mapX-1, mapY));
            return true;

        } else if (room.isEast() && x == room.getWidth() && y > thirdHeight-1 && y < height - thirdHeight) {
            this.setCurrentRoom(new Point(mapX+1, mapY));
            return true;
        }
        return false;
    }

    public Player() {
        kills = 0;
        deaths = 0;
        level = 1;
        hp = 100;
        defence = 1;
        attack = 1;
        playersGold = 0;
        currentRoom = new Point(5, 0);
        position = new Point(5, 0);
        facing = new Point(5,1);
        currentSlot = 1;

        this.inv = new Inventory();
    }

    @Override
    public String toString() {
        return "P";
    }
}
