package com.witineo.healthapp;

import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.witineo.lib.MedClass;
import com.witineo.lib.Utilities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import java.util.List;

public class ClassList extends AppCompatActivity {
    Resources res = getResources();
    List<MedClass> list = MedClass.reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        String[] classList = res.getStringArray(R.array.classList);
        for (MedClass clas : list){
            System.out.println("Loaded class: " + clas.getName());
            MediaMetadataRetriever retriever = new MediaMetadataRetriever();
            retriever.setDataSource(clas.res);
            String time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            long timeInmillisec = Long.parseLong(time);
            double timeToSet = Utilities.minsAndSecs(Utilities.getMillToSec(timeInmillisec));
            clas.setTime(timeToSet);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               System.out.print("yeet");
            }
        });
    }
}