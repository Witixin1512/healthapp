package com.witineo.lib;
import com.witineo.lib.MedClass;

import java.util.List;

public class Utilities {
    public static void main(String[] args){
    }
    public static void launchMyActivity(String activityName) {
        System.out.println("Starting activity " + activityName + " Activity");
    }
    public static MedClass getClassFromName(String name){
        for (int i = 0; i < MedClass.reg.toArray().length; i++){
            if (MedClass.reg.get(i).nom.matches(name)){
                return (MedClass) MedClass.reg.get(i);
                }

        }
        return null;
    }
    public int getTimeEstimated(){
            int output = 0;
            for (String s : MedClass.completedClasses) {
                output += (getClassFromName(s).temps);
            }
            return output;
        }
    }

