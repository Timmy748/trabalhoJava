package itens.espadas;
import itens.base.ItemEquipavel;
import itens.base.SlotType;

public class EspadaFerro extends ItemEquipavel {
    public EspadaFerro() {
        super("Espada de Ferro", 
              "Espada forjada em ferro, confiável e resistente.", 
              SlotType.WEAPON, 20, 2, 60);
    }
}
