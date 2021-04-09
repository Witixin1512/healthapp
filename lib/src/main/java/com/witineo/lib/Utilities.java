package com.witineo.lib;
import com.witineo.lib.medClass;

import java.util.List;

public class Utilities {
    public static void main(String[] args){
        System.out.println("Hello world");
    }
    public static void launchMyActivity(String activityName) {
        System.out.println("Starting activity " + activityName + " Activity");
    }
    public static MedClass getClassFromName(String name){
        for (int i = 0; i < MedClass.reg.toArray().length; i++){
            List<MedClass> newThing = MedClass.reg;
            for (MedClass class : newThing.toArray()){
            if (class.name.matches(name)){
                return class;
            }
            return null;
        }
    }
    public int getTimeEstimated(){
            int output = 0;
            for (String s : MedClass.completedClasses) {
                output += (getClassFromName(s).temps);
            }
            return output;
        }
    }
}
