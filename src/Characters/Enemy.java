package Characters;

public class Enemy extends Enemies{
    public Enemy(int hp, int damage, String name) {
        super(hp, damage, name);
    }

    public Enemy(int hp, int damage, String name, int cooldown) {
        super(hp, damage, name, cooldown);
    }

    public Enemy(Enemy enemy) {
        super(enemy.hp, enemy.damage, enemy.name, enemy.cooldown);
    }

    @Override
    public String toString() {
        return "E";
    }
}
