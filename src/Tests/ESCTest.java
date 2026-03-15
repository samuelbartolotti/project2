package Tests;

import Game.GameData;
import Player.Player;
import PlayerCommand.ESC;
import PlayerCommand.Interact;
import Rooms.ChestRoom;
import Rooms.Room;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ESCTest {

    @Test
    void execute() {
        GameData data = GameData.loadGameDataFromResources("/gamedata.json");

        String command = "esc";
        Player player = new Player();
        Room room = new ChestRoom();

        ESC esc = new ESC();

        boolean result = esc.execute(command, player, room);

        assertTrue(result);
    }
}