package src.Jeu.Mob;

public class Bat extends Monsters {

    public Bat(String name) {

        super(name);
        this.HP_max = 6;
        this.HP_act = HP_max;
        this.damage = 5;

    }

}
