package itens.base;

import player.Player;

public abstract class Item {
    private String name;
    private String description;

    
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public abstract boolean usar(Player player);
    

    

    public String getName() { return name; }
    public String getDescription() { return description; }
    
    @Override
    public String toString() {
        return name + " - " + description;
    }
}
