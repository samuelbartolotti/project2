package Player;

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

    public void addKill(){
        this.kills++;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void addDeath(){
        this.deaths++;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void addLevel(){
        this.level++;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void addHp(int hp){
        if (!(this.hp+hp > this.maxHp)){this.hp += hp;}
    }

    public void takeDamage(int damage){
        this.hp -= damage;
        if (this.hp < 0){addDeath();}
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void addMaxHp(int hp){
        this.maxHp += hp;
    }

    public double getDefence() {
        return defence;
    }

    public void setDefence(double defence) {
        this.defence = defence;
    }

    public void addDefence(double defence){
        this.defence += defence;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public void addAttack(double attack){
        this.attack += attack;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Player() {
        kills = 0;
        deaths = 0;
        level = 1;
        hp = 100;
        defence = 1;
        attack = 1;
    }
}
