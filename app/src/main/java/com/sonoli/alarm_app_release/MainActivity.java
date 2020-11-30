package com.sonoli.alarm_app_release;


import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;
    @BindView(R.id.btn_set_alarm) Button btn_set;
    @BindView(R.id.btn_off) Button btn_off;
    @BindView(R.id.btn_readme) Button btn_readme;
    @BindView(R.id.activity_main_RelativeLayout) View screenview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.FOREGROUND_SERVICE}, PackageManager.PERMISSION_GRANTED);
        timePicker = findViewById(R.id.timPicker);
        timePicker.setIs24HourView(true);

        final Intent intent = new Intent(this, MyService.class);

        btn_readme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.dialog_title);
                builder.setMessage(R.string.dialog_text_permission);
                builder.setPositiveButton(R.string.btn_dialog_main_activity, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent4 = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent4.setData(uri);
                        startActivity(intent4);
                    }
                });
                builder.create().show();
            }
        });


        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer alarmHourStart = timePicker.getCurrentHour();
                Integer alarmMinuteStart = timePicker.getCurrentMinute();
                ServiceCaller(intent);

                Toast.makeText(MainActivity.this, getString(R.string.setalarm), Toast.LENGTH_SHORT).show();
            }
        });
        btn_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, R.string.alarm_cancel_btn_main_activity, Toast.LENGTH_SHORT).show();
                stopService(new Intent(getBaseContext(), MyService.class));
            }
        });
    }


    public void ServiceCaller(Intent intent) {

        stopService(intent);
        Integer alarmHour = timePicker.getCurrentHour();
        Integer alarmMinute = timePicker.getCurrentMinute();
        intent.putExtra("alarmHour", alarmHour);
        intent.putExtra("alarmMinute", alarmMinute);
        startService(intent);
    }

}

