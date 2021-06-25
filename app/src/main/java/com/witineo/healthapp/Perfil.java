package com.witineo.healthapp;

import android.annotation.SuppressLint;

import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Calendar;
import java.util.Date;

import android.widget.TextView;
import android.widget.Toast;

import com.witineo.healthapp.MedClass;

import static com.witineo.healthapp.Initial.launchMyActivity;

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
    private static String DEFNAMEVALUE = "Inserte su nombre aquí";
    private Button btnperfil;
    private TextView txtperfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        launchMyActivity("Perfil");
        setContentView(R.layout.activity_perfil);
        mVisible = true;
        btnperfil = findViewById(R.id.perfil_btn01);
        txtperfil = findViewById(R.id.perfil_txttop);
        btnperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtperfil.setText(myPrefs().getString("saveddate", "01/01/1970"));
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        updateAllValues();
    }
    @Override
    protected void onStop(){
        super.onStop();
        System.out.println("Current saved name is: "  + name.getText().toString());
        if (name.getText().toString() != "Inserte su nombre aquí") {
            SharedPreferences pref = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor ed = pref.edit();
            ed.putString("name", name.getText().toString());
            ed.apply();
        }
    }

    public void updateAllValues() {
        this.totalTime = findViewById(R.id.time);
        this.classAmount = findViewById(R.id.classamount);
        this.dateStarted = findViewById(R.id.date);
        this.name = findViewById(R.id.editTextTextPersonName);

        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        Date dat = Calendar.getInstance().getTime();
        SharedPreferences.Editor prefsEditor = pref.edit();

        String name = pref.getString("name", "Inserte su nombre aquí");
        String date = pref.getString("saveddate", null);
        int amount = MedClass.getCompletedStringClasses().size();
        String time = String.valueOf(MedClass.getFullTime());
            if (date == null){
                StringBuilder s = new StringBuilder();
                for(int i = 4; i < 16; i++){
                    s.append(dat.toString().toCharArray()[i]);
                }
                date = s.toString();
                System.out.println(date);
                prefsEditor.putString("saveddate", date);
                prefsEditor.apply();
            }
         this.name.setText(name);
         this.dateStarted.setText(pref.getString("saveddate", "01/01/1970"));
         this.classAmount.setText(String.valueOf(amount));
         this.totalTime.setText(time);
    }

    private SharedPreferences myPrefs(){
        return getPreferences(MODE_PRIVATE);
    }
    private  SharedPreferences.Editor editor(){
        return myPrefs().edit();
    }
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            android.app.ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (AUTO_HIDE) {
                        delayedHide(AUTO_HIDE_DELAY_MILLIS);
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    view.performClick();
                    break;
                default:
                    break;
            }
            return false;
        }
    };
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }
    private void hide() {
        // Hide UI first
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
    }

    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in delay milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }
}