package PlayerCommand;

import Player.Player;
import Rooms.Room;

public class Interact extends Command {

    @Override
    public void execute(String str, Player player, Room room) {
        if (str.equals("e")) {

        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
