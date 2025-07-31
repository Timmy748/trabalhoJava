package itens.armaduras;
import itens.base.ItemEquipavel;
import itens.base.SlotType;

public class ArmaduraAco extends ItemEquipavel {
    public ArmaduraAco() {
        super("Armadura de Aço", 
              "Armadura pesada de aço forjado.", 
              SlotType.ARMOR, 0, 40, 120);
    }
}
