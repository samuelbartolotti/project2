package Tests;

import Game.GameData;
import PlayerCommand.Interact;
import Rooms.ChestRoom;
import Rooms.Room;
import Player.Player;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class InteractTest {

    @Test
    void execute() {
        GameData data = GameData.loadGameDataFromResources("/gamedata.json");

        String command = "e";
        Player player = new Player();
        player.setFacing(new Point(1,1));
        Room room = new ChestRoom();
        room.setObj(1,1, "S");

        Interact interact = new Interact();

        boolean result = interact.execute(command, player, room);

        assertTrue(result);
    }
}