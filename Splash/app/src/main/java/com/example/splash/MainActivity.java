package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(mainIntent);
                finish();
            }
        },2500);
    }
}



//what we have to do to make the splash screen
//
//1 make activity mainactity
//2 right click on package new activity empty mainactivity2
//3 maker a hander in overide class
//4 color main ripudaman ka color
//5 minifest.xml mai icon
//6 drawable mai icon