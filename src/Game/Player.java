package Game;

import Game.DPlaces.*;
public class Player extends Characters {
    protected Job job;
    protected int level;
    protected int coins;
    private Places currentPlace;

    public Player(String name, Job job, Places startingPlace) {
        super(name);
        this.job = job;
        this.level = 1;
        this.coins = 0;
        this.currentPlace = startingPlace;
    }

    public void move(Places newPlace) {
        if (currentPlace.getAccessiblePlaces().contains(newPlace)) {
            if (currentPlace.hasMonsters()) {
                System.out.println("Vous ne pouvez pas vous déplacer vers " + newPlace.getName() + " car il y a des monstres !");
            } else {
                currentPlace = newPlace;
                System.out.println("Vous êtes maintenant à " + newPlace.getName());
            }
        } else {
            System.out.println("Vous ne pouvez pas vous déplacer vers " + newPlace.getName() + " depuis " + currentPlace.getName());
        }
    }

    public void rest() {
        if (currentPlace.hasMonsters()) {
            System.out.println("Vous ne pouvez pas vous reposer ici car il y a des monstres !");
        } else {
            HP_act = HP_max;
            System.out.println("Vous avez entièrement récupéré vos points de vie !");
        }
    }
    public String getName() {
        return this.name;
    }

    public Places getCurrentPlace() {
        return currentPlace;
    }

    public String getJob() {
        return job.getName(); 
    }

    public int getCoin(){
        return this.coins;
    }
    
    public int getLevel(){
        return this.level;
    }
}


