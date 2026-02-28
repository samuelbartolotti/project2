package Rooms;

import Game.GameData;

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
