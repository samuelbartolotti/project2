package PlayerCommand;

import Exceptions.PlaceIsOccupied;
import Player.Player;
import Rooms.Room;

import java.awt.*;

public class Move extends Command {

    @Override
    public void execute(String str, Player player, Room room) {
        if (str.equals("w") || str.equals("s") || str.equals("a") || str.equals("d")) {
            int x = player.getY();
            int y = player.getY();
            switch (str) {
                case "w" -> {
                    player.movePlayer(x, y+1, room);
                    player.setFacing(new Point(x,y + 1));
                }

                case "s" -> {
                    player.movePlayer(x, y-1, room);
                    player.setFacing(new Point(x, y - 1));
                }

                case "a" -> {
                    player.movePlayer(x-1, y, room);
                    player.setFacing(new Point(x - 1, y));
                }

                case "d" -> {
                    player.movePlayer(x+1, y, room);
                    player.setFacing(new Point(x + 1, y));
                }

                default -> throw new PlaceIsOccupied("You cant move to this place beacose it contains another object");
            }
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
