package Jeu

public class Player extends Characters {
    protected Metier metier;
    protected int niveau;

    // Constructeur
    public Player(Metier metier, int niveau) {
        this.metier = metier;
        this.niveau = niveau;
    }