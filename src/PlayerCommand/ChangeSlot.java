package PlayerCommand;

import Player.Player;
import Rooms.Room;

public class ChangeSlot extends Command {

    @Override
    public void execute(String str, Player player, Room room) {
        if (str.equals("1") || str.equals("+")) {
            player.setCurrentSlot(1);
        } else if (str.equals("2") || str.equals("ě")) {
            player.setCurrentSlot(2);
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
