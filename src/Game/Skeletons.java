package Game;

import java.util.Random;

public class Skeletons extends Monsters {

    protected int LameSquelettique;
    protected int LancerDos;
    protected int TempeteDeCrane;

    public Skeletons(String name) {

        super(name);
        this.Mana_max = 45;
        this.Mana_act = Mana_max;
        this.HP_max = 20;
        this.HP_act = HP_max;

    }

    public void LameSquelettique(Characters name) {

        LameSquelettique = new Random().nextInt(16);

        if (Mana_act >= 10) {

            if (LameSquelettique >= 13) {
                System.out.println(
                        "Squelette utilise Lame Squelettique et effectue un coup critique.\n" + name.getName() + " -"
                                + LameSquelettique + " HP.\n");
                super.hit(name, LameSquelettique);
                this.Mana_act -= 10;
            }

            else if (LameSquelettique >= 0) {
                System.out.println(
                        "Squelette utilise Lame Squelettique et effectue un coup critique.\n" + name.getName() + " -"
                                + LameSquelettique + " HP.\n");
                super.hit(name, LameSquelettique);
                this.Mana_act -= 10;
            }

            else {
                System.out.println("Squelette utilise Lame Squelettique mais manque son coup.\n");
            }

        }

        else {
            System.out.println("Pas assez de mana disponible.");
        }

    }

    public void LancerDos(Characters name) {
        LancerDos = new Random().nextInt(11);

        if (Mana_act >= 6) {

            if (LancerDos >= 9) {
                System.out.println(
                        "Squelette utilise Lame Squelettique et effectue un coup critique.\n" + name.getName() + " -"
                                + LancerDos + " HP.\n");
                super.hit(name, LancerDos);
                this.Mana_act -= 6;
            }

            else if (LancerDos >= 0) {
                System.out.println(
                        "Squelette utilise Lame Squelettique\n" + name.getName() + " -7"
                                + " HP.\n");
                super.hit(name, 7);
                this.Mana_act -= 6;
            }

            else {
                System.out.println("Squelette utilise Lame Squelettique mais manque son coup.\n");
            }

        }

        else {
            System.out.println("Pas assez de mana disponible.");
        }
    }

    public void TempeteDeCrane(Characters name) {
        TempeteDeCrane = new Random().nextInt(11);

        if (Mana_act >= 3) {

            if (TempeteDeCrane >= 9) {
                System.out.println(
                        "Squelette utilise Tempete De Crâne et effectue un coup critique.\n" + name.getName() + " -"
                                + TempeteDeCrane + " HP.\n");
                super.hit(name, TempeteDeCrane);
                this.Mana_act -= 3;
            }

            else if (TempeteDeCrane >= 0) {
                System.out.println(
                        "Squelette utilise Tempete De Crâne\n" + name.getName() + " -5"
                                + " HP.\n");
                super.hit(name, 5);
                this.Mana_act -= 3;
            }

            else {
                System.out.println("Squelette utilise Tempete De Crâne mais manque son coup.\n");
            }

        }

        else {
            System.out.println("Pas assez de mana disponible.");
        }
    }
}
