package Items;

import Interface.RandomGenerator;
import Player.Player;

public class Consumables extends RandomGenerator {
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

    public Effect generateEffect() {
        int eff = rnd(0, 3);

        return switch (eff) {
            case 0 -> Effect.HEAL;
            case 1 -> Effect.ADDMAXHEALTH;
            case 2 -> Effect.DEFENCE;
            case 3 -> Effect.ATTACK;
            default -> null;
        };
    }

    public Rarity generateRarity() {
        int r = rnd(0, 3);
        return switch (r) {
            case 0 -> Rarity.COMMON;
            case 1 -> Rarity.RARE;
            case 2 -> Rarity.EPIC;
            case 3 -> Rarity.LEGENDARY;
            default -> null;
        };
    }

    public Consumables() {
        this.effect = generateEffect();
        this.rarity = generateRarity();
    }

    public void addEffect(Player player) {
        effect.apply(player, rarity.returnEffect());
    }

    @Override
    public String toString() {
        return rarity.colorize("C");
    }
}
