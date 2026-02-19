package Items;

public enum Rarity {
    COMMON("\u001B[37m",0.01, 40, 5),
    RARE("\u001B[32m", 0.02, 30, 10),
    EPIC("\u001B[35m", 0.05, 20, 25),
    LEGENDARY("\u001B[38;5;208m", 0.1, 10, 100);

    private final String color;
    private final double effect;
    private final int chance;
    private final int price;

    Rarity(String color, double effect, int chance, int price) {
        this.color = color;
        this.effect = effect;
        this.chance = chance;
        this.price = price;
    }

    public String colorize(String text) {
        return color + text + "\u001B[0m";
    }

    public double returnEffect() {
        return effect;
    }

    public int returnChance() {
        return chance;
    }

    public int returnPrice() {
        return price;
    }
}
