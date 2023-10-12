package Game;
import java.util.List;
import java.util.Scanner;

import Game.Job.*;
import Game.Mob.*;
import Game.Pla.*;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Places padhiver = new Padhiver();
        Places northraod = new Route_Nord();
        Places southroad = new Route_Sud();
        Places forest = new Foret();
        Places marsh = new Marrais();
        Places crypt = new Crypte();
        Places volcano = new Volcan();

        padhiver.addAccessiblePlace(southroad);
        padhiver.addAccessiblePlace(northraod);
        northraod.addAccessiblePlace(forest);
        northraod.addAccessiblePlace(padhiver);
        southroad.addAccessiblePlace(marsh);
        southroad.addAccessiblePlace(padhiver);
        forest.addAccessiblePlace(northraod);
        forest.addAccessiblePlace(volcano);
        marsh.addAccessiblePlace(crypt);
        marsh.addAccessiblePlace(southroad);
        crypt.addAccessiblePlace(marsh);
        volcano.addAccessiblePlace(forest);

        Gobelin gobelin1 = new Gobelin("Dmitroff");
        forest.addGobelin(gobelin1);


    }
}




