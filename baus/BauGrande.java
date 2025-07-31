package baus;

import itens.base.Item;
import itens.consumiveis.comidas.FrutaMagica;
import itens.consumiveis.pocoes.PocaoGuerreiro;
import itens.consumiveis.pocoes.PocaoVidaGrande;

public class BauGrande extends Bau{

    public BauGrande(){
        super("Bau Grande");
    }
    
    public Item[] abrir(){
        return new Item[] {
            new PocaoVidaGrande(),
            new PocaoVidaGrande(),
            new PocaoGuerreiro(),
            new FrutaMagica()
        };
    };
}
