package Rooms;

public class Corridor extends Room{
    private boolean up;

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public Corridor(boolean up){
        this.up = up;
        if(up){
            this.width = 5;
            this.length = 10;
        } else {
            this.width = 10;
            this.length = 5;
        }
        this.display = new String[width][length];
    }
}
