package PlayerCommand;

import Interface.ConsoleUI;
import Player.Player;
import Rooms.Room;

/**
 * This is base class for all commands.
 *
 * @author Samuel Barolotti.
 */
public abstract class Command extends ConsoleUI {
    public abstract boolean execute(String str, Player player, Room room);

    public abstract boolean exit();
}
