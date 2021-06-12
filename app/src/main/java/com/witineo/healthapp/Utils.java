package com.witineo.healthapp;

public class Utils {
    public static void main(String[] args){
    }
    public static void launchMyActivity(String activityName) {
        System.out.println("Starting activity " + activityName + " Activity");
    }
    public static double minsAndSecs(double secs){
        secs = secs % 60;
        double mins = Math.floor(secs / 60);
        double x = mins + secs;
        System.out.println(x);
        return x;
    }
    public static double getMillToSec(long millSec) {
        double secs = (double)millSec / 1000;
        return secs;
    }
}
