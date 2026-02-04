package Characters;

public class Boss extends Enemies{
    public Boss(int hp, int damage, String name, int cooldown) {
        super(hp, damage, name, cooldown);
    }

    @Override
    public String toString() {
        return "B";
    }
}
