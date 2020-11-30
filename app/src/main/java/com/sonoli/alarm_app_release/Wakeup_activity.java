package com.sonoli.alarm_app_release;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Wakeup_activity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    @BindView(R.id.btn_stop_alarm)
    Button btn_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wakeup_activity);

        ButterKnife.bind(this);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN |
                        WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_FULLSCREEN |
                        WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(getBaseContext(), MyService.class));
                Wakeup_activity.this.finish();
                mediaPlayer.stop();
                finish();
            }
        });
        alarm();
    }

    private void alarm() {
        CreateRandom();
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                CreateRandom();
                alarm();
              //  audio();
            }
        });
    }

    private void audio() {
        AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int currentVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
        audio.setStreamVolume(AudioManager.STREAM_MUSIC, audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);

        // audio.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume, 0);
    }

    private void CreateRandom() {
        Random random = new Random();
        final int n = random.nextInt(52);

        switch (n) {
            case 0:
                mediaPlayer = MediaPlayer.create(this, R.raw.b1);
                break;
            case 1:
                mediaPlayer = MediaPlayer.create(this, R.raw.b2);
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(this, R.raw.b3);
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(this, R.raw.b4);
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(this, R.raw.b5);
                break;
            case 5:
                mediaPlayer = MediaPlayer.create(this, R.raw.b6);
                break;
            case 6:
                mediaPlayer = MediaPlayer.create(this, R.raw.b7);
                break;
            case 7:
                mediaPlayer = MediaPlayer.create(this, R.raw.b8);
                break;
            case 8:
                mediaPlayer = MediaPlayer.create(this, R.raw.b9);
                break;
            case 9:
                mediaPlayer = MediaPlayer.create(this, R.raw.b10);
                break;
            case 10:
                mediaPlayer = MediaPlayer.create(this, R.raw.b11);
                break;
            case 11:
                mediaPlayer = MediaPlayer.create(this, R.raw.b12);
                break;
            case 12:
                mediaPlayer = MediaPlayer.create(this, R.raw.b13);
                break;
            case 13:
                mediaPlayer = MediaPlayer.create(this, R.raw.b14);
                break;
            case 14:
                mediaPlayer = MediaPlayer.create(this, R.raw.b15);
                break;
            case 15:
                mediaPlayer = MediaPlayer.create(this, R.raw.b16);
                break;
            case 16:
                mediaPlayer = MediaPlayer.create(this, R.raw.b17);
                break;
            case 17:
                mediaPlayer = MediaPlayer.create(this, R.raw.b18);
                break;
            case 18:
                mediaPlayer = MediaPlayer.create(this, R.raw.b19);
                break;
            case 19:
                mediaPlayer = MediaPlayer.create(this, R.raw.b20);
                break;
            case 20:
                mediaPlayer = MediaPlayer.create(this, R.raw.b21);
                break;
            case 21:
                mediaPlayer = MediaPlayer.create(this, R.raw.b22);
                break;
            case 22:
                mediaPlayer = MediaPlayer.create(this, R.raw.b23);
                break;
            case 23:
                mediaPlayer = MediaPlayer.create(this, R.raw.b24);
                break;
            case 24:
                mediaPlayer = MediaPlayer.create(this, R.raw.b25);
                break;
            case 25:
                mediaPlayer = MediaPlayer.create(this, R.raw.b26);
                break;
            case 26:
                mediaPlayer = MediaPlayer.create(this, R.raw.b27);
                break;
            case 27:
                mediaPlayer = MediaPlayer.create(this, R.raw.b28);
                break;
            case 28:
                mediaPlayer = MediaPlayer.create(this, R.raw.b29);
                break;
            case 29:
                mediaPlayer = MediaPlayer.create(this, R.raw.b30);
                break;
            case 30:
                mediaPlayer = MediaPlayer.create(this, R.raw.b31);
                break;
            case 31:
                mediaPlayer = MediaPlayer.create(this, R.raw.b32);
                break;
            case 32:
                mediaPlayer = MediaPlayer.create(this, R.raw.b33);
                break;
            case 33:
                mediaPlayer = MediaPlayer.create(this, R.raw.b34);
                break;
            case 34:
                mediaPlayer = MediaPlayer.create(this, R.raw.b35);
                break;
            case 35:
                mediaPlayer = MediaPlayer.create(this, R.raw.b36);
                break;
            case 36:
                mediaPlayer = MediaPlayer.create(this, R.raw.b37);
                break;
            case 37:
                mediaPlayer = MediaPlayer.create(this, R.raw.b38);
                break;
            case 38:
                mediaPlayer = MediaPlayer.create(this, R.raw.b39);
                break;
            case 39:
                mediaPlayer = MediaPlayer.create(this, R.raw.b40);
                break;
            case 40:
                mediaPlayer = MediaPlayer.create(this, R.raw.b41);
                break;
            case 41:
                mediaPlayer = MediaPlayer.create(this, R.raw.b42);
                break;
            case 42:
                mediaPlayer = MediaPlayer.create(this, R.raw.b43);
                break;
            case 43:
                mediaPlayer = MediaPlayer.create(this, R.raw.b44);
                break;
            case 44:
                mediaPlayer = MediaPlayer.create(this, R.raw.b45);
                break;
            case 45:
                mediaPlayer = MediaPlayer.create(this, R.raw.b46);
                break;
            case 46:
                mediaPlayer = MediaPlayer.create(this, R.raw.b47);
                break;
            case 47:
                mediaPlayer = MediaPlayer.create(this, R.raw.b48);
                break;
            case 48:
                mediaPlayer = MediaPlayer.create(this, R.raw.b49);
                break;
            case 49:
                mediaPlayer = MediaPlayer.create(this, R.raw.b50);
                break;
            case 50:
                mediaPlayer = MediaPlayer.create(this, R.raw.b51);
                break;
            case 51:
                mediaPlayer = MediaPlayer.create(this, R.raw.b52);
                break;

            default:
                mediaPlayer = MediaPlayer.create(this, R.raw.b1);
                break;
        }
    }

}
