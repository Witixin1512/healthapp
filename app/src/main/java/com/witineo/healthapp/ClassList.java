package com.witineo.healthapp;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


import androidx.appcompat.widget.Toolbar;

import android.view.View;

import java.util.HashSet;
import java.util.Set;

public class ClassList extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list2);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
    public void completeClass(MedClass c){
        MedClass.getCompletedStringClasses().add(c.getName());
        HashSet<String> mama = (HashSet<String>) getPreferences(MODE_PRIVATE).getStringSet("completedClasses", new HashSet<String>());
        mama.add(c.getName());
        getPreferences(MODE_PRIVATE).edit().putStringSet("completedClasses", mama);
    }
}