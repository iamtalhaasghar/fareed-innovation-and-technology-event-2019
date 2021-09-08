package com.java.sd.task;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainMenu extends AppCompatActivity {


    int secretNumber;
    int guessedNumber;
    int totalChances;
    int availableChances;
    public static int attempts;
    Spinner levelSelect;
    EditText inputUserNumber;
    Button guessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        levelSelect =findViewById(R.id.levelSelect);
        inputUserNumber =findViewById(R.id.userNumber);
        guessButton=findViewById(R.id.guessButton);
        TextView userName=findViewById(R.id.userName);
        userName.setText("Welcome : "+firstactivity.userName);


        ArrayAdapter<String>  selectLEVEL=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,new String[]{"0-10","0-100","0-1000"});
        levelSelect.setAdapter(selectLEVEL);

        levelSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String temp= levelSelect.getSelectedItem().toString();
                int upperLimit=Integer.parseInt(temp.split("-")[1]);
                Toast.makeText(MainMenu.this,"Range Selected 0 - "+upperLimit,Toast.LENGTH_SHORT).show();


                int level = levelSelect.getSelectedItemPosition()+1;
                secretNumber = createASecretNumber(upperLimit);
                Log.i("Secret: ",String.valueOf(secretNumber));
                switch(level){
                    case 1:
                        totalChances = 3;
                        break;
                    case 2:
                        totalChances = 8;
                        break;
                    case 3 :
                        totalChances = 15;
                        break;
                }
                availableChances = totalChances;


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(inputUserNumber.getText().toString()))
                {
                    Toast.makeText(MainMenu.this,"Nothing Entered. ", Toast.LENGTH_SHORT).show();

                    return;
                }

                attempts++;
                guessedNumber = Integer.parseInt(inputUserNumber.getText().toString());
                Log.i("Guessed: ",String.valueOf(guessedNumber));

                if(availableChances == 0){
                    Toast.makeText(MainMenu.this,"Not Enough Chances. ", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(secretNumber < guessedNumber){

                    showNotification("\t\tToo High");
                    availableChances--;
                    Toast.makeText(MainMenu.this,"Chances Left: "+availableChances, Toast.LENGTH_SHORT).show();
                }
                else if(secretNumber > guessedNumber){
                    showNotification("\t\tToo Low");
                    availableChances--;
                    Toast.makeText(MainMenu.this,"Chances Left: "+availableChances, Toast.LENGTH_SHORT).show();
                }
                else{
                    showNotification("\t\tCorrect!!!");
                    showCongratulations();


                    try{
                        new Database(MainMenu.this).putName(firstactivity.userName,attempts+"");

                    }
                    catch (Exception e)
                    {


                    }
                    availableChances--;
                    startActivity(new Intent(MainMenu.this,firstactivity.class));


                }




            }
        });






    }


    public int createASecretNumber(int upperLimit){
        Random r = new Random();
        return r.nextInt(upperLimit + 1);

    }

    public void showNotification(String msg){

        AlertDialog.Builder notify = new AlertDialog.Builder(MainMenu.this);
        notify.setTitle("Result");
        notify.setMessage(msg);
        notify.setPositiveButton("Ok",null);
        notify.show();
    }

    public void showCongratulations(){
        NotificationCompat.Builder congrat = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Guess Number").setContentText("Congratulations!!! You Won!");
        NotificationManager congratManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        congratManager.notify(0,congrat.build());
    }

}





