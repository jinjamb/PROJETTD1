package src.Jeu;
import java.util.Random;

public class Characters {
    protected String name;
    protected int HP_max;
    protected int HP_act;
    //protected Places place;
    protected int Mana_max;
    protected int Mana_act;
    protected int damage;

    public Characters(String name){
        this.Mana_act=0;
        this.Mana_max=0;
        this.name=name;
        this.HP_act=10;
        this.HP_max=10;
        this.damage=3;

    }

    public void take_DMG(int n){
        this.HP_act-=n;
    }
    public void hit(Characters target) {
        double successProbability = 0.7;
        Random random = new Random();
        double randomValue = random.nextDouble();

        if (randomValue <= successProbability) {
            int dmg = this.damage;
            target.take_DMG(dmg);
            System.out.println(this.name + " attaque " + target.name + " et inflige " + damage + " dégâts.");
        } else {
            System.out.println(this.name + " a raté son attaque contre " + target.name + ".");
        }
    }
    public void talk(String msg){
        System.out.println(this.name+" dit: "+msg);
    }
    public int Get_HP(){
        return HP_act;
    }
    public int Get_HPMax(){
        return this.HP_max;
    }
}