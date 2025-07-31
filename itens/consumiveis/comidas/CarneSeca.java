package itens.consumiveis.comidas;
import itens.base.ItemConsumivel;

public class CarneSeca extends ItemConsumivel {
    public CarneSeca() {
        super("Carne Seca", 
              "Carne nutritiva que restaura 30 de vida e dá +3 de ataque por 2 turnos.", 
              30, 3, 0, 2);
    }
}