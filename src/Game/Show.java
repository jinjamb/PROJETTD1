package Game;

import java.util.List;
import java.util.Scanner;

import Game.Job.*;
import Game.Mob.Monsters;
import Game.Pla.Places;
import Game.Pnj.*;

public class Show{
    


    public static void PrintPlace(Player p,int action){
        Places place=p.getCurrentPlace();
        String bg=place.getBackground();

        bg=palyerStats(bg, p);


        //if p.hasmagie()

        String ActDescrip="";
        String Act1="";
        String posi1="";

        String Act2="";
        String posi2="";

        String Act3="";
        String posi3="";

        String Act4="";
        String posi4="";

        if(action==0){
            ActDescrip="";
            Act1="1.se deplacer";
            Act2="2.se battre";
            Act3="3.se reposer";
            Act4="4.parler avec";
            if(place.areMonstersAlive()){
                posi1="(Impossible)";
                posi2="(Possible)";
                posi3="(Impossible)";
                
            }else{
                posi1="(Possible)";
                posi2="(Impossible)";
                posi3="(Possible)";
                
            }
            if(place.hasNpc()){
                posi4="(Possible)";
            }else{
                posi4="(Impossible)";
            }
        }

        else if(action==1){
            ActDescrip="Lieux:";
            List<Places> accessiblePlaces = place.getAccessiblePlaces();
            Act1="1."+accessiblePlaces.get(0).getName();

            if(accessiblePlaces.size()==2){
                Act2="2."+accessiblePlaces.get(1).getName();
            }
            Act3="";
            Act4="";
        }
        else if(action==2){
            ActDescrip="Monstres:";
            Monsters m1=place.getMonsters().get(0);
            Act1="1."+m1.getName();
            if(m1.getHP()<=0){posi1="(Mort)";}else{posi1="(Vivant)";}

            if(place.getMonsters().size()>=2){
                Monsters m2=place.getMonsters().get(1);
                Act2="2."+m2.getName();
                if(m2.getHP()<=0){posi2="(Mort)";}else{posi2="(Vivant)";}
            }
            if(place.getMonsters().size()>=3){
                Monsters m3=place.getMonsters().get(2);
                Act3="3."+m3.getName();
                if(m3.getHP()<=0){posi3="(Mort)";}else{posi3="(Vivant)";}
            }
        }
        else if(action==3){
            ActDescrip="Villageois:";
            Npc m1=place.getNpc().get(0);
            Act1="1."+m1.getName();
            
            if(place.getNpc().size()>=2){
                Npc m2=place.getNpc().get(1);
                Act2="2."+m2.getName();
            }
        }
        ActDescrip = complet(ActDescrip,"AAAAAAAAAAAAAA");
        Act1 = complet(Act1, "1.BBBBBBBBBBBBBBB");
        Act2 = complet(Act2, "2.BBBBBBBBBBBBBBB");
        Act3 = complet(Act3, "3.DDDDDDDDDDDDDD");
        Act4 = complet(Act4, "4.EEEEEEEEEEEEEE");
        posi1 = complet(posi1, "bbbbbbbbbbbb");
        posi2 = complet(posi2, "bbbbbbbbbbbb");
        posi3 = complet(posi3, "bbbbbbbbbbbb");
        posi4 = complet(posi4, "bbbbbbbbbbbb");

        bg = bg.replace("AAAAAAAAAAAAAA", ActDescrip);
        bg = bg.replace("1.BBBBBBBBBBBBBBB",Act1);
        bg = bg.replace("bbbbbbbbbbbb",posi1);

        bg = bg.replace("2.CCCCCCCCCCCCCCC",Act2);
        bg = bg.replace("cccccccccccc",posi2);

        bg = bg.replace("3.DDDDDDDDDDDDDD",Act3);
        bg = bg.replace("dddddddddddd",posi3);

        bg = bg.replace("4.EEEEEEEEEEEEEE",Act4);
        bg = bg.replace("eeeeeeeeeeee",posi4);

        System.out.println(bg);
    }




    public static void PrintChoice(String Name,Job job){
        for(int i=Name.length();i<"Nom_Joueur".length();i++){Name += " ";}
        
        String Illu=job.getIllu();
        Illu = Illu.replace("NOM_JOUEUR",Name);

        System.out.println(Illu);
    }


    public static String complet(String base,String patern){
        for(int i=base.length();i<patern.length();i++){base+=" ";}
        return base;
    }

    public static String palyerStats(String patern,Player p){
        String bg=patern;
        String name=p.getName();
        String HP =  String.valueOf(p.getHP());
        String HPMax = String.valueOf(p.getHPMax());
        String Lvl = String.valueOf(p.getLevel());
        String Mana="";
        String HPAndMax = HP +"/"+ HPMax;
        if(p.getManaMax()!=0){
            Mana="Mana: "+p.getMana()+"/"+p.getManaMax();
        }

        Mana=complet(Mana,"Mana: Act/Max");
        name=complet(name, "NOM_JOUEUR");
        HPAndMax = complet(HPAndMax,"ACT/MAX");
        Lvl=complet(Lvl,"NIVEAU");

        bg = bg.replace("Mana: Act/Max", Mana);
        bg = bg.replace("NOM_JOUEUR",name);
        bg = bg.replace("Act/Max", HPAndMax);
        bg = bg.replace("NIVEAU", Lvl);

        return bg;
    }

