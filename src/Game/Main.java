package Game;
import java.util.List;
import java.util.Scanner;

import Game.Job.*;
import Game.Mob.*;
import Game.Pla.*;
//import Game.*;




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
        Gobelin gobelin2 = new Gobelin("Gobby");

        Orc orc1 = new Orc("Orc");
        Orc orc2 = new Orc("lorc");

        Bat bat1 = new Bat("batun");
        Bat bat2 = new Bat("batdeu");
        Bat bat3 = new Bat("battroa");

        Necromancer nec = new Necromancer("Necromant");

        Dragon Dragon = new Dragon("Dragon2Shrek");

        southroad.addMonster(orc1);
        southroad.addMonster(orc2);
        forest.addMonster(gobelin2);
        forest.addMonster(gobelin1);
        marsh.addMonster(bat1);
        marsh.addMonster(bat3);
        marsh.addMonster(bat2);
        crypt.addMonster(nec);
        volcano.addMonster(Dragon);


        System.out.print("Entrez le nom du joueur : ");
        String playerName = scanner.nextLine();
        Job playerJob = null;
        
        playerJob = Job.chooseJob(playerName,scanner);
        

        Player joueur = new Player(playerName, playerJob, padhiver);
        
        System.out.println(joueur.getName());

        boolean quitGame = false;
        boolean print=true;

        while (!quitGame) {
            //print de test:
            System.out.println(joueur.getCurrentPlace());
            System.out.println(joueur.getCurrentPlace().hasMonsters());


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
                    System.out.print("test info sur les monstres en vie:"+!currentPlace.areMonstersAlive());
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
                    joueur.rest();
                }
                else if(choice==4){
                    //
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

    private static int fight(Player p, Monsters m,Scanner scanner){
        Show.fight(p, m);
        while(p.getHP()>0 && m.getHP()>0){
            System.out.println("test fight"+m.getHP());
            
            System.out.print("Choix: ");
            String input = scanner.nextLine();
            try{
                int choise = Integer.parseInt(input);
                int playerdmg=0;
                if (choise==1){
                    playerdmg=p.getJob().getDmg(p.getLevel());
                }else if(choise==2 && p.getManaMax()!=0){
                    if(p.getMana()<2){System.out.println("Mana insufisant");continue;}
                    playerdmg=4;
                    p.downmana(2);
                }else if(choise==2 && p.getManaMax()!=0){
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
                                Show.fight(p, m);
                                System.out.println(m.getName()+"a pris "+ p.getJob().getDmg(p.getLevel())+" dégats");
                                System.out.println(m.getName()+"vous a infligé "+ m.getMagicDmg()+" dégats");
                                continue;
                            }
                        }
                    m.hit(p,m.getDmg());
                }
                
                Show.fight(p, m);
                System.out.println(m.getName()+"a pris "+ p.getJob().getDmg(p.getLevel())+" dégats");
                System.out.println(m.getName()+"vous a infligé "+ m.getDmg()+" dégats");





            }catch(NumberFormatException e){
                System.out.println("choix invalide");
            }
        }
        if(p.getHP()<=0){
            return -1;
        }else{
            return 1;
        }
    }

}




