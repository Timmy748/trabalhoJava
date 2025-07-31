package mobs.enimies;

import itens.acessorios.ColarVitalidade;
import itens.base.Item;
import mobs.Mob;

public class Morcego extends Mob {
    public Morcego(int level) {
        super("Morcego", level,
              25, 4,
              12, 3,
              3, 1);
    }
    @Override
    public int getExperienceReward() {
        return level * 60;
    }
    @Override
    public Item[] getDrops() {
        return new Item[] {
            new ColarVitalidade()
        };
    }
}