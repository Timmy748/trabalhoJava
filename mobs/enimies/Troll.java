package mobs.enimies;

import itens.base.Item;
import mobs.Mob;
import itens.consumiveis.pocoes.PocaoGuerreiro;
import itens.espadas.EspadaFerro;

public class Troll extends Mob {
    public Troll(int level) {
        super("Troll", level,
              100, 12,
              18, 5,
              10, 3);
    }
    @Override
    public int getExperienceReward() {
        return level * 600;
    }
    @Override
    public Item[] getDrops() {
        return new Item[] {
            new PocaoGuerreiro(),
            new EspadaFerro()
        };
    }
}