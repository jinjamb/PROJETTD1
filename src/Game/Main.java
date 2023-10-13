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
        forest.addGobelin(gobelin1);

        System.out.print("Entrez le nom du joueur : ");
        String playerName = scanner.nextLine();
        Job playerJob = null;
        
        playerJob = Job.chooseJob(playerName,scanner);
        

        Player joueur = new Player(playerName, playerJob, padhiver);
        
        System.out.println(joueur.getName());

        boolean quitGame = false;

        while (!quitGame) {
            Show.PrintPlace(joueur,0);
            String choiceStr = scanner.nextLine();
            Places currentPlace = joueur.getCurrentPlace();
            List<Monsters> monstersInCurrentPlace = currentPlace.getMonsters();

            try {
                int choice = Integer.parseInt(choiceStr);
        
                switch (choice) {
                    case 1:
                        if (Places.areMonstersAlive(currentPlace)) {
                            System.out.println("Impossible de se déplacer avec des monstres encore en vie autour.");
                        } else {
                            List<Places> accessiblePlaces = currentPlace.getAccessiblePlaces();
                            System.out.println("Lieux accessibles :");
                            for (int i = 0; i < accessiblePlaces.size(); i++) {
                                System.out.println((i + 1) + ". " + accessiblePlaces.get(i).getName());
                            }
                            int placeChoice = chooseNumber(scanner, accessiblePlaces);
                            if (placeChoice != -1) {
                                Places destination = accessiblePlaces.get(placeChoice);
                                joueur.move(destination);
                            }
                        }
                    case 2:
                        // Option "Se battre"
                        if (!monstersInCurrentPlace.isEmpty()) {
                            System.out.println("Monstres présents :");
                            for (int i = 0; i < monstersInCurrentPlace.size(); i++) {
                                Monsters monster = monstersInCurrentPlace.get(i);
                                if (monster.getHP() > 0) {
                                    System.out.println((i + 1) + ". " + monster.getName());
                                }
                            }
                            int monsterChoice = chooseNumber(scanner, monstersInCurrentPlace);
                            if (monsterChoice != -1) {
                                // Ajoutez ici la logique pour démarrer un combat contre le monstre choisi.
                                System.out.println("Vous vous battez contre " + monstersInCurrentPlace.get(monsterChoice).getName());
                            } else {
                                System.out.println("Aucun ennemi en vie ici.");
                            }
                        } else {
                            System.out.println("Aucun ennemi ici.");
                        }
                        break;
                    case 3:
                        // Option "Se reposer"
                        System.out.println("Vous vous reposez et récupérez vos points de vie.");
                        // Ajoutez ici la logique pour rétablir les points de vie du joueur.
                        break;
                    case 4:
                        // Option "Quitter le jeu"
                        quitGame = true;
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez choisir un numéro valide.");
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

}




