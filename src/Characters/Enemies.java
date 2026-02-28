package Characters;

import Player.Player;
import Interface.RandomGenerator;
import Rooms.Room;

import java.awt.*;

public abstract class Enemies {
    protected int hp;
    protected int damage;
    protected String name;
    protected int cooldown;
    protected Point location;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void giveDamage(int damage) {
        this.hp -= damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public int getX() {
        return location.x;
    }

    public int getY() {
        return location.y;
    }

    public Enemies(int hp, int damage, String name) {
        this.hp = hp;
        this.damage = damage;
        this.name = name;
        this.cooldown = 1;
    }

    public Enemies(int hp, int damage, String name, int cooldown) {
        this.hp = hp;
        this.damage = damage;
        this.name = name;
        this.cooldown = cooldown;
    }

    public void attack(Player player) {
        player.takeDamage(damage);
    }

    public void move(Player player, Room room) {
        int x = getX();
        int y = getY();

        int dx = (int) Math.signum(player.getX() - x);
        int dy = (int) Math.signum(player.getY() - y);

        if (RandomGenerator.rnd(0, 1) == 0) {
            x += dx;
        } else {
            y += dy;
        }

        if(room.getWidth() > x && room.getHeight() > y && 0 <=x && 0 <=y && room.getObj(x, y) == null) {
            room.setObj(x, y, this);
            room.setObj(getX(), getY(), null);
        }
    }

    public void playRound(Player player, Room room) {
        if (RandomGenerator.rnd(0, 2) == 0) {
            attack(player);
        } else {
            move(player, room);
        }
    }

    public StringBuilder enemiesStats() {
        StringBuilder stats = new StringBuilder();
        stats.append("Enemy: ").append("\n" + " name - ").append(name).append("\n" + " HP - ").append(hp).append("\n" + " damage - ").append(damage).append("\n" + " Cooldown - ").append(cooldown);
        return stats;
    }
}
