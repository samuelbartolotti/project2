package Game;

import Characters.Boss;
import Characters.Enemy;
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
 * @author Samuel Bartolotti.
 */
public class GameData {

    private ArrayList<Weapons> weapons;
    private ArrayList<Boss> bosses;
    private ArrayList<Enemy> enemies;
    private ArrayList<String> textLoad;

    private static ArrayList<Weapons> wepList;
    private static ArrayList<Boss> bossList;
    private static ArrayList<Enemy> eneList;
    private static ArrayList<String> text;

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

    public ArrayList<String> getTextLoad() {
        return textLoad;
    }

    public void setTextLoad(ArrayList<String> textLoad) {
        this.textLoad = textLoad;
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

    public static ArrayList<String> getText() {
        return text;
    }

    public static void setText(ArrayList<String> text) {
        GameData.text = text;
    }

    /**
     * Loads game data from a JSON file.
     * @param resourcePath path to the resource file
     * @return a game.GameData object filled with the loaded data
     */
    public static GameData loadGameDataFromResources(String resourcePath) {
        Gson gson = new Gson();

        try (InputStream is = GameData.class.getResourceAsStream(resourcePath)) {

            if (is == null) {
                throw new IllegalStateException("Nenalezen resource: " + resourcePath +
                        " (zkontrolujte, že soubor je v src/main/resources).");
            }

            GameData data = gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    GameData.class
            );

            wepList = data.getWeapons();
            bossList = data.getBosses();
            eneList = data.getEnemies();
            text = data.getTextLoad();

            return data;

        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }

    }
}
