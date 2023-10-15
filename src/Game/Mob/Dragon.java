package Game.Mob;

import Game.*;

public class Dragon extends Monsters {

    public Dragon(String name) {

        super(name);
        this.HP_max = 70;
        this.HP_act = HP_max;
        this.Mana_max = 24;
        this.Mana_act = Mana_max;
        this.damage = 12;

        this.heal=0;
        this.magicDmg=20;
        this.spellPrice=8;

        this.texture="=-=-=-=-=-=-=-=-=-=-=                                                             &&&       &&&&     \r\n" + //
                "| NOM: NOM_JOUEUR   |                                                            &&&&     &&&&    && \r\n" + //
                "| LVL: NIVEAU       |                                                         &&&&&&&     &&&&&&&&   \r\n" + //
                "| PV:  Act/Max      |                                                        &&&&&      &&&&&&&&     \r\n" + //
                "| Mana: Act/Max     |                                                       &&         &&&&&         \r\n" + //
                "|                   |                                                         &&&&&&&&&             &\r\n" + //
                "|                   |                                                       &&&&&&&&&&&&&&&&     &&&&\r\n" + //
                "|                   |                                                     &&&&&&&&&&&&&&&&&&&&&&&&&&&\r\n" + //
                "|                   |                                           &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\r\n" + //
                "|                   |                                         &&  &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\r\n" + //
                "|                   |            &&&&&&&&&&&                       &&&&&&&&&&&&&&&&&&&&&&&&&&&    && \r\n" + //
                "|                   |         &&&&&&&&&&&&&&&&&&&&&&&&&        &&&&&&&&&&&&&&&&&     &&&&&&&&&&&     \r\n" + //
                "|                   |         && &&&&&&&&&&&  &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&       &&&&&&&&&&&&&&&&&&\r\n" + //
                "|                   |             &&&&&&&     &&&&&&&&&&&&&&&&&&&&&&&&&&&        &&&&&&&&&&&&&&&&&&&&\r\n" + //
                "|                   |         &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\r\n" + //
                "|                   |         &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\r\n" + //
                "|                   |         &      &&&&&&&&&&&&&        &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& \r\n" + //
                "|                   |   &&&&     &&&&  &&                   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&  \r\n" + //
                "|                  &&&&   &&&&&&     &&&             &&&&    &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&  &&&&&&&\r\n" + //
                "|                   |&           &    & &&&&       &&&&&&&&& &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&    &&&&\r\n" + //
                "|                  &&            &&&&&&     &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&   &&&&\r\n" + //
                "|                   |            &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&    &&&\r\n" + //
                "|                   |            &&&&&&&&&&&&&&&&&&&&&&&&&&&              &&&&&&&&&&&&&&&&&&       &&\r\n" + //
                "|                   |              &&&&&&&&&&&&&&&                               &&&&&&&&    &&&&&   \r\n" + //
                "|                   |                                         &&&&&&&&&&&                &&&&&&&&&&& \r\n" + //
                "|                   |                                       &&&&&&&&&&&&&&&&       &&&&&&&&&&&&&&&&&&\r\n" + //
                "|                   | ======================================&&&==&&===&&=========&&&&===&&&&&&=&&&&&&\r\n" + //
                "| Attaque Possible: | |                                Drag && n &&    &         &&&    &&&&&   &&&| \r\n" + //
                "|                   | | PV:      PVMOB                        &    &              &&    &&&&    &&&| \r\n" + //
                "| 1.ATTAQUE1XXXXXXXX| | ManaMob: MANAM                                              &     &&     &&| \r\n" + //
                "| 2.ATTAQUE2XXXXXXXX| |                                                                     &&     & \r\n" + //
                "| 3.ATTAQUE3XXXXXXXX| |                                                                            | \r\n" + //
                "|                   | |                                                                            | \r\n" + //
                "=-=-=-=-=-=-=-=-=-=-= ============================================================================== \r\n" + //
                "";

    }

    public void DragonBreath(Characters name) {

        if (Mana_act >= 8) {
            hit(name,20);

            this.Mana_act -= 8;

        } else {
            hit(name,this.damage);
        }

    }


}
