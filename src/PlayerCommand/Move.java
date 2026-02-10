package PlayerCommand;

import Items.Effect;
import Player.Player;
import Rooms.Room;

public class Move extends Command {

    @Override
    public void execute(String str, Player player, Room room) {
        if (str.equals("w") || str.equals("s") || str.equals("a") || str.equals("d")) {
//            return switch (str) {
//                case "w" -> if(room.isPlaceEmpty(player.getX(), player.getY(), room) == true){};
//                case "s" -> ;
//                case "a" -> ;
//                case "d" -> ;
//                default -> null;
//            };
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
