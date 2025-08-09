package player;

import itens.base.ItemEquipavel;

public class EquipmentManager {
    private final Inventory inventory;
    private ItemEquipavel weaponSlot;
    private ItemEquipavel armorSlot;
    private ItemEquipavel accessorySlot;

    public EquipmentManager(Inventory inventory) {
        this.inventory = inventory;
    }

    public void equipWeapon(ItemEquipavel weapon) {
        this.unequipWeapon();
        this.weaponSlot = weapon;
        System.out.println("Arma equipada: " + weapon.getName());
    }

    public void unequipWeapon() {
        if (weaponSlot != null) {
            inventory.add(weaponSlot);
            weaponSlot = null;
        }
    }

    public void equipArmor(ItemEquipavel armor) {
        this.unequipArmor();
        this.armorSlot = armor;
        System.out.println("Armadura equipada: " + armor.getName());
    }

    public void unequipArmor() {
        if (armorSlot != null) {
            inventory.add(armorSlot);
            armorSlot = null;
        }
    }

    public void equipAccessory(ItemEquipavel accessory) {
        this.unequipAccessory();
        this.accessorySlot = accessory;
        System.out.println("Acessório equipado: " + accessory.getName());
    }

    public void unequipAccessory() {
        if (accessorySlot != null) {
            inventory.add(accessorySlot);
            accessorySlot = null;
        }
    }

    public ItemEquipavel getWeapon() { return weaponSlot; }
    public ItemEquipavel getArmor()  { return armorSlot; }
    public ItemEquipavel getAccessory() { return accessorySlot; }
}
