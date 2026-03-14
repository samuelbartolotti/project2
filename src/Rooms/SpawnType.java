package Rooms;

/**
 * This class contains chances for Object to be spawn in room.
 *
 * @author Samuel Barolotti.
 */
public enum SpawnType {
    CONSUMABLE(3),
    WEAPON(1),
    CHEST_ROOM(3);

    private final int chance;

    SpawnType(int chance) {
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }
}
