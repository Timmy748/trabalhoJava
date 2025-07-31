package baus;

import itens.base.Item;
import itens.espadas.*;
import java.util.Random;


public class BauEspadas extends Bau{
    private Random random = new Random();
    private Item[] possibleLoots = {
        new EspadaEnferrujada(),
        new EspadaFerro(),
        new EspadaAco(),
        new EspadaChamas()
    };

    public BauEspadas(){
        super("Bau De Espadas");
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

