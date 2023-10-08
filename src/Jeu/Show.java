package Jeu;

public class Show{
    

    public static void Print(Player p){
        String name=p.getName();
        String HP =  String.valueOf(p.Get_HP());
        String HPMax = String.valueOf(p.Get_HPMax());
        String Lvl = String.valueOf(p.getLevel());

        String bg=p.getCurrentPlace().getBackground();

        String HPAndMax = " "+HP +"/"+ HPMax+" ";

        for(int i=name.length();i<"Nom_Joueur".length();i++){name += " ";}
        for(int i=HPAndMax.length();i<"Act/Max".length();i++){HP+=" ";}
        for(int i=Lvl.length();i<"NIVEAU".length();i++){Lvl+=" ";}

        bg = bg.replace("NOM_JOUEUR",name);
        bg = bg.replace("Act/Max", HPAndMax);
        bg = bg.replace("NIVEAU", Lvl);

        System.out.println(bg);

    }

}