package Rooms;

import Interface.RandomGenerator;

import java.awt.*;

public abstract class Room extends RandomGenerator {
    protected final int maxLength = 20;
    protected final int minLength = 10;
    protected Object[][] display;
    protected boolean north;
    protected boolean south;
    protected boolean east;
    protected boolean west;
    protected int ID;

    protected int width;
    protected int length;

    public int getMaxLength() {
        return maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Object[][] getDisplay() {
        return display;
    }

    public void setDisplay(Object[][] display) {
        this.display = display;
    }

    public boolean isNorth() {
        return north;
    }

    public void setNorth(boolean north) {
        this.north = north;
    }

    public boolean isSouth() {
        return south;
    }

    public void setSouth(boolean south) {
        this.south = south;
    }

    public boolean isEast() {
        return east;
    }

    public void setEast(boolean east) {
        this.east = east;
    }

    public boolean isWest() {
        return west;
    }

    public void setWest(boolean west) {
        this.west = west;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Point generateXY(){
       int width = rnd(minLength, maxLength);
       int length = rnd(minLength, maxLength);

       return new Point(width, length);
    }

    public StringBuilder displayRoom(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < width; i++){
            for(int y = 0; y < length; y++){
                sb.append(display[y][i]);
            }
            sb.append("\n");
        }
        return sb;
    }
}
