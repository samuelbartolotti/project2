package PlayerCommand;

import Player.Player;
import Rooms.Room;

public class DropItem extends Command {

    @Override
    public void execute(String str, Player player, Room room) {
        if (str.equals("q")) {
            Object o = room.getObj(player.getX(), player.getY());
            Object item = player.getInv().getItem(player.getCurrentSlot());
            if (o == null && item != null) {
                room.setObj(player.getX(), player.getY(), item);
            }
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
