package Player;

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
    private String currentRoom;
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

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inventory){
        this.inv = inventory;
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

    public String getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(String currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getX(){
        return getPosition().x;
    }

    public int getY(){
        return getPosition().y;
    }

    public Point getFacing() {
        return facing;
    }

    public int facingX(){
        return getFacing().x;
    }

    public int facingY(){
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

    public boolean isSlotEmpty(){
        return inv.getItem(currentSlot) == null;
    }

    public int getPlayersGold() {
        return playersGold;
    }

    public void setPlayersGold(int playersGold) {
        this.playersGold = playersGold;
    }

    public void movePlayer(int x, int y, Room room){
        if(room.isPlaceEmpty(x,y,room)){
            this.setFacing(new Point(x,y));
            room.setObj(x,y,this);
        }
    }

    public Player() {
        kills = 0;
        deaths = 0;
        level = 1;
        hp = 100;
        defence = 1;
        attack = 1;
        playersGold = 0;

        this.inv = new Inventory();
    }
}
