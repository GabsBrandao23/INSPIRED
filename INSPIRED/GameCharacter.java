
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

public class GameCharacter {

    private String name;
    private int health;

    private int starsPhysicalDamage;
    private int starsMagicDamage;
    private int starsPhysicalDefense;
    private int starsMagicDefense;

    private final Map<StatusEffect.Type, StatusEffect> statusEffects =
            new EnumMap<>(StatusEffect.Type.class);

    public GameCharacter(
            String name,
            int health,
            int starsPhysicalDamage,
            int starsMagicDamage,
            int starsPhysicalDefense,
            int starsMagicDefense) {

        this.name = name;
        this.health = health;

        this.starsPhysicalDamage = starsPhysicalDamage;
        this.starsMagicDamage = starsMagicDamage;
        this.starsPhysicalDefense = starsPhysicalDefense;
        this.starsMagicDefense = starsMagicDefense;
    }

    // Returns the character's name.
    public String getName() {
        return name;
    }

    // Returns the character's current health.
    public int getHealth() {
        return health;
    }

    // Returns the number of stars for each attribute.
    public int getStarsPhysicalDamage() {
        return starsPhysicalDamage;
    }

    public int getStarsMagicDamage() {
        return starsMagicDamage;
    }

    public int getStarsPhysicalDefense() {
        return starsPhysicalDefense;
    }

    public int getStarsMagicDefense() {
        return starsMagicDefense;
    }

    // Reduces health without allowing it to drop below zero.
    public void takeDamage(int damage) {
        if (damage <= 0) {
            return;
        }

        health = Math.max(0, health - damage);
    }

    // Restores health, if needed.
    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }

        health += amount;
    }

    // Returns whether the character is still alive.
    public boolean isAlive() {
        return health > 0;
    }

    // Applies a status effect. Reapplying the same effect
    // refreshes its duration instead of stacking it.
    public void applyStatusEffect(
            StatusEffect.Type type,
            int damagePerTurn,
            int duration) {

        if (type == null || damagePerTurn <= 0 || duration <= 0) {
            return;
        }

        statusEffects.put(
                type,
                new StatusEffect(type, damagePerTurn, duration)
        );
    }

    // Applies active status effects at the start of the character's turn.
    public void processStatusEffects() {

        Iterator<Map.Entry<StatusEffect.Type, StatusEffect>> iterator =
                statusEffects.entrySet().iterator();

        while (iterator.hasNext() && isAlive()) {

            StatusEffect effect = iterator.next().getValue();

            String effectName;

            switch (effect.getType()) {
                case BURN:
                    effectName = "Burn";
                    break;

                case BLEED:
                    effectName = "Bleed";
                    break;

                default:
                    effectName = "Unknown effect";
                    break;
            }

            TextUI.printSlow(
                    name + " suffers from " + effectName + "!"
            );

            takeDamage(effect.getDamagePerTurn());

            TextUI.printSlow(
                    effectName + " deals "
                    + effect.getDamagePerTurn()
                    + " damage to " + name + "."
            );

            TextUI.printSlow(
                    name + "'s remaining HP: " + health
            );

            effect.decreaseDuration();

            if (effect.getRemainingTurns() <= 0) {
                iterator.remove();

                TextUI.printSlow(
                        effectName + " has worn off."
                );
            }

            TextUI.pause(400);
        }
    }
}
