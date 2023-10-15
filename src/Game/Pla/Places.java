package Game.Pla;

import java.util.List;

//import Game.*;
import Game.Mob.*;
import Game.Pnj.Npc;

import java.util.ArrayList;

public abstract class Places {
    private String name;
    private List<Places> accessiblePlaces;
    private List<Monsters> monsters;
    protected String background="";
    protected List<Npc> villagers;

    public Places(String name) {
        this.name = name;
        this.accessiblePlaces = new ArrayList<>();
        this.monsters = new ArrayList<>();
        this.villagers = new ArrayList<>();
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
    public void addVillager(Npc v) {
        villagers.add(v);
    }

    public List<Monsters> getMonsters() {
        return monsters;
    }
    public List<Npc> getNpc(){
        return villagers;
    }

    public boolean hasMonsters() {
        return !monsters.isEmpty();
    }
    public String getBackground(){
        return this.background;
    }
    public boolean hasNpc(){
        return !villagers.isEmpty();
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



