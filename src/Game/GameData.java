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

    private static ArrayList<Weapons> weapons;
    private static ArrayList<Boss> bosses;
    private static ArrayList<Enemy> enemies;

    public static ArrayList<Weapons> getWeapons() {
        return weapons;
    }

    public static void setWeapons(ArrayList<Weapons> weapons) {
        GameData.weapons = weapons;
    }

    public static ArrayList<Boss> getBosses() {
        return bosses;
    }

    public static void setBosses(ArrayList<Boss> bosses) {
        GameData.bosses = bosses;
    }

    public static ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public static void setEnemies(ArrayList<Enemy> enemies) {
        GameData.enemies = enemies;
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
            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    GameData.class
            );

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
