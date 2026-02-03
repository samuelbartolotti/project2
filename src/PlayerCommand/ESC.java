package PlayerCommand;

import Player.Player;

public class ESC extends Command {
    private boolean inMenu;

    public boolean isInMenu() {
        return inMenu;
    }

    public void setInMenu(boolean inMenu) {
        this.inMenu = inMenu;
    }

    @Override
    public void execute(String str, Player player) {
        if (str.equals("esc")){

        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
