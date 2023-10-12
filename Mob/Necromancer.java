package Game.Mob;

import Game.*;

public class Necromancer extends Monsters {

    public Necromancer(String name) {

        super(name);
        this.HP_max = 30;
        this.HP_act = HP_max;
        this.Mana_max = 10;
        this.Mana_act = Mana_max;
        this.damage = 8;

    }

    public void LifeTransfer(Characters name) {

        if (Mana_act >= 5) {

            this.damage = 12;
            super.Attack(name);
            this.HP_act += 6;
            this.damage = 8;
            this.Mana_act -= 5;

        } else {

            System.out.println("Mana insuffisante.");

        }

    }

}
