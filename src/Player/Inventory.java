package Player;

import Exceptions.FullInventoryException;
import Items.Weapons;

public class Inventory {
    private final int inventorySize = 2;
    private Weapons[] inventory;

    public Object[] getIventory() {
        return inventory;
    }

    public void setIventory(Weapons[] iventory) {
        this.inventory = iventory;
    }

    public Inventory(){
        this.inventory = new Weapons[inventorySize-1];
    }

    public Object getItem(int i){
        return inventory[i];
    }

    public String displayInv(){
        if(inventory[0] == null){
            return "inventory is empty";
        } else if(inventory[1] == null) {
            return inventory[0].wepStats().toString();

        } else {
            return inventory[0].wepStats().toString() + inventory[1].wepStats().toString();
        }
    }

    public void addtoInventory(Weapons wep){
        if(inventory[0] == null){
            inventory[0] = wep;
        } else if (inventory[1] == null) {
            inventory[1] = wep;
        } else {
            throw new FullInventoryException("your inventory is full");
        }
    }
}
