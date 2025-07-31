package player;

public class BuffManager {
    private int attackBoost;
    private int defenseBoost;
    private int duration;  // em turnos

    public void apply(int attackBoost, int defenseBoost, int duration) {
        this.attackBoost = attackBoost;
        this.defenseBoost = defenseBoost;
        this.duration = duration;
        System.out.println("Buff aplicado: +" + attackBoost + " atk, +" +
                           defenseBoost + " def, duração " + duration + " turnos");
    }

    public int getAttackBoost() {
        return (duration > 0) ? attackBoost : 0;
    }

    public int getDefenseBoost() {
        return (duration > 0) ? defenseBoost : 0;
    }

    public boolean isActive() {
        return duration > 0;
    }

    public void tick() {
        if (duration > 0) duration--;
        if (duration == 0) reset();
    }

    private void reset() {
        attackBoost = 0;
        defenseBoost = 0;
        System.out.println("Buff expirou");
    }
}

