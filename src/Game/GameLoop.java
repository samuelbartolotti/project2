package Game;

import Interface.ConsoleUI;
import Player.Player;
import Map.Map;
import PlayerCommand.*;
import Rooms.*;

public class GameLoop extends ConsoleUI {
    private Player player = new Player();
    private final int numberOfLevels = 10;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getNumberOfLevels() {
        return numberOfLevels;
    }

    GameData data = GameData.loadGameDataFromResources("/gamedata.json");

    public void start() {
        super.println(GameData.getText().get(1));

        Command[] commands = {
                new Attack(),
                new ChangeSlot(),
                new DropItem(),
                new ESC(),
                new Interact(),
                new Move()
        };

        for(int i = 0; i < numberOfLevels; i++) {
            Map map = new Map();

            while(true) {
                Room room = map.getRoom(player.getCurrentRoom());
                room.setObj(player.getX(), player.getY(), player);
                super.println(room.displayRoom());
                String s = super.scanLine();

                for (Command command : commands) {
                    command.execute(s, player, room);
                }
            }
        }
    }
}
