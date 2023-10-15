package Game.Pnj;

import Game.Characters;

public class Npc extends Characters{
    protected String nom;
    protected String phrase;
    protected String texture;

    public Npc(String nom) {
        super(nom);
        this.nom=nom;

    }

    public String monsterString() {
        this.phrase = "";
        return phrase;
    }

    public String passiveString() {
        this.phrase = "Bonjour combattant.";
        return phrase;
    }

    public String getTexture(){
        return texture;
    }
    public String getPhrase(){
        return this.phrase;
    }
}
