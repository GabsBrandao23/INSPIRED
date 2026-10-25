
public class StatusEffect {

    public enum Type {
        BURN,
        BLEED
    }

    private final Type type;
    private final int damagePerTurn;
    private int remainingTurns;

    public StatusEffect(
            Type type,
            int damagePerTurn,
            int duration) {

        this.type = type;
        this.damagePerTurn = damagePerTurn;
        this.remainingTurns = duration;
    }

    public Type getType() {
        return type;
    }

    public int getDamagePerTurn() {
        return damagePerTurn;
    }

    public int getRemainingTurns() {
        return remainingTurns;
    }

    // Reduces the effect's remaining duration by one turn.
    public void decreaseDuration() {
        if (remainingTurns > 0) {
            remainingTurns--;
        }
    }

    // Returns whether the effect has expired.
    public boolean isExpired() {
        return remainingTurns <= 0;
    }
}
