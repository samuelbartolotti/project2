package Rooms;

import Game.GameData;
import Items.Consumables;
import Items.Weapons;

import java.util.ArrayList;

public class Shop extends Room {
    private final int numberOfItems = 3;
    private ArrayList<Weapons> weapons;
    private ArrayList<Consumables> consumables;

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
        this.display = new String[width][height];
        this.display[6][6] = "O";
        chance = 10;

        generateItems();
    }

    public void generateItems() {
        for (int i = 0; i < numberOfItems; i++) {
            int chooseTypeOfWeapon = rnd(0, 1);

            if (chooseTypeOfWeapon == 1) {
                int chooseWeapon = rnd(0, GameData.getWeapons().size());

                   weapons.add(GameData.getWeapons().get(chooseWeapon));
            } else {
                consumables.add(new Consumables());
            }
        }
    }
}
