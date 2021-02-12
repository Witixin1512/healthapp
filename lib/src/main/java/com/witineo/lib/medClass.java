package com.witineo.lib;

import java.util.ArrayList;
import java.util.List;
import com.witineo.lib.Utilities;

public class medClass extends Object {
    String nom;
    double temps;
    int nivell;

    public medClass (String name, double time, int tier) {
        this.nom = name;
        this.temps = time;
        this.nivell = tier;

    }
    public static int getVideoTime(){
        return 10; // afegir posibilitat d'extreure info d'un mp4?
    }
    public static void main(String[] args){
        medClass Cremades = new medClass("Cremades", 10, 1);
        medClass Iniciacio = new medClass("Explicació", 10.58, 0 );
        //registre.add(Iniciacio);
        System.out.println(Cremades.nom);
        //for thing in thingy
        Utilities.launchMyActivity("Clase");
    }
}