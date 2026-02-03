package PlayerCommand;

import Player.Player;

public class DropItem extends Command {

    @Override
    public void execute(String str, Player player) {
       if (str.equals("q")) {

       }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
