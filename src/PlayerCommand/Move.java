package PlayerCommand;

import Player.Player;

public class Move extends Command {

    @Override
    public void execute(String str, Player player) {
        if (str.equals("w") || str.equals("s") || str.equals("a") || str.equals("d")) {

        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
