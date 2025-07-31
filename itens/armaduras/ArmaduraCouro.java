package itens.armaduras;
import itens.base.ItemEquipavel;
import itens.base.SlotType;

public class ArmaduraCouro extends ItemEquipavel {
    public ArmaduraCouro() {
        super("Armadura de Couro", 
              "Proteção básica feita de couro resistente.", 
              SlotType.ARMOR, 0, 18, 50);
    }
}
