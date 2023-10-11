package Game;
import java.util.Scanner;
import Game.DPlaces.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("");

        Scanner scanner = new Scanner(System.in);

        Places village1 = new P_Village();
        Places plain = new Places("Plaine");
        Places lake = new Places("Lac");
        Places forest = new Places("Forêt");
        Places ruins = new Places("Ruines");
        Places orchard = new Places("Verger");
        Places path1 = new Places("chemin1");
        Places path2 = new Places("chemin2");
        Places montain = new Places("Montagne");
        Places cabain = new Places("Cabane");
        Places castle = new Places("Chateau");
        Places beacon = new Places("Phare");
        Places sea = new Places("Mer");
        Places cave = new Places("Grotte");
        Places village2 = new Places("Village2");
        Places northraod = new Places("Route Nord");
        Places city = new Places("Ville");
        Places graveyard = new Places("Cimetière");
        Places southroad = new Places("Route Sud");
        Places temple = new Places("Temple");
        Places passage = new Places("Passage");

        village1.addAccessiblePlace(plain);
        village1.addAccessiblePlace(forest);
        plain.addAccessiblePlace(village1);
        plain.addAccessiblePlace(lake);
        plain.addAccessiblePlace(path1);
        plain.addAccessiblePlace(path2);
        forest.addAccessiblePlace(village1);
        forest.addAccessiblePlace(ruins);
        forest.addAccessiblePlace(passage);
        lake.addAccessiblePlace(orchard);
        lake.addAccessiblePlace(plain);
        orchard.addAccessiblePlace(lake);
        path1.addAccessiblePlace(montain);
        path1.addAccessiblePlace(plain);
        montain.addAccessiblePlace(path1);
        montain.addAccessiblePlace(cabain);
        montain.addAccessiblePlace(castle);
        cabain.addAccessiblePlace(montain);
        castle.addAccessiblePlace(montain);
        path2.addAccessiblePlace(plain);
        path2.addAccessiblePlace(beacon);
        path2.addAccessiblePlace(sea);
        sea.addAccessiblePlace(path2);
        sea.addAccessiblePlace(beacon);
        sea.addAccessiblePlace(cave);
        sea.addAccessiblePlace(village2);
        cave.addAccessiblePlace(sea);
        village2.addAccessiblePlace(sea);
        beacon.addAccessiblePlace(path2);
        beacon.addAccessiblePlace(sea);
        beacon.addAccessiblePlace(southroad);
        southroad.addAccessiblePlace(beacon);
        southroad.addAccessiblePlace(city);
        city.addAccessiblePlace(southroad);
        city.addAccessiblePlace(graveyard);
        city.addAccessiblePlace(northraod);
        graveyard.addAccessiblePlace(city);
        northraod.addAccessiblePlace(city);
        northraod.addAccessiblePlace(temple);
        temple.addAccessiblePlace(northraod);
        temple.addAccessiblePlace(passage);
        passage.addAccessiblePlace(temple);
        passage.addAccessiblePlace(forest);


        city.addAccessiblePlace(southroad);
        city.addAccessiblePlace(northraod);

        System.out.print("Entrez le nom du joueur : ");
        String playerName = scanner.nextLine();
        Job playerJob = null;
        while (playerJob == null) {
            playerJob = Job.chooseJob(scanner);  // Tant que playerJob est null, continuez à demander à l'utilisateur de choisir un métier
        }
        
        Player joueur = new Player(playerName, playerJob, village1);

        boolean quitGame = false;

        while (!quitGame) {

            displayPlayerInfo(joueur);
        
            System.out.print("Où voulez-vous vous déplacer ? Entrez le nom du lieu (ou tapez #quit pour quitter) : ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("#quit")) {
                quitGame = true;  // Si le joueur entre "#quit", mettez quitGame à vrai pour quitter le jeu
            } else {
                Places destination = null;
                for (Places place : joueur.getCurrentPlace().getAccessiblePlaces()) {
                    if (place.getName().equalsIgnoreCase(input)) {
                        destination = place;
                        break;
                    }
                }

                if (destination != null) {
                    joueur.move(destination);   
                } else {
                    System.out.println("DESTINATION INVALIDE. Vous ne pouvez pas vous déplacer là-bas.");
                }
            }
        }
        
        scanner.close();
    }

    private static void displayPlayerInfo(Player joueur) {
        
        Show.Print(joueur);
        /* 
        System.out.println("\nInformations du joueur :");
        System.out.println("Nom du joueur : " + joueur.getName());
        System.out.println("Lieu actuel du joueur : " + joueur.getCurrentPlace().getName());
        System.out.println("Lieux accessibles depuis " + joueur.getCurrentPlace().getName() + ":");
        for (Places place : joueur.getCurrentPlace().getAccessiblePlaces()) {
            System.out.println("- " + place.getName());
        }
        System.out.println("Points de vie du joueur : " + joueur.Get_HP());
        System.out.println("Niveau du joueur: "+ joueur.getLevel());
        System.out.println("Argent du joueur: "+ joueur.getCoin());
        */
    }
}




