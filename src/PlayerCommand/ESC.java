package PlayerCommand;

import Game.GameData;
import Player.Player;
import Rooms.Room;

public class ESC extends Command {


    @Override
    public void execute(String str, Player player, Room room) {
        if (str.equals("esc")) {
            if (player.isInMenu()) {
                player.setInMenu(false);
            } else {
                player.setInMenu(true);
                super.println(GameData.getText().getFirst());
            }
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
