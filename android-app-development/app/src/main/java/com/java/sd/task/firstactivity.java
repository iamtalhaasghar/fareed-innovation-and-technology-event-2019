package com.java.sd.task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class firstactivity extends AppCompatActivity {

    static String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstactivity);

        Button start=findViewById(R.id.start);
        Button showRecords=findViewById(R.id.show);
       final  EditText Name=findViewById(R.id.editText);

        start.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(TextUtils.isEmpty(Name.getText().toString()))
            {
                userName="Player 2";
            }
            else
            userName=Name.getText().toString();

            startActivity(new Intent(firstactivity.this,MainMenu.class));

        }
    });


        showRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName=Name.getText().toString();

                startActivity(new Intent(firstactivity.this,highscroe.class));

            }
        });
}




}
