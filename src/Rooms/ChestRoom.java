package Rooms;

import java.awt.*;

public class ChestRoom extends Room {
    public ChestRoom() {
        Point xy = super.generateRoomXY();

        this.width = xy.x;
        this.height = xy.y;
        this.display = new Object[width][height];
        chance = 10;

        display[width/2][height/2] = "ch";
    }
}
