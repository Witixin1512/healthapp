package com.witineo.healthapp;

import android.app.Activity;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.witineo.lib.MedClass;
import com.witineo.lib.Utilities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import java.util.List;

public class ClassList extends Activity {
    List<MedClass> list = MedClass.getClassRegistry();

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               System.out.println("yeet");
            }
        });
        for (MedClass clas : list){
            System.out.println("Loaded class: " + clas.getName());
            MediaMetadataRetriever retriever = new MediaMetadataRetriever();
            if (clas.res != null){
                retriever.setDataSource(clas.res);
                String time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
                long timeInmillisec = Long.parseLong(time);
                double timeToSet = Utilities.minsAndSecs(Utilities.getMillToSec(timeInmillisec));
                System.out.println(clas.getName() + " " + timeToSet);
                clas.setTime(timeToSet);
            }

        }

    }
}