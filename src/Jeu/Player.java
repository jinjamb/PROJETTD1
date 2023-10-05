package src.Jeu;

public class Player extends Characters {
    protected Job job;
    protected int level;
    private Places currentPlace;

    public Player(String name, Job job, Places startingPlace) {
        super(name);
        this.job = job;
        this.level = 1;
        this.currentPlace = startingPlace;
    }

    public void move(Places newPlace) {
        if (currentPlace.getAccessiblePlaces().contains(newPlace)) {
            if (newPlace.hasMonsters()) {
                System.out.println("You cannot move to " + newPlace.getName() + " as there are monsters!");
            } else {
                currentPlace = newPlace;
                System.out.println("You have moved to " + newPlace.getName());
            }
        } else {
            System.out.println("You cannot move to " + newPlace.getName() + " from " + currentPlace.getName());
        }
    }

    public void rest() {
        if (currentPlace.hasMonsters()) {
            System.out.println("You cannot rest here as there are monsters!");
        } else {
            PV_act = PV_max;
            System.out.println("You have fully recovered your hit points!");
        }
    }
}

