package src.Jeu;

public class Player extends Characters {
    protected Job job;
    protected int level;

    public Player(String name, Job job) {
        super(name); 
        this.job = job;
        this.level = 1; 
    }

    public void rest(){
        if(true){
            this.PV_act=this.PV_max;
            System.out.println("You have fully recovered your hit points!");
        }
        else{
            System.out.println("You cannot rest here as there are still monsters around!");
        }
    }
}
