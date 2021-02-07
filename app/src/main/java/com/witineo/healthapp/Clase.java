package com.witineo.healthapp;

public class Clase {
    String nom;
    double temps;
    int nivell;
    public Clase (String name, double time, int tier) {
        this.nom = name;
        this.temps = time;
        this.nivell = tier;

    }
    public static int getVideoTime(){
        return 10;
    }
    Clase Cremades = new Clase("Cremades", 10, 1);
}