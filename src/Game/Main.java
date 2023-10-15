package Game;
import java.util.List;
import java.util.Scanner;

import Game.Job.*;
import Game.Mob.*;
import Game.Pla.*;
import Game.Pnj.*;




public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Places padhiver = new Padhiver();
        Places northraod = new Route_Nord();
        Places southroad = new Route_Sud();
        Places forest = new Foret();
        Places marsh = new Marrais();
        Places crypt = new Crypte();
        Places volcano = new Volcan();

        padhiver.addAccessiblePlace(southroad);
        padhiver.addAccessiblePlace(northraod);
        northraod.addAccessiblePlace(forest);
        northraod.addAccessiblePlace(padhiver);
        southroad.addAccessiblePlace(marsh);
        southroad.addAccessiblePlace(padhiver);
        forest.addAccessiblePlace(northraod);
        forest.addAccessiblePlace(volcano);
        marsh.addAccessiblePlace(crypt);
        marsh.addAccessiblePlace(southroad);
        crypt.addAccessiblePlace(marsh);
        volcano.addAccessiblePlace(forest);

        Gobelin gobelin1 = new Gobelin("Dmitroff");
        Gobelin gobelin2 = new Gobelin("gollum");

        Orc orc1 = new Orc("Shrek");
        Orc orc2 = new Orc("Azog");

        Bat bat1 = new Bat("man");
        Bat bat2 = new Bat("signal");
        Bat bat3 = new Bat("mobil");
        Necromancer nec = new Necromancer("Angmar");
        Dragon Dragon = new Dragon("Dragonne");

        Npc pnj1 = new Giroud();
        Npc pnj4 = new Roberts();
        Npc pnj3 = new Bern();
        Npc pnj2 = new Daho();

        southroad.addMonster(orc1);
        southroad.addMonster(orc2);
        forest.addMonster(gobelin2);
        forest.addMonster(gobelin1);
        marsh.addMonster(bat1);
        marsh.addMonster(bat3);
        marsh.addMonster(bat2);
        crypt.addMonster(nec);
        volcano.addMonster(Dragon);

        padhiver.addVillager(pnj1);
        padhiver.addVillager(pnj4);
        northraod.addVillager(pnj3);
        southroad.addVillager(pnj2);


        int choix = 1;

        switch(choix){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
        }


        System.out.print("Entrez le nom du joueur : ");
        String playerName = scanner.nextLine();
        Job playerJob = null;
        
        playerJob = Job.chooseJob(playerName,scanner);
        

        Player joueur = new Player(playerName, playerJob, padhiver);
        
        System.out.println(joueur.getName());

        boolean quitGame = false;
        boolean print=true;

        while (!quitGame) {


            if(print){Show.PrintPlace(joueur,0);}else{print=true;}
            String choiceStr = scanner.nextLine();
            Places currentPlace = joueur.getCurrentPlace();
            //List<Monsters> monstersInCurrentPlace = currentPlace.getMonsters();

            try {
                int choice = Integer.parseInt(choiceStr);
                
                if(choice==1){
                    if(currentPlace.areMonstersAlive()){
                        System.out.println("Impossible");
                        print=false;
                        continue;
                    }
                    Show.PrintPlace(joueur,1);
                    int placeChoice = choosePlace(scanner, currentPlace.getAccessiblePlaces());
                    if (placeChoice != -1) {
                        Places destination = currentPlace.getAccessiblePlaces().get(placeChoice);
                        joueur.move(destination);
                    }
                }
                else if(choice==2){
                    if(!currentPlace.areMonstersAlive()){
                        System.out.println("Tout les monstres sont mort");
                        print=false;
                        continue;
                    }
                    Show.PrintPlace(joueur,2);
                    int n=chooseMonster(scanner, currentPlace.getMonsters());
                    int res= fight(joueur,currentPlace.getMonsters().get(n),scanner);
                    if(res==-1){
                        System.out.println("YOU DIE!!!");
                        break;
                    }else{
                        joueur.lvlup();
                    }
                }
                else if(choice==3){
                    if(currentPlace.areMonstersAlive()){
                        System.out.println("Impossible");
                    }
                    joueur.rest();
                }
                else if(choice==4){
                    Show.PrintPlace(joueur,3);
                    if(currentPlace.areMonstersAlive()){
                        int n=chooseNpc(scanner,currentPlace.getNpc());
                        Show.talk(joueur,currentPlace.getNpc().get(n),true);
                        scanner.nextLine();

                    }else{
                        int n=chooseNpc(scanner,currentPlace.getNpc());
                        Show.talk(joueur,currentPlace.getNpc().get(n),false);
                        scanner.nextLine();
                    }
                }else{
                    System.out.println("Choix invalide. Veuillez entrer un numéro valide.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Choix invalide. Veuillez entrer un numéro valide.");
            }

        }


    }
    private static int choosePlace(Scanner scanner, List<?> options) {
        System.out.print("Entrez un numéro : ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("#quit")) {
            return -1;
        }

        try {
            int choice = Integer.parseInt(input);
            if (choice >= 1 && choice <= options.size()) {
                return choice - 1;
            } else {
                System.out.println("CHOIX INVALIDE. Veuillez choisir un numéro valide.");
                return choosePlace(scanner, options);
            }
        } catch (NumberFormatException e) {
            System.out.println("CHOIX INVALIDE. Veuillez entrer un numéro valide.");
            return choosePlace(scanner, options);
        }
    }

    private static int chooseMonster(Scanner scanner,List<?> options){
        System.out.print("Choix: ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("#quit")) {
            return -1;
        }

        try {
            int choice = Integer.parseInt(input);
            if (choice >= 1 && choice <= options.size()) {
                return choice-1;
            } else {
                System.out.println("CHOIX INVALIDE. Veuillez choisir un numéro valide.");
                return chooseMonster(scanner, options);
            }
        } catch (NumberFormatException e) {
            System.out.println("CHOIX INVALIDE. Veuillez entrer un numéro valide.");
            return chooseMonster(scanner, options);
        }
    }

    private static int chooseNpc(Scanner scanner, List<?> options) {
        System.out.print("Entrez un numéro : ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("#quit")) {
            return -1;
        }

        try {
            int choice = Integer.parseInt(input);
            if (choice >= 1 && choice <= options.size()) {
                return choice - 1;
            } else {
                System.out.println("CHOIX INVALIDE. Veuillez choisir un numéro valide.");
                return choosePlace(scanner, options);
            }
        } catch (NumberFormatException e) {
            System.out.println("CHOIX INVALIDE. Veuillez entrer un numéro valide.");
            return choosePlace(scanner, options);
        }
    }

    private static int fight(Player p, Monsters m,Scanner scanner){
        Show.fight(p, m);
        while(p.getHP()>0 && m.getHP()>0){
            
            System.out.print("Choix: ");
            String input = scanner.nextLine();
            try{
                int choice = Integer.parseInt(input);
                int playerdmg=0;
                int mobdmg=0;
                if (choice==1){
                    playerdmg=p.getJob().getDmg(p.getLevel());
                }else if(choice==2 && p.getManaMax()!=0){
                    if(p.getMana()<2){System.out.println("Mana insufisant");continue;}
                    playerdmg=4;
                    p.downmana(2);
                }else if(choice==3 && p.getManaMax()!=0){
                    if(p.getMana()<9){System.out.println("Mana insufisant");continue;}
                    playerdmg=15;
                    p.downmana(9);
                }else{
                    System.out.println("choix invalide");
                    continue;
                }
                p.hit(m,playerdmg);
                if(m.getHP()>0){
                        if(m.getManaMax()>0){
                            if(m.spell(p)){
                                mobdmg=m.getMagicDmg();                 
                            }else{
                                mobdmg=m.getDmg();
                            }
                        }
                    m.hit(p,m.getDmg());
                }
                
                Show.fight(p, m);
                System.out.println(m.getName()+" a pris "+ playerdmg +" dégats");
                System.out.println(m.getName()+"vous a infligé "+ mobdmg+" dégats");


            }catch(NumberFormatException e){
                System.out.println("choix invalide");
            }
        }
        System.out.print("suite (entrez une touche)");
        scanner.nextLine();
        if(p.getHP()<=0){
            return -1;
        }else{
            return 1;
        }
    }

}




