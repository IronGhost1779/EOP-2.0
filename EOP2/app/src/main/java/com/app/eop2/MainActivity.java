package com.app.eop2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;

import android.os.Bundle;

import android.content.Intent;

import java.util.*;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent (MainActivity.this, SearchActivity.class);
                startActivity(intent);
                finish();
            }
        };

        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 2000);
    }
}