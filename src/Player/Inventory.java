package Player;

import Exceptions.EmptyInventoryException;
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

    public String displayInv(){
        if(inventory[0] == null){
            throw new EmptyInventoryException("inventory is empty");
        } else if(inventory[1] == null) {
            return inventory[0].wepStats().toString();
        } else {
            return inventory[0].wepStats().toString() + inventory[1].wepStats().toString();
        }
    }

    public int isInventoryFull(){
        for(int i = 0; i < inventory.length; i++){
            if(inventory[i] == null){
                return i;
            }
        }
        return -1;
    }

    public void addToInventory(Weapons wep, int currentInventory){
        if(this.isInvEmpty(currentInventory)){
            inventory[currentInventory-1] = wep;
        } else {
            throw new FullInventoryException("your inventory is full");
        }
    }
}
