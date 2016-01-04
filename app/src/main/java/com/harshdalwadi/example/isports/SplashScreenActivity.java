package com.harshdalwadi.example.isports;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends Activity {

    // Set Duration of the Splash Screen
    long Delay = 5000;
    int init = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        Timer RunSplash = new Timer();

        TimerTask ShowSplash = new TimerTask() {
            @Override
            public void run()
            {

                finish();

                Intent myIntent = new Intent(SplashScreenActivity.this , MainActivity.class);
                startActivity(myIntent);
            }
        };

        // Start the timer
        RunSplash.schedule(ShowSplash, Delay);
    }
}