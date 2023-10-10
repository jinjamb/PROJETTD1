package src.Jeu;

public class Main {
    public static void main(String[] args) {
        Characters popo = new Characters("popo");
        Gobelin Dmitroff = new Gobelin("Dmitroff");
        System.out.println(Dmitroff.getHP());
        System.out.println(popo.getHP());
        Dmitroff.FurieSanguinaire(popo);
        System.out.println(popo.getHP());
    }

}