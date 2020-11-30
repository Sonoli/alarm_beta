package com.sonoli.alarm_app_release;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(Welcome.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 1500);
    }
}
