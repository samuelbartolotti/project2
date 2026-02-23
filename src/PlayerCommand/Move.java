package PlayerCommand;

import Exceptions.PlaceIsOccupied;
import Player.Player;
import Rooms.Room;

import java.awt.*;

public class Move extends Command {

    @Override
    public void execute(String str, Player player, Room room) {
        if (str.equals("w") || str.equals("s") || str.equals("a") || str.equals("d")) {
            int x = player.getX();
            int y = player.getY();
            switch (str) {
                case "w" -> {
                    player.setFacing(new Point(player.getX(), player.getY() + 1));
                    player.movePlayer(x, y+1, -2, room);
                }

                case "s" -> {
                    player.setFacing(new Point(player.getX(), player.getY() - 1));
                    player.movePlayer(x, y-1, 2, room);
                }

                case "a" -> {
                    player.setFacing(new Point(player.getX() - 1, player.getY()));
                    player.movePlayer(x-1, y, 1, room);
                }

                case "d" -> {
                    player.setFacing(new Point(player.getX() + 1, player.getY()));
                    player.movePlayer(x+1, y, -1, room);
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
