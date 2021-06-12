package com.witineo.healthapp;

import android.annotation.SuppressLint;

import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import java.util.Calendar;
import java.util.Date;

import android.widget.TextView;

import com.witineo.lib.MedClass;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Perfil extends Activity {
    private TextView classAmount;
    private TextView totalTime;
    private EditText name;
    private TextView dateStarted;
    private static final boolean AUTO_HIDE = true;
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_perfil);
        updateAllValues();

    }
    @Override
    protected void onPause(){
        super.onPause();
        if (name.getText().toString() != null) {
            SharedPreferences pref = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor ed = pref.edit();
            ed.putString("name", name.getText().toString());
            ed.commit();
        }
    }
    public void updateAllValues() {
        this.totalTime = findViewById(R.id.time);
        this.classAmount = findViewById(R.id.classamount);
        this.dateStarted = findViewById(R.id.date);
        this.name = findViewById(R.id.editTextTextPersonName);
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        String time = String.valueOf(MedClass.getFullTime());
        int amount = MedClass.getCompletedStringClasses().size();
        Date dat = Calendar.getInstance().getTime();
        System.out.println("Todays date = " + dat.toString());
        SharedPreferences.Editor prefsEditor = pref.edit();
        String name = pref.getString("name", "");
        String date = pref.getString("saveddate", "");
        if (name != null){
            this.name.setText(name);
        }
            if (name == null) {
                name = this.name.getText().toString();
                prefsEditor.putString("name", name);
                prefsEditor.commit();
            }
            if (date == null){
                date = dat.toString();
                prefsEditor.putString("saveddate", date);
                prefsEditor.commit();
                this.dateStarted.setText(date);
            }
         this.classAmount.setText(String.valueOf(amount));
         this.totalTime.setText(time);
    }
}