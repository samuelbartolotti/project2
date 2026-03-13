package PlayerCommand;

import Exceptions.PlaceIsOccupied;
import Player.Player;
import Rooms.Room;

import java.awt.*;

/**
 * This class executes Move command.
 *
 * @author Samuel Barolotti.
 */
public class Move extends Command {

    @Override
    public boolean execute(String str, Player player, Room room) {
        if (str.equals("w") || str.equals("s") || str.equals("a") || str.equals("d")) {
            int x = player.getX();
            int y = player.getY();
            switch (str) {
                case "w" -> {return player.movePlayer(x, y+1, -2, room);}


                case "s" -> {return player.movePlayer(x, y-1, 2, room);}


                case "a" -> {return player.movePlayer(x-1, y, 1, room);}


                case "d" -> {return player.movePlayer(x+1, y, -1, room);}

                default -> throw new PlaceIsOccupied("You cant move to this place beacose it contains another object");
            }
        }
        return false;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
