package Characters;

public class Enemy extends Enemies{
    public Enemy(int hp, int damage, String name) {
        super(hp, damage, name);
    }

    @Override
    public String toString() {
        return "E";
    }
}
