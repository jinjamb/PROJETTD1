package Game.Mob;

public class Orc extends Monsters {

    public Orc(String name) {

        super(name);
        this.HP_max = 8;
        this.HP_act = HP_max;
        this.damage = 5;
        this.texture="=-=-=-=-=-=-=-=-=-=-=                                                                                \r\n" + //
                "| NOM: NOM_JOUEUR   |                                                                                \r\n" + //
                "| LVL: NIVEAU       |                                                                                \r\n" + //
                "| PV:  Act/Max      |                                                                                \r\n" + //
                "| Mana: Act/Max     |                            &               &                                   \r\n" + //
                "|                   |                          &   &           &   &                                 \r\n" + //
                "|                   |                          &   &&&&&&&&&&&&&   &                                 \r\n" + //
                "|                   |                         &&   &&            &&&&                                \r\n" + //
                "|                   |                         &&&&      O    O     &&                                \r\n" + //
                "|                   |                         &&                   &&                                \r\n" + //
                "|                   |                         &&                   &&                                \r\n" + //
                "|                   |                         &&       &       &     &&                              \r\n" + //
                "|                   |                         &&     &&&&&&&&&&&&&   &&                              \r\n" + //
                "|                   |                            &                  &&                               \r\n" + //
                "|                   |                       &&&&   &&&&&&&&&&&&&&&&&                                 \r\n" + //
                "|                   |                     &&                       &&                                \r\n" + //
                "|                   |                  &&                            &&                              \r\n" + //
                "|                   |                  &&        &            &&     &&&&                            \r\n" + //
                "|                   |                  &&     &&                 &      &                            \r\n" + //
                "|                   |                  &&     &&                 &      &                            \r\n" + //
                "|                   |                  &&        &               &      &                            \r\n" + //
                "|                   |                     &&     &&&&&&&&&&&&&&&   &&&&                              \r\n" + //
                "|                   |                       &&&&   &&&&   &&&&                                       \r\n" + //
                "|                   |                              &&&&   &&&&                                       \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   | ============================================================================== \r\n" + //
                "| Attaque Possible: | |                                NOMDUMONSTRE                                | \r\n" + //
                "|                   | | PV:      PVMOB                                                             | \r\n" + //
                "| 1.ATTAQUE1XXXXXXXX| | ManaMob: MANAM                                                             | \r\n" + //
                "| 2.ATTAQUE2XXXXXXXX| |                                                                            | \r\n" + //
                "| 3.ATTAQUE3XXXXXXXX| |                                                                            | \r\n" + //
                "|                   | |                                                                            | \r\n" + //
                "=-=-=-=-=-=-=-=-=-=-= ============================================================================== \r\n" + //
                "";
    }

}
