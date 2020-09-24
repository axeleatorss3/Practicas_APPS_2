package com.example.rep_4_runonuithread_banner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView  imageView;
    int i = 0;
    int [] imagenes = {R.drawable.f1,R.drawable.f2,R.drawable.f3};

    Runnable runnable =  new Runnable() {
        @Override
        public void run() {
            imageView.setImageResource(imagenes[i]);

        }
    };

    Thread thread = new Thread(){
        @Override
        public void run() {
            super.run();

            while(i <3){
                try {
                    Thread.sleep(1000);
                    i++;
                    runOnUiThread(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i > 2){
                    i= 0;
                }

                Log.wtf("hilo",""+i);
            }


        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.img1);
        thread.start();

    }
}