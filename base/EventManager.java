package base;
import java.util.Random;
import java.util.Scanner;

import baus.*;
import mobs.*;
import mobs.enimies.*;
import itens.base.Item;

import player.Player;

public class EventManager {
    private static Random random = new Random();
    private static  Scanner scan = new Scanner(System.in);
    private static String[] mobsArray = {
        "aranha",
        "dragao",
        "esqueleto",
        "goblin",
        "mocergo",
        "ogro",
        "slime",
        "troll",
        "zumbi"
    };
    private static String[] bausArray = {
        "bau pequenho",
        "bau medio",
        "bau grande",
        "bau de espadas",
        "bau de armaduras",
        "bau de acessorios"
    };
    
    public static void generateEvent(int lvlDungeon, Player player){

        if(EventManager.random.nextInt(10) >= 6){
            EventManager.summonBau(player);
            return;
        } 
        EventManager.createBattle(lvlDungeon, player);
        

    }

    private static Mob createMob(int lvlDungeon){
        int posicao = EventManager.random.nextInt(EventManager.mobsArray.length);
            switch (EventManager.mobsArray[posicao]) {
                case "aranha":     return new Aranha(lvlDungeon);
                case "dragao":     return new Dragao(lvlDungeon);
                case "esqueleto":  return new Esqueleto(lvlDungeon);
                case "goblin":     return new Goblin(lvlDungeon);
                case "mocergo":    return new Morcego(lvlDungeon);
                case "ogro":       return new Ogro(lvlDungeon);
                case "slime":      return new Slime(lvlDungeon);
                case "troll":      return new Troll(lvlDungeon);
                default:      return new Zumbi(lvlDungeon);
            }
    }

    public static void createBattle(int lvlDungeon, Player player){
        Mob mob = EventManager.createMob(lvlDungeon);
        BattleManager batalha = new BattleManager(player, mob);
        batalha.startBattle();
    }

    private static Bau createBau(){
        int posicao = EventManager.random.nextInt(EventManager.bausArray.length);
            switch (EventManager.bausArray[posicao]) {
                case "bau medio":     return new BauMedio();
                case "bau grande":     return new BauGrande();
                case "bau de espadas":     return new BauEspadas();
                case "bau de armaduras":     return new BauArmaduras();
                case "bau de acessorios":     return new BauAcessorios();
                default:      return new BauPequenho();
            }
    }

    public static void summonBau(Player player){
        System.out.println("Você encontrou um báu");
        Bau bau = EventManager.createBau();
        Item[] itensBau = bau.abrir();
        for(Item item:itensBau){
            System.out.printf("deseja colocar %s no inventario [S] | [N]%n", item.getName());
            String resposta = scan.nextLine();

            if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
                player.addItem(item);
            } else {
                System.out.printf("%s descartado.%n", item.getName());
            }

        }
    }

}
