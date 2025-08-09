package itens.consumiveis.comidas;
import itens.base.ItemConsumivel;

public class Pao extends ItemConsumivel {
    public Pao() {
        super("Pao", 
              "Um pao simples que restaura 15 pontos de vida.", 
              15);
    }
}
