package src.Jeu;


public class Main{
    public static void main(String[] args) {
        Characters popo = new Characters("popo");
        popo.talk("salut");
        Monsters lemo = new Monsters("lemo");

        lemo.talk("JE VAIS TE BUT2");

        popo.Get_PV();
        lemo.hit(popo,4);
        popo.Get_PV();

    }

}
