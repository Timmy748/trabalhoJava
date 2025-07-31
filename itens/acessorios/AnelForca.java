package itens.acessorios;
import itens.base.ItemEquipavel;
import itens.base.SlotType;

public class AnelForca extends ItemEquipavel {
    public AnelForca() {
        super("Anel da Força", 
              "Anel mágico que aumenta o poder de ataque.", 
              SlotType.ACCESSORY, 10, 0, 999);
    }
}
