package PlayerCommand;

import Game.GameData;
import Player.Player;
import Rooms.Room;

/**
 * This class creates ESC command.
 *
 * @author Samuel Barolotti.
 */
public class ESC extends Command {


    @Override
    public boolean execute(String str, Player player, Room room) {
        if (str.equals("esc")) {
            player.setInMenu(true);
            super.println(GameData.getText().getFirst());

                while (true) {
                    String s = super.scanLine();
                    s = s.trim();
                    if (s.equalsIgnoreCase("esc")) {
                        player.setInMenu(false);
                        break;
                    } else {
                        super.println("To close this menu type esc.");
                    }
                }
            return true;
        }
        return false;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
