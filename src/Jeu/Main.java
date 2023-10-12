package src.Jeu;
import java.util.List;
import java.util.Scanner;

import src.Jeu.Job.Job;
import src.Jeu.Mob.Monsters;
import src.Jeu.Mob.Gobelin;
import src.Jeu.Pla.*;

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

        Monsters gobelin1 = new Gobelin("Dmitroff");
        forest.addMonster(gobelin1);


        System.out.print("Entrez le nom du joueur : ");
        String playerName = scanner.nextLine();
        Job playerJob = null;
        while (playerJob == null) {
            playerJob = Job.chooseJob(scanner);  // Tant que playerJob est null, continuez à demander à l'utilisateur de choisir un métier
        }
        
        Player joueur = new Player(playerName, playerJob, padhiver);

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

            for (int i = 0; i < currentPlace.getMonsters().size(); i++) {
                Monsters monster = currentPlace.getMonsters().get(i);
                if (monster.getHP() > 0) {
                    System.out.println((i + 1) + ". Un " + monster.getName() + " se trouve ici !");
                    boolean combatEnCours = true;
            
                    while (combatEnCours) {
                        System.out.println("Choisissez la cible pour votre attaque (entrez le numéro du monstre) : ");
                        int targetChoice = chooseNumber(scanner, currentPlace.getMonsters());
                        
                        if (targetChoice == -1) {
                            combatEnCours = false;
                        } else {
                            Monsters targetMonster = currentPlace.getMonsters().get(targetChoice);
                            joueur.hit(targetMonster, joueur.damage);
                            System.out.println("Vous avez attaqué " + targetMonster.getName() + " et lui avez infligé " + joueur.damage + " points de dégâts.");
                            System.out.println(targetMonster.getName() + " a maintenant " + targetMonster.getHP() + " points de vie.");
                            
                            if (targetMonster.getHP() > 0) {
                                // Vous pouvez ajouter des actions spécifiques au monstre ici si nécessaire
                                joueur.getHP();
                            } else {
                                System.out.println(targetMonster.getName() + " a été vaincu !");
                            }
                        }
            
                        if (joueur.getHP() <= 0) {
                            System.out.println("Game Over");
                            quitGame = true;
                            combatEnCours = false;
                        } else {
                            boolean tousLesMonstresVaincus = true;
                            for (Monsters m : currentPlace.getMonsters()) {
                                if (m.getHP() > 0) {
                                    tousLesMonstresVaincus = false;
                                    break;
                                }
                            }
                            if (tousLesMonstresVaincus) {
                                System.out.println("Tous les monstres ont été vaincus !");
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




