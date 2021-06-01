package com.witineo.lib;

import java.util.ArrayList;
import java.util.List;


public class MedClass extends Object {
    private static List<MedClass> reg = new ArrayList<MedClass>();
    private static final List<String> completedClasses = new ArrayList<String>();
    public String res;
    String nom;
    double temps;
    int nivell;

    public MedClass (String name, String resLocation, int tier) {
        this.nom = name;
        this.temps = 0;
        this.res = resLocation;
        this.nivell = tier;
        if (this.isReadyToRegister()){
            registerClass(this);
        }
    }
    public boolean isReadyToRegister(){
        if (this.res == null || this.nivell < 0 || this.nom == null){
            return false;
        }
        return true;
    }
    public static List<MedClass> getClassRegistry() {
        return reg;
    }
    public static List<String> getCompletedStringClasses(){
        return completedClasses;
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
        System.out.println("Registering class: "+ m.getName());
    }
    public static void main(String[] args){
        Utilities.launchMyActivity("MedClass");
        MedClass Cremades = new MedClass("Cremades", null, 1);
        MedClass Iniciacio = new MedClass("Explicació", null, 0 );
        MedClass Avici = new MedClass("Avici", "android.resource://com.witineo.healthapp/" + 180000,0 );

    }

}
