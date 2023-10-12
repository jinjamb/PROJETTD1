package src.Jeu;

import src.Jeu.Job.Job;
import src.Jeu.Mob.Monsters;
import src.Jeu.Mob.Gobelin;
import src.Jeu.Pla.*;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Places padhiver = new Places("Padhiver");
        Places northroad = new Places("Route Nord");
        Places southroad = new Places("Route Sud");
        Places forest = new Places("Foret");
        Places marsh = new Places("Marais des Morts");
        Places crypt = new Places("Crypte");
        Places volcano = new Places("Volcan");

        padhiver.addAccessiblePlace(southroad);
        padhiver.addAccessiblePlace(northroad);
        northroad.addAccessiblePlace(forest);
        northroad.addAccessiblePlace(padhiver);
        southroad.addAccessiblePlace(marsh);
        southroad.addAccessiblePlace(padhiver);
        forest.addAccessiblePlace(northroad);
        forest.addAccessiblePlace(volcano);
        marsh.addAccessiblePlace(crypt);
        marsh.addAccessiblePlace(southroad);
        crypt.addAccessiblePlace(marsh);
        volcano.addAccessiblePlace(forest);

        Monsters gobelin1 = new Gobelin("Dmitroff");
        forest.addMonster(gobelin1);

        System.out.print("Entrez le nom du joueur : ");
        String playerName = scanner.nextLine();
        Job playerJob = null;
        while (playerJob == null) {
            playerJob = Job.chooseJob(scanner);
        }

        Player joueur = new Player(playerName, playerJob, padhiver);

        boolean quitGame = false;

        while (!quitGame) {
            displayPlayerInfo(joueur);
            Places currentPlace = joueur.getCurrentPlace();
        
            List<Monsters> monstersInCurrentPlace = currentPlace.getMonsters();

            if (!monstersInCurrentPlace.isEmpty()) {
                System.out.println("Des monstres se trouvent dans ce lieu !");
                for (int i = 0; i < monstersInCurrentPlace.size(); i++) {
                    System.out.println((i + 1) + ". Un " + monstersInCurrentPlace.get(i).getName() + " se trouve ici !");
                }
            } else {
                System.out.println("Il n'y a aucun ennemi ici.");
            }
        
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1. Se déplacer");
            System.out.println("2. Se battre");
            System.out.println("3. Se reposer");
            System.out.println("4. Quitter le jeu");
            System.out.print("Entrez le numéro de votre choix : ");
        
            String choiceStr = scanner.nextLine();
        
            try {
                int choice = Integer.parseInt(choiceStr);
        
                switch (choice) {
                    case 1:
                        if (areMonstersAlive(currentPlace)) {
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

        scanner.close();
    }   

    private static void displayPlayerInfo(Player joueur) {
        // Afficher les informations du joueur
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

    private static boolean areMonstersAlive(Places place) {
        List<Monsters> monstersInPlace = place.getMonsters();
        for (Monsters monster : monstersInPlace) {
            if (monster.getHP() > 0) {
                return true;
            }
        }
        return false;
    }
    
}




