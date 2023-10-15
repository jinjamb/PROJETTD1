package Game.Job;

import Game.Ite.*;
import Game.Mob.Monsters;
import Game.*;

public class Magician extends Job {
    public Magician() {
        super("Mage");
        this.hp=7;
        this.mana=4;
        this.item= new Stick();
        this.Illustration="=-=-=-=-=-=-=-=-=-=-=                         &   &                                                  \r\n" + //
                "| NOM: NOM_JOUEUR   |                     &  &&  &                                                   \r\n" + //
                "| LVL: 1            |                      & &  &  &                                                 \r\n" + //
                "|                   |                       & & & &                                                  \r\n" + //
                "|                   |                           &                          &                         \r\n" + //
                "|                   |                        &   &                        &&&                        \r\n" + //
                "|                   |                        &   &                      &  &  &                      \r\n" + //
                "|                   |                        &   &                       &   &                       \r\n" + //
                "|                   |                        &&  &                        &&&                        \r\n" + //
                "|                   |                        & &&&                         &                         \r\n" + //
                "|                   |                        &   &                         &                         \r\n" + //
                "|                   |                      &&&   &&&                       &                         \r\n" + //
                "|                   |                    &&&       &&&                     &                         \r\n" + //
                "|                   |                    &      &    &                     &                         \r\n" + //
                "|                   |                   &&           &&                    &                         \r\n" + //
                "|                   |                   &  &  &       &                    &                         \r\n" + //
                "|                   |                   &         &   &                    &                         \r\n" + //
                "|                   |                   &    &  &     &                    &                         \r\n" + //
                "|                   |                   && &      &  &&                    &                         \r\n" + //
                "|                   |                    &&         &&                     &                         \r\n" + //
                "|                   |                     &&&  &  &&&                      &                         \r\n" + //
                "|                   |                       &&&&&&&                        &                         \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |   =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=  \r\n" + //
                "|                   |   |                                  Magicien                               |  \r\n" + //
                "|                   |   |                                                                         |  \r\n" + //
                "|                   |   |  Point de vie:  7 PV par niveaux                                        |  \r\n" + //
                "|                   |   |  Objet: - Baton (2 dégats)                                              |  \r\n" + //
                "|                   |   |  Rajoute une stat de mana pour lancer des sorts:                        |  \r\n" + //
                "|                   |   |         - Rayon de givre (4 dégats/cout 2)                              |  \r\n" + //
                "|                   |   |         - Boule de feu (15 dégats/cout 9)                               |  \r\n" + //
                "|                   |   |                                                                         |  \r\n" + //
                "|                   |   |         1.Choisir                             2.Retour                  |  \r\n" + //
                "=-=-=-=-=-=-=-=-=-=-=   =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=  \r\n" + //
                "";
    }

    public boolean rayon(Characters p,Monsters m){
        if (this.mana>0){
            this.mana-=2;
        }
        return true;
    }

}
