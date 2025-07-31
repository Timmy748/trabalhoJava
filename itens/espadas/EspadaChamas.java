package itens.espadas;
import itens.base.ItemEquipavel;
import itens.base.SlotType;

public class EspadaChamas extends ItemEquipavel {
    public EspadaChamas() {
        super("Espada das Chamas", 
              "Espada mágica que arde em chamas eternas.", 
              SlotType.WEAPON, 80, 25, 120);
    }
}
