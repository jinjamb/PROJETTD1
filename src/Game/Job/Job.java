package Game.Job;

import java.util.Scanner;

import Game.*;
import Game.Ite.*;

public class Job{
    private String name;
    protected int hp;
    protected Items item;
    protected String Illustration;
    protected String Pres;

    public Job(String name) {
        this.name = name;
        this.Pres="=-=-=-=-=-=-=-=-=-=-=                                                                                \r\n" + //
                "| NOM: NOM_JOUEUR   |                              CHOISIR UN METIER                                 \r\n" + //
                "| LVL: 1            |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |           1.Barbare                   |              2.Guerrier                \r\n" + //
                "|                   |                                       |                                        \r\n" + //
                "|                   |                                       |        &&&&&&&&&                       \r\n" + //
                "|                   |                                       |       &&&&&&&&&&&                      \r\n" + //
                "|                   |                            &   &&     |       &&       &&                      \r\n" + //
                "|                   |     &&         &&       &&&&&&&&&     |       &&&&   &&&&            &&        \r\n" + //
                "|                   |     &&  &&&&   &&       &&&&&&&&&     |                              &&        \r\n" + //
                "|                   |     &&&&     &&&&          &   &&     |     &&&&&&   &&&&&&          &&        \r\n" + //
                "|                   |   &              &&        &          |     &&&&&&&&&&&&&&&          &&        \r\n" + //
                "|                   |   &&&&&&&&&&&&&&&&&        &          |     &&&&&&&&&&&&&&&          &&        \r\n" + //
                "|                   |   & &   &   &   & &        &          |         &&&&&&&&             &&        \r\n" + //
                "|                   |   &&&&&&&&&&&&&&&&&        &          |         &&&&&&&&           &&&&&&      \r\n" + //
                "|                   |                            &          |         &&&&&&&&             &&        \r\n" + //
                "|                   |                                       |                                        \r\n" + //
                "|                   |                                       |                                        \r\n" + //
                "|                   |==============================================================================  \r\n" + //
                "|                   |                                 3.Magicien                                     \r\n" + //
                "|                   |                                                  &&&                           \r\n" + //
                "|                   |                       &&&&&&                  &   &   &                        \r\n" + //
                "|                   |                       &    &                   &&   &&                         \r\n" + //
                "|                   |                       &    &                      &                            \r\n" + //
                "|                   |                       &    &                      &                            \r\n" + //
                "|                   |                     &&       &&                   &                            \r\n" + //
                "|                   |                   &            &&                 &                            \r\n" + //
                "|                   |                   &            &&                 &                            \r\n" + //
                "|                   |                   &            &&                 &                            \r\n" + //
                "|                   |                     &&       &&                   &                            \r\n" + //
                "|                   |                       &&&&&&                      &                            \r\n" + //
                "|                   |                                                                                \r\n" + //
                "=-=-=-=-=-=-=-=-=-=-=                                                                                \r\n" + //
                "";
    }

    public String getName() {
        return name;
    }

    public static Job chooseJob(Scanner scanner) {
        Job selectedJob = new Job("null");
    
        while (selectedJob.name.equals("null")) {
            System.out.println(selectedJob.Pres);
    
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
                            System.out.println("Vous avez choisi d'être un Guerrier.");
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
                            selectedJob = new Magician();
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
                            System.out.println("Vous avez choisi d'être un Guerrier.");
                            break;
                        } else if (confirmChoice3.equals("non")) {
                            System.out.println("Recommencez la sélection du métier.");
                        } else {
                            System.out.println("Choix invalide. Veuillez entrer 'oui' pour confirmer ou 'non' pour refuser.");
                        }
                        break;
                    case 4:
                        System.out.println("Description des métiers :");
                        System.out.println("1. Guerrier : Un combattant spécialisé dans la force brute.");
                        System.out.println("2. Mage : Un utilisateur de la magie avec de puissants sorts.");
                        System.out.println("3. Archer : Un tireur d'élite avec une grande précision.");
                        System.out.println("Entrez 'oui' pour confirmer ou 'non' pour refuser.");
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


