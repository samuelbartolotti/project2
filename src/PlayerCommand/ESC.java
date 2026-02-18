package PlayerCommand;

import Game.GameData;
import Player.Player;
import Rooms.Room;

public class ESC extends Command {
    private boolean inMenu;

    public boolean isInMenu() {
        return inMenu;
    }

    public void setInMenu(boolean inMenu) {
        this.inMenu = inMenu;
    }



    @Override
    public void execute(String str, Player player, Room room) {
        if (str.equals("esc")){
            if(inMenu){

            } else {
                inMenu = true;
                super.println(GameData.getHelp());
            }
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
