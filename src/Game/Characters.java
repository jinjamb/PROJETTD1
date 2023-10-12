package Game;

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

    public String getName(){
        return this.name;
    }

    public void takeDmg(int n){
        this.HP_act-=n;
    }
    public void hit(Characters name, int n) {
        name.takeDmg(n);
    }


    public void talk(String msg){
        System.out.println(this.name+" dit: "+msg);
    }
    public int getHP(){
        return HP_act;
    }
    public int getHPMax(){
        return this.HP_max;
    }
}