package itens.acessorios;
import itens.base.ItemEquipavel;
import itens.base.SlotType;

public class AnelProtecao extends ItemEquipavel {
    public AnelProtecao() {
        super("Anel de Proteçao", 
              "Anel abençoado que oferece proteçao extra.", 
              SlotType.ACCESSORY, 0, 8, 999);
    }
}
