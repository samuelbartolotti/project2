package Items;

public enum Rarity {
    COMMON("\u001B[37m",0.01),
    RARE("\u001B[32m", 0.02),
    EPIC("\u001B[35m", 0.05),
    LEGENDARY("\u001B[38;5;208m", 0.1);

    private final String color;
    private final double effect;

    Rarity(String color, double effect) {
        this.color = color;
        this.effect = effect;
    }

    public String colorize(String text) {
        return color + text + "\u001B[0m";
    }

    public double returnEffect() {
        return effect;
    }
}
