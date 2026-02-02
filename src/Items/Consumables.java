package Items;

import Player.Player;

public class Consumables {
    private Effect effect;
    private Rarity rarity;

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public Consumables(Effect effect, Rarity rarity) {
        this.effect = effect;
        this.rarity = rarity;
    }

    public void addEffect(Player player) {
        effect.apply(player, rarity.returnEffect());
    }
}
