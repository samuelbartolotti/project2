package Items;

import Player.Player;

public enum Effect {
    HEAL {
        @Override
        public void apply(Player player, double rarityEffect) {
            player.addHp((int) rarityEffect*1000);
        }
    },
    ADDMAXHEALTH {
        @Override
        public void apply(Player player, double rarityEffect) {
            player.addMaxHp((int) rarityEffect*100);
        }
    },
    DEFENCE {
        @Override
        public void apply(Player player, double rarityEffect) {
            player.addDefence(rarityEffect);
        }
    },
    ATTACK {
        @Override
        public void apply(Player player, double rarityEffect) {
            player.addAttack(rarityEffect);
        }
    };

    public abstract void apply(Player player, double rarityEffect);
}
