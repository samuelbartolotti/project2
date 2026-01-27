package Characters;

public abstract class Enemies {
    protected int hp;
    protected int damage;
    protected String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enemies(int hp, int damage, String name) {
        this.hp = hp;
        this.damage = damage;
        this.name = name;
    }
}
