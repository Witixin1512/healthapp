package com.witineo.healthapp;

import android.media.MediaMetadataRetriever;

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
            this.registerClass();
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
    public static double getFullTime(){
        double output = 0.0;
        for (String s : completedClasses){
            output += Utils.getClassFromName(s).getTime();
        }
        return output;
    }
    public double getTime(){
        return this.temps;
    }
    public String getName(){
        return this.nom;
    }
    public void registerClass() {
        MedClass classToRegister = this;
        reg.add(classToRegister);
        if (classToRegister.res != null) {
            System.out.println("Loaded class: " + classToRegister.getName());
            MediaMetadataRetriever retriever = new MediaMetadataRetriever();
            if (classToRegister.res != null) {
                retriever.setDataSource(classToRegister.res);
                String time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
                long timeInmillisec = Long.parseLong(time);
                double timeToSet = Utils.minsAndSecs(Utils.getMillToSec(timeInmillisec));
                System.out.println(classToRegister.getName() + " " + timeToSet);
                classToRegister.setTime(timeToSet);
            }
            System.out.println("Registering class: " + classToRegister.getName());
        }
    }
    public static void main(String[] args){
        Utils.launchMyActivity("MedClass");
        MedClass Cremades = new MedClass("Cremades", null, 1);
        MedClass Iniciacio = new MedClass("Explicació", null, 0 );
        MedClass Avici = new MedClass("Avici", "android.resource://com.witineo.healthapp/" + 180000,0 );

    }
}
