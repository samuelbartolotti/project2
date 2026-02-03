package Rooms;

import Interface.RandomGenerator;

import java.awt.*;

public abstract class Room extends RandomGenerator {
    protected final int maxLength = 20;
    protected final int minLength = 10;
    protected String[][] display;

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

    public String[][] getDisplay() {
        return display;
    }

    public void setDisplay(String[][] display) {
        this.display = display;
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
