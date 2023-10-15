package src.Jeu.Job;

import java.util.Scanner;

import src.Jeu.Ite.Items;

public class Job{
    private String name;
    protected int hp;
    protected Items item;

    public Job(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Job chooseJob(Scanner scanner) {
        Job selectedJob = null;
    
        while (selectedJob == null) {
            System.out.println("Choisissez un métier :");
            System.out.println("1. Barbare");
            System.out.println("2. Guerrier");
            System.out.println("3. Mage");
            System.out.print("Entrez le numéro du métier que vous souhaitez : ");
    
            String choiceStr = scanner.nextLine();
    
            try {
                int choice = Integer.parseInt(choiceStr);
    
                switch (choice) {
                    case 1:
                        System.out.println("Description Guerrier");
                        System.out.println("Entrez 'oui' pour confirmer ou 'non' pour refuser.");
                        String confirmChoice1 = scanner.nextLine().trim().toLowerCase();
                        if (confirmChoice1.equals("oui")) {
                            selectedJob = new Barbarian();
                            System.out.println("Vous avez choisi d'être un Barbare.");
                            break;
                        } else if (confirmChoice1.equals("non")) {
                            System.out.println("Recommencez la sélection du métier.");
                        } else {
                            System.out.println("Choix invalide. Veuillez entrer 'oui' pour confirmer ou 'non' pour refuser.");
                        }
                        break;
                    case 2:
                        System.out.println("Description Mage");
                        System.out.println("Entrez 'oui' pour confirmer ou 'non' pour refuser.");
                        String confirmChoice2 = scanner.nextLine().trim().toLowerCase();
                        if (confirmChoice2.equals("oui")) {
                            selectedJob = new Warrior();
                            System.out.println("Vous avez choisi d'être un Guerrier.");
                            break;
                        } else if (confirmChoice2.equals("non")) {
                            System.out.println("Recommencez la sélection du métier.");
                        } else {
                            System.out.println("Choix invalide. Veuillez entrer 'oui' pour confirmer ou 'non' pour refuser.");
                        }
                        break;
                    case 3:
                        System.out.println("Description Guerrier");
                        System.out.println("Entrez 'oui' pour confirmer ou 'non' pour refuser.");
                        String confirmChoice3 = scanner.nextLine().trim().toLowerCase();
                        if (confirmChoice3.equals("oui")) {
                            selectedJob = new Magician();
                            System.out.println("Vous avez choisi d'être un Mage.");
                            break;
                        } else if (confirmChoice3.equals("non")) {
                            System.out.println("Recommencez la sélection du métier.");
                        } else {
                            System.out.println("Choix invalide. Veuillez entrer 'oui' pour confirmer ou 'non' pour refuser.");
                        }
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez choisir un numéro valide.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Choix invalide. Veuillez entrer un numéro valide.");
            }
        }
    
        return selectedJob;
    }
    
}


