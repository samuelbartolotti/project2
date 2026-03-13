package Map;

import Interface.RandomGenerator;
import Rooms.BossFight;
import Rooms.Corridor;
import Rooms.EmptyRoom;
import Rooms.Room;
import Player.Player;

import java.awt.*;

/**
 * This class creates map of all rooms in level.
 *
 * @author Samuel Bartolotti.
 */
public class Map extends RandomGenerator {
    private Room[][] map;
    private final int width = 50;
    private final int height = 50;
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
        map[25][0] = new EmptyRoom();
        map[25][1] = Room.generateRoomType();

        generateMap();
        generateCorridors();
    }

    /**
     * This method generates corridors between rooms.
     */
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

    /**
     * Check if there is a room on coordinates xy.
     * @param row x.
     * @param col y.
     * @return if there is room.
     */
    public boolean hasRoom(int row, int col) {
        return row >= 0 && row < height &&
                col >= 0 && col < width &&
                map[row][col] != null;
    }

    /**
     * Sets player to base position in start room.
     * @param player player to be set.
     */
    public void setPlayer(Player player){
        Room room = map[25][0];
        int half = room.getWidth()/2;
        player.setCurrentRoom(new Point(25,0));
        player.setPosition(new Point(half,0));
        player.setFacing(new Point(half, 1));
        room.setObj(player.getX(), player.getY(), player);
        player.setHp(player.getMaxHp());
    }

    /**
     * This method generates map from start room to random direction except down.
     */
    public void generateMap() {
        Point roomXY = new Point(25,1);

        boolean lastRoom = false;

        for(int i = 0; i < roomCount - 2; i++) {
            int way = rnd(1,3);

            if(i+1==roomCount-2) {
                lastRoom = true;
            }

            try {

                switch (way) {
                    case 1 -> {
                        roomXY.x++;
                        if(!isPlaceEmpty(roomXY, lastRoom)) {roomXY.x--; i--;}
                    }
                    case 2 -> {
                        roomXY.y++;
                        if(!isPlaceEmpty(roomXY, lastRoom)) {roomXY.y--; i--;}
                    }
                    case 3 -> {
                        roomXY.x--;
                        if(!isPlaceEmpty(roomXY, lastRoom)) {roomXY.x++; i--;}
                    }
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                i--;
            }
        }
    }

    /**
     * This method creates rooms type.
     * @param roomXY coordinates for new room.
     * @param lastRoom room before.
     * @return for loop to continue.
     */
    public boolean isPlaceEmpty(Point roomXY, boolean lastRoom){
        if(map[roomXY.x][roomXY.y] == null) {
            if(lastRoom) {
                map[roomXY.x][roomXY.y] = new BossFight();
            } else {
                map[roomXY.x][roomXY.y] = Room.generateRoomType();
            }

            return true;
        } else {
            return false;
        }
    }

    /**
     * Displays map.
     * @return String of all roooms.
     */
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
