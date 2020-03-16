package com.example.moderngpa_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        TextView tv = findViewById (R.id.text1);
        ImageView iv = findViewById (R.id.LOGO);
        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);
        Intent myIntent=new Intent(this,Signup.class);
        Thread myThread=new Thread()
        {
            public void run() {
               try{
                   sleep(5000);
               }catch (InterruptedException e)
               {
                   e.printStackTrace();
               }
               finally {
                   startActivity(myIntent);
                   finish();
               }
            }
        };
        myThread.start();


    }
}
