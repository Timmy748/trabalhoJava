package itens.base;
import player.Player;

public class ItemEquipavel extends Item {
    private final SlotType slotType;
    private final int attackBonus;
    private final int defenseBonus;
    private final int maxDurability;
    private int currentDurability;
    private boolean equipped;

    public ItemEquipavel(String name,
                         String description,
                         SlotType slotType,
                         int attackBonus,
                         int defenseBonus,
                         int durability) {
        super(name, description);
        this.slotType         = slotType;
        this.attackBonus      = attackBonus;
        this.defenseBonus     = defenseBonus;
        this.maxDurability    = durability;
        this.currentDurability= durability;
        this.equipped         = false;
    }

    @Override
    public boolean usar(Player player) {
        if (equipped) {
            return unequip(player);
        } else {
            return equip(player);
        }
    }

    private boolean equip(Player player) {
        if (isBroken()) {
            System.out.println(getName() + " está quebrado e nao pode ser equipado!");
            return false;
        }
        if (equipped) {
            System.out.println(getName() + " já está equipado!");
            return false;
        }
        switch (slotType) {
            case WEAPON:
                player.equipWeapon(this);
                break;
            case ARMOR:
                player.equipArmor(this);
                break;
            case ACCESSORY:
                player.equipAccessory(this);
                break;
        }
        equipped = true;
        System.out.printf("%s equipou %s! Bônus: +%d Atk, +%d Def%n",
                          player.getName(), getName(), attackBonus, defenseBonus);
        player.removeItem(this);
        return false;
    }

    private boolean unequip(Player player) {
        if (!equipped) {
            System.out.println(getName() + " nao está equipado!");
            return false;
        }

        switch (slotType) {
            case WEAPON:
                player.unequipWeapon();
                break;
            case ARMOR:
                player.unequipArmor();
                break;
            case ACCESSORY:
                player.unequipAccessory();
                break;
        }
        equipped = false;
        System.out.printf("%s desequipou %s!%n", player.getName(), getName());
        return false; 
    }

    public void takeDamage(int damage) {
        if (equipped && !isBroken()) {
            currentDurability = Math.max(0, currentDurability - damage);
            if (isBroken()) {
                System.out.println(getName() + " quebrou!");
            }
        }
    }


    public boolean isBroken() {
        return currentDurability <= 0;
    }

    public int getAttackBonus() {
        return !isBroken() ? attackBonus : 0;
    }
    public int getDefenseBonus() {
        return !isBroken() ? defenseBonus : 0;
    }
    public int getCurrentDurability() {
        return currentDurability;
    }
    public int getMaxDurability() {
        return maxDurability;
    }
    public boolean isEquipped() {
        return equipped;
    }
    public SlotType getSlotType() {
        return slotType;
    }
}
