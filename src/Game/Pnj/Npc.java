package Game.Pnj;

public class Npc {

    protected String phrase;

    public Npc() {
        this.phrase = "";
    }

    public String monsterString() {
        this.phrase = "Il y a un monstre dans la zone. Au secours !";
        return phrase;
    }

    public String passiveString() {
        this.phrase = "Bonjour combattant.";
        return phrase;
    }
}
