package baus;

import itens.base.Item;
import itens.acessorios.*;
import java.util.Random;


public class BauAcessorios extends Bau{
    private Random random = new Random();
    private Item[] possibleLoots = {
        new AnelForca(),
        new AnelProtecao(),
        new ColarVitalidade(),
        new AmuletoAnciao()
    };

    public BauAcessorios(){
        super("Bau De Acessorios");
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

