package Items;

import Player.Player;

/**
 * This class is used to create effects for consumables.
 *
 * @author Samuel Bartolotti.
 */
public enum Effect {
    HEAL {
        @Override
        public void apply(Player player, double rarityEffect) {
            player.addHp((int) (rarityEffect*1000));
        }
    },
    ADDMAXHEALTH {
        @Override
        public void apply(Player player, double rarityEffect) {
            player.addMaxHp((int) (rarityEffect * 100));
        }
    },
    DEFENCE {
        @Override
        public void apply(Player player, double rarityEffect) {
            player.addDefence(rarityEffect*10);
        }
    },
    ATTACK {
        @Override
        public void apply(Player player, double rarityEffect) {
            player.addAttack(rarityEffect*10);
        }
    };

    public abstract void apply(Player player, double rarityEffect);
}
