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
            this.height = 10;
        } else {
            this.width = 10;
            this.height = 5;
        }
        this.display = new Object[width][height];
    }
}
