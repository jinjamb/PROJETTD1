package Game.Mob;

import Game.Characters;

public class Monsters extends Characters {

    public Monsters(String name) {
        
        super(name);
        this.Mana_max = 0;
        this.Mana_act = Mana_max;
        this.HP_max = 15;
        this.HP_act = HP_max;

    }
}
