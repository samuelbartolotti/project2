package Rooms;

public class Shop extends Room{
    private final int numberOfItems = 3;

    public Shop(){
        this.width = 11;
        this.length = 11;
        this.display = new String[width][length];
        this.display[6][6] = "O";
        chance = 10;
    }
}
