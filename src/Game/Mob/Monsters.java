package Game.Mob;

import Game.Characters;

public abstract class Monsters extends Characters {
    String texture="";

    public Monsters(String name) {

        super(name);
        this.Mana_max = 0;
        this.Mana_act = Mana_max;
        this.HP_max = 0;
        this.HP_act = HP_max;
        this.damage = 0;

    }

    public String getTexture(){
        return this.texture;
    }
    public int getDmg(){
        return this.damage;
    }
}
