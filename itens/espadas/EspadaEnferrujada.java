package itens.espadas;
import itens.base.ItemEquipavel;
import itens.base.SlotType;

public class EspadaEnferrujada extends ItemEquipavel{
    public EspadaEnferrujada() {
        super("Espada Enferrujada", 
              "Uma velha espada enferrujada, mas ainda funcional.", 
              SlotType.WEAPON, 10, 0, 30);
    }
}
