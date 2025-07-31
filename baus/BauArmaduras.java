package baus;

import itens.base.Item;
import itens.armaduras.*;
import java.util.Random;


public class BauArmaduras extends Bau{
    private Random random = new Random();
    private Item[] possibleLoots = {
        new ArmaduraCouro(),
        new ArmaduraFerro(),
        new ArmaduraAco(),
        new CamisaElfos()
    };

    public BauArmaduras(){
        super("Bau De Armaduras");
    }
    
    public Item[] abrir(){
        
        int position = 0;
        for(int i = 0; i < this.possibleLoots.length; i++){
            if(this.random.nextInt(100) >= 70) position++;
        }

        return new Item[] {
            this.possibleLoots[position]
        };
    };
}

