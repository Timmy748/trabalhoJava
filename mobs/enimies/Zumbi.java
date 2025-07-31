package mobs.enimies;

import itens.base.Item;
import itens.consumiveis.comidas.CarneSeca;
import mobs.Mob;

public class Zumbi extends Mob {
    public Zumbi(int level) {
        super("Zumbi", level,
              50, 7,
              11, 3,
              7, 2);
    }
    @Override
    public int getExperienceReward() {
        return level * 90;
    }
    @Override
    public Item[] getDrops() {
        return new Item[] {
            new CarneSeca(),
            new CarneSeca(),
            new CarneSeca(),
            new CarneSeca()
        };
    }
}