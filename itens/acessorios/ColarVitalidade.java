package itens.acessorios;
import itens.base.ItemEquipavel;
import itens.base.SlotType;

public class ColarVitalidade extends ItemEquipavel {
    public ColarVitalidade() {
        super("Colar da Vitalidade", 
              "Amuleto que fortalece corpo e mente.", 
              SlotType.ACCESSORY, 5, 5, 150);
    }
}
