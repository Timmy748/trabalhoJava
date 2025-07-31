package player;

import java.util.Random;

import base.Character;
import itens.base.Item;
import itens.base.ItemEquipavel;

public class Player extends Character {
    private final Inventory inventory = new Inventory();
    private final EquipmentManager equipment;
    private final BuffManager buffManager = new BuffManager();

    private int level = 1;
    private int experience = 0;
    private final Random random = new Random();

    public Player(String name, int life, int attack, int defense) {
        super(name, life, attack, defense);
        this.equipment = new EquipmentManager(this.inventory);
    }

    @Override
    public int calculateAttack() {

        int base       = this.attack;
        int eqBonus    = getTotalEquipmentAttackBonus();
        int buffBonus  = buffManager.getAttackBoost();
        int total      = base + eqBonus + buffBonus;

        boolean isCrit = random.nextInt(100) < 20;
        int finalAtk   = isCrit ? total * 2 : total;
        
        ItemEquipavel weapon = equipment.getWeapon();
        if (weapon != null) {
            weapon.takeDamage(1);
        }
        
        return finalAtk;
    }

    @Override
    public void receiveDamage(int damage) {
        int base        = this.defense;
        int eqBonus     = getTotalEquipmentDefenseBonus();
        int buffBonus   = buffManager.getDefenseBoost();
        int totalDef    = base + eqBonus + buffBonus;

        int dmg   = Math.max(damage - totalDef / 2, 1);
        this.currentLife = Math.max(this.currentLife - dmg, 0);;
        
        ItemEquipavel armor = this.equipment.getArmor();
        if (armor != null && dmg > 0) {
            armor.takeDamage(dmg);
        }
    }


    public int getInvetorySize(){ return this.inventory.size();}
    public void addItem(Item item) { inventory.add(item); }
    public void removeItem(Item item) { inventory.remove(item); }
    public void showInventory()     { inventory.show(); }
    public Item getItem(int idx)    { return inventory.get(idx); }


    public void equipWeapon(ItemEquipavel weapon) {
        this.equipment.equipWeapon(weapon);
    }

    public void unequipWeapon() {
        this.equipment.unequipWeapon();
    }
    public void equipArmor(ItemEquipavel armor) {
        this.equipment.equipArmor(armor);
    }

    public void unequipArmor() {
        this.equipment.unequipArmor();
    }
    public void equipAccessory(ItemEquipavel acessory) {
        this.equipment.equipAccessory(acessory);
    }

    public void unequipAccessory() {
        this.equipment.unequipAccessory();
    }


    public void applyBuff(int atk, int def, int dur) {
        buffManager.apply(atk, def, dur);
    }

    public boolean isBuffed(){
        return this.buffManager.isActive();
    }

    public void heal(int healthRestore){
        this.currentLife += healthRestore;
        if(this.currentLife > this.life) this.currentLife = this.life;
    }

    public void nextTurn() {
        buffManager.tick();
    }

    public void levelUp(){
        this.attack += random.nextInt(5) + 1;
        this.defense += random.nextInt(5) + 1;
        this.life += random.nextInt(21) + 5;
        this.currentLife = this.life;
        this.level++;
        this.showStats();
    }

    public void gainExperience(int xp){
        this.experience += xp;
        int xpNeeded = this.level * 100;
        if(this.experience > xpNeeded){
            this.levelUp();
            this.experience -= xpNeeded;
        }
    }


    public void showStats() {
    int totalAtk = attack 
                 + buffManager.getAttackBoost() 
                 + getTotalEquipmentAttackBonus();
    int totalDef = defense 
                 + buffManager.getDefenseBoost() 
                 + getTotalEquipmentDefenseBonus();

    System.out.printf("""
        
        === STATUS DO JOGADOR ===
        Nome: %s
        Vida: %d / %d
        Ataque : %d
        Defesa : %d 
        Nível: %d
        Experiência: %d
        =========================

        """,
        name,
        currentLife, life,
        totalAtk,
        totalDef,
        level, experience
    );
}

    private int getTotalEquipmentAttackBonus() {
        int sum = 0;
        ItemEquipavel weapon    = equipment.getWeapon();
        ItemEquipavel armor     = equipment.getArmor();
        ItemEquipavel accessory = equipment.getAccessory();
        if (weapon    != null) sum += weapon.getAttackBonus();
        if (armor     != null) sum += armor.getAttackBonus();
        if (accessory != null) sum += accessory.getAttackBonus();
        return sum;
    }

    private int getTotalEquipmentDefenseBonus() {
        int sum = 0;
        ItemEquipavel weapon    = equipment.getWeapon();
        ItemEquipavel armor     = equipment.getArmor();
        ItemEquipavel accessory = equipment.getAccessory();
        if (weapon    != null) sum += weapon.getDefenseBonus();
        if (armor     != null) sum += armor.getDefenseBonus();
        if (accessory != null) sum += accessory.getDefenseBonus();
        return sum;
    }

}
