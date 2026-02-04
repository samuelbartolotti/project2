package Rooms;

import java.awt.*;

public class EmptyRoom extends Room{
    public EmptyRoom() {
        Point xy = super.generateXY();

        this.width = xy.x;
        this.length = xy.y;
        this.display = new String[width][length];
        this.chance = 40;
    }
}
