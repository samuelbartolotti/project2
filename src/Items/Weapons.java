package Items;

public class Weapons extends Item{

    public Weapons(String name, int damage, int range, Rarity rarity, int cooldown) {
        this.name = name;
        this.damage = damage;
        this.range = range;
        this.rarity = rarity;
        this.cooldown = cooldown;
        this.price = rarity.returnPrice();
    }

    public StringBuilder wepStats(){
        StringBuilder stats = new StringBuilder();
        stats.append("Weapon:").append("\n" + " name - ").append(name).append("\n" + " damage - ").append(damage).append("\n" + " range - ").append(range).append("\n" + " rarity - ").append(rarity).append("\n").append("cooldown - ").append(cooldown).append("\n");
        return stats;
    }

    @Override
    public String toString() {
        return rarity.colorize("W");
    }
}