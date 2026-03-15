package Tests;

import Game.GameData;
import Player.Player;
import PlayerCommand.Attack;
import PlayerCommand.Interact;
import Rooms.ChestRoom;
import Rooms.FightRoom;
import Rooms.Room;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class AttackTest {

    @Test
    void execute() {
        GameData data = GameData.loadGameDataFromResources("/gamedata.json");

        String command = "f";
        Player player = new Player();
        player.setFacing(new Point(1,1));
        player.setCurrentSlot(1);
        player.getInv().addToInventory(GameData.getWepList().get(1),1);
        Room room = new FightRoom();
        room.setObj(1,1, GameData.getEneList().get(1));

        Attack attack = new Attack();

        boolean result = attack.execute(command, player, room);

        assertTrue(result);
    }
}