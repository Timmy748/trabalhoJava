package itens.acessorios;
import itens.base.ItemEquipavel;
import itens.base.SlotType;

public class AmuletoAnciao extends ItemEquipavel {
    public AmuletoAnciao() {
        super("Amuleto do Ancião", 
              "Relíquia antiga com poderes misteriosos.", 
              SlotType.ACCESSORY, 12, 12, 250);
    }
}