    public static void talk(Player p,Npc npc,boolean monstre){
        String bg= npc.getTexture();
        bg = palyerStats(bg, p);
        String phrase="";
        if(monstre){
            phrase="Au secours, des MONSTRES !!!";
        }else{
            phrase=npc.getPhrase();
        }
        phrase = complet(phrase, "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
        bg = bg.replace("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF", phrase);

        System.out.println(bg);
    }

    public static void fight(Player p,Monsters m){
        String bg=m.getTexture();
        bg=palyerStats(bg, p);

        String nom=m.getName();
        String PV=String.valueOf(m.getHP())+"/"+m.getHPMax();
        String Mana="";

        String att1="coup de "+ p.getJob().getNomItem();
        String att2="";
        String att3="";

        if(p.getManaMax()!=0){
            att2="Rayon de givre";
            att3="Boule de feu";
        }

        if(m.getManaMax()!=0){
            Mana="ManaMob: "+m.getMana()+"/"+m.getManaMax();
        }
        
        att1 = complet(att1,"ATTAQUE1XXXXXXXX");
        att2 = complet(att2,"ATTAQUE2XXXXXXXX");
        att3 = complet(att3,"ATTAQUE3XXXXXXXX");

        nom=complet(nom,"NOMDUMONSTRE");
        PV = complet(PV,"PVMOBBB");
        Mana=complet(Mana,"ManaMob: MANAMMM");

        bg = bg.replace("NOMDUMONSTRE", nom);
        bg = bg.replace("PVMOBBB", PV);
        bg = bg.replace("ManaMob: MANAMMM",Mana);
        bg = bg.replace("ATTAQUE1XXXXXXXX", att1);
        bg = bg.replace("ATTAQUE2XXXXXXXX", att2);
        bg = bg.replace("ATTAQUE3XXXXXXXX", att3);

        System.out.println(bg);
    }

    public static void fin(Player p,boolean vic,Scanner scan){
        String bg;
        String defaite=
                "=-=-=-=-=-=-=-=-=-=-=                                                                                \r\n" + //
                "| NOM: NOM_JOUEUR   |                                                                                \r\n" + //
                "| LVL: NIVEAU       |                                                                                \r\n" + //
                "| PV:  Act/Max      |                                                                                \r\n" + //
                "| Mana: Act/Max     |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                         &&                                                     \r\n" + //
                "|                   |   &&&&&&&&&&          &&          &&&&              &&  &&                     \r\n" + //
                "|                   |   &        &&&&                &&                       &&                     \r\n" + //
                "|                   |   &          &&     &&&&&&   &&&&&&   &&&&&&&&&     &&  &&&&&&&   &&&&&&&&     \r\n" + //
                "|                   |   &          &&   &        &   &&            &&     &&  &&        &     &&     \r\n" + //
                "|                   |   &          &&   &&&&&&&&&&   &&       &&&&&&&     &&  &&        &&&&&&&&     \r\n" + //
                "|                   |   &          &&   &            &&     &&     &&     &&  &&        &            \r\n" + //
                "|                   |   &        &&&&   &&&&         &&     &&     &&     &&  &&        &            \r\n" + //
                "|                   |   &&&&&&&&&&        &&&&&&&&   &&     &&&&&&&&&     &&  &&&&&&&     &&&&&&     \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "=-=-=-=-=-=-=-=-=-=-=                                                                                \r\n" + //
                "";
        String Victoire="=-=-=-=-=-=-=-=-=-=-=                                                                                \r\n" + //
                "| NOM: NOM_JOUEUR   |                                                                                \r\n" + //
                "| LVL: NIVEAU       |                                                                                \r\n" + //
                "| PV:  Act/Max      |                                                                                \r\n" + //
                "| Mana: Act/Max     |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |              &&&&                                                              \r\n" + //
                "|                   |&&          &&&&                                                                \r\n" + //
                "|                   |&&          &&& &&&&                                   &&&&                     \r\n" + //
                "|                   |&&&         &&  &&&&            &&                     &&&&                     \r\n" + //
                "|                   |&&&&        &&                  &&                                              \r\n" + //
                "|                   | &&&        &&  &&&&   &&&&&&   &&&&&&&     &&&&&&     &&&&   &&&&&&   &&&&&&   \r\n" + //
                "|                   |   &&&    &&&   &&&&   &&       &&       &&&&   &&&&   &&&&   &&       &&&&&&   \r\n" + //
                "|                   |   &&&&  &&&&   &&&&   &&       &&       &&&&   &&&&   &&&&   &&       &&       \r\n" + //
                "|                   |     &&&&&&     &&&&   &&&&&&   &&&&&&&     &&&&&&     &&&&   &&       &&&&&&   \r\n" + //
                "|                   |     &&&&&&                                                                     \r\n" + //
                "|                   |       &&&                                                                      \r\n" + //
                "|                   |       &&                                                                       \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "|                   |                                                                                \r\n" + //
                "=-=-=-=-=-=-=-=-=-=-=                                                                                \r\n" + //
                "";

        if(vic){
            bg=Victoire;
        }else{
            bg=defaite;
        }
        bg = palyerStats(bg, p);
        System.out.println(bg);

        scan.nextLine();

    }
}
