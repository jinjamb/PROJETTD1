package Game;
import java.util.List;
import java.util.Scanner;

import Game.Job.*;
import Game.Mob.*;
import Game.Pla.*;


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
        Bat bat1 = new Bat("batm");
        forest.addMonster(gobelin1);
        forest.addMonster(bat1);


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
            List<Monsters> monstersInCurrentPlace = currentPlace.getMonsters();

            try {
                int choice = Integer.parseInt(choiceStr);
                
                if(choice==1){
                    if(currentPlace.areMonstersAlive()){
                        System.out.println("Impossible");
                        print=false;
                        continue;
                    }
                    Show.PrintPlace(joueur,1);
                    int placeChoice = chooseNumber(scanner, currentPlace.getAccessiblePlaces());
                            if (placeChoice != -1) {
                                Places destination = currentPlace.getAccessiblePlaces().get(placeChoice);
                                joueur.move(destination);
                            }

                }
            } catch (NumberFormatException e) {
                System.out.println("Choix invalide. Veuillez entrer un numéro valide.");
            }

        }


    }
    private static int chooseNumber(Scanner scanner, List<?> options) {
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
                return chooseNumber(scanner, options);
            }
        } catch (NumberFormatException e) {
            System.out.println("CHOIX INVALIDE. Veuillez entrer un numéro valide.");
            return chooseNumber(scanner, options);
        }
    }

    private static void fight(Player p,Monsters m){

    }

}




