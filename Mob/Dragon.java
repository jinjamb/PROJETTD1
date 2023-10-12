package Game.Mob;

import Game.*;

public class Dragon extends Monsters {

    public Dragon(String name) {

        super(name);
        this.HP_max = 70;
        this.HP_act = HP_max;
        this.Mana_max = 24;
        this.Mana_act = Mana_max;
        this.damage = 12;

    }

    public void DragonBreath(Characters name) {

        if (Mana_act >= 8) {

            this.damage = 20;
            super.Attack(name);
            this.HP_act += 6;
            this.damage = 12;
            this.Mana_act -= 8;

        } else {

            System.out.println("Mana insuffisante.");

        }

    }

}
