package mobs.enimies;

import itens.armaduras.ArmaduraDragao;
import itens.espadas.EspadaChamas;
import itens.base.Item;
import mobs.Mob;


public class Dragao extends Mob {
    public Dragao(int level) {
        super("Dragao", level,
              200, 20,
              30, 8,
              15, 4);
    }
    @Override
    public int getExperienceReward() {
        return level * 1000;
    }
    @Override
    public Item[] getDrops() {
        return new Item[] {
            new ArmaduraDragao(),
            new EspadaChamas()
        };
    }
}