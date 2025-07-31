package itens.espadas;
import itens.base.ItemEquipavel;
import itens.base.SlotType;

public class EspadaAco extends ItemEquipavel {
    public EspadaAco() {
        super("Espada de Aço", 
              "Lâmina afiada de aço temperado.", 
              SlotType.WEAPON, 35, 3, 100);
    }
}
