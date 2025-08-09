package base;

import java.util.Scanner;

import itens.base.Item;
import itens.base.ItemConsumivel;
import mobs.Mob;
import player.Player;

import java.util.Random;


public class BattleManager {
    private final Player player;
    private final Mob mob;
    private boolean isPlayerTurn = true;
    private final Scanner scan = new Scanner(System.in);
    private Random random = new Random();

    public BattleManager(Player player, Mob mob) {
        this.player = player;
        this.mob = mob;
    }

    public boolean startBattle() {
        System.out.printf("\nUma batalha começa: %s vs %s (nível %d)!\n\n",
            this.player.getName(), this.mob.getName(), this.mob.getLevel());

        while (this.player.isAlive() && this.mob.isAlive()) {
            if (this.isPlayerTurn) {
                playerTurn();
            } else {
                mobTurn();
            }
            
        }

        if (!this.player.isAlive()) {
            System.out.println("Você foi derrotado...");
            return false;
        }
        

        System.out.println("Você venceu a batalha!");
            int exp = this.mob.getExperienceReward();
            System.out.printf("Ganhou %d de experiência!\n", exp);
            this.player.gainExperience(exp);
            
            if (this.random.nextInt(100) >= 90) {
                for(Item item: this.mob.getDrops()){
                    System.out.printf("O mob deixou cair: %s. Deseja pegar este item? (s/n)%n", item.getName());

                    String resposta = scan.nextLine();

                    if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
                        player.addItem(item);

                    } else {
                        System.out.printf("%s descartado.%n", item.getName());
                    }
                }
            } else {
                System.out.printf("%s nao dropou nada kkkkkkkkkkk", mob.getName());
            }
        return true;
    }

    private void playerTurn() {
        System.out.println("Sua vez! O que deseja fazer?");
        System.out.println("1 - Atacar");
        System.out.println("2 - Usar consumível");
        System.out.println("3 - Mostrar status");

        int choice = readChoice(1, 3);
        switch (choice) {
            case 1:
                this.handleAttack();
                break;
            case 2:
                this.handleUseConsumable();
                break;
            case 3:
                this.handleShowStatus();
                break;
        }
    }

    private void handleAttack() {
        int dmg = player.calculateAttack();
        System.out.printf("Você atacou!!!\n");
        mob.receiveDamage(dmg);
        player.nextTurn();
        isPlayerTurn = false;
    }

    private void handleUseConsumable() {
        this.player.showInventory();
        System.out.print("Escolha índice do consumível: ");
        int idx = readChoice(1, this.player.getInvetorySize());
        Item item =  this.player.getItem(idx - 1);
        if(item instanceof ItemConsumivel){
            boolean usar = item.usar(this.player);
            if(usar) {
                System.out.printf("%s usado", item.getName());
                this.isPlayerTurn = false;
            } else{
                this.isPlayerTurn = true;
            }
        } else {
            System.out.println("isso nao é um item válido");
            this.isPlayerTurn = true;
        }
    }

    private void handleShowStatus() {
        player.showStats();
        mob.showStats();

        isPlayerTurn = true;
    }

    private void mobTurn() {
        System.out.printf("%s está atacando!\n", this.mob.getName());
        int dmg = this.mob.calculateAttack();
        this.player.receiveDamage(dmg);
        this.player.showStats();
        this.isPlayerTurn = !this.isPlayerTurn;
    }



    private int readChoice(int min, int max) {
        while (true) {
            System.out.print("> ");
            int choice = this.scan.nextInt();
            if (choice < min || choice > max) {
                System.out.println("Opçao inválida. Tente novamente.");
                continue;
            }
            return choice;
        }
    }
}
