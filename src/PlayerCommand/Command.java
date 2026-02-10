package PlayerCommand;

import Player.Player;
import Rooms.Room;

public abstract class Command {
    public abstract void execute(String str, Player player, Room room);

    public abstract boolean exit();
}
