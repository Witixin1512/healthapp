package com.witineo.lib;

import android.media.MediaMetadataRetriever;

import java.util.ArrayList;
import java.util.List;
import com.witineo.lib.Utilities;


public class MedClass extends Object {
    public static final List<MedClass> reg = null;
    public static final List<String> completedClasses = null;
    String nom;
    double temps;
    int nivell;

    public MedClass (String name, String resLocation, int tier) {
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(resLocation);
        String time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        long timeInmillisec = Long.parseLong(time);
        this.nom = name;
        this.temps = Utilities.getMillToSec(timeInmillisec);
        this.nivell = tier;

        reg.add((MedClass) Utilities.getClassFromName(name));
    }
    public static void main(String[] args){
        MedClass Cremades = new MedClass("Cremades", "blank", 1);
        MedClass Iniciacio = new MedClass("Explicació", "blank", 0 );
        MedClass Avici = new MedClass("Avici", "android.resource://com.witineo.healthapp/" + 180000,0 );
        Utilities.launchMyActivity("medClass");
    }

}
