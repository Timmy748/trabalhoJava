package itens.consumiveis.pocoes;
import itens.base.ItemConsumivel;

public class PocaoForca extends ItemConsumivel {
    public PocaoForca() {
        super("Poção de Força", 
              "Aumenta o ataque em 10 por 5 turnos.", 
              0, 10, 0, 5);
    }
}
