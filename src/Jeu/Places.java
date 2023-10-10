package src.Jeu;

import java.util.List;
import java.util.ArrayList;

public class Places {
    private String name;
    private List<Places> accessiblePlaces;
    private List<Monsters> monsters;
    protected String background;

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
}



