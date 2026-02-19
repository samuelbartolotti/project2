package PlayerCommand;

import Items.Consumables;
import Items.Weapons;
import Player.Player;
import Rooms.Room;
import Rooms.Shop;
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

                } else if(o.equals("o") && room instanceof Shop) {
                    boolean inMenu = true;
                    while(inMenu) {
                        String s = super.scanLine();
                        int choice = Integer.parseInt(s);
                        if(s.equals("esc")){
                            inMenu = false;
                        } else if (choice >= 1 && choice <= 3) {
                            Shop shop = (Shop) room;
                            shop.buy(shop.choose(choice), player);
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
