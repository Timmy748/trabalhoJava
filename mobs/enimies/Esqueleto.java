package mobs.enimies;

import itens.base.Item;
import mobs.Mob;
import itens.consumiveis.pocoes.PocaoResistencia;


public class Esqueleto extends Mob {
    public Esqueleto(int level) {
        super("Esqueleto", level,
              40, 6,
              10, 3,
              6, 2);
    }
    @Override
    public int getExperienceReward() {
        return level * 70;
    }
    @Override
    public Item[] getDrops() {
        return new Item[] {
            new PocaoResistencia()
        };
    }
}
