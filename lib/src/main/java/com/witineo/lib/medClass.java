package com.witineo.lib;

import java.util.ArrayList;
import java.util.List;
import com.witineo.lib.Utilities;


public class MedClass extends Object {
    public static final List<MedClass> reg = null;
    public static final List<String> completedClasses = null;
    String nom;
    int temps;
    int nivell;

    public MedClass (String name, int time, int tier) {
        this.nom = name;
        this.temps = time;
        this.nivell = tier;

        reg.add((MedClass) Utilities.getClassFromName(name));
    }
    public static int getVideoTime(){
        return 10; // afegir posibilitat d'extreure info d'un mp4?
    }
    public static void main(String[] args){
        MedClass Cremades = new MedClass("Cremades", 10, 1);
        MedClass Iniciacio = new MedClass("Explicació", 10, 0 );
        Utilities.launchMyActivity("medClass");
    }

}
