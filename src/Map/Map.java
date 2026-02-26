package Map;

import Interface.RandomGenerator;
import Rooms.Corridor;
import Rooms.EmptyRoom;
import Rooms.Room;
import Player.Player;

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

    public Room getRoom(Point point){
        return map[point.x][point.y];
    }

    public Map() {
        this.map = new Room[width][height];
        map[5][0] = new EmptyRoom();
        map[5][1] = Room.generateRoomType();

        generateMap();
        generateCorridors();
    }

    public void generateCorridors() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Room room = map[row][col];

                if (room != null) {
                    room.setNorth(hasRoom(row, col + 1));
                    room.setSouth(hasRoom(row, col - 1));
                    room.setEast(hasRoom(row + 1, col ));
                    room.setWest(hasRoom(row - 1, col));
                }
            }
        }
    }

    public boolean hasRoom(int row, int col) {
        return row >= 0 && row < height &&
                col >= 0 && col < width &&
                map[row][col] != null;
    }

    public void setPlayer(Player player){
        map[5][0].setObj(player.getX(), player.getY(), player);
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
