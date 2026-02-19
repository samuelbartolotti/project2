package Rooms;

import Exceptions.FullInventoryException;
import Exceptions.NotEnoughManyException;
import Game.GameData;
import Items.Consumables;
import Items.Item;
import Items.Weapons;
import Player.Player;
import Player.Inventory;

import java.util.ArrayList;

public class Shop extends Room {
    private final int numberOfItems = 3;
    private ArrayList<Weapons> weapons = new ArrayList<>();
    private ArrayList<Consumables> consumables = new ArrayList<>();

    public ArrayList<Weapons> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapons> weapons) {
        this.weapons = weapons;
    }

    public ArrayList<Consumables> getConsumables() {
        return consumables;
    }

    public void setConsumables(ArrayList<Consumables> consumables) {
        this.consumables = consumables;
    }

    public Shop() {
        this.width = 11;
        this.height = 11;
        this.display = new Object[width][height];
        this.display[6][6] = "O";
        chance = 10;

        generateItems();
    }

    public void generateItems() {
        for (int i = 0; i < numberOfItems; i++) {
            int chooseTypeOfWeapon = rnd(0, 1);

            if (chooseTypeOfWeapon == 1) {
                int chooseWeapon = rnd(0, GameData.getWepList().size() - 1);

                weapons.add(GameData.getWepList().get(chooseWeapon));
            } else {
                consumables.add(new Consumables());
            }
        }
    }

    public Object choose(int choice) {
        int current = 0;
        for (int i = 0; i < numberOfItems; i++) {
            if (current == choice && i < weapons.size()) {
                return weapons.get(current);
            } else if (current == choice) {
                return consumables.get(current - weapons.size());
            }
            current++;
        }
        return null;
    }

    public void buy(Object o, Player player) {
        if (o instanceof Weapons || o instanceof Consumables) {
            Inventory inv = player.getInv();
            int price = ((Item) o).getPrice();
            int place = inv.isInventoryFull();

            if (player.getPlayersGold() - price < 0) {
                throw new NotEnoughManyException("You don't have enough money, to buy this item");

            } else if (place != -1 && o instanceof Weapons) {
                inv.addToInventory((Weapons) o, place);

            } else if (place != -1) {
                ((Consumables) o).useConsumable(player);

            } else {
                throw new FullInventoryException("You don't have enough space in your inventory");
            }
        }
    }
}
