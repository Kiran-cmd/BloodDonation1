package com.example.kiran.blooddonation1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Blood Donation Application");
        setContentView(R.layout.activity_splash_screen);

        Thread myThread=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent=new Intent(SplashScreen.this,MainHome.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}
