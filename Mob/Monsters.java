package Game.Mob;

import Game.Characters;

public abstract class Monsters extends Characters {

    public Monsters(String name) {

        super(name);
        this.Mana_max = 0;
        this.Mana_act = Mana_max;
        this.HP_max = 0;
        this.HP_act = HP_max;
        this.damage = 0;

    }

    public void Attack(Characters name) {

        super.hit(name, damage);

    }
}
