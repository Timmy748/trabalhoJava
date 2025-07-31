package itens.armaduras;
import itens.base.ItemEquipavel;
import itens.base.SlotType;

public class CamisaElfos extends ItemEquipavel {
    public CamisaElfos() {
        super("Camisa dos Elfos", 
              "Veste élfica que aumenta agilidade e defesa.", 
              SlotType.ARMOR, 20, 20, 90);
    }
}
