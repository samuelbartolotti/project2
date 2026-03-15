package Tests;

import Rooms.EmptyRoom;
import Rooms.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests display method in Room class.
 *
 * @author Samuel Barolotti.
 */
class RoomTest {

    @Test
    void displayRoom() {

        Room room = new EmptyRoom();

        String result = room.displayRoom();

        System.out.println(result);
    }
}