package mobs.enimies;

import itens.base.Item;
import itens.consumiveis.pocoes.PocaoVidaPequena;
import mobs.Mob;

public class Aranha extends Mob {
    public Aranha(int level) {
        super("Aranha", level,
              35, 5,
              16, 4,
              5, 2);
    }
    @Override
    public int getExperienceReward() {
        return level * 20;
    }
    @Override
    public Item[] getDrops() {
        return new Item[] {
            new PocaoVidaPequena()
        };
    }
}