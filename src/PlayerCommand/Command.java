package PlayerCommand;

import Interface.ConsoleUI;
import Player.Player;
import Rooms.Room;

public abstract class Command extends ConsoleUI {
    public abstract void execute(String str, Player player, Room room);

    public abstract boolean exit();
}
