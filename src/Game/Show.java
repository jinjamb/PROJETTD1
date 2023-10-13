package Game;

import Game.Job.*;
import Game.Pla.Places;

public class Show{
    


    public static void PrintPlace(Player p,int action){
        String name=p.getName();
        String HP =  String.valueOf(p.getHP());
        String HPMax = String.valueOf(p.getHPMax());
        String Lvl = String.valueOf(p.getLevel());

        Places place=p.getCurrentPlace();
        String bg=place.getBackground();

        String HPAndMax = " "+HP +"/"+ HPMax+" ";

        for(int i=name.length();i<"Nom_Joueur".length();i++){name += " ";}
        for(int i=HPAndMax.length();i<"Act/Max".length();i++){HP+=" ";}
        for(int i=Lvl.length();i<"NIVEAU".length();i++){Lvl+=" ";}

        bg = bg.replace("NOM_JOUEUR",name);
        bg = bg.replace("Act/Max", HPAndMax);
        bg = bg.replace("NIVEAU", Lvl);
        //if p.hasmagie()

        String Act1="";
        String posi1="";

        String Act2="";
        String posi2="";

        String Act3="";
        String posi3="";

        String Act4="";
        String posi4="";

        if(action==0){
            Act1="se deplacer    ";
            Act2="se battre      ";
            Act3="se reposer    ";
            Act4="parler avec   ";
            if(place.hasMonsters()){
                posi1="(Impossible)";
                posi2="(Possible)  ";
                posi3="(Impossible)";
                posi4="(Impossible)";
            }else{
                posi1="(Possible)  ";
                posi2="(Impossible)";
                posi3="(Possible)  ";
                posi4="(Possible)  ";
            }
        }
        bg = bg.replace("BBBBBBBBBBBBBBB",Act1);
        bg = bg.replace("bbbbbbbbbbbb",posi1);

        bg = bg.replace("CCCCCCCCCCCCCCC",Act2);
        bg = bg.replace("cccccccccccc",posi2);

        bg = bg.replace("DDDDDDDDDDDDDD",Act3);
        bg = bg.replace("dddddddddddd",posi3);

        bg = bg.replace("EEEEEEEEEEEEEE",Act4);
        bg = bg.replace("eeeeeeeeeeee",posi4);

        System.out.println(bg);
    }




    public static void PrintChoice(String Name,Job job){
        for(int i=Name.length();i<"Nom_Joueur".length();i++){Name += " ";}
        
        String Illu=job.getIllu();
        Illu = Illu.replace("NOM_JOUEUR",Name);

        System.out.println(Illu);
    }

}