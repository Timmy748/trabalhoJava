package mobs;

import java.util.Random;
import base.Character;
import itens.base.Item;


public abstract class Mob extends Character {
    protected final int level;
    private final Random random = new Random();

    protected Mob(String name, int level,
                  int baseLife, int lifePerLevel,
                  int baseAttack, int atkPerLevel,
                  int baseDefense, int defPerLevel) {
        super(name,
              calculateLife(level, baseLife, lifePerLevel),
              calculateAttack(level, baseAttack, atkPerLevel),
              calculateDefense(level, baseDefense, defPerLevel));
        this.level = level;
    }

    private static int calculateLife(int level, int baseLife, int lifePerLevel) {
        return baseLife + (level - 1) * lifePerLevel;
    }

    private static int calculateAttack(int level, int baseAttack, int atkPerLevel) {
        return baseAttack + (level - 1) * atkPerLevel;
    }

    private static int calculateDefense(int level,int baseDefense,int defPerLevel) {
        return baseDefense + (level - 1) * defPerLevel;
    }


    @Override
    public int calculateAttack() {
        int atk = this.attack;
        boolean isCrit = random.nextInt(10) >= 8;
        return isCrit ? atk * 2 : atk;
    }


    @Override
    public void receiveDamage(int damage) {
        int dmg = Math.max(damage - this.defense / 2, 0);
        this.currentLife -= dmg;
        if (this.currentLife < 0) this.currentLife = 0;
    }

    public void showStats() {
        System.out.printf(
            """
            === STATUS DO MOB ===
            Nome: %s (Nível %d)%n
            Vida: %d / %d%n
            Ataque: %d%n
            Defesa: %d%n
            =====================%n
            """,
            name, level,
            currentLife, life,
            attack,
            defense
        );
    }


    public abstract int getExperienceReward();

    public abstract Item[] getDrops();


    public int getLevel() {
        return level;
    }
}
