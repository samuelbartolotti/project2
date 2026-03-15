package Tests;

import Rooms.EmptyRoom;
import Rooms.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void displayRoom() {

        Room room = new EmptyRoom();

        String result = room.displayRoom();

        System.out.println(result);
    }
}