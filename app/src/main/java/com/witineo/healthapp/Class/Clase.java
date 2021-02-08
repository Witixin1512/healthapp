package com.witineo.healthapp;

import java.util.ArrayList;
import java.util.List;

public class Clase {
    String nom;
    double temps;
    int nivell;
    ArrayList<Clase> registre;

    public Clase (String name, double time, int tier) {
        this.nom = name;
        this.temps = time;
        this.nivell = tier;

    }
    public static int getVideoTime(){
        return 10;
    }
    Clase Cremades = new Clase("Cremades", 10, 1);
    Clase Iniciacio = new Clase("Explicació", 10.58, 0 );
    //registre.add(Iniciacio);

    //for thing in
}