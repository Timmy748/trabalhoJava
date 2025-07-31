package itens.espadas;
import itens.base.ItemEquipavel;
import itens.base.SlotType;

public class MachadoBatalha extends ItemEquipavel {
    public MachadoBatalha() {
        super("Machado de Batalha", 
              "Machado pesado que causa muito dano.", 
              SlotType.WEAPON, 90, 0, 80);
    }
}
