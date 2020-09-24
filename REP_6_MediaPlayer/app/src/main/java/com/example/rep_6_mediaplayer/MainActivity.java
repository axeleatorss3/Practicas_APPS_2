package com.example.rep_6_mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer = null;
    Button btninicio, btnEND;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btninicio = findViewById(R.id.btnInicio);
        btnEND = findViewById(R.id.btnEND);
        mediaPlayer = MediaPlayer.create(this,R.raw.edning);

    }

    public void inicio(View view) {
        if(mediaPlayer !=null){
            mediaPlayer.start();
        }

    }

    public void detener(View view) {
        if(mediaPlayer !=null){
            mediaPlayer.stop();
        }

    }
}