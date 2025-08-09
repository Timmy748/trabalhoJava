import player.Player;
import base.EventManager;
import itens.base.Item;
import itens.base.ItemConsumivel;
import itens.base.ItemEquipavel;

import java.io.IOException;
import java.util.Scanner;

// pra rodar o jogo com acentos porque eu nao quero mudar o codigo
// java -Dfile.encoding=UTF-8 Game.java

public class Game {
    private static final Scanner scan = new Scanner(System.in);
    private static int lvlDungeon = 0;
    public static void main(String[] args) {
        

        System.out.println("""
        =================================
        Bem-vindo ao jogo de RPG!
        Você é um aventureiro em busca de tesouros e desafios.
        Você começará no nível 1 e enfrentará monstros em uma dungeon.
        A cada nível, você ganhará experiência e poderá encontrar itens valiosos.
        Prepare-se para a aventura!
        =================================
                """);
        System.out.print("Digite seu nome: ");
        String name = scan.nextLine();

        Player player = createPlayer(name);
        while (player.isAlive()) {
            Game.lvlDungeon++;
            preEventAction(player);
            EventManager.generateEvent(Game.lvlDungeon, player);
        }
        Game.clearConsole();
        System.out.printf("Game Over. você conseguiu chegar ao level %d", Game.lvlDungeon);
        scan.close();
    }

    public static Player createPlayer(String name) {
        return new Player(name, 100, 15, 15);
    }

    private static void preEventAction(Player player) {
        while (true) {
            Game.clearConsole();
            System.out.printf("""
            =================================

            Você está no level %d da dungeon.

            ======= Açoes Pré-Evento ========

            1) Abrir inventário
            2) Mostrar status
            3) Prosseguir para o Evento

            =================================

            Escolha uma opçao:

                    """, Game.lvlDungeon);
            String opt = scan.nextLine();

            switch (opt) {
                case "1":
                    openInventory(player);
                    break;
                case "2":
                    Game.clearConsole();
                    player.showStats();
                    System.out.println("Pressione Enter para continuar...");
                    scan.nextLine();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Opçao inválida. Tente novamente.");
            }
        }
    }

    private static void openInventory(Player player) {
        if (player.getInvetorySize() == 0) {
            System.out.println("Inventario vazio.");
            return;
        }
        player.showInventory();
        System.out.println("\nEscolha índice do item (0 para voltar):");
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
            System.out.println("2) (açao nao disponível)");
        }
        System.out.println("Escolha: ");
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
        System.out.println("\n=== Detalhes do Item ===");
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
        System.out.println("========================\n");
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
            System.out.println("Opçao inválida. Tente novamente.");
        }
    }
}
