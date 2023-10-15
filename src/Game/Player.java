package Game;

import Game.Job.Job;
import Game.Mob.Monsters;
import Game.Pla.Places;

public class Player extends Characters {
    protected Job job;
    protected int level;
    protected int coins;
    private Places currentPlace;

    public Player(String name, Job job, Places startingPlace) {
        super(name);
        this.HP_max=job.getHp();
        this.HP_act=job.getHp();
        this.Mana_max=job.getMana();
        this.Mana_act=job.getMana();
        this.job = job;
        this.level = 1;
        this.coins = 0;
        this.currentPlace = startingPlace;
    }

    public void move(Places newPlace) {
        if (currentPlace.getAccessiblePlaces().contains(newPlace)) {
            if (currentPlace.areMonstersAlive()) {
                System.out.println("Vous ne pouvez pas vous déplacer vers " + newPlace.getName() + " car il y a des monstres !");
            } else {
                currentPlace = newPlace;
                System.out.println("Vous êtes maintenant à " + newPlace.getName());
            }
        } else {
            //System.out.println("Vous ne pouvez pas vous déplacer vers " + newPlace.getName() + " depuis " + currentPlace.getName());
        }
    }

    public void rest() {
        if (currentPlace.areMonstersAlive()) {
            System.out.println("Vous ne pouvez pas vous reposer ici car il y a des monstres !");
        } else {
            this.heal();
            if(this.Mana_max>0){
                System.out.println("Vous avez entièrement récupéré vos points de vie !\nvous avez donc "+this.HP_act+" HP et "+this.Mana_act+" Mana" );
            }else{
                System.out.println("Vous avez entièrement récupéré vos points de vie !\nvous avez donc "+this.HP_act+" HP");
            }
        }
    }
    public String getName() {
        return this.name;
    }

    public Places getCurrentPlace() {
        return currentPlace;
    }

    public Job getJob() {
        return this.job; 
    }

    public int getCoin(){
        return this.coins;
    }
    
    public int getLevel(){
        return this.level;
    }
    public void heal(){
        this.HP_act=this.HP_max;
        this.Mana_act=this.Mana_max;
    }

    public void setHP(int newHP) {
        this.HP_act = newHP;
    }

    public void lvlup(){
        this.HP_max+=this.job.getHp();
        this.Mana_max+=this.job.getMana();
        this.level+=1;
    }
    public void hit(Monsters m,int n){
        m.takeDmg(n);
    }
    public void downmana(int n){
        this.Mana_act-=n;
    }
}


