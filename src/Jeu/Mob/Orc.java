package src.Jeu.Mob;

public class Orc extends Monsters {

    public Orc(String name) {

        super(name);
        this.HP_max = 8;
        this.HP_act = HP_max;
        this.damage = 5;

    }

}
