package Game;

import Characters.Boss;
import Characters.Enemy;
import Items.Consumables;
import Items.Weapons;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Represents the game data loaded from a JSON file.
 * This class serves as a data container for all static game content, such as items, characters, locations, and quests.
 *
 */
public class GameData {

    private ArrayList<Weapons> weapons;
    private ArrayList<Boss> bosses;
    private ArrayList<Enemy> enemies;
    private String helpLoad;

    private static ArrayList<Weapons> wepList;
    private static ArrayList<Boss> bossList;
    private static ArrayList<Enemy> eneList;
    private static String help;

    public ArrayList<Weapons> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapons> weapons) {
        this.weapons = weapons;
    }

    public ArrayList<Boss> getBosses() {
        return bosses;
    }

    public void setBosses(ArrayList<Boss> bosses) {
        this.bosses = bosses;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

    public String getHelpLoad() {
        return helpLoad;
    }

    public void setHelpLoad(String helpLoad) {
        this.helpLoad = helpLoad;
    }

    public static ArrayList<Weapons> getWepList() {
        return wepList;
    }

    public static void setWepList(ArrayList<Weapons> wepList) {
        GameData.wepList = wepList;
    }

    public static ArrayList<Boss> getBossList() {
        return bossList;
    }

    public static void setBossList(ArrayList<Boss> bossList) {
        GameData.bossList = bossList;
    }

    public static ArrayList<Enemy> getEneList() {
        return eneList;
    }

    public static void setEneList(ArrayList<Enemy> eneList) {
        GameData.eneList = eneList;
    }

    public static String getHelp() {
        return help;
    }

    public static void setHelp(String help) {
        GameData.help = help;
    }

    /**
     * Loads game data from a JSON file.
     * @param resourcePath path to the resource file
     * @return a game.GameData object filled with the loaded data
     */
    public static GameData loadGameDataFromResources(String resourcePath) {
        //Vytvoření objektu pro práci s JSON souborem
        Gson gson = new Gson();

        //Načtení souboru gamedata.json, musí být ve složce res/resources, ta musí být označena jako resource složka projektu
        try (InputStream is = GameData.class.getResourceAsStream(resourcePath)) {

            //Zde ověřujeme, zdali soubor existuje
            if (is == null) {
                throw new IllegalStateException("Nenalezen resource: " + resourcePath +
                        " (zkontrolujte, že soubor je v src/main/resources).");
            }

            //Přečte celý JSON a vytvoří instanci game.GameData, naplní vlastnosti podle názvů klíčů v JSONU, vrátí se hotová třída game.GameData
            GameData data = gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    GameData.class
            );

            //  PŘIDÁNO – přehrání do statických listů
            wepList = data.getWeapons();
            bossList = data.getBosses();
            eneList = data.getEnemies();
            help = data.getHelpLoad();

            return data;

        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }

    }


//    public Location findLocation(String id) {
//        for (Location l : locations) {
//            if (l.getId().equals(id)){
//                return l;
//            }
//        }
//        throw new IllegalArgumentException("Neexistuje lokace s id: " + id);
//    }


}
