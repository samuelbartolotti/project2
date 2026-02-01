package Items;

public class Weapons {
    private String name;
    private int damage;
    private int range;
    private Rarity rarity;
    private int cooldown;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public Weapons(String name, int damage, int range, Rarity rarity, int cooldown) {
        this.name = name;
        this.damage = damage;
        this.range = range;
        this.rarity = rarity;
        this.cooldown = cooldown;
    }

    public StringBuilder wepStats(Weapons weapon){
        StringBuilder stats = new StringBuilder();
        stats.append("Weapon:").append("\n" + " name - ").append(weapon.getName()).append("\n" + " damage - ").append(weapon.getDamage()).append("\n" + " range - ").append(weapon.getRange()).append("\n" + " rarity - ").append(weapon.getRarity()).append("\n").append("cooldown - ").append(weapon.getCooldown()).append("\n");
        return stats;
    }

    @Override
    public String toString() {
        return rarity.colorize("W");
    }
}