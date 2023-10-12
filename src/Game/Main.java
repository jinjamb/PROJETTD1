package Game;
import java.util.List;
import java.util.Scanner;

import Game.Job.*;
import Game.Mob.*;
import Game.Pla.*;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Padhiver pad = new Padhiver();
        Places padhiver = new Padhiver();
        Places northraod = new Places("Route Nord");
        Places southroad = new Places("Route Sud");
        Places forest = new Places("Foret");
        Places marsh = new Places("Marais des Morts");
        Places crypt = new Places("Crypte");
        Places volcano = new Places("Volcan");

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
        Jobs playerJob = null;
        while (playerJob == null) {
            playerJob = Jobs.chooseJob(scanner);  // Tant que playerJob est null, continuez à demander à l'utilisateur de choisir un métier
        }
        
        Player joueur = new Player(playerName, playerJob, padhiver);

        Show.PrintPlace(joueur);

        boolean quitGame = false;

        while (!quitGame) {
            displayPlayerInfo(joueur);
            Places currentPlace = joueur.getCurrentPlace();
            System.out.println("Où voulez-vous vous déplacer ? Entrez le numéro du lieu (ou tapez -1 pour quitter) : ");
        
            List<Places> accessiblePlaces = currentPlace.getAccessiblePlaces();
            for (int i = 0; i < accessiblePlaces.size(); i++) {
                System.out.println((i + 1) + ". " + accessiblePlaces.get(i).getName());
            }
        
            int placeChoice = chooseNumber(scanner, accessiblePlaces);
        
            if (placeChoice == -1) {
                quitGame = true;  // Si le joueur entre "#quit", mettez quitGame à vrai pour quitter le jeu
            } else {
                Places destination = accessiblePlaces.get(placeChoice);
                joueur.move(destination);
            }

            if (joueur.getHP() <= 0) {
                System.out.println("Game Over");
                quitGame = true;
                break;
            }

            for (int i = 0; i < joueur.getCurrentPlace().getGobelins().size(); i++) {
                Gobelin gobelin = joueur.getCurrentPlace().getGobelins().get(i);
                if (gobelin.getHP() > 0) {
                    System.out.println((i + 1) + ". Un gobelin (" + gobelin.getName() + ") se trouve ici !");
                    boolean combatEnCours = true;

                    while (combatEnCours) {
                        System.out.println("Choisissez la cible pour votre attaque (entrez le numéro du gobelin) : ");
                        int targetChoice = chooseNumber(scanner, joueur.getCurrentPlace().getGobelins());
                    
                        if (targetChoice == -1) {
                            combatEnCours = false;
                        } else {
                            Gobelin targetGobelin = joueur.getCurrentPlace().getGobelins().get(targetChoice);
                            joueur.hit(targetGobelin, joueur.damage);
                            System.out.println("Vous avez attaqué " + targetGobelin.getName() + " et lui avez infligé " + joueur.damage + " points de dégâts.");
                            System.out.println(targetGobelin.getName() + " a maintenant " + targetGobelin.getHP() + " points de vie.");
                    
                            if (targetGobelin.getHP() > 0) {
                                gobelin.FurieSanguinaire(joueur);
                                joueur.getHP();
                            } else {
                                System.out.println(targetGobelin.getName() + " a été vaincu !");
                            }
                        }

                        if (joueur.getHP() <= 0) {
                            System.out.println("Game Over");
                            quitGame = true;
                            combatEnCours = false;
                        } else {
                            boolean tousLesGobelinsVaincus = true;
                            for (Gobelin g : joueur.getCurrentPlace().getGobelins()) {
                                if (g.getHP() > 0) {
                                    tousLesGobelinsVaincus = false;
                                    break;
                                }
                            }
                            if (tousLesGobelinsVaincus) {
                                System.out.println("Tous les gobelins ont été vaincus !");
                                combatEnCours = false;
                            }
                        }
                    }
                }
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
}




