package itens.consumiveis.pocoes;
import itens.base.ItemConsumivel;

public class PocaoGuerreiro extends ItemConsumivel {
    public PocaoGuerreiro() {
        super("Poçao do Guerreiro", 
              "Aumenta ataque e defesa em 6 por 3 turnos.", 
              0, 6, 6, 3);
    }
}
