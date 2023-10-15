package Game.Pla;

import java.util.List;

//import Game.*;
import Game.Mob.*;

import java.util.ArrayList;

public abstract class Places {
    private String name;
    private List<Places> accessiblePlaces;
    private List<Monsters> monsters;
    private List<Gobelin> gobelins = new ArrayList<>();
    protected String background="";

    public Places(String name) {
        this.name = name;
        this.accessiblePlaces = new ArrayList<>();
        this.monsters = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAccessiblePlace(Places place) {
        accessiblePlaces.add(place);
    }

    public List<Places> getAccessiblePlaces() {
        return accessiblePlaces;
    }

    public void addMonster(Monsters monster) {
        monsters.add(monster);
    }

    public List<Monsters> getMonsters() {
        return monsters;
    }

    public boolean hasMonsters() {
        return !monsters.isEmpty();
    }
    public String getBackground(){
        return this.background;
    }
    public List<Gobelin> getGobelins() {
        return gobelins;
    }
    public void addGobelin(Gobelin gobelin) {
        gobelins.add(gobelin);
    }
    public boolean areMonstersAlive() {
        List<Monsters> monstersInPlace = this.getMonsters();
        for (Monsters monster : monstersInPlace) {
            if (monster.getHP() > 0) {
                return true;
            }
        }
        return false;
    }
}



