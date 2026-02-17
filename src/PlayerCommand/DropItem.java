package PlayerCommand;

import Exceptions.EmptyInventorySlot;
import Exceptions.PlaceInFrontOfYouIsOccupied;
import Player.Player;
import Rooms.Room;

public class DropItem extends Command {

    @Override
    public void execute(String str, Player player, Room room) {
        if (str.equals("q")) {
            Object o = room.getObj(player.facingX(), player.facingY());
            Object item = player.getInv().getItem(player.getCurrentSlot());
            if (o == null && item != null) {
                room.setObj(player.facingX(), player.facingY(), item);
            }  else if (item == null){
                throw new EmptyInventorySlot("You dont have any item in your current slot");
            } else {
                throw new PlaceInFrontOfYouIsOccupied("You are currently facing an occupied square");
            }
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
