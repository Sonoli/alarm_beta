package com.sonoli.alarm_app_release;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {

    private Integer alarmHour;
    private Integer alarmMinute;
    private Timer t = new Timer();
    int runActivity = 0;
    private static final String CHANNEL_ID = "MyNotificationChannelID";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        try {
            alarmHour = intent.getIntExtra("alarmHour", 0);
            alarmMinute = intent.getIntExtra("alarmMinute", 0);
        } catch (Exception e) { }

        try {
            Intent notificationIntent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

            Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setContentTitle("My Alarm clock")
                    .setContentText("Alarm time - " + alarmHour.toString() + " : " + alarmMinute.toString())
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentIntent(pendingIntent)
                    .build();

            startForeground(1, notification);

            NotificationChannel notificationChannel = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = new NotificationChannel(CHANNEL_ID, "My Alarm clock Service", NotificationManager.IMPORTANCE_DEFAULT);
            }
            NotificationManager notificationManager = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                notificationManager = getSystemService(NotificationManager.class);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.createNotificationChannel(notificationChannel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (Calendar.getInstance().getTime().getHours() == alarmHour &&
                        Calendar.getInstance().getTime().getMinutes() == alarmMinute) {

                    if (runActivity == 0) {
                        Intent dialogIntent = new Intent(MyService.this, Wakeup_activity.class);
                        dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(dialogIntent);
                    }
                    runActivity = 1;
                } else { }
            }
        }, 0, 2000);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        t.cancel();
        super.onDestroy();
    }
}