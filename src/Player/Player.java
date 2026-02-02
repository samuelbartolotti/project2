package Player;

public class Player {
    private String name;
    private int kills;
    private int deaths;
    private int level;
    private int hp;
    private int defence;

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

    public void takeDamage(int damage){
        this.hp -= damage;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void addDefence(int defence){
        this.defence += defence;
    }

    public Player() {
        kills = 0;
        deaths = 0;
        level = 1;
        hp = 100;
        defence = 1;
    }
}
