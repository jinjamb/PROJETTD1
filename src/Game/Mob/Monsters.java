package Game.Mob;

import Game.Characters;
import java.util.Random;

public abstract class Monsters extends Characters {
    String texture="";
    String attakName;
    int magicDmg=0;
    int heal=0;
    int spellPrice=0;
    String spellname="";

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
    public boolean spell(Characters p){
        if(this.Mana_act<this.spellPrice){
            hit(p,this.getDmg());
            return false;
        }else{
            Random r = new Random();
            int n = r.nextInt(2);
            if (n==1){
                this.hit(p,this.magicDmg);
                this.Mana_act-=this.spellPrice;


                this.HP_act+=this.heal;
                if(this.HP_act>this.HP_max){this.HP_act=this.HP_max;}
                return true;
            }else{
                this.hit(p,this.getDmg());
                return false;
            }
        }
    }
    public int getMagicDmg(){
        return this.magicDmg;
    }
    public String getSpellName(){
        return this.spellname;
    }
    public String getAttakName(){
        return this.attakName;
    }
}
