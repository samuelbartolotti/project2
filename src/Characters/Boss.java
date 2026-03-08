package Characters;

public class Boss extends Enemies{
    public Boss(int hp, int damage, String name, int cooldown) {
        super(hp, damage, name, cooldown);
    }

    public Boss(Boss boss) {
        super(boss.hp, boss.damage, boss.name, boss.cooldown);
    }

    @Override
    public String toString() {
        return "B";
    }
}
