package com.example.cs449_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    TextView ballsCounter;
    Button ballsButton;

    TextView strikesCounter;
    Button strikesButton;

    Button resetButton;
    Button endButton;

    int balls = 0;
    int strikes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ballsCounter = findViewById((R.id.ballsCounter));
        ballsButton = findViewById((R.id.ballsButton));

        strikesCounter = findViewById((R.id.strikesCounter));
        strikesButton = findViewById((R.id.strikesButton));

        resetButton = findViewById((R.id.resetButon));
        endButton = findViewById((R.id.endButton));

        ballsCounter.setText("0");
        strikesCounter.setText("0");


        ballsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                balls = balls + 1;
                ballsCounter.setText(String.valueOf((balls)));

                if (balls == 4){

                    alert("Walk!");
                }
            }
        });

        strikesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                strikes = strikes + 1;
                strikesCounter.setText(String.valueOf(strikes));

                if (strikes == 3){
                    alert("Out!");
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                balls = 0;
                strikes = 0;
                strikesCounter.setText(String.valueOf(strikes));
                ballsCounter.setText(String.valueOf(balls));
            }
        });

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }

    private void alert(String action){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(action);
        //builder.setMessage("The batter walks.");
        builder.setCancelable(false);
        builder.setPositiveButton("Next Batter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                balls = 0;
                strikes = 0;
                strikesCounter.setText(String.valueOf(strikes));
                ballsCounter.setText(String.valueOf(balls));
            }
        });
        builder.show();
    }

    public void toAbout(View v){
        Intent startNewActivity = new Intent(this, DisplayMessageActivity.class);
        startActivity(startNewActivity);
    }

}
