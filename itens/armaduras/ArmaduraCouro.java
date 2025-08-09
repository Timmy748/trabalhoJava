package itens.armaduras;
import itens.base.ItemEquipavel;
import itens.base.SlotType;

public class ArmaduraCouro extends ItemEquipavel {
    public ArmaduraCouro() {
        super("Armadura de Couro", 
              "Proteçao básica feita de couro resistente.", 
              SlotType.ARMOR, 0, 18, 50);
    }
}
