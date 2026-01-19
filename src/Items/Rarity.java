package Items;

public enum Rarity {
    COMMON("\u001B[37m"),
    RARE("\u001B[32m"),
    EPIC("\u001B[35m"),
    LEGENDARY("\u001B[38;5;208m");

    private final String color;

    Rarity(String color) {
        this.color = color;
    }

    public String colorize(String text) {
        return color + text + "\u001B[0m";
    }
}
