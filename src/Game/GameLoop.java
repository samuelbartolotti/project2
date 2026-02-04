package Game;
import Player.Player;

public class GameLoop {
    private static GameData world;
    private Player player;

    public static void inicialization(){
        world = GameData.loadGameDataFromResources("/gamedata.json");
    }

    public static void start(){
        inicialization();
        //zde bude herni smycka
    }
}
