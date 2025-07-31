package itens.consumiveis.comidas;
import itens.base.ItemConsumivel;

public class FrutaMagica extends ItemConsumivel {
    public FrutaMagica() {
        super("Fruta Mágica", 
              "Fruta especial que restaura 40 de vida e aumenta defesa em 5 por 3 turnos.", 
              40, 0, 5, 3);
    }
}