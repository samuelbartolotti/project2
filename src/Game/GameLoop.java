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
        player.getInv().addToInventory(GameData.getWepList().getFirst(), 1);

        Command[] commands = {
                new Attack(),
                new ChangeSlot(),
                new DropItem(),
                new ESC(),
                new Interact(),
                new Move()
        };

        for(int i = 0; i < numberOfLevels; i++) {
            if(player.isDead()){
                super.println("You are dead");
                return;
            }

            Map map = new Map();
            map.setPlayer(player);
            player.setMap(map);

            while(true) {
                if(player.isDead()){
                    return;
                }

                Room room = map.getRoom(player.getCurrentRoom());
                super.println(room.displayRoom());
                super.println(player.displayStats());
                String s = super.scanLine();

                try {
                    for (Command command : commands) {
                        command.execute(s, player, room);
                    }
                } catch (Exception e) {
                    super.println(e.getMessage());
                }

                player.setInFight(room.isInFight());

                if(player.isInFight() && !player.isInMenu()) {
                    room.fight(player);
                }
            }
        }
    }
}
