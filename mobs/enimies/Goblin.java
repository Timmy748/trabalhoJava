package mobs.enimies;

import itens.base.Item;
import mobs.Mob;
import itens.consumiveis.comidas.Pao;


public class Goblin extends Mob {
    public Goblin(int level) {
        super("Goblin", level,
              30, 5,      
              8, 2,       
              4, 1);      
    }
    @Override
    public int getExperienceReward() {
        return level * 100;
    }
    @Override
    public Item[] getDrops() {
        return new Item[] {
            new Pao(),
            new Pao()
        };
    }
}