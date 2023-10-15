package Game.Ite;

public abstract class Items {
    protected String name;
    protected int dmg;

    public Items(String name){
        this.name=name;
    }

    public int getDmg() {
        return this.dmg;
    }
    public String getName(){
        return this.name;
    }
}
