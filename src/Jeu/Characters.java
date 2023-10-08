package Jeu;

public class Characters {
    protected String name;
    protected int HP_max;
    protected int HP_act;
    //protected Places place;
    protected int Mana_max;
    protected int Mana_act;

    public Characters(String name){
        this.Mana_act=0;
        this.Mana_max=0;
        this.name=name;
        this.HP_act=10;
        this.HP_max=10;

    }

    public void take_DMG(int n){
        this.HP_act-=n;
    }
    public void hit(Characters name,int n){
        name.take_DMG(n);
    }
    public void talk(String msg){
        System.out.println(this.name+" dit: "+msg);
    }
    public int Get_HP(){
        return this.HP_act;
    }
    public int Get_HPMax(){
        return this.HP_max;
    }
}