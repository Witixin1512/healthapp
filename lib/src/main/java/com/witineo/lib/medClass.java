package com.witineo.lib;

import java.util.ArrayList;
import java.util.List;


public class MedClass extends Object {
    public static List<MedClass> reg = new ArrayList<MedClass>();
    public static final List<String> completedClasses = null;
    public String res;
    String nom;
    double temps;
    int nivell;

    public MedClass (String name, String resLocation, int tier) {
        this.nom = name;
        this.temps = 0;
        this.res = resLocation;
        this.nivell = tier;
    }
    public void setTime(double time){
        this.temps = time;
    }
    public double getTime(){
        return this.temps;
    }
    public String getName(){
        return this.nom;
    }
    public static void registerClass(MedClass m){
        reg.add(m);
    }
    public static void main(String[] args){
        Utilities.launchMyActivity("MedClass");
        MedClass Cremades = new MedClass("Cremades", "blank", 1);
        MedClass Iniciacio = new MedClass("Explicació", "blank", 0 );
        MedClass Avici = new MedClass("Avici", "android.resource://com.witineo.healthapp/" + 180000,0 );

        registerClass(Cremades);
        registerClass(Iniciacio);
        registerClass(Avici);
    }

}
