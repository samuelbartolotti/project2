package PlayerCommand;

import Player.Player;

public abstract class Command {
    public abstract void execute(String str, Player player);

    public abstract boolean exit();
}
