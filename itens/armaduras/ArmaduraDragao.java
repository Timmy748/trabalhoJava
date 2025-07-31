package itens.armaduras;
import itens.base.ItemEquipavel;
import itens.base.SlotType;

public class ArmaduraDragao extends ItemEquipavel {
    public ArmaduraDragao() {
        super("Armadura de Dragão", 
              "Armadura lendária feita com escamas de dragão.", 
              SlotType.ARMOR, 45, 100, 200);
    }
}
