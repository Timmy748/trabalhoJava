package mobs.enimies;

import itens.base.Item;
import itens.espadas.EspadaEnferrujada;
import mobs.Mob;

public class Slime extends Mob {
    public Slime(int level) {
        super("Slime", level,
              20, 3,
              5, 1,
              2, 1);
    }
    @Override
    public int getExperienceReward() {
        return level * 90;
    }
    @Override
    public Item[] getDrops() {
        return new Item[] {
            new EspadaEnferrujada()
        };
    }
}