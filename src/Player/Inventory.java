package Player;

import Exceptions.EmptyInventoryException;
import Exceptions.FullInventoryException;
import Items.Weapons;

/**
 * This class creates inventory for player.
 *
 * @author Samuel Bartolotti.
 */
public class Inventory {
    private final int inventorySize = 2;
    private Weapons[] inventory;

    public Object[] getIventory() {
        return inventory;
    }

    public void setIventory(Weapons[] iventory) {
        this.inventory = iventory;
    }

    public boolean isInvEmpty(int i) {
        return this.inventory[i-1] == null;
    }

    public Inventory(){
        this.inventory = new Weapons[inventorySize];
    }

    public Object getItem(int i){
        return inventory[i-1];
    }

    public void removeItem(int i){
        inventory[i-1] = null;
    }

    /**
     * Displays weapons in inventory.
     * @return returns String of weapons.
     */
    public String displayInv(){
        if(inventory[0] == null){
            throw new EmptyInventoryException("inventory is empty");
        } else if(inventory[1] == null) {
            return inventory[0].wepStats().toString();
        } else {
            return inventory[0].wepStats().toString() + inventory[1].wepStats().toString();
        }
    }

    /**
     * Adds weapon to inventory.
     * @param wep weapon to add.
     * @param currentInventory current slot player has equipped.
     */
    public void addToInventory(Weapons wep, int currentInventory){
        if(this.isInvEmpty(currentInventory)){
            inventory[currentInventory-1] = wep;
        } else {
            throw new FullInventoryException("your inventory is full");
        }
    }
}
