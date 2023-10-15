package Game.Mob;

import Game.*;

public class Necromancer extends Monsters {

    public Necromancer(String name) {

        super(name);
        this.HP_max = 30;
        this.HP_act = HP_max;
        this.Mana_max = 10;
        this.Mana_act = Mana_max;
        this.damage = 8;
        this.attakName="coup de faux";

        this.heal=6;
        this.magicDmg=12;
        this.spellPrice=5;
        this.spellname="Transfert de vie";
        this.texture="=-=-=-=-=-=-=-=-=-=-=                                                                                \r\n" + //
                "| NOM: NOM_JOUEUR   |                                                                                \r\n" + //
                "| LVL: NIVEAU       |                                                                                \r\n" + //
                "| PV:  Act/Max      |                                   &&&&&&&&                                     \r\n" + //
                "| Mana: Act/Max     |                                &&&&&&&&&&&&&                                   \r\n" + //
                "|                   |                   &    &     &&&&&        &&&&&       &&                       \r\n" + //
                "|                   |                   &    &     &&&&  O    O  &&&&       &&&&&&&&&                \r\n" + //
                "|                   |                       &      &&&&          &&&&       &&       &&&&            \r\n" + //
                "|                   |                    &&        &&&&&&&    &&&&&&&       &&            &&         \r\n" + //
                "|                   |                   &&&&         &&&&&&&&&&&&&          &&              &&       \r\n" + //
                "|                   |                    &&          &&   &&&&   &          &&              &&       \r\n" + //
                "|                   |                              &&&&          &          &&                       \r\n" + //
                "|                   |                     &&&&     &&            &      &&&&&&                       \r\n" + //
                "|                   |                         &&&&&&&            &&&&&&&&   &&                       \r\n" + //
                "|                   |                            &&&&            &&&&       &&                       \r\n" + //
                "|                   |                            &&&&            &&&&       &&                       \r\n" + //
                "|                   |                            &                 &&&&     &&                       \r\n" + //
                "|                   |                         &&&&                 &&&&     &&                       \r\n" + //
                "|                   |                         &&                     &&     &&                       \r\n" + //
                "|                   |                         &&     &&&&       &&&  &&     &&                       \r\n" + //
                "|                   |                         &&&&&&&     &&&&&&   &&&&                              \r\n" + //
                "|                   |                                                                               \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
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

    public boolean LifeTransfer(Characters name) {

        if (Mana_act >= 5) {
            hit(name,12);

            this.HP_act += 6;
            this.Mana_act -= 5;
            return true;

        } else {
            return false;
        }

    }

}
