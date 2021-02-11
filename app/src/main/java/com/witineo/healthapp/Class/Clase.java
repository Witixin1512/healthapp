package com.witineo.healthapp.Class;

import java.util.ArrayList;
import java.util.List;

public class Clase extends Object {
    String nom;
    double temps;
    int nivell;

    public Clase (String name, double time, int tier) {
        this.nom = name;
        this.temps = time;
        this.nivell = tier;

    }
    public static int getVideoTime(){
        return 10; // afegir posibilitat d'extreure info d'un mp4?
    }
    public static void main(String[] args){
        Clase Cremades = new Clase("Cremades", 10, 1);
        Clase Iniciacio = new Clase("Explicació", 10.58, 0 );
        //registre.add(Iniciacio);
        System.out.println(Cremades.nom);
        //for thing in thingy
        launchMyActivity("Clase");
    }


    public static void launchMyActivity(String activityName) {
        System.out.println("Starting activity " + activityName + " Activity");
    }
}