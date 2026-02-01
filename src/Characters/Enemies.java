package Characters;

public abstract class Enemies {
    protected int hp;
    protected int damage;
    protected String name;
    protected int cooldown;

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

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
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

    public StringBuilder enemiesStats() {
        StringBuilder stats = new StringBuilder();
        stats.append("Enemy: ").append("\n" + " name - ").append(name).append("\n" + " HP - ").append(hp).append("\n" + " damage - ").append(damage).append("\n" + " Cooldown - ").append(cooldown);
        return stats;
    }

    @Override
    public String toString() {
        return "E";
    }
}
