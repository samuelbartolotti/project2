package Tests;

import Game.GameData;
import Player.Player;
import PlayerCommand.Attack;
import PlayerCommand.DropItem;
import Rooms.EmptyRoom;
import Rooms.FightRoom;
import Rooms.Room;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class DropItemTest {

    @Test
    void execute() {
        GameData data = GameData.loadGameDataFromResources("/gamedata.json");

        String command = "q";
        Player player = new Player();
        player.setFacing(new Point(1,1));
        player.setCurrentSlot(1);
        player.getInv().addToInventory(GameData.getWepList().get(1),1);
        Room room = new EmptyRoom();

        DropItem dropItem = new DropItem();

        boolean result = dropItem.execute(command, player, room);

        assertTrue(result);
    }
}