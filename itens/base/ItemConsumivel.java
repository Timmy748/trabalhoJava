package itens.base;

import player.Player;

public class ItemConsumivel extends Item {
    private final int healthRestore;
    private final int attackBoost;
    private final int defenseBoost;
    private final int boostDuration;

    public ItemConsumivel(String name, String description, int healthRestore) {
        this(name, description, healthRestore, 0, 0, 0);
    }

    public ItemConsumivel(String name, String description,
                          int healthRestore,
                          int attackBoost,
                          int defenseBoost,
                          int boostDuration) {
        super(name, description);
        this.healthRestore  = healthRestore;
        this.attackBoost    = attackBoost;
        this.defenseBoost   = defenseBoost;
        this.boostDuration  = boostDuration;
    }

    @Override
    public boolean usar(Player player) {
        System.out.printf("%s usou %s!%n", player.getName(), getName());
        boolean used = false;

        if (healthRestore > 0) {
            player.heal(healthRestore);
            System.out.printf("  +%d de vida aplicada.%n", healthRestore);
            used = true;
        }


        if ((attackBoost > 0 || defenseBoost > 0) && !player.isBuffed()) {
            player.applyBuff(attackBoost, defenseBoost, boostDuration);
            System.out.printf("  Buff: +%d Atk, +%d Def por %d turnos.%n",
                              attackBoost, defenseBoost, boostDuration);
            used = true;
        }

        if (used) {
            player.removeItem(this);
        } else {
            System.out.println("  Nada aconteceu.");
        }

        return used;
    }


    public int getHealthRestore() { return healthRestore; }
    public int getAttackBoost() { return attackBoost; }
    public int getDefenseBoost() { return defenseBoost; }
    public int getBoostDuration() { return boostDuration; }
}