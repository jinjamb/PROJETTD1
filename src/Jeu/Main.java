package src.Jeu;

public class Main {
    public static void main(String[] args) {
        Gobelin Dmitroff = new Gobelin("Dmitroff");
        Skeletons Nikomok = new Skeletons("Nikomok");
        System.out.println(Dmitroff.getHP());
        System.out.println(Nikomok.getHP());
        Dmitroff.FurieSanguinaire(Nikomok);
        System.out.println(Nikomok.getHP());
        Nikomok.LameSquelettique(Dmitroff);
        System.out.println(Dmitroff.getHP());
    }

}