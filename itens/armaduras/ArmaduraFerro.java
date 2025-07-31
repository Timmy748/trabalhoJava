package itens.armaduras;
import itens.base.ItemEquipavel;
import itens.base.SlotType;

public class ArmaduraFerro extends ItemEquipavel {
    public ArmaduraFerro() {
        super("Armadura de Ferro", 
              "Armadura sólida que oferece boa proteção.", 
              SlotType.ARMOR, 2, 30, 80);
    }
}
