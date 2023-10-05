package src.Jeu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Places padhiver = new Places("Padhiver");
        Places routeNord = new Places("Route Nord");
        Places routeSud = new Places("Route Sud");
        Places village = new Places("Village");

        Job Guerrier = new Job("Guerrier");

        padhiver.addAccessiblePlace(routeNord);
        padhiver.addAccessiblePlace(routeSud);
        routeNord.addAccessiblePlace(padhiver);
        routeNord.addAccessiblePlace(village);
        routeSud.addAccessiblePlace(padhiver);
        village.addAccessiblePlace(routeNord);

        System.out.print("Entrez le nom du joueur : ");
        String playerName = scanner.nextLine();
        Job playerJob = new Job("Warrior");
        Player joueur = new Player(playerName, playerJob, padhiver);
        
        System.out.println("Choisissez un métier :");
        System.out.println("Guerrier");
        System.out.println("Mage");
        System.out.println("Archer");
        System.out.println("Description");

        while (true) {

            displayPlayerInfo(joueur);
        
            System.out.print("Où voulez-vous vous déplacer ? Entrez le nom du lieu : ");
            String destinationName = scanner.nextLine();
        
            Places destination = null;
            for (Places place : joueur.getCurrentPlace().getAccessiblePlaces()) {
                if (place.getName().equalsIgnoreCase(destinationName)) {
                    destination = place;
                    break;
                }
            }
        
            if (destination != null) {
                joueur.move(destination);
                System.out.println("Vous arrivez à " + destination.getName());
                break;
            } else {
                System.out.println("DESTINATION INVALIDE. Vous ne pouvez pas vous déplacer là-bas.");
            }
        }
        
        scanner.close();
    }

    private static void displayPlayerInfo(Player joueur) {
        System.out.println("\nInformations du joueur :");
        System.out.println("Nom du joueur : " + joueur.getName());
        System.out.println("Lieu actuel du joueur : " + joueur.getCurrentPlace().getName());
        System.out.println("Lieux accessibles depuis " + joueur.getCurrentPlace().getName() + ":");
        for (Places place : joueur.getCurrentPlace().getAccessiblePlaces()) {
            System.out.println("- " + place.getName());
        }
        System.out.println("Points de vie du joueur : " + joueur.Get_HP());
    }
}




