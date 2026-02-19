package Rooms;

import Game.GameData;
import Items.Consumables;
import Items.Weapons;

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
                int chooseWeapon = rnd(0, GameData.getWepList().size()-1);

                   weapons.add(GameData.getWepList().get(chooseWeapon));
            } else {
                consumables.add(new Consumables());
            }
        }
    }

    public Object buy(int choice){
        int current = 0;
        for (int i = 0; i < numberOfItems; i++) {
            if(current == choice && i < weapons.size()) {
                return weapons.get(current);
            } else if (current == choice) {
                return consumables.get(current-weapons.size());
            }
            current ++;
        }
        return null;
    }
}
