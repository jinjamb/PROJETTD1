package Game.Job;

import java.util.Scanner;


import Game.*;
import Game.Ite.*;

public class Job{
    private String name;
    protected int hp;
    protected int mana;
    protected Items item;
    protected String Illustration;
    protected String Pres;
    protected String attakname;

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
    public String getAttakName(){
        return this.attakname;
    }


    public static Job chooseJob(String name,Scanner scanner) {
        Job selectedJob = new Job("null");

        boolean confirm=false;
        boolean choix=false;


        Show.PrintChoice(name,selectedJob);

        while (!choix) {
            
            System.out.print("Choix:");
            
            String choiceStr = scanner.nextLine();
            try {
                int choice = Integer.parseInt(choiceStr);
                if(choice==1){selectedJob = new Barbarian();}
                else if(choice==2){selectedJob = new Warrior();}
                else if(choice==3){selectedJob = new Magician();}
                else{
                    System.out.println("Choix invalide. Veuillez choisir un numéro valide.");
                    continue;
                }
                Show.PrintChoice(name,selectedJob);
                while(!confirm){
                    
                    System.out.print("Choix:");
                    try{
                        choiceStr = scanner.nextLine();
                        int confirmChoice1 = Integer.parseInt(choiceStr);
                        if (confirmChoice1==1) {
                            choix=true;
                            confirm=true;
                            break;
                        } else if (confirmChoice1==2) {
                            selectedJob.Illustration=selectedJob.Pres;
                            Show.PrintChoice(name,selectedJob);
                            break;
                        } else {
                            System.out.println("Choix invalide.");
                            System.out.print("Choix:");
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Choix invalide.");
                        System.out.print("Choix:");
                    }
                }

                } catch (NumberFormatException e) {
                    System.out.println("Choix invalide. Veuillez entrer un numéro valide.");
                    System.out.print("Choix:");
                    continue;
                }

            
            
 
        }   
        return selectedJob;
    }
    
    public String getIllu(){
        return this.Illustration;
    }
    public Items getItem(){
        return this.item;
    }

    public int getDmg(int lvl){
        if(lvl<3){
            return this.getItem().getDmg();
        }else if(lvl<6){
            return 2*this.getItem().getDmg();
        }else if(lvl<9){
            return 3*this.getItem().getDmg();
        }else{
            return 4*this.getItem().getDmg();
        }
    }

    public int getHp(){
        return this.hp;
    }
    public int getMana(){
        return this.mana;
    }
    public String getNomItem(){
        return this.item.getName();
    }
}


