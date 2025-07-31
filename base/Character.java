package base;


public abstract class Character implements Battlable {
    protected String name;
    protected int life;
    protected int currentLife;
    protected int attack;
    protected int defense; 

    public Character(String name, int life, int attack, int defense){
        this.name = name;
        this.life = life;
        this.currentLife = this.life;
        this.attack = attack;
        this.defense = defense;
    }

    public boolean isAlive(){
        return currentLife > 0;
    }
    public String getName() { return name; }
    public int getLife() { return life; }
    public int getCurrentLife() { return currentLife; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }

}
    
