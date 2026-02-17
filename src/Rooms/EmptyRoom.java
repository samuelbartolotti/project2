package Rooms;

import java.awt.*;

public class EmptyRoom extends Room{
    public EmptyRoom() {
        Point xy = super.generateRoomXY();

        this.width = xy.x;
        this.height = xy.y;
        this.display = new Object[width][height];
        chance = 40;
    }
}
