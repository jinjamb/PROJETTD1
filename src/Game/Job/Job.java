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
        this.Illustration="=-=-=-=-=-=-=-=-=-=-=                                                                                \r\n" + //
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
                this.Pres=this.Illustration;
    }

    public String getName() {
        return name;
    }

    public static Job chooseJob(String name,Scanner scanner) {
        Job selectedJob = new Job("null");

        boolean select=true;
    
        while (select) {
            Show.PrintChoice(name,selectedJob);
            
            System.out.print("Choix:");
            String choiceStr = scanner.nextLine();
    
            try {
                int choice = Integer.parseInt(choiceStr);
    
                switch (choice) {
                    case 1:
                        selectedJob = new Barbarian();
                        System.out.println("bar");
                        break;
                    case 2:
                        selectedJob = new Warrior();
                        System.out.println("war");
                        break;
                    case 3:
                        selectedJob = new Magician();
                        System.out.println("mag");
                        break;
                        
                    default:
                        System.out.println("Choix invalide. Veuillez choisir un numéro valide.");
                        break;
                    }
            } catch (NumberFormatException e) {
                System.out.println("Choix invalide. Veuillez entrer un numéro valide.");
                System.out.print("Choix:");
            }
            Show.PrintChoice(name,selectedJob);
            System.out.print("Choix:");
            int confirmChoice1 = Integer.parseInt(scanner.nextLine());
            if (confirmChoice1==1) {
                break;
            } else if (confirmChoice1==2) {
                selectedJob.Illustration=selectedJob.Pres;
            } else {
                System.out.println("Choix invalide.");
                System.out.print("Choix:");
            }
 
        }

        return selectedJob;
    }
    public String getIllu(){
        return this.Illustration;
    }
}


