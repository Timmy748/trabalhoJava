package baus;

import itens.base.Item;
import itens.consumiveis.pocoes.PocaoVidaMedia;

public class BauPequenho extends Bau{

    public BauPequenho(){
        super("Bau Pequenho");
    }
    
    public Item[] abrir(){
        return new Item[] {
            new PocaoVidaMedia(),
            new PocaoVidaMedia()
        };
    };
}
