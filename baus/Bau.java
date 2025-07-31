package baus;
import itens.base.Item;

public abstract class Bau {
    protected String name;

    public Bau(String name){
        this.name = name;
    }

    public abstract Item[] abrir();
    public String getName(){
        return this.name;
    }
}
