package Rooms;

import Exceptions.FullInventoryException;
import Exceptions.NotEnoughManyException;
import Game.GameData;
import Interface.UI;
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
    private ArrayList<Item> items = new ArrayList<>();

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

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String itemsToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Items:\n");
        for (Item item : items) {
            if(item instanceof Weapons) {
                sb.append(item.getRarity().colorize(item.getName())).append("\n");
            } else {
                sb.append(item.getRarity().colorize(item.getEffect().toString())).append("\n");
            }
        }
        return sb.toString();
    }

    public Shop() {
        this.width = 11;
        this.height = 11;
        this.display = new Object[width][height];
        this.display[width/2][height/2] = "S";
        chance = 10;

        generateItems();
        generateChances();
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

        items.addAll(weapons);
        items.addAll(consumables);
    }

    public Object choose(int choice) {
        return items.get(choice-1);
    }

    public void buy(Object o, Player player) {
        if (o instanceof Weapons || o instanceof Consumables) {
            Inventory inv = player.getInv();
            int price = ((Item) o).getPrice();
            int current = player.getCurrentSlot();
            boolean place = inv.isInvEmpty(current);

            if (player.getPlayersGold() - price < 0) {
                throw new NotEnoughManyException("You don't have enough money, to buy this item");

            } else if (place && o instanceof Weapons) {
                inv.addToInventory((Weapons) o, current);
                player.subtractGold(((Weapons) o).getPrice());

            } else if (o instanceof Consumables) {
                ((Consumables) o).useConsumable(player);
                player.subtractGold(((Consumables) o).getPrice());

            } else {
                throw new FullInventoryException("You don't have enough space in your inventory");
            }
        }
    }
}
