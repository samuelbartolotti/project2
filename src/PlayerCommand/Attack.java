package PlayerCommand;

import Exceptions.NoneEnemyInFrontOfYou;
import Exceptions.NoneWeaponInYourSlot;
import Items.Weapons;
import Player.Player;
import Rooms.Room;
import Characters.Enemies;

public class Attack extends Command {

    @Override
    public void execute(String str, Player player, Room room) {
        if(str.equals("f")){
            Object o = room.getObj(player.getX(), player.getY());
            Object wep = player.getInv().getItem(player.getCurrentSlot());
            if(o instanceof Enemies enemy && wep instanceof Weapons weapon){
                enemy.giveDamage(weapon.getDamage());
            } else if (wep instanceof Weapons){
                throw new NoneEnemyInFrontOfYou("You are not facing enemy");
            } else {
                throw new NoneWeaponInYourSlot("Your current slot does not contain weapon");
            }
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
