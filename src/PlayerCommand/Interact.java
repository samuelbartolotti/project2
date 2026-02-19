package PlayerCommand;

import Items.Consumables;
import Items.Weapons;
import Player.Player;
import Rooms.Room;
import Rooms.SpawnType;

public class Interact extends Command {

    @Override
    public void execute(String str, Player player, Room room) {
        if (str.equals("e")) {
            Object o = room.getDisplay()[player.facingX()][player.facingY()];
            int x = player.facingX();
            int y = player.facingY();
            if(o != null) {

                if(o instanceof Weapons && player.isSlotEmpty()) {
                    player.getInv().addtoInventory((Weapons) o);

                } else if(o.equals("ch")) {
                    SpawnType type = SpawnType.values()[rnd(0, 1)];
                    room.getDisplay()[x][y] = room.chooseItem(type);

                } else if(o instanceof Consumables) {
                    ((Consumables) o).useConsumable(player);

                } else if(o.equals("o")) {

                }
            }
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
