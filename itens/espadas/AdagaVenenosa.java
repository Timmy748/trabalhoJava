package itens.espadas;
import itens.base.ItemEquipavel;
import itens.base.SlotType;

public class AdagaVenenosa extends ItemEquipavel {
    public AdagaVenenosa() {
        super("Adaga Venenosa", 
              "Adaga rápida com lâmina envenenada.", 
              SlotType.WEAPON, 40, 5, 40);
    }
}
