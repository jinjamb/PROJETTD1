package src.Jeu.Mob;


public class Gobelin extends Monsters {

    public Gobelin(String name) {

        super(name);
        this.HP_max = 4;
        this.HP_act = HP_max;
        this.damage = 4;

    }

}