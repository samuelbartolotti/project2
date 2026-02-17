package Map;

import Interface.RandomGenerator;
import Rooms.EmptyRoom;
import Rooms.Room;

import java.awt.*;

public class Map extends RandomGenerator {
    private Room[][] map;
    private final int width = 11;
    private final int height = 11;
    private final int roomCount = 10;

    public Room[][] getMap() {
        return map;
    }

    public void setMap(Room[][] map) {
        this.map = map;
    }

    public int getWidth() {
        return width;
    }

    public Map() {
        this.map = new Room[width][height];
        map[5][0] = new EmptyRoom();
        map[5][1] = Room.generateRoomType();

        generateMap();
    }

    public void generateMap() {
        Point roomXY = new Point(5,1);

        for(int i = 0; i < roomCount - 2; i++) {
            int way = rnd(1,3);

            try {

                switch (way) {
                    case 1 -> {
                        roomXY.x++;
                        if(!isPlaceEmpty(roomXY)){roomXY.x--; i--;}
                    }
                    case 2 -> {
                        roomXY.y++;
                        if(!isPlaceEmpty(roomXY)){roomXY.y--; i--;}
                    }
                    case 3 -> {
                        roomXY.x--;
                        if(!isPlaceEmpty(roomXY)){roomXY.x++; i--;}
                    }
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                i--;
            }
        }
    }

    public boolean isPlaceEmpty(Point roomXY){
        if(map[roomXY.x][roomXY.y] == null) {
            map[roomXY.x][roomXY.y] = Room.generateRoomType();
            return true;
        } else {
            return false;
        }
    }

    public String displayMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int y = 0; y < height; y++) {
                if (map[y][i] != null) {
                    sb.append(map[y][i]);
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
