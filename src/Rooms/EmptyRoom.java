package Rooms;

import java.awt.*;

/**
 * This class is just empty space with random height and width.
 *
 * @author Samuel Barolotti.
 */
public class EmptyRoom extends Room{
    public EmptyRoom() {
        Point xy = super.generateRoomXY();

        this.width = xy.x;
        this.height = xy.y;
        this.display = new Object[width][height];
        chance = 45;

        generateChances();
    }
}
