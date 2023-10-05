package src.Jeu;

public class Player extends Characters {
    protected Job job;
    protected int niveau;

    // Constructeur
    public class Player(Job job, int niveau) {
        this.Job = job;
        this.niveau = niveau;
    }
}