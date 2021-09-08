package com.java.sd.task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
        catch (Exception e)
        {
            // DO NOTHING
        }


        Thread t=new Thread(){

            @Override
            public void run() {
                try{

                    Thread.sleep(3000);
                }
                catch (Exception e)
                {

                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                      startActivity(new Intent(MainActivity.this,firstactivity.class));

                    }
                });
            }
        };

        t.start();



    }



}

