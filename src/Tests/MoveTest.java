package Tests;

import Game.GameData;
import Player.Player;
import PlayerCommand.Attack;
import PlayerCommand.Move;
import Rooms.EmptyRoom;
import Rooms.FightRoom;
import Rooms.Room;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests move command.
 *
 * @author Samuel Barolotti.
 */
class MoveTest {

    @Test
    void execute() {
        GameData data = GameData.loadGameDataFromResources("/gamedata.json");

        String command = "w";
        Player player = new Player();
        player.setPosition(new Point(0,0));
        Room room = new EmptyRoom();

        Move move = new Move();

        boolean result = move.execute(command, player, room);

        assertTrue(result);
    }
}