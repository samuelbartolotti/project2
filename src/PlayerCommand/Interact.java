package PlayerCommand;

import Exceptions.PlaceIsEmpty;
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
            if (o != null) {

                if (o instanceof Weapons && player.isSlotEmpty()) {
                    player.getInv().addtoInventory((Weapons) o);
                    room.setObj(x, y, null);

                } else if (o.equals("ch")) {
                    SpawnType type = SpawnType.values()[rnd(0, 1)];
                    room.setObj(x, y, room.chooseItem(type));

                } else if (o instanceof Consumables) {
                    ((Consumables) o).useConsumable(player);
                    room.setObj(x, y, null);

                } else if (room instanceof Shop && o.equals("O")) {
                    boolean inMenu = true;
                    super.println(((Shop) room).itemsToString() + "\n\n" + "Choose item by writing its number in list order, or close this menu by writing esc.");

                    while (inMenu) {
                        String s = super.scanLine();
                        int choice = Integer.parseInt(s);
                        if (s.equals("esc")) {
                            inMenu = false;
                        } else if (choice >= 1 && choice <= 3) {
                            Shop shop = (Shop) room;
                            shop.buy(shop.choose(choice), player);
                        }
                    }
                }
            } else {
                throw new PlaceIsEmpty("There is no action to be made. The place infront is empty.");
            }
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
