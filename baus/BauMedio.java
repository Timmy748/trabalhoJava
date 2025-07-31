package baus;

import itens.base.Item;
import itens.consumiveis.pocoes.PocaoForca;
import itens.consumiveis.pocoes.PocaoGuerreiro;
import itens.consumiveis.pocoes.PocaoResistencia;
import itens.consumiveis.pocoes.PocaoVidaGrande;


public class BauMedio extends Bau{

    public BauMedio(){
        super("Bau Medio");
    }
    
    public Item[] abrir(){
        return new Item[] {
            new PocaoVidaGrande(),
            new PocaoForca(),
            new PocaoGuerreiro(),
            new PocaoResistencia()
        };
    };
}
