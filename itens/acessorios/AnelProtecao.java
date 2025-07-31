package itens.acessorios;
import itens.base.ItemEquipavel;
import itens.base.SlotType;

public class AnelProtecao extends ItemEquipavel {
    public AnelProtecao() {
        super("Anel de Proteção", 
              "Anel abençoado que oferece proteção extra.", 
              SlotType.ACCESSORY, 0, 8, 999);
    }
}
