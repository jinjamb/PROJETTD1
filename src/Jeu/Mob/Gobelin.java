package src.Jeu.Mob;

import java.util.Random;

import src.Jeu.Characters;

public class Gobelin extends Monsters {

    protected int FurieSanguinaire;
    protected int AttaqueSaignante;
    protected int CriDeGuerre;

    public Gobelin(String name) {

        super(name);
        this.Mana_max = 35;
        this.Mana_act = Mana_max;
        this.HP_max = 30;
        this.HP_act = HP_max;

    }

    public void FurieSanguinaire(Characters name) {

        FurieSanguinaire = new Random().nextInt(11);

        if (Mana_act >= 5) {

            if (FurieSanguinaire >= 8) {
                System.out.println(
                        "Gobelin utilise Furie Sanguinaire et effectue un coup critique.\n" + name.getName() + " -"
                                + FurieSanguinaire + " HP.\n");
                super.hit(name, FurieSanguinaire);
                this.Mana_act -= 5;
            }

            else if (FurieSanguinaire > 0) {
                System.out.println(
                        "Gobelin utilise Furie Sanguinaire.\n" + name.getName() + "-" + FurieSanguinaire + "HP\n");
                super.hit(name, FurieSanguinaire);
                this.Mana_act -= 5;
            }

            else {
                System.out.println("Gobelin utilise Furie Sanguinaire mais manque son coup.\n");
            }
        }

        else {
            System.out.println("Pas assez de mana disponible.");
        }

    }

    public void AttaqueSaignante(Characters name) {

        AttaqueSaignante = new Random().nextInt(9);

        if (Mana_act >= 3) {

            if (AttaqueSaignante >= 6) {
                System.out.println(
                        "Gobelin utilise Attaque Saignante et effectue un coup critique.\n" + name.getName() + " -"
                                + AttaqueSaignante + " HP.\n");
                super.hit(name, AttaqueSaignante);
                this.Mana_act -= 3;
            }

            else if (AttaqueSaignante > 0) {
                System.out.println(
                        "Gobelin utilise Attaque Saignante.\n" + name.getName() + " -" + AttaqueSaignante + "HP\n");
                super.hit(name, AttaqueSaignante);
                this.Mana_act -= 3;
            }

            else {
                System.out.println("Gobelin utilise Attaque Saignante mais manque son coup.\n");
            }
        }

    }

    public void CriDeGuerre(Characters name) {

        CriDeGuerre = new Random().nextInt(6);

        if (Mana_act >= 2) {

            if (CriDeGuerre >= 3) {
                System.out
                        .println("Gobelin utilise Cri De Guerre et effectue un coup critique.\n" + name.getName() + "-"
                                + CriDeGuerre + " HP.\n");
                super.hit(name, CriDeGuerre);
                this.Mana_act -= 2;
            }

            else if (CriDeGuerre > 0) {
                System.out
                        .println("Gobelin utilise Cri De Guerre.\n" + name.getName() + "-" + FurieSanguinaire + "HP\n");
                super.hit(name, CriDeGuerre);
                this.Mana_act -= 2;
            }

            else {
                System.out.println("Gobelin utilise Cri De Guerre mais manque son coup.\n");
            }
        }

    }
}
