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

        for (int i = 0; i < numberOfLevels; i++) {
            Map map = new Map();
            map.setPlayer(player);
            player.setMap(map);

            while (true) {
                boolean didCommandRun = false;

                if (player.isDead()) {
                    super.closeSc();
                    super.println("\u001B[31m\n\n\n\n\n\n\n                 You died");
                    return;
                }

                Room room = map.getRoom(player.getCurrentRoom());
                super.println(room.displayRoom());
                super.println(player.displayStats());
                super.print(">");
                String s = super.scanLine();
                s = s.trim();

                player.setInFight(room.isInFight());

                super.println("======================================================================================================================================================================================================");

                try {
                    for (Command command : commands) {
                        if (command.execute(s, player, room)) {
                            didCommandRun = true;
                            break;
                        }
                    }
                } catch (Exception e) {
                    super.println(e.getMessage());
                }

                if (player.isInFight()&& didCommandRun) {
                    room.fight(player);
                } else if (!didCommandRun) {
                    super.println("Wrong input.");
                }

                if (room instanceof BossFight && room.getEnemies().isEmpty()) {
                    super.println("You concured the boss. Next level is awaiting you.");
                    break;
                }
            }
        }
    }
}
