package Rooms;

import java.awt.*;

public class EmptyRoom extends Room{
    private final int consumableSpawnChance = 5;
    private final int weaponSpawnChance = 1;
    public EmptyRoom() {
        Point xy = super.generateXY();

        this.width = xy.x;
        this.length = xy.y;
        this.display = new String[width][length];
    }
}
