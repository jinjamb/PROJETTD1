package src.Jeu;

public class Characters {
    protected String name;
    protected int PV_max;
    protected int PV_act;
    //protected Places place;
    protected int Mana_max;
    protected int Mana_act;

    public Characters(String name){
        this.Mana_act=0;
        this.Mana_max=0;
        this.name=name;
        this.PV_act=10;
        this.PV_max=10;

    }

    public void take_DMG(int n){
        this.PV_act-=n;
    }
    public void hit(Character name,int n){
        // name.take_DMG(n)
    }
    public void talk(String msg){
        System.out.println(this.name+" dit: "+msg);
    }
}