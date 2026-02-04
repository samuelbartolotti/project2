package Rooms;

public enum SpawnType {
    CONSUMABLE(5),
    WEAPON(1),
    CHEST_ROOM(5);

    private final int chance;

    SpawnType(int chance) {
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }
}
