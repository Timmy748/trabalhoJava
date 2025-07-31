package player;

import java.util.ArrayList;
import java.util.List;

import itens.base.Item;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
        System.out.printf("%s adicionado ao inventário%n", item.getName());
    }

    public void remove(Item item) {
        items.remove(item);
        System.out.printf("%s removido do inventário%n", item.getName());
    }

    public Item get(int index) {
        return items.get(index);
    }

    public int size(){return this.items.size();}

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void show() {
        System.out.println("\n=== INVENTÁRIO ===");
        if (items.isEmpty()) {
            System.out.println("Inventário vazio");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName());
        }
    }
}

