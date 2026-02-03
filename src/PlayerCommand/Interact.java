package PlayerCommand;

import Player.Player;

public class Interact extends Command {

    @Override
    public void execute(String str, Player player) {
        if (str.equals("e")) {

        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
