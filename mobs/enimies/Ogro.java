package mobs.enimies;

import itens.armaduras.ArmaduraCouro;
import itens.base.Item;
import itens.espadas.EspadaFerro;
import mobs.Mob;

public class Ogro extends Mob {
    public Ogro(int level) {
        super("Ogro", level,
              120, 15,
              22, 6,
              12, 3);
    }
    @Override
    public int getExperienceReward() {
        return level * 500;
    }
    @Override
    public Item[] getDrops() {
        return new Item[] {
            new ArmaduraCouro(),
            new EspadaFerro()
        };
    }
}