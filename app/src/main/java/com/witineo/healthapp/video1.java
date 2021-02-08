package com.witineo.healthapp;

import android.annotation.SuppressLint;

import android.app.ActionBar;
import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.VideoView;
import android.widget.MediaController;

import androidx.annotation.RequiresApi;

import static com.witineo.healthapp.R.id.videoclip1;


@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class video1 extends Activity {

    private static final boolean AUTO_HIDE = true;


    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;


    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        public void run() {

        }
    };
        private final Runnable mShowPart2Runnable = new Runnable() {
            @Override
            public void run() {
                // Delayed display of UI elements
                android.app.ActionBar actionBar = getActionBar();
                if (actionBar != null) {
                    actionBar.show();
                }

            }
        };
        private boolean mVisible;
        private final Runnable mHideRunnable = new Runnable() {
            @Override
            public void run() {
                hide();
            }
        };
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
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_video1);


            mVisible = true;

            // Upon interacting with UI controls, delay any scheduled hide()
            // operations to prevent the jarring behavior of controls going away
            // while interacting with the UI.
            //findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
        }
     @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
     public void playVideo(View v) {
         VideoView vid = (VideoView)findViewById(videoclip1);
         MediaController m;
         Uri u = Uri.parse("android.resource://com.witineo.healthapp/1800000");
         m = new MediaController(this);
         vid.setMediaController(m);
         vid.setVideoURI(u);
         vid.start();
     }
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
            mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
        }

        private void show() {
            // Show the system bar

            mVisible = true;

            // Schedule a runnable to display UI elements after a delay
            mHideHandler.removeCallbacks(mHidePart2Runnable);
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