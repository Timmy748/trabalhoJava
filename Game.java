

import player.Player;
import base.EventManager;
import itens.armaduras.ArmaduraDragao;
import itens.base.Item;
import itens.base.ItemConsumivel;
import itens.base.ItemEquipavel;

import java.io.IOException;
import java.util.Scanner;

public class Game {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int lvlDungeon = 1;

        System.out.println("Bem-vindo ao Game Sei lá o que mano kkkkkk");
        System.out.print("Digite o nome do seu jogador: ");
        String name = scan.nextLine();

        Player player = createPlayer(name);
        player.addItem(new ArmaduraDragao());
        while (player.isAlive()) {
            clearConsole();
            preEventAction(player);
            EventManager.generateEvent(lvlDungeon, player);
            lvlDungeon++;
        }
        System.out.println("Game Over! Volte sempre :)");
        scan.close();
    }

    public static Player createPlayer(String name) {
        return new Player(name, 100, 10, 10);
    }

    private static void preEventAction(Player player) {
        while (true) {
            System.out.println("\n=== Ações Pré-Evento ===");
            System.out.println("1) Abrir inventário");
            System.out.println("2) mostrar status");
            System.out.println("3) Prosseguir para o Evento");
            System.out.print("Escolha uma opção: ");
            String opt = scan.nextLine();

            switch (opt) {
                case "1":
                    openInventory(player);
                    break;
                case "2":
                    player.showStats();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void openInventory(Player player) {
        if (player.getInvetorySize() == 0) {
            System.out.println("Inventário vazio.");
            return;
        }
        player.showInventory();
        System.out.print("Escolha índice do item (0 para voltar): ");
        int idx = readChoice(0, player.getInvetorySize());
        if (idx == 0) return;

        Item item = player.getItem(idx - 1);
        showItemDetails(item);

        System.out.println("1) Jogar fora");
        if (item instanceof ItemConsumivel) {
            System.out.println("2) Usar agora");
        } else if (item instanceof ItemEquipavel) {
            System.out.println("2) Equipar");
        } else {
            System.out.println("2) (ação não disponível)");
        }
        System.out.print("Escolha: ");
        int action = readChoice(1, 2);

        if (action == 1) {
            player.removeItem(item);
            System.out.printf("%s descartado.%n", item.getName());
        } else if (action == 2) {
            if (item instanceof ItemConsumivel) {
                boolean used = item.usar(player);
                if (used) {
                    System.out.printf("%s usado.%n", item.getName());
                } else {
                    System.out.println("Nada aconteceu.");
                }
            } else if (item instanceof ItemEquipavel) {
                ItemEquipavel equip = (ItemEquipavel) item;
                equip.usar(player);
                } 
            }
        }



    private static void showItemDetails(Item item) {
        System.out.printf("Item: %s%n", item.getName());
        System.out.printf("Desc: %s%n", item.getDescription());
        if (item instanceof ItemConsumivel) {
            ItemConsumivel ic = (ItemConsumivel) item;
            System.out.printf("Cura: +%d, Buff Atk: +%d, Def: +%d por %d turnos%n",
                ic.getHealthRestore(), ic.getAttackBoost(),
                ic.getDefenseBoost(), ic.getBoostDuration());
        } else if (item instanceof ItemEquipavel) {
            ItemEquipavel ie = (ItemEquipavel) item;
            System.out.printf("Bônus Atk: +%d, Bônus Def: +%d%n",
                ie.getAttackBonus(), ie.getDefenseBonus());
        }
    }


    public static void clearConsole() {
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls")
                    .inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    private static int readChoice(int min, int max) {
        while (true) {
            System.out.print("> ");
            try {
                int choice = Integer.parseInt(scan.nextLine().trim());
                if (choice >= min && choice <= max) {
                    return choice;
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
