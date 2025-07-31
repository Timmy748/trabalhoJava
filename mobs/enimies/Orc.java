package mobs.enimies;

import itens.base.Item;
import mobs.Mob;
import itens.consumiveis.comidas.CarneSeca;

public class Orc extends Mob {
    public Orc(int level) {
        super("Orc", level,
              60, 8,
              14, 4,
              8, 2);
    }
    @Override
    public int getExperienceReward() {
        return level * 350;
    }
    @Override
    public Item[] getDrops() {
        return new Item[] {
            new CarneSeca(),
        };
    }
}