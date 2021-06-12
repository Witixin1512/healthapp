package com.witineo.healthapp;

public class Utils {
    public static void main(String[] args){
    }
    public static void launchMyActivity(String activityName) {
        System.out.println("Starting activity " + activityName + " Activity");
    }
    public static MedClass getClassFromName(String name){
        for (int i = 0; i < MedClass.getClassRegistry().toArray().length; i++){
            if (MedClass.getClassRegistry().get(i).nom.matches(name)){
                return (MedClass) MedClass.getClassRegistry().get(i);
            }

        }
        return null;
    }
    public static double minsAndSecs(double secs){
        secs = secs % 60;
        double mins = Math.floor(secs / 60);
        double x = mins + secs;
        System.out.println(x);
        return x;
    }
    public double getTimeCompleted(){
        double output = 0;
        for (String s : MedClass.getCompletedStringClasses()) {
            output += (getClassFromName(s).temps);
        }
        //Returns in minuts
        return output;
    }
    public static double getMillToSec(long millSec) {
        double secs = (double)millSec / 1000;
        return secs;
    }
}
