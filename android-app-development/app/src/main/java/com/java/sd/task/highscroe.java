package com.java.sd.task;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class highscroe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscroe);
        ListView Scores=findViewById(R.id.scroes);

        String result[]=new Database(highscroe.this).getName();


        if(result!=null
                )
        {

            ArrayAdapter<String>  scores=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,result);
            Scores.setAdapter(scores);

        }
        else
        {
            ArrayAdapter<String>  scores=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,new String[]{"No Records In LIst"});
            Scores.setAdapter(scores);
        }


    }
}
