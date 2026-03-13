package Items;
import Player.Player;

/**
 * This class creates consumable, which player can use.
 *
 * @author Samuel Bartolotti.
 */
public class Consumables extends Item {

    /**
     * This method generates effect of consumable.
     * @return is used for setting effect to consumable.
     */
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

    /**
     * This method generates rarity of consumable.
     * @return rarity to be assigned to consumable.
     */
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
        this.price = rarity.returnPrice();
    }

    /**
     * This method add effect of consumable to player.
     * @param player used to add effect.
     */
    public void useConsumable(Player player) {
        effect.apply(player, rarity.returnEffect());
        super.println("Added effect: " + effect.name());
    }

    @Override
    public String toString() {
        return rarity.colorize("C");
    }
}
